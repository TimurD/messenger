package com.timur.java.resources;

import com.timur.java.model.Message;
import com.timur.java.service.MessageService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by timur_000 on 12.12.2016.
 */
@Path("messages")
public class MessageResource {
    private MessageService messageService=new MessageService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Message> getMessages(){
        return messageService.getAllMessages();
    }

    @GET
    @Path("/{messageId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Message getMessage(@PathParam("messageId") long id){
    return messageService.getMessage(id);
    }
}
