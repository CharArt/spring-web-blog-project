package ru.specialist.java.spring.service;

import ru.specialist.java.spring.entity.Post;
import ru.specialist.java.spring.entity.Tag;

import java.util.List;

public interface PostService {

    List<Post> listAllPosts();

    List<Post> search(String search);

    List<Tag> searchWithTag (String tag);
//Home work-------------------------------------------------------------------------------------------------------------
    List<Post> listAllPostsWithUserName(String name);

    List<Post> listPostsWithTag (String name);
//Home work-------------------------------------------------------------------------------------------------------------
}
