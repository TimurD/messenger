package com.timur.java.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Created by timur_000 on 15.12.2016.
 */
@XmlRootElement
public class Comment {
    private long id;
    private Date created;
    private String author;
    private String text;

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

    public Comment() {

    }

    public Comment(long id, String author, String text) {
        this.id = id;
        this.created = new Date();
        this.author = author;
        this.text = text;
    }
}
