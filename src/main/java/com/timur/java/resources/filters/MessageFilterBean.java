package com.timur.java.resources.filters;

import javax.ws.rs.QueryParam;

/**
 * Created by timur_000 on 15.12.2016.
 */
public class MessageFilterBean {
    private  @QueryParam("year")int year;
    private @QueryParam("start")int start;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    private @QueryParam("size")int size;
}
