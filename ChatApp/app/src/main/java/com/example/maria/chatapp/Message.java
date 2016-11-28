package com.example.maria.chatapp;

import java.util.Calendar;

/**
 * Created by Maria on 26.11.2016.
 */

public class Message {
    private int id;
    private String sender;
    private String hour;
    private String date;
    private String content;

    public Message(int id, String sender, String hour, String date, String content) {
        this.id = id;
        this.sender = sender;
        this.hour = hour;
        this.date = date;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
