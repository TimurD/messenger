package com.timur.java.service;

import com.timur.java.database.DataBase;
import com.timur.java.model.Comment;
import com.timur.java.model.Message;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

/**
 * Created by timur_000 on 15.12.2016.
 */
public class CommentService {


    public static Map<Long,Message> messages= DataBase.getMessages();
    public List<Comment> getAllComments(long messageId) {
        Map<Long,Comment>comments=messages.get(messageId).getComments();
        return new ArrayList<>(comments.values());
    }

    public Comment getComment(long commentId,long messageId){
        Map<Long,Comment>comments=messages.get(messageId).getComments();
        return comments.get(commentId);
    }
    public Comment updateComment(Comment comment,long messageId,long commentId){
        if(comment.getId()<=0){
            return null;
        }
        Map<Long,Comment>comments=messages.get(commentId).getComments();
        comments.put(comment.getId(),comment);
        return comment;
    }

    public Comment addComment(Comment comment,long messageId){
        Map<Long,Comment>comments=messages.get(messageId).getComments();
        comment.setId(comments.size()+1);
        comments.put(comment.getId(),comment);
        return comment;
    }



    public Comment removeComment(long commentId,long messageId){
        Map<Long,Comment>comments=messages.get(messageId).getComments();
        return comments.remove(commentId);
    }
}
