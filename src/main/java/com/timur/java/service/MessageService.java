package com.timur.java.service;

import com.timur.java.model.Message;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by timur_000 on 13.12.2016.
 */
public class MessageService {

    public List<Message> getAllMessages(){
        ArrayList<Message> messages=new ArrayList<>();
        Message m1=new Message(1L,"Timur","Hello World!");
        Message m2=new Message(2L,"Timur","Hey everyone");
        messages.add(m1);
        messages.add(m2);
        return messages;
    }
}
