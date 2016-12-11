package com.example.darek.myapplication.Task;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created by Darek on 11.12.2016.
 */

public class Task implements Serializable {
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonProperty("id")
    public int id;
     @JsonProperty("status")
     public String status;
    @JsonProperty("name")
    public String name;
     @JsonProperty("description")
     public String description;
    @JsonProperty("task_list")
    public int task_list;
}