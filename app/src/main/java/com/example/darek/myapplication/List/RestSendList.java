package com.example.darek.myapplication.List;

import com.example.darek.myapplication.ListaZadan;
import com.example.darek.myapplication.RestClient;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.rest.RestService;
/**
 * Created by Darek on 06.12.2016.
 */
@EBean
public class RestSendList {
    @RootContext
    ListaZadan listaZadan;
    @RestService
    RestClient restClient;

    @Background
    public void sendList(String token, Zadanie zadanie) {
        try {
            restClient.setHeader("Authorization", token);
            restClient.addList(zadanie);
            publishResult(zadanie.name);
        } catch (Exception ex) {
            publishError(ex);
        }
    }

    @UiThread
    void publishResult(String name) {
        listaZadan.dodanoZadanie(name);
    }

    @UiThread
    void publishError(Exception ex) {
        listaZadan.showError(ex);
    }
}


