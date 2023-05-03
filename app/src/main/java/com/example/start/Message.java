package com.example.start;

public class Message {
    private String name;
    private String text;
    private int time;
    private boolean senderIsMe;
    public Message(String name, String text, int time, boolean senderIsMe){
        this.name = name;
        this.text = text;
        this.time = time;
        this.senderIsMe = senderIsMe;

    }
    public String getName(){
        return name;
    }
    public String getText(){
        return text;
    }
    public int getTime(){
        return time;
    }
    public boolean getSenderIsMe(){
        return senderIsMe;
    }
}

