package ru.specialist.java.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.specialist.java.spring.service.PostService;
import ru.specialist.java.spring.service.TagService;
import ru.specialist.java.spring.service.UserService;

@Controller
public class PostController {

    private final PostService postService;
    private final TagService tagService;
    private final UserService userService;

    @Autowired
    public PostController(PostService postService, TagService tagService, UserService userService) {
        this.postService = postService;
        this.tagService = tagService;
        this.userService = userService;
    }

    @GetMapping("/")
    public String index (ModelMap modelMap, @RequestParam(required = false) String search,
                                            @RequestParam (required = false) String username,
                                            @RequestParam(required = false) String name){
        if (search != null) {
            modelMap.put("posts", postService.search(search));
            modelMap.put("title", "Search by");
            modelMap.put("subtitle", search.length() < 20 ? search : search.substring(20) + "...");
        } else {
            modelMap.put("posts", postService.listAllPosts());
            modelMap.put("title", "All posts");
            modelMap.put("tags", tagService.listAllTag());
            modelMap.put("users", userService.findByAll());
        }
        if (username!=null){
            modelMap.put("posts", postService.listAllPostsWithUserName(username));
            modelMap.put("title", "All posts");
            modelMap.put("tags", tagService.listAllTag());
            modelMap.put("users", userService.findByAll());
        }
        if (name!=null){
            modelMap.put("posts", postService.listPostsWithTag(name));
            modelMap.put("title", "All posts");
            modelMap.put("tags", tagService.listAllTag());
            modelMap.put("users", userService.findByAll());
        }
        return "blog";
    }




}
