package model;

import db.UserDB;

import java.util.ArrayList;
import java.util.Random;

public class User {
    private int id;
    private String name;

    public User(String name){
        this.id = new Random().nextInt(10000);
        this.name = name;
    }

    public User(int id, String name){
        this.id = id;
        this.name = name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return this.name;
    }

    @Override
    public String toString(){
        return this.name+" "+this.id;
    }
}

