package com.example.darek.myapplication.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Darek on 09.12.2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PobranaLista {

     public List<PobraneZadanie> records = new ArrayList<PobraneZadanie>();
}
