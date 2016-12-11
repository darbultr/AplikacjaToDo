package com.example.darek.myapplication.Login;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Darek on 06.12.2016.
 */


@JsonIgnoreProperties(ignoreUnknown = true)
public class clientIdPassword {

    public String client_id;

    public String client_secret;


}
