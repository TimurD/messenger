package com.timur.java.model;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by timur_000 on 13.12.2016.
 */
@XmlRootElement
public class Message {
    private long id;
    private Date created;
    private String author;
    private String text;
    private Map<Long,Comment> comments=new HashMap<>();;

    @XmlTransient
    public Map<Long, Comment> getComments() {
        return comments;
    }

    public void setComments(Map<Long, Comment> comments) {
        this.comments = comments;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Message() {

    }

    public Message(long id, String author, String text) {
        this.id = id;
        this.created = new Date();
        this.author = author;
        this.text = text;

    }
}
