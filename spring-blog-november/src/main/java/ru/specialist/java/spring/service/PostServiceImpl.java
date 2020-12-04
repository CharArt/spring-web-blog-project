package ru.specialist.java.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.specialist.java.spring.entity.Post;
import ru.specialist.java.spring.entity.Tag;
import ru.specialist.java.spring.repository.PostRepository;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public List<Post> listAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public List<Post> search(String search) {
        return postRepository.findByContentLikeIgnoreCase("%" + search +"%");
    }

    @Override
    public List<Tag> searchWithTag(String tag) {
        return null;
    }

    @Override
    public List<Post> listAllPostsWithUserName(String name) {
        return postRepository.findByPostsWithUserName(name);
    }

    @Override
    public List<Post> listPostsWithTag(String name) {
        return postRepository.findByPostsWithTagName(name);
    }

}
