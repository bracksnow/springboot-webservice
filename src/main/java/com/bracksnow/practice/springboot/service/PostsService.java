package com.bracksnow.practice.springboot.service;


import com.bracksnow.practice.springboot.domain.Posts.Posts;
import com.bracksnow.practice.springboot.domain.Posts.PostsRepository;
import com.bracksnow.practice.springboot.web.dto.PostsResponseDto;
import com.bracksnow.practice.springboot.web.dto.PostsSaveRequestDto;
import com.bracksnow.practice.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();

    }
    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + id));
        posts.update(requestDto.getTitle(), requestDto.getContent());
        return id;

    }
    public PostsResponseDto findById (Long id){
        Posts entity = postsRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다. id = "+ id));
        return new PostsResponseDto(entity);
    }

    @Transactional
    public void delete (Long id){
        try {
            postsRepository.deleteById(id);
            System.out.println("해당 게시글은 삭제되었습니다");
        }catch(Exception e){
            System.out.println("해당 게시글이 없습니다"+ e);
        }

    }
}
