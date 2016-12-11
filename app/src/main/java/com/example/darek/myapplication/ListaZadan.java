package com.example.darek.myapplication;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.darek.myapplication.List.PobranaLista;
import com.example.darek.myapplication.List.PobraneZadanie;
import com.example.darek.myapplication.List.RestGetList;
import com.example.darek.myapplication.List.RestSendList;
import com.example.darek.myapplication.List.Zadanie;
import com.example.darek.myapplication.Login.User;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.ItemClick;
import org.androidannotations.annotations.NonConfigurationInstance;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_lista_zadan)
public class ListaZadan extends AppCompatActivity {



    @ViewById
    EditText textZadanie;
    @ViewById
    ListView listView;
    @Extra("User")
    User user;

    @Bean
    @NonConfigurationInstance
    RestSendList restSendList;
    @Bean
    @NonConfigurationInstance
    RestGetList restGetList;
    ProgressDialog postProgressDialog;
    ProgressDialog getProgressDialog;
    @AfterViews
    void init(){
        postProgressDialog = new ProgressDialog(this);
        postProgressDialog.setMessage("Dodawanie nowego zadania...");
        postProgressDialog.setIndeterminate(true);
        getProgressDialog = new ProgressDialog(this);
        getProgressDialog.setMessage("Pobieranie listy zadań...");
        getProgressDialog.setIndeterminate(true);
        getProgressDialog.show();
        restGetList.getList(user.token);
    }

    public void wyswietlZadania(PobranaLista[] pobranaLista) {
        getProgressDialog.dismiss();
        Toast.makeText(this, "Pobrano zadania", Toast.LENGTH_LONG).show();
          ArrayAdapter<PobranaLista> adapter = new ArrayAdapter<PobranaLista>(this,android.R.layout.simple_list_item_1, pobranaLista);
        listView.setAdapter(adapter);



    }

    public void showError(Exception e) {
        getProgressDialog.dismiss();
        postProgressDialog.dismiss();
        Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        e.printStackTrace();
    }

    public void dodanoZadanie(String name) {
        postProgressDialog.dismiss();
        Toast.makeText(this, "Dodano zadanie: "+name, Toast.LENGTH_LONG).show();

    }


    @Click
    void buttonAccClicked(){
        Toast.makeText(this,"Twój account to: "+user.account + " Twój token: "+user.token,Toast.LENGTH_LONG).show();


    }

@Click
  void  btnDodajClicked(){
    postProgressDialog.show();
    Zadanie zadanie = new Zadanie();
    zadanie.account = user.account;
    zadanie.name = textZadanie.getText().toString();
    restSendList.sendList(user.token, zadanie);

}
    @ItemClick
    void listViewItemClicked(PobraneZadanie pobraneZadanie) {
        int id=pobraneZadanie.id;
        String zadanie = pobraneZadanie.name;
        String status = pobraneZadanie.status;
        Intent i = new Intent(this, PodgladListy.class);
        i.putExtra("id",id);
        i.putExtra("zadanie",zadanie);
        i.putExtra("status", status);
        startActivity(i);
    }
}
