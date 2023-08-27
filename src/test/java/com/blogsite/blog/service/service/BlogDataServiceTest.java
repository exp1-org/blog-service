//package com.blogsite.blog.service.service;
//
//import com.blogsite.blog.service.entity.Blog;
//import com.blogsite.blog.service.exception.ServiceException;
//import com.blogsite.blog.service.repository.BlogRepository;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.slf4j.Logger;
//
//import javax.servlet.http.HttpServletRequest;
//import java.time.LocalDate;
//import java.time.Month;
//import java.util.Calendar;
//import java.util.Collections;
//import java.util.GregorianCalendar;
//import java.util.List;
//
//import static org.mockito.Mockito.*;
//
//class BlogDataServiceTest {
//    @Mock
//    HttpServletRequest request;
//    @Mock
//    BlogRepository blogRepository;
//    @Mock
//    Logger log;
//    @InjectMocks
//    BlogDataService blogDataService;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    void testValidateblogDetails() throws Exception {
//        Blog result = blogDataService.ValidateblogDetails(new Blog("blogname-must-be-of-20-characters-length", "category", "we would like to add this as a blog which had certain restrictions for validating article, hence this should be more than 1000 words I guess but not sure exactly what is the count of words given in the code", "authorname", "username", new GregorianCalendar(2023, Calendar.JULY, 4, 22, 25).getTime()));
//        Assertions.assertEquals(null, result);
//    }
//
////    @Test
////    void testDeleteBlog() throws Exception {
////        when(blogRepository.findByBlogname(anyString())).thenReturn(new Blog("blogname-must-be-of-20-characters-length", "category", "we would like to add this as a blog which had certain restrictions for validating article, hence this should be more than 1000 words I guess but not sure exactly what is the count of words given in the code", "authorname", "test_user2", new GregorianCalendar(2023, Calendar.JULY, 4, 22, 25).getTime()));
////        blogDataService.deleteBlog("blogname-must-be-of-20-characters-length");
////    }
//
//    @Test
//    void testGetAllBlogs() throws Exception {
//        List<Blog> result = blogDataService.getAllBlogs();
//        Assertions.assertEquals(Collections.emptyList(), result);
//    }
//
//    @Test
//    void testGetMyBlogs() throws ServiceException {
//        when(blogRepository.findAllBlogsByUsername(anyString())).thenReturn(List.of(new Blog("blogname", "category", "article", "authorname", "username", new GregorianCalendar(2023, Calendar.JULY, 4, 22, 25).getTime())));
//
//        List<Blog> result = blogDataService.getMyBlogs();
//        Assertions.assertEquals(Collections.emptyList(), result);
//    }
//
//    @Test
//    void testGetBlogsBetweenDateRange() {
//        when(blogRepository.findByTimestampBetween(any(), any())).thenReturn(List.of(new Blog("blogname", "category", "article", "authorname", "username", new GregorianCalendar(2023, Calendar.JULY, 4, 22, 25).getTime())));
//
//        List<Blog> result = blogDataService.getBlogsBetweenDateRange(LocalDate.of(2023, Month.JULY, 4), LocalDate.of(2023, Month.JULY, 4));
//        Assertions.assertEquals(List.of(new Blog("blogname", "category", "article", "authorname", "username", new GregorianCalendar(2023, Calendar.JULY, 4, 22, 25).getTime())), result);
//    }
//
//    @Test
//    void testGetAllBlogsByCategory() throws ServiceException {
//        when(blogRepository.findAllBlogsByCategory(anyString())).thenReturn(List.of(new Blog("blogname", "category", "article", "authorname", "username", new GregorianCalendar(2023, Calendar.JULY, 4, 22, 25).getTime())));
//
//        List<Blog> result = blogDataService.getAllBlogsByCategory("category");
//        Assertions.assertEquals(List.of(new Blog("blogname", "category", "article", "authorname", "username", new GregorianCalendar(2023, Calendar.JULY, 4, 22, 25).getTime())), result);
//    }
//}