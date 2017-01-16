package com.timur.java.service;

import com.timur.java.database.DataBase;
import com.timur.java.model.Message;
import com.timur.java.model.Profile;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by timur_000 on 14.12.2016.
 */
public class ProfileService {
    public ProfileService() {
        profiles.put("Timur",new Profile(1L,"Timur","Timur","Dadashov"));
        profiles.put("Alina",new Profile(2L,"Alina","Alina","Loh"));
    }

    public static Map<String, Profile> profiles= DataBase.getProfiles();
    public List<Profile> getAllProfiles(){
        return new ArrayList<>(profiles.values());
    }

    public Profile getProfile(String profileName){
        return profiles.get(profileName);
    }
    public Profile updateProfile(Profile profile){
        if(profile.getProfileName().isEmpty()){
            return null;
        }
        profiles.put(profile.getProfileName(),profile);
        return profile;
    }

    public Profile addProfile(Profile profile){
        profile.setId(profiles.size()+1);
        profiles.put(profile.getProfileName(),profile);
        return profile;
    }

    public Profile removeProfile(String profileName){
        return profiles.remove(profileName);
    }
}
