package com.example.start;

import io.realm.RealmObject;

public class Message extends RealmObject {
    private String name;
    private String text;
    private int time;
    private boolean senderIsMe;
    private long id;
    public Message(){

    }
    public Message(Message message) {
        this(message.getName(), message.getText(), message.getTime(), message.getSenderIsMe());
    }
    public Message(String name, String text, int time, boolean senderIsMe){
        this.name = name;
        this.text = text;
        this.time = time;
        this.senderIsMe = senderIsMe;
        this.id = -1;
    }


    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getText(){
        return text;
    }
    public void setText(String text){
        this.text = text;
    }
    public int getTime(){
        return time;
    }
    public boolean getSenderIsMe(){
        return senderIsMe;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
}

