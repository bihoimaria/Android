package com.example.maria.chatapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Maria on 26.11.2016.
 */

public class ChatAdapter extends BaseAdapter {

    private Context context;

    private ChatFactory factory = new ChatFactory();
    public List<Message> messages = factory.getMessages();

    public ChatAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return messages.size();
    }

    @Override
    public Object getItem(int position) {
        return messages.get(position);
    }

    @Override
    public long getItemId(int position) {
        return messages.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View myRow = (convertView == null) ? inflater.inflate(R.layout.chat_item, parent, false) : convertView;

        TextView sender = (TextView) myRow.findViewById(R.id.sender);
        TextView hour = (TextView) myRow.findViewById(R.id.hour);
        TextView date = (TextView) myRow.findViewById(R.id.day);
        EditText content = (EditText) myRow.findViewById(R.id.message);

        Message m = messages.get(position);

        sender.setText(m.getSender());
        hour.setText(String.valueOf(m.getHour()));
        date.setText(String.valueOf(m.getDate()));
        content.setText(m.getContent());
        content.setKeyListener(null);

        return myRow;
    }

    public void clear() {
        messages.clear();
    }
}
