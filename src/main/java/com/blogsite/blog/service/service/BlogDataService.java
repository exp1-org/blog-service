package com.blogsite.blog.service.service;

//import com.blogsite.blog.service.config.KafkaProducerConfig;
import com.blogsite.blog.service.entity.Blog;
import com.blogsite.blog.service.exception.ServiceException;
import com.blogsite.blog.service.repository.BlogRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class BlogDataService {
    @Autowired
    private HttpServletRequest request;

    @Autowired
    private BlogRepository blogRepository;

//    KafkaProducerConfig config = new KafkaProducerConfig();

    public Blog ValidateblogDetails(Blog blog) throws Exception {

        log.info("inside blog service method");
        String username = request.getHeader("username");
        String[] noOfWords = blog.getArticle().split("\\s+");
        Blog uniqueBlog = blogRepository.findByBlogname(blog.getBlogname());
        if(uniqueBlog!=null){
            throw new ServiceException(uniqueBlog.getBlogname()+" already exists");
        }
        if (blog.getBlogname() != null && blog.getBlogname().length() < 20) {
            throw new ServiceException("Blog name must contain more than 20 characters");
        }
        if (blog.getCategory() != null && blog.getCategory().length() < 5) {
            throw new ServiceException("Category must contain more than 5 characters");
        }
        if (blog.getArticle() != null && noOfWords.length < 10) {
            throw new ServiceException("Article must contain more than 1000 words");
        }
        blog.setUsername(username);
        Calendar calendar = Calendar.getInstance();
        Date now = calendar.getTime();
        blog.setTimestamp(now);
        if (now.toString() == null) {
            throw new ServiceException("timestamp is not provided by the service");
        }
        return blogRepository.save(blog);
    }

    public void deleteBlog(String blogID) throws Exception {
        log.info("inside delete blog method");
        String username = request.getHeader("username");
        Blog deleteBlog = blogRepository.findByBlogid(blogID);
        log.info(String.valueOf(deleteBlog));
        if(deleteBlog==null){
            throw new ServiceException(blogID+" doesn't exist");
        }
        else if(username.equals(deleteBlog.getUsername())) {
            blogRepository.delete(deleteBlog);
        }
        else{
            throw new ServiceException("you are not a valid user");
        }
    }


    public List<Blog> getMyBlogs() throws ServiceException {
        log.info("inside get blogs by logged in user");
        String username = request.getHeader("username");
//        config.sendLogToKafka("Blogs retrieved by user: "+username);
        List<Blog> blogs = blogRepository.findAllBlogsByUsername(username);
//        if(blogs.isEmpty()){
//            throw new ServiceException("No blogs added by user: "+username);
//        }
//        else{
//            return blogs;
//        }
        return blogs;
    }

    public Blog getOneBlog(String blogid){
        log.info("inside get individual blog");
        log.info(blogid);
//        config.sendLogToKafka("Individual blog retrieved");
        return blogRepository.findByBlogid(blogid);
    }

    public List<Blog> getAllBlogsByCategory(String category) throws ServiceException {
        log.info("inside get all blogs by category");
        List<Blog> blogs = blogRepository.findAllBlogsByCategory(category);
        if(blogs.isEmpty()){
            throw new ServiceException("No blogs added with category:"+category);
        }
        else{
            return blogs;
        }
    }
}
