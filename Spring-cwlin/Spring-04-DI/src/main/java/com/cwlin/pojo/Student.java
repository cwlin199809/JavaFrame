package com.cwlin.pojo;

import lombok.Data;

import java.util.*;

@Data
public class Student {
    private String name;
    private Address address;
    private String[] books;
    private List<String> hobby;
    private Map<String,String> card;
    private Set<String> games;
    private String wife;
    private Properties info;
}
