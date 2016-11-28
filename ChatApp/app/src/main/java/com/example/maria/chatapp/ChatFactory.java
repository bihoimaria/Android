package com.example.maria.chatapp;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

/**
 * Created by Maria on 26.11.2016.
 */

public class ChatFactory {

    private List<Message> list = new ArrayList<Message>();

    public List<Message> getMessages() {
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT+1:00"));
        Date currentLocalTime = cal.getTime();
        DateFormat date = new SimpleDateFormat("HH:mm:ss a");
        date.setTimeZone(TimeZone.getTimeZone("GMT+2:00"));
        String localTime = date.format(currentLocalTime);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        String currentDate = sdf.format(new Date());

        list.add(new Message(1, "Maria", localTime , currentDate, "hello!"));

        return list;
    }

    public void addM(Message m) {
        list.add(m);
    }
}
