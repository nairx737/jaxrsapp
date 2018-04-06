package com.jaxrs.service;

import com.jaxrs.entity.Post;
import com.jaxrs.repository.PostRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PostService {

    private Map<Long, Post> posts = PostRepository.getPosts();



    public PostService() {
    }

    public List<Post> getPosts(){
        return new ArrayList<Post>(posts.values());
    }

    public Post createPost(Post post) {
        long id = posts.size() + 1;
        post.setId(id);
        posts.put(post.getId(), post);
        return post;
    }

    public Post getPost(long id) {
        return posts.get(id);
    }

    public Post updatePost(long id, Post post) {
        if(posts.get(id) ==null){
            return null;
        }
        post.setId(id);
        posts.put(id, post);
        return  post;
    }

    public void deletePost(long id) {
        posts.remove(id);
    }
}
