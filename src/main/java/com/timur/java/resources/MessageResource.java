package com.timur.java.resources;

import com.timur.java.model.Message;
import com.timur.java.resources.filters.MessageFilterBean;
import com.timur.java.service.MessageService;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.List;

/**
 * Created by timur_000 on 12.12.2016.
 */
@Path("messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {
    private MessageService messageService = new MessageService();

    @GET
    public List<Message> getMessages(@BeanParam MessageFilterBean filterBean) {
        if (filterBean.getYear() > 0) {
            return messageService.getAllMessagesForYear(filterBean.getYear());
        }
        if (filterBean.getSize() > 0 && filterBean.getStart() > 0) {
            return messageService.getAllMessagesPagination(filterBean.getStart(), filterBean.getSize());
        }
        return messageService.getAllMessages();
    }

    @GET
    @Path("/{messageId}")
    public Message getMessage(@PathParam("messageId") long id,@Context UriInfo uriInfo) {
        Message message= messageService.getMessage(id);
        message.addLink(getUri(uriInfo, message),"self");
        message.addLink(getUriAuthor(uriInfo, message),"author");
        message.addLink(getUriComments(uriInfo, message),"comments");

        return message;
    }

    private String getUriComments(UriInfo uriInfo, Message message) {
        return uriInfo.getBaseUriBuilder().path(MessageResource.class).path(MessageResource.class,"getComment").path(CommentResources.class).resolveTemplate("messageId",message.getId()).build().toString();
    }

    private String getUriAuthor(UriInfo uriInfo, Message message) {
        return uriInfo.getBaseUriBuilder().path(ProfileResource.class).path(message.getAuthor()).build().toString();
    }

    private String getUri(UriInfo uriInfo, Message message) {
        return uriInfo.getBaseUriBuilder().path(MessageResource.class).path(Long.toString(message.getId())).build().toString();
    }

    @POST
    public Response addMessage(Message message, @Context UriInfo uriInfo) {
        Message newMassage=messageService.addMessage(message);
        String newId= String.valueOf(newMassage.getId());
        URI uri=uriInfo.getAbsolutePathBuilder().path(newId).build();
        return Response.created(uri)
                .status(Response.Status.CREATED)
                .entity(newMassage).build();
    }

    @PUT
    @Path("/{messageId}")
    public Message setMessage(@PathParam("messageId") long id, Message message) {
        message.setId(id);
        return messageService.updateMessage(message);
    }

    @DELETE
    @Path("/{messageId}")
    public Message removeMessage(@PathParam("messageId") long id) {
        return messageService.removeMessage(id);
    }

    @Path("/{messageId}/comments")
        public CommentResources getComment () {
            return new CommentResources();
    }
}
