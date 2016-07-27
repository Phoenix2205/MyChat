package com.example.sonyvaio.MyChat.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sonyvaio.MyChat.Model.User;

import java.util.List;

/**
 * Created by Sony Vaio on 7/26/2016.
 */
public class ChatContentAdapter extends RecyclerView.Adapter<ChatContentAdapter.ViewHolder> {
    Context context;
    List<User.Message>messageList;
    LayoutInflater layoutInflater;
    ChatContentAdapter (Context context, List<User.Message> messageList)
    {
        this.context=context;
        this.messageList=messageList;
        this.layoutInflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
        @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
