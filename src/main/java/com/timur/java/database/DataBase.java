package com.timur.java.database;

import com.timur.java.model.Message;
import com.timur.java.model.Profile;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by timur_000 on 13.12.2016.
 */
public class DataBase {
    private static Map<Long,Message> messages=new HashMap<>();
    private static Map<Long,Profile>profiles=new HashMap<>();

    public static Map<Long, Message> getMessages() {
        return messages;
    }

    public static Map<Long, Profile> getProfiles() {
        return profiles;
    }
}
