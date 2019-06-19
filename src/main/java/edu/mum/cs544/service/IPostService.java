package edu.mum.cs544.service;

import edu.mum.cs544.model.Post;

import java.util.List;

public interface IPostService {

    public List<Post> getAll();
    public List<Post> getAllByUserId(int userId);
    public Post get(int postId);
    public int store(int userId, Post post);
    public void delete(int postId);
    public List<Post> searchByTitle(String title);
}
