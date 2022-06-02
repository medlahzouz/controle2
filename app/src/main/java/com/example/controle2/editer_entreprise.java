package com.example.controle2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class editer_entreprise extends AppCompatActivity {
    EditText rso,adrs,cpt;
    Button Modifier,Supprimer;
    MyDatabase db;
Spinner sp ;
    Entreprise e;
    ArrayList<Entreprise> ar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editer_entreprise);
        rso=findViewById(R.id.e1);
        adrs=findViewById(R.id.e2);
        cpt=findViewById(R.id.e3);
        ar = MyDatabase.getAllEntreprise(db.getReadableDatabase());
        ArrayList<Integer> items = new ArrayList<>();
        for(Entreprise e :ar){
            items.add(e.getID());
        }
        ArrayAdapter<String> ad = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,items);
        sp.setAdapter(ad);

            @Override
            Publi {
                e=ar.get(i);
                rso.setText(String.valueOf(e.getRaison_Sociale()));
                adrs.setText(String.valueOf(e.getAdresse()));
                cpt.setText(String.valueOf(e.getCapitale()));
                Toast.makeText(editer_entreprise.this, String.valueOf(e.getRaison_Sociale()), Toast.LENGTH_SHORT).show();
            }



            db=new MyDatabase(this);
        setContentView(R.layout.activity_editer_entreprise);
    }

    public void modifier(View view) {

    }

    public void suprimer(View view) {
        if(MyDatabase.DeleteEntreprise(db.getWritableDatabase(),e.getID())!=-1){
            Toast.makeText(this, "sup[ression avec succe", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(getApplicationContext(),"n'est pa suprimer ",Toast.LENGTH_LONG).show();
        }
    }
}