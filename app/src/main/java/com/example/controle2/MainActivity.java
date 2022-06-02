package com.example.controle2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void ajoute(View view) {
        Intent i =new Intent(MainActivity.this,ajouter_entrprise.class);
        startActivity(i);
    }

    public void edite(View view) {
        Intent i =new Intent(MainActivity.this,editer_entreprise.class);
        startActivity(i);
    }

    public void list(View view) {
        Intent i =new Intent(MainActivity.this,liste_des_entreprise.class);
        startActivity(i);
    }
}


