package com.example.sonyvaio.MyChat;

import android.app.Application;

import com.example.sonyvaio.MyChat.Helper.FireBaseDBHelper;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;

/**
 * Created by Sony Vaio on 7/26/2016.
 */
public class App extends Application {
    @Override
    public void onCreate()
    {
        super.onCreate();
        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);
        FireBaseDBHelper.getInstance();

    }
}
