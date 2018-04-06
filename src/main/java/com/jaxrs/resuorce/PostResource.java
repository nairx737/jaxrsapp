package com.jaxrs.resuorce;

import com.jaxrs.entity.Post;
import com.jaxrs.service.PostService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/posts")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PostResource {

    private PostService postService = new PostService();

    @GET
    public Response getPosts(){
        List<Post> posts = postService.getPosts();
        return Response.status(Response.Status.OK).entity(posts).build();
    }

    @POST
    public Response createPost(Post post){
        Post createdPost = postService.createPost(post);
        return Response.status(Response.Status.CREATED).entity(createdPost).build();
        //gumruyanz@gmail.com
    }

    @GET
    @Path("/{id}")
    public Response getPost(@PathParam("id") long id){
        Post post = postService.getPost(id);
        return  Response.status(Response.Status.OK).entity(post).build();
    }

    @PUT
    @Path("/{id}")
    public Response updatePost(@PathParam("id") long id, Post post){
        Post updatedPost = postService.updatePost(id, post);
        return Response.status(Response.Status.OK).entity(updatedPost).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deletePost(@PathParam("id") long id){
        postService.deletePost(id);
        List<Post> posts = postService.getPosts();
        return  Response.status(Response.Status.OK).entity(posts).build();
    }
}
