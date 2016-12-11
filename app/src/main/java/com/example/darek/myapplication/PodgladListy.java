package com.example.darek.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_podglad_listy)
public class PodgladListy extends AppCompatActivity {
    @ViewById
    EditText editTextZad;
    @ViewById
    TextView textStatus;
    @AfterViews
    void init() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String zadanie = extras.getString("zadanie");
            String status = extras.getString("status");
            int idZadania = extras.getInt("id");
            editTextZad.setText(zadanie);
}}}
