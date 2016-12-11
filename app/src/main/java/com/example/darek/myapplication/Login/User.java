package com.example.darek.myapplication.Login;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created by Darek on 06.12.2016.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class User implements Serializable {

    public String account;

    @JsonProperty("token")
    public String token;

}