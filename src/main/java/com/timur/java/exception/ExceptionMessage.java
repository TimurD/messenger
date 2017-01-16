package com.timur.java.exception;

/**
 * Created by timur_000 on 17.12.2016.
 */
public class ExceptionMessage {
    private int code;
    private String message;
    private String descr;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public ExceptionMessage() {

    }

    public ExceptionMessage(int code, String message, String descr) {

        this.code = code;
        this.message = message;
        this.descr = descr;
    }
}
