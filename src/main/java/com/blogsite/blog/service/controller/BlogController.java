package com.blogsite.blog.service.controller;

//import com.blogsite.blog.service.config.KafkaProducerConfig;
import com.blogsite.blog.service.entity.Blog;
import com.blogsite.blog.service.repository.BlogRepository;
import com.blogsite.blog.service.service.BlogDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

//@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/blogsite")
@Slf4j
public class BlogController {

    @Autowired
    private BlogDataService blogDataService;

    @Autowired
    private BlogRepository blogRepository;
//    KafkaProducerConfig config = new KafkaProducerConfig();

    @PostMapping(value="/user/blogs/add")
    public String addBlog(@RequestBody Blog blog) throws Exception {
        log.info("inside add blog controller");
        blogDataService.ValidateblogDetails(blog);
//        config.sendLogToKafka(blog.getBlogname() + " added successfully");
        return blog.getBlogname() + " added successfully";
    }

    @DeleteMapping (value="/user/delete/{blogid}")
    public String deleteBlog(@PathVariable String blogid) throws Exception {
        log.info("inside delete blog controller");
        blogDataService.deleteBlog(blogid);
//        config.sendLogToKafka(blogid+" deleted successfully");
        return blogid+" deleted successfully";
    }

    @GetMapping(value="/user/getall")
    public List<Blog> getAllBlogs(@RequestParam(required =false) String category,
                                  @RequestParam(name = "startDate",required = false) String startDate,
                                  @RequestParam(name = "endDate",required = false) String endDate) throws Exception {
        if(category!=null && startDate!=null && endDate!=null){
            if(category.equals("All"))
                return blogRepository.findByTimestampBetween(formatDate(startDate), formatDate(endDate));
            return blogRepository.findByCategoryAndTimestampBetween(category,formatDate(startDate), formatDate(endDate));
        }
        else if(category!=null){
            if(category.equals("All")){
                return blogRepository.findAll();
            }
            return blogRepository.findAllBlogsByCategory(category);
        }
        else if(startDate!=null && endDate!=null){
            return blogRepository.findByTimestampBetween(formatDate(startDate), formatDate(endDate));
        }
        else{
            return blogRepository.findAll();
        }
    }

    public Date formatDate(String date) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        Date fromDate = dateFormat.parse(date);
        return fromDate;
    }

    @GetMapping(value="/user/getBlogs")
    public List<Blog> getMyBlogs() throws Exception {
        return blogDataService.getMyBlogs();
    }

    @GetMapping(value="/user/getBlog/{blogid}")
    public Blog getIndividualBlogs(@PathVariable String blogid) throws Exception {
        return blogDataService.getOneBlog(blogid);
    }

//    @GetMapping(value="/user/getBlogsBtwDateRange")
//    public List<Blog> getBlogsBetweenRange(@RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
//                                           @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) throws Exception {
//        return blogDataService.getBlogsBetweenDateRange(startDate,endDate);
//    }
}
