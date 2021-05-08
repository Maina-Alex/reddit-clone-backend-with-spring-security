package com.maina.redditBackend.repository;

import com.maina.redditBackend.model.Post;
import com.maina.redditBackend.model.Subreddit;
import com.maina.redditBackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllBySubreddit(Subreddit subreddit);

    List<Post> findByUser(User user);
}
