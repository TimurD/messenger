package com.timur.java.resources;

import com.timur.java.model.Message;
import com.timur.java.model.Profile;
import com.timur.java.service.MessageService;
import com.timur.java.service.ProfileService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by timur_000 on 14.12.2016.
 */
@Path("profiles")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProfileResource {

    private ProfileService profileService=new ProfileService();

    @GET
    public List<Profile> getProfiles(){
        return profileService.getAllProfiles();
    }

    @GET
    @Path("/{profileName}")
    public Profile getProfile(@PathParam("profileName") String profileName){
        return profileService.getProfile(profileName);
    }

    @POST
    public Profile addProfile(Profile profile){
        return profileService.addProfile(profile);
    }

    @PUT
    @Path("/{profileName}")
    public Profile setProfile(@PathParam("profileName") String  profileName,Profile profile){
        profile.setProfileName(profileName);
        return profileService.updateProfile(profile);
    }
    @DELETE
    @Path("/{profileName}")
    public Profile removeMessage(@PathParam("profileName") String profileName){
        return profileService.removeProfile(profileName);
    }

}
