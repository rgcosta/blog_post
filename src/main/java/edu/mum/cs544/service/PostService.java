package edu.mum.cs544.service;

import edu.mum.cs544.dao.PostDao;
import edu.mum.cs544.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service @Transactional
public class PostService implements IPostService {
    @Autowired
    private PostDao postDao;

    @Override
    public List<Post> getAll() {
        return postDao.findAll();
    }

    @Override
    public List<Post> getAllByUserId(int userId) {
        return postDao.findPostsByUserId(userId);
    }

    @Override
    public Post get(int postId) {
        return postDao.findById(postId).get();
    }

    @Override
    public int store(int userId, Post post) {
        post.setUserId(userId);
        postDao.save(post);
        return post.getId();
    }

    @Override
    public void delete(int postId) {
        postDao.deleteById(postId);
    }

    @Override
    public List<Post> searchByTitle(String title) {
        return postDao.findAllByTitleContaining(title);
    }


}
