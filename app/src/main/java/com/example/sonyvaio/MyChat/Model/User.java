package com.example.sonyvaio.MyChat.Model;

import java.util.List;

/**
 * Created by Sony Vaio on 7/26/2016.
 */
public class User {
    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public Message getLastMessage() {
        return lastMessage;
    }

    public void setLastMessage(Message lastMessage) {
        this.lastMessage = lastMessage;
    }

    public List<User> getFriendList() {
        return friendList;
    }

    public void setFriendList(List<User> friendList) {
        this.friendList = friendList;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    private  String userName;
    private  String profilePic;
    private List<User>friendList;
    Message lastMessage;


    public class Message {
        //TODO: define time and time zone, https://developer.android.com/reference/java/util/GregorianCalendar.html
        private String message;
        private String userNameDisplay=userName;
        private String pictureprofile=profilePic;

        public Message (String message)
        {
            this.message=message;
        }

    }
}
