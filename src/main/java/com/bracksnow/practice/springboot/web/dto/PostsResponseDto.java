package com.bracksnow.practice.springboot.web.dto;

import com.bracksnow.practice.springboot.domain.Posts.Posts;

public class PostsResponseDto {
    private Long id;
    private String title;
    private String content;
    private String author;
    public PostsResponseDto(Posts entity){
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
    }
}
