package com.example.sonyvaio.MyChat.Helper;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Sony Vaio on 7/25/2016.
 */
public class FireBaseDBHelper {
    private static FireBaseDBHelper instance;

    public DatabaseReference getFirebaseClient() {
        return firebaseClient;
    }

    private DatabaseReference firebaseClient;

    private FireBaseDBHelper ()
    {
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        firebaseClient=FirebaseDatabase.getInstance().getReference();
    }

    public static FireBaseDBHelper getInstance()
    {
        if(instance==null) instance=new FireBaseDBHelper();
        return instance;
    }
}
