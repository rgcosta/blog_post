package edu.mum.cs544.controller;

import edu.mum.cs544.model.Post;
import edu.mum.cs544.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    @Autowired
    private IPostService postService;

    @GetMapping
    public List<Post> getAll() {
        return postService.getAll();
    }

    @GetMapping("/{id}")
    public Post get(@PathVariable int id) {
        return postService.get(id);
    }

    @DeleteMapping("/{postId}")
    public void delete(@PathVariable int postId) {
        postService.delete(postId);
    }

    @GetMapping("/search/{title}")
    public List<Post> searchByTitle(@PathVariable String title) {
        return postService.searchByTitle(title);
    }

    @GetMapping("/error")
    public Map<String, String> error() {
        Map<String, String> error = new HashMap<>();
        error.put("error", "validation");
        error.put("message", "Title or text cannot be null");
        return error;
    }
}
