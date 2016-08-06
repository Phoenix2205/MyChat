package com.example.sonyvaio.MyChat.Helper;

import android.content.Context;
import android.util.Log;

import com.example.sonyvaio.MyChat.Model.Message;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.List;

/**
 * Created by Sony Vaio on 8/3/2016.
 */
public class ChatHelper {
    private static ChatHelper instance;
    private Context context;
    FirebaseUser firebaseUser;
    public static ChatHelper getInstance(Context context){
        if(instance == null){
            instance = new ChatHelper(context);
        }
        return instance;
    }

    private ChatHelper(Context context){
        this.context = context;
        firebaseUser= FirebaseAuth.getInstance().getCurrentUser();
    }
    public int isFromThisUser(Message item){
        String senderID=item.getSenderID();
        Log.d("SenderID",String.valueOf(senderID));
        String uid=firebaseUser.getUid();
        Log.d("uid",String.valueOf(uid));
        boolean compare=senderID.equals(uid);
        Log.d("compare sender vs uid",String.valueOf(compare));
        if(senderID.equals(uid)){
            return 1;
        }
        return 0;
    }


    public Message findMessage(Message message, List<Message>messageList)
    {
        for(Message temp:messageList)
            if (message.equals(temp)) return temp;
        return null;
    }
}
