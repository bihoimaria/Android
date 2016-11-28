package com.example.maria.mailapp;

/**
 * Created by Maria on 26.11.2016.
 */

public class Mail {

    private int id;
    private String sender;
    private String subject;
    private String content;

    public Mail(int id, String sender, String subject, String content) {
        this.id = id;
        this.sender = sender;
        this.subject = subject;
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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
