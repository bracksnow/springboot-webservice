package com.bracksnow.practice.springboot.web;

import com.bracksnow.practice.springboot.service.PostsService;
import com.bracksnow.practice.springboot.web.dto.PostsResponseDto;
import com.bracksnow.practice.springboot.web.dto.PostsSaveRequestDto;
import com.bracksnow.practice.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor  //final로 생성된 변수를 사용하는 생성자 생성
@RestController
public class PostsApiController {

    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto){
        return postsService.save(requestDto);
    }

    @PutMapping("api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto){
        return postsService.update(id, requestDto);
    }
    @GetMapping("api/v1/posts/{id}")
    public PostsResponseDto findByid(@PathVariable Long id){
        return postsService.findById(id);
    }

    @DeleteMapping("api/v1/posts/{id}")
    public Long delete(@PathVariable Long id){
        postsService.delete(id);
        return id;
    }


}
