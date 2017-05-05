package com.example.leamariette.myapplication;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;

/**
 * Created by leamariette on 05/05/2017.
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class ListPosts {

    public ArrayList<Post> posts;
}
