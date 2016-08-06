package com.example.sonyvaio.MyChat.Helper;

import com.example.sonyvaio.MyChat.Model.Message;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Sony Vaio on 7/25/2016.
 */
public class FireBaseDBHelper {

    private static FireBaseDBHelper instance;

    private final static String CHAT_HISTORY="DATA";
    private final static String MESSAGE="MESSAGE";
    private final static String MEMBER="MEMBER";
    private final static String GROUPCHAT="GROUPCHAT";
    private final static String USER="USER";

    public DatabaseReference getFirebaseClient() {
        return firebaseClient.child(CHAT_HISTORY).child(MESSAGE);
    }

    private DatabaseReference firebaseClient;//object firebase dataref

    private FireBaseDBHelper ()
    {
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);//luu xuong dia
        firebaseClient=FirebaseDatabase.getInstance().getReference();// khoi tao firebase database
       // firebaseClient.child(CHAT_HISTORY);
    }

    public static FireBaseDBHelper getInstance()
    {
        if(instance==null) instance=new FireBaseDBHelper();
        return instance;
    }

    public String saveChatItem(Message message) {
        DatabaseReference messageItem = firebaseClient.child(CHAT_HISTORY).child(MESSAGE).push();
        Message mesage1temp=message;
        messageItem.child("message").setValue(message.getMessage());
        messageItem.child("senderID").setValue(message.getSenderID());
        messageItem.child("userPicture").setValue(message.getUserPicture());
        return messageItem.getKey();
    }


  //  public SaveChatMessage
}
