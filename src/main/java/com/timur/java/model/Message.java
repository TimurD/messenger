package com.timur.java.model;

import com.timur.java.exception.Link;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.*;

/**
 * Created by timur_000 on 13.12.2016.
 */
@XmlRootElement
public class Message {
    private long id;
    private Date created;
    private String author;
    private String text;
    private Map<Long,Comment> comments=new HashMap<>();
    private List<Link> links=new ArrayList<>();

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

    public void addLink(String link,String rel){
        Link link1 =new Link();
        link1.setLink(link);
        link1.setRel(rel);
        links.add(link1);
    }

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
