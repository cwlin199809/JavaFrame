package com.cwlin.pojo;

public class UserNone {
    private String name;

    public UserNone() { System.out.println("UserNone的无参构造");}
    public String getName() { return name;}
    public void setName(String name) { this.name = name;}
    public void show(){ System.out.println("name="+name);}
}