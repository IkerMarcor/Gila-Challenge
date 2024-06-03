package com.gila.challenge.model;

public class Person {
    private int id;
    private String name, email, phoneNumber;
    private String[] Subscribed, Channels;
    

    public Person() {
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }


    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    public String[] getSubscribed() {
        return Subscribed;
    }


    public void setSubscribed(String[] subscribed) {
        Subscribed = subscribed;
    }


    public String[] getChannels() {
        return Channels;
    }


    public void setChannels(String[] channels) {
        Channels = channels;
    }

    
}
