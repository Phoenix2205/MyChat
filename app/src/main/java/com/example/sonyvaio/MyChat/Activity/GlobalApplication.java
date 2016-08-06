package com.example.sonyvaio.MyChat.Activity;

import android.app.Application;

import com.example.sonyvaio.MyChat.Helper.FireBaseDBHelper;
import com.example.sonyvaio.MyChat.Model.Session;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;

/**
 * Created by Sony Vaio on 7/26/2016.
 */
public class GlobalApplication extends Application {
//    public FirebaseUser getUser() {
//
//        return user;
//    }

    //public void setUser(FirebaseUser user) {
   //     this.user = user;
    //}

//    FirebaseUser user;
//
//    public User getCurrentUser() {
//        setCurrentUser();
//        return currentUser;
//    }
//
//    private void setCurrentUser()
//    {
//      //  currentUser.setID(user.getProviderId());
//        currentUser.setProfilePic(user.getPhotoUrl().toString());
//        currentUser.setUserName(user.getDisplayName());
//
//    }
//
//    User currentUser;

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    Session session;
    @Override
    public void onCreate()
    {
        super.onCreate();
        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);
        FireBaseDBHelper.getInstance();
    }
}
