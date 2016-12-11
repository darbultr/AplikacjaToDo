package com.example.darek.myapplication.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created by Darek on 06.12.2016.
 */


public class Zadanie implements Serializable {
    @JsonIgnoreProperties(ignoreUnknown = true)
@JsonProperty("account")
public String account;
    // @JsonProperty("id")
    // public int id;
    @JsonProperty("name")
    public String name;
   // @JsonProperty("status")
   // public String status;



}

