package edu.mum.cs544.controller;

import edu.mum.cs544.model.Post;
import edu.mum.cs544.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users/{userId}")
public class UserPostController {
    @Autowired
    private IPostService postService;

    @GetMapping("/posts")
    public List<Post> getAllByUserId(@PathVariable int userId) {
        return postService.getAllByUserId(userId);
    }

    @GetMapping("/posts/{postId}")
    public Post get(@PathVariable int userId, @PathVariable int postId) {
        return postService.get(userId, postId);
    }

    @PostMapping("/posts")
    public RedirectView add(@PathVariable int userId, @Valid @RequestBody Post post, BindingResult result) {
        if (result.hasErrors()) {
            return new RedirectView("/posts/error");
        }
        int id = postService.store(userId, post);
        return new RedirectView("/users/" + userId + "/posts/" + id);
    }

    @PutMapping("/posts/{postId}")
    public RedirectView update(@PathVariable int userId, @Valid @RequestBody Post post, BindingResult result) {
        if (result.hasErrors()) {
            return new RedirectView("/posts/error");
        }
        int id = postService.store(userId, post);
        return new RedirectView("/users/" + userId + "/posts/" + id);
    }

    @DeleteMapping("/posts/{postId}")
    public void delete(@PathVariable int postId) {
        postService.delete(postId);
    }

}
