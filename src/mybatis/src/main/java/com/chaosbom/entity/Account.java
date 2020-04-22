package com.chaosbom.entity;
import lombok.Data;

@Data
public class Account {
    private int id;
    private String username;
    private String password;
    private int age;
    public Account(String username,String password,int age){
        this.username=username;
        this.password=password;
        this.age=age;
    }
    public Account(int id,String username,String password,int age){
        this.id=id;
        this.username=username;
        this.password=password;
        this.age=age;
    }
}
