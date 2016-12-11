package com.example.darek.myapplication.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created by Darek on 10.12.2016.
 */

public class PobraneZadanie implements Serializable {
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonProperty("id")
    public int id;

    @JsonProperty("status")
    public String status;

    @JsonProperty("name")
    public String name;

    @JsonProperty("account")
    public String account;



}
