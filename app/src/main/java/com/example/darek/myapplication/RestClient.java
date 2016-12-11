package com.example.darek.myapplication;

import com.example.darek.myapplication.List.PobranaLista;
import com.example.darek.myapplication.List.Zadanie;
import com.example.darek.myapplication.Login.User;
import com.example.darek.myapplication.Login.clientIdPassword;
import com.example.darek.myapplication.Task.PobraneTask;
import com.example.darek.myapplication.Task.Task;

import org.androidannotations.annotations.rest.Delete;
import org.androidannotations.annotations.rest.Get;
import org.androidannotations.annotations.rest.Post;
import org.androidannotations.annotations.rest.Put;
import org.androidannotations.annotations.rest.RequiresHeader;
import org.androidannotations.annotations.rest.Rest;
import org.androidannotations.api.rest.RestClientHeaders;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

/**
 * Created by Darek on 06.12.2016.
 */
@Rest(rootUrl = "http://todo.examplewww.com", converters = {MappingJackson2HttpMessageConverter.class, FormHttpMessageConverter.class})
public interface RestClient extends RestClientHeaders{
//LOGIN
    //authorization
   @Post("/auth/login/")
    User login(clientIdPassword clientIdPassword);

//LIST
    //create
    @Post("/list/")
    @RequiresHeader({"Authorization"})
    void addList (Zadanie zadanie);

    //edit
    @Put("/list/{id}/")
    @RequiresHeader({"Authorization"})
    void editList (Zadanie zadanie, int id);

    //full list
    @Get("/list")
    @RequiresHeader({"Authorization"})
    PobranaLista[] getList();

    //get specific list
    @Get("/list/{id}")
    @RequiresHeader({"Authorization"})
     PobranaLista getSpList(int id);

    //delete
    @Delete("/list/{id}")
    @RequiresHeader({"Authorization"})
     void delList(int id);

//TASK
 //task create
 @Post("/task/")
 @RequiresHeader({"Authorization"})
 void addTask (Task task);

 //task update
 @Put("/task/{task_list}/")
 @RequiresHeader({"Authorization"})
 void editTask (Task task, int task_list);

 //get all tasks
 @Get("/task")
 @RequiresHeader({"Authorization"})
 PobraneTask getTask();

 //get spec task
 @Get("/task/{task_list}")
 @RequiresHeader({"Authorization"})
 PobraneTask getSpTask(int task_list);

 //delete task
 @Delete("/task/{task_list}")
 @RequiresHeader({"Authorization"})
 void delTask(int task_list);
}
