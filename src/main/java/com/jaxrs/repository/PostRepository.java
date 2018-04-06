package com.jaxrs.repository;

import com.jaxrs.entity.Post;

import java.util.HashMap;
import java.util.Map;

public class PostRepository {

    private static Map<Long, Post> posts = new HashMap<Long, Post>();

    static {
        Post post1 = new Post(1, " Content 1 ");
        Post post2 = new Post(2, " Content 2 ");
        posts.put(post1.getId(), post1);
        posts.put(post2.getId(), post2);
    }

    public static Map<Long, Post> getPosts(){
        return posts;
    }
}
