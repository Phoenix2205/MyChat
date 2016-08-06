package com.example.sonyvaio.MyChat.Model;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.firebase.auth.FirebaseUser;

/**
 * Created by Sony Vaio on 8/1/2016.
 */
public class Session {
    private static SharedPreferences pref;
    Context context;
    static final String PREF_NAME="USER_SESSION";
    static final int PRIVATE_MODE =0;
    private static final String IS_LOGIN = "LoggedStatus";
    private static FirebaseUser userInfo=null;
    private static SharedPreferences.Editor editor;
    public Session(Context context, FirebaseUser user)
    {
        this.context=context;
        pref = this.context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor=pref.edit();
        createLoginSession(user);
        userInfo=user;
    }

    public void createLoginSession(FirebaseUser user){
        // Storing login value as TRUE
        editor.putBoolean(IS_LOGIN, true);
        // commit changes
        editor.commit();
    }
    public  boolean isLoggedIn(){
        return pref.getBoolean(IS_LOGIN, false);
    }

    public FirebaseUser getUserSession()
    {
       return userInfo;
    }

    public void cleanUserSession()
    {
        editor.clear();
        editor.commit();
    }
}
