//package com.blogsite.blog.service.controller;
//
//import com.blogsite.blog.service.entity.Blog;
//import com.blogsite.blog.service.service.BlogDataService;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.slf4j.Logger;
//
//import java.time.LocalDate;
//import java.time.Month;
//import java.util.Calendar;
//import java.util.GregorianCalendar;
//import java.util.List;
//
//import static org.mockito.Mockito.*;
//
//class BlogControllerTest {
//    @Mock
//    BlogDataService blogDataService;
//    @Mock
//    Logger log;
//    @InjectMocks
//    BlogController blogController;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    void testAddBlog() throws Exception {
//        when(blogDataService.ValidateblogDetails(any())).thenReturn(new Blog("blogname", "category", "article", "authorname", "username", new GregorianCalendar(2023, Calendar.JULY, 4, 22, 19).getTime()));
//
//        String result = blogController.addBlog(new Blog("blogname", "category", "article", "authorname", "username", new GregorianCalendar(2023, Calendar.JULY, 4, 22, 19).getTime()));
//        Assertions.assertEquals("blogname added successfully", result);
//    }
//
//    @Test
//    void testDeleteBlog() throws Exception {
//        String result = blogController.deleteBlog("blogname");
//        Assertions.assertEquals("blogname deleted successfully", result);
//    }
//
//    @Test
//    void testGetAllBlogs() throws Exception {
//        when(blogDataService.getAllBlogs()).thenReturn(List.of(new Blog("blogname", "category", "article", "authorname", "username", new GregorianCalendar(2023, Calendar.JULY, 4, 22, 19).getTime())));
//        when(blogDataService.getAllBlogsByCategory(anyString())).thenReturn(List.of(new Blog("blogname", "category", "article", "authorname", "username", new GregorianCalendar(2023, Calendar.JULY, 4, 22, 19).getTime())));
//
//        List<Blog> result = blogController.getAllBlogs("category");
//        Assertions.assertEquals(List.of(new Blog("blogname", "category", "article", "authorname", "username", new GregorianCalendar(2023, Calendar.JULY, 4, 22, 19).getTime())), result);
//    }
//
//    @Test
//    void testGetMyBlogs() throws Exception {
//        when(blogDataService.getMyBlogs()).thenReturn(List.of(new Blog("blogname", "category", "article", "authorname", "username", new GregorianCalendar(2023, Calendar.JULY, 4, 22, 19).getTime())));
//
//        List<Blog> result = blogController.getMyBlogs();
//        Assertions.assertEquals(List.of(new Blog("blogname", "category", "article", "authorname", "username", new GregorianCalendar(2023, Calendar.JULY, 4, 22, 19).getTime())), result);
//    }
//
//    @Test
//    void testGetBlogsBetweenRange() throws Exception {
//        when(blogDataService.getBlogsBetweenDateRange(any(), any())).thenReturn(List.of(new Blog("blogname", "category", "article", "authorname", "username", new GregorianCalendar(2023, Calendar.JULY, 4, 22, 19).getTime())));
//
//        List<Blog> result = blogController.getBlogsBetweenRange(LocalDate.of(2023, Month.JULY, 4), LocalDate.of(2023, Month.JULY, 4));
//        Assertions.assertEquals(List.of(new Blog("blogname", "category", "article", "authorname", "username", new GregorianCalendar(2023, Calendar.JULY, 4, 22, 19).getTime())), result);
//    }
//}