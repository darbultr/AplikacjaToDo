package com.example.darek.myapplication.List;

import com.example.darek.myapplication.ListaZadan;
import com.example.darek.myapplication.RestClient;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.rest.RestService;
/**
 * Created by Darek on 09.12.2016.
 */
@EBean
public class RestGetList {
    @RootContext
    ListaZadan listaZadan;
    @RestService
    RestClient restClient;
    @Background
   public void getList(String token){
        try{
            restClient.setHeader("Authorization", token);


           PobranaLista[] pobranaLista = restClient.getList();
        publishResult(pobranaLista);

        }catch (Exception ex){
            publishError(ex);
        }
    }


    @UiThread
    void publishResult(PobranaLista[] pobranaLista) {listaZadan.wyswietlZadania(pobranaLista);}

    @UiThread
    void publishError(Exception e) {listaZadan.showError(e);}
}
