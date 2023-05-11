package com.example.start.data;

import android.util.Log;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Message extends RealmObject {
    private String id_sender;
    private String id_getter;
    private String name;
    private String text;
    private long time;
    private String datetime;
    private int timezone;
    private boolean senderIsMe;
    public Message(String name, String text, long time, boolean senderIsMe, String id_sender, String id_getter){
        this.name = name;
        this.text = text;
        this.time = time;
        this.senderIsMe = senderIsMe;
        this.id_sender = id_sender;
        this.id_getter = id_getter;
        this.datetime = new SimpleDateFormat("HH:mm", Locale.getDefault()).format(time + TimeZone.getDefault().getOffset(System.currentTimeMillis()));
        this.datetime = this.datetime.charAt(0) == "0".charAt(0)? this.datetime.substring(1) : this.datetime;
    }
    public Message(Message message) {
        this(message.getName(), message.getText(), message.getTime(), message.getSenderIsMe(), message.getIdSender(), message.getIdGetter());
    }

    public Message() {

    }


    public String getName(){
        return name;
    }
    public String getText(){
        return text;
    }
    public long getTime(){return time;}
    public String getDateTime(){return datetime;}
    public int getTimezone(){return timezone;}
    public boolean getSenderIsMe(){
        return senderIsMe;
    }
    public String getIdSender() {
        return id_sender;
    }
    public String getIdGetter() {
        return id_getter;
    }
}

