package com.example.leamariette.myapplication;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

/**
 * Created by leamariette on 05/05/2017.
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class Post {

    public int id;
    public String titre;
    public String content;
    public Date date;


}
