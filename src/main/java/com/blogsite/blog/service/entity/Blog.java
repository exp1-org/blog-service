package com.blogsite.blog.service.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "blog")
public class Blog{
    @Id private String blogid;
    private String blogname;
    private String category;
    private String article;
    private String authorname;
    private String username;
    private Date timestamp;

}
