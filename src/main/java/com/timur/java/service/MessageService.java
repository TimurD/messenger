package com.timur.java.service;

import com.timur.java.database.DataBase;
import com.timur.java.exception.NotFoundException;
import com.timur.java.model.Message;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

/**
 * Created by timur_000 on 13.12.2016.
 */
public class MessageService {

    public MessageService() {
        messages.put(1L,new Message(1L,"Timur","Hello World!"));
        messages.put(2L,new Message(2L,"Timur","Alina Loh!"));
    }

    public static Map<Long,Message> messages= DataBase.getMessages();
    public List<Message> getAllMessages(){
    return new ArrayList<>(messages.values());
    }

    public Message getMessage(long id){
        Message message=messages.get(id);
        if(message==null){
            throw new NotFoundException("Message:"+id+" not found");
        }
        return message;
    }
    public Message updateMessage(Message message){
        if(message.getId()<=0){
            return null;
        }
        messages.put(message.getId(),message);
        return message;
    }

    public Message addMessage(Message message){
        message.setId(messages.size()+1);
        messages.put(message.getId(),message);
        return message;
    }

    public List<Message>getAllMessagesForYear(int year){
        ArrayList<Message>messages=new ArrayList<>();
        Calendar c=Calendar.getInstance();
        for(Message m: this.getAllMessages()){
            c.setTime(m.getCreated());
            if(c.get(Calendar.YEAR)==year){
                messages.add(m);
            }
        }
        return messages;
    }
    public List<Message>getAllMessagesPagination(int start,int size){
        if((start+size)>messages.size()){
            return new ArrayList<>();
        }
        return new ArrayList<>(messages.values()).subList(start, size+start);
    }

    public Message removeMessage(long id){
        return messages.remove(id);
    }
}
