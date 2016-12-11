package com.example.darek.myapplication;

import com.example.darek.myapplication.Login.User;
import com.example.darek.myapplication.Login.clientIdPassword;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;
import org.androidannotations.annotations.rest.RestService;

/**
 * Created by Darek on 06.12.2016.
 */


@EBean
public class RestLogin {

    private static final int maxRepeat = 3;

    private int i = 0;

    @RootContext
    MainActivity activity;

    @RestService
    RestClient restClient;

    @Background
    public void login(clientIdPassword clientIdPassword) {


        try {

            User user = restClient.login(clientIdPassword);
            publishResult(user);


        } catch (Exception ex) {

            i++;

            if (i <= maxRepeat) {
                login(clientIdPassword);
            } else {

                publishError(ex);
            }
        }

    }

    @UiThread
    void publishResult(User user) {

        activity.loginSuccess(user);


    }

    @UiThread
    void publishError(Exception ex) {
        activity.showError(ex);
    }


}