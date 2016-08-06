package com.example.sonyvaio.MyChat.Model;

/**
 * Created by Sony Vaio on 8/2/2016.
 */
public class GroupChat {
    enum TYPE {DIRECT,GROUP_PRIVATE,GROUP_PUBLIC}
    public String getLastMessage() {
        return lastMessage;
    }

    public void setLastMessage(String lastMessage) {
        this.lastMessage = lastMessage;
    }

    public String getNameOfGroup() {
        return nameOfGroup;
    }

    public void setNameOfGroup(String nameOfGroup) {
        this.nameOfGroup = nameOfGroup;
    }

    public String getIDRoom() {
        return IDRoom;
    }

    public void setIDRoom(String IDRoom) {
        this.IDRoom = IDRoom;
    }

    String IDRoom;
    String nameOfGroup;
    String lastMessage;
}
