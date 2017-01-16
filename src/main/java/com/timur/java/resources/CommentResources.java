package com.timur.java.resources;

import com.timur.java.model.Comment;
import com.timur.java.service.CommentService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by timur_000 on 15.12.2016.
 */
@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CommentResources {

    private CommentService commentService=new CommentService();

    @GET
    public List<Comment>getComments(@PathParam("messageId") long id){
        return commentService.getAllComments(id);
    }
    @GET
    @Path("/{commentId}")
    public Comment getComment(@PathParam("messageId") long messageId,@PathParam("commentId") long commentId){
       return commentService.getComment(commentId,messageId);
    }
  

    @POST
    public Comment addComment(@PathParam("messageId") long messageId,Comment comment){
        return commentService.addComment(comment,messageId);
    }

    @PUT
    @Path("/{commentId}")
    public Comment setComment(@PathParam("messageId") long messageId,@PathParam("commentId") long commentId,Comment comment){
        return commentService.updateComment(comment,messageId,commentId);
    }
    @DELETE
    @Path("/{commentId}")
    public Comment removeComment(@PathParam("messageId") long messageId,@PathParam("commentId") long commentId){
        return commentService.removeComment(commentId,messageId);
    }

}
