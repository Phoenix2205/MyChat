package com.example.sonyvaio.MyChat.Model;

import com.google.firebase.database.DataSnapshot;

/**
 * Created by Sony Vaio on 8/2/2016.
 */
public class Message {
    String message;
    String messageID;
    String senderID;
    String userPicture;
    //TODO:them datetime
    enum STATUS {SEND,RECEIVED,TYPING}
    public String getMessage() {
        return message;
    }
    public Message(String message)
    {
        this.message=message;
    }
    public Message(DataSnapshot dataSnapshot)
    {
        Message messageItem = dataSnapshot.getValue(Message.class);
        message=messageItem.getMessage();
       // messageID=messageItem.getMessageID();
        senderID=messageItem.getSenderID();
        userPicture=messageItem.getUserPicture();
    }
    public Message(){
    };
    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessageID() {
        return messageID;
    }

    public void setMessageID(String messageID) {
        this.messageID = messageID;
    }

    public String getSenderID() {
        return senderID;
    }

    public void setSenderID(String senderID) {
        this.senderID = senderID;
    }

    public String getUserPicture() {
        return userPicture;
    }

    public void setUserPicture(String userPicture) {
        this.userPicture = userPicture;
    }





}
