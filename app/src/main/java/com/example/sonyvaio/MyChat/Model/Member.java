package com.example.sonyvaio.MyChat.Model;

/**
 * Created by Sony Vaio on 8/2/2016.
 */
public class Member {
    public String getGroupchatID() {
        return groupchatID;
    }

    public void setGroupchatID(String groupchatID) {
        this.groupchatID = groupchatID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    String userID;
    String groupchatID;
}
