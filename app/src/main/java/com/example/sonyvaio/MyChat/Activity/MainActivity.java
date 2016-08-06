package com.example.sonyvaio.MyChat.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.sonyvaio.MyChat.Adapter.ChatContentAdapter;
import com.example.sonyvaio.MyChat.Helper.ChatHelper;
import com.example.sonyvaio.MyChat.Helper.FireBaseDBHelper;
import com.example.sonyvaio.MyChat.Model.Message;
import com.example.sonyvaio.MyChat.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText messageBox;
    RecyclerView messageContainer;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ImageButton send;
    List<Message> userMessageList=new ArrayList<>();
   // Session session;
    ChatHelper chatHelper;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chatHelper=ChatHelper.getInstance(MainActivity.this);
        messageContainer= (RecyclerView) findViewById(R.id.message_container);
        messageBox=(EditText)findViewById(R.id.message_box);

        adapter=new ChatContentAdapter(MainActivity.this,userMessageList);
        Log.d("List message size",String.valueOf(userMessageList.size()));
        messageContainer.setAdapter(adapter);
        layoutManager=new LinearLayoutManager(this);
        messageContainer.setLayoutManager(layoutManager);
        send=(ImageButton)findViewById(R.id.btn_send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text=messageBox.getText().toString();
                Message message= new Message(text);
                message.setSenderID(FirebaseAuth.getInstance().getCurrentUser().getUid());
                String url=FirebaseAuth.getInstance().getCurrentUser().getPhotoUrl().toString();
                Log.d("Image URL:",url);
                message.setUserPicture(url);
                userMessageList.add(message);
                adapter.notifyDataSetChanged();
                String id=FireBaseDBHelper.getInstance().saveChatItem(message);
                Log.d("ID message",id);
                message.setMessageID(id);
                messageBox.setText("");
            }
        });

        FireBaseDBHelper.getInstance().getFirebaseClient().addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Message messageTemp= new Message(dataSnapshot);
                Message existedMessage= chatHelper.findMessage(messageTemp,userMessageList);
                if (existedMessage==null)
                    userMessageList.add(messageTemp);
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                Message messageTemp= new Message(dataSnapshot);
                Message existedMessage= chatHelper.findMessage(messageTemp,userMessageList);
                if (existedMessage==null) userMessageList.add(messageTemp);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
