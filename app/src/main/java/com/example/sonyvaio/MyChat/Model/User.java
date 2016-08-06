package com.example.sonyvaio.MyChat.Model;

import com.google.firebase.auth.FirebaseUser;

import java.util.List;

/**
 * Created by Sony Vaio on 7/26/2016.
 */
public class  User {

    public static List<FirebaseUser> getFriendList() {
        return friendList;
    }

    public static void setFriendList(List<FirebaseUser> friendList) {
        User.friendList = friendList;
    }

    private static List<FirebaseUser>friendList;



}