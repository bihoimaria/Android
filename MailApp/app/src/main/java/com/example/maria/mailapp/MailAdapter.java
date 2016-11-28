package com.example.maria.mailapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Maria on 26.11.2016.
 */

public class MailAdapter extends BaseAdapter {

    private Context context;

    private MailFactory factory = new MailFactory();
    public List<Mail> mails = factory.getMails();

    public MailAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return mails.size();
    }

    @Override
    public Object getItem(int position) {
        return mails.get(position);
    }

    @Override
    public long getItemId(int position) {
        return mails.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View myRow = (convertView == null) ? inflater.inflate(R.layout.list_item, parent, false) : convertView;

        TextView sender = (TextView) myRow.findViewById(R.id.sender);
        TextView subject = (TextView) myRow.findViewById(R.id.subject);
        TextView content = (TextView) myRow.findViewById(R.id.content);

        Mail mail = mails.get(position);
        sender.setText(mail.getSender());
        subject.setText(mail.getSubject());
        content.setText(mail.getContent());

        return myRow;
    }
}
