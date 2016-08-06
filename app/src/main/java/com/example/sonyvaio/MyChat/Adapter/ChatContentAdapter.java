package com.example.sonyvaio.MyChat.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.sonyvaio.MyChat.Helper.ChatHelper;
import com.example.sonyvaio.MyChat.Model.Message;
import com.example.sonyvaio.MyChat.R;
import com.google.firebase.auth.FirebaseAuth;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Sony Vaio on 7/26/2016.
 */
public class ChatContentAdapter extends RecyclerView.Adapter<ChatContentAdapter.ViewHolder> {
    Context context;
    List<Message>messageList;
    LayoutInflater layoutInflater;
    FirebaseAuth mAuth;

     public  ChatContentAdapter (Context context, List<Message> messageList)
    {
        this.context=context;
        this.messageList=messageList;
        this.layoutInflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mAuth=FirebaseAuth.getInstance();
    }
        @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v=null;

            switch (viewType){
                case 0:
              {
                   v=layoutInflater.inflate(R.layout.recycler_view_cell_other_user,parent,false);
                  break;
               }
             case 1:   {
                 v=layoutInflater.inflate(R.layout.recycler_view_cell_current_user,parent,false);
                  break;
              }
          }
        ViewHolder viewHolder = new ViewHolder(v);
          return viewHolder;


    }

    @Override
    public int getItemViewType(int position) {
        Log.d("Position", String.valueOf(position));
        Message message=messageList.get(position);
      //  if (message!=null)
            return ChatHelper.getInstance(context).isFromThisUser(message);
      //  return -1;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

            if(mAuth!=null)
            {
                Message message=messageList.get(position);
                if(message!=null) {
                    String chat = message.getMessage();
                    holder.chatContent.setText(chat);
                    String url=message.getUserPicture();
                    Glide.with(context).load(message.getUserPicture()).into(holder.circleImageView);
                }
            }

    }

    @Override
    public int getItemCount() {
        return messageList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public  TextView chatContent;
        public  CircleImageView circleImageView;
        public ViewHolder(View itemView) {
            super(itemView);
            chatContent=(TextView)itemView.findViewById(R.id.text_view_message);
            circleImageView=(CircleImageView)itemView.findViewById(R.id.user_pic);
        }
    }
}
