package edu.mum.cs544.dao;

import edu.mum.cs544.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostDao extends JpaRepository<Post, Integer> {

    public List<Post> findPostsByUserId(int userId);
    public Post findByUserIdAndId(int userId, int postId);
    public List<Post> findAllByTitleContaining(String title);

}
