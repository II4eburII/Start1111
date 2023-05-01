package com.example.start;

public class Message {
    private String name;
    private String text;
    private int time;
    private String sender;
    public Message(String name, String text, int time, String sender){
        this.name = name;
        this.text = text;
        this.time = time;
        this.sender = sender;

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
    public String getSender(){
        return sender;
    }
}

