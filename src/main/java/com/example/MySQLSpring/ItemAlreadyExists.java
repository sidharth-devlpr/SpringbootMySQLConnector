package com.example.MySQLSpring;

public class ItemAlreadyExists extends RuntimeException{
    public ItemAlreadyExists(String s){
        super(s);
    }
}
