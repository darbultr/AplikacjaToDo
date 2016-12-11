package com.example.darek.myapplication;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Toast;

import com.example.darek.myapplication.Login.User;
import com.example.darek.myapplication.Login.clientIdPassword;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.NonConfigurationInstance;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {
    @ViewById
    EditText editLogin;
    @ViewById
    EditText editPassword;
    @Bean
    @NonConfigurationInstance
    RestLogin restLogin;

    ProgressDialog ringProgressDialog;

@Click
void btnDaneClicked(){
    editLogin.setText("32c88d6a-2aef-4595-bed6-c63b1e4dc985");
    editPassword.setText("4bdc63b8-2c37-412b-8bcd-7e152602e9de");
}
    @AfterViews
    void init() {

        ringProgressDialog = new ProgressDialog(this);
        ringProgressDialog.setMessage("Logowanie...");
        ringProgressDialog.setIndeterminate(true);

    }

    @Click
    void btnEnterClicked() {
        if (editLogin.getText().length() > 0 && editPassword.getText().length() > 0) {

            ringProgressDialog.show();

            clientIdPassword client = new clientIdPassword();

            client.client_id = editLogin.getText().toString();

            client.client_secret = editPassword.getText().toString();

            restLogin.login(client);


        } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            builder.setTitle("Puste pola");

            builder.setMessage("Aby się zalogować wypełnij pola email i password");

            AlertDialog dialog = builder.create();

            dialog.show();


        }

    }
    public void loginSuccess(User user) {

        ringProgressDialog.dismiss();

       // Toast.makeText(this, "Witaj " + user.token, Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, ListaZadan_.class);
        intent.putExtra("User", user);
       startActivity(intent);



    }
    public void showError(Exception ex) {

        ringProgressDialog.dismiss();

        Toast.makeText(this, ex.getMessage(), Toast.LENGTH_LONG).show();

        ex.printStackTrace();

    }
}
