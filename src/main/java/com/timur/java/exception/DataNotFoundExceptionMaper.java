package com.timur.java.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Created by timur_000 on 17.12.2016.
 */
@Provider
public class DataNotFoundExceptionMaper implements ExceptionMapper<NotFoundException> {
    @Override
    public Response toResponse(NotFoundException e) {
        ExceptionMessage exceptionMessage=new ExceptionMessage(404,e.getMessage(),"data not found");
        return Response.status(Response.Status.NOT_FOUND)
                .entity(exceptionMessage)
                .build();
    }
}
