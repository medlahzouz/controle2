package com.example.controle2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ajouter_entrprise extends AppCompatActivity {
   EditText rso,adr,cpt;
   Button enreg,anull;
    MyDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db=new MyDatabase(this);
        setContentView(R.layout.activity_ajouter_entrprise);
        rso=findViewById(R.id.e1);
        adr=findViewById(R.id.e2);
        cpt=findViewById(R.id.e3);
        enreg=findViewById(R.id.btnaEnregistrer);
        anull=findViewById(R.id.btnaAnnuler);
        setContentView(R.layout.activity_ajouter_entrprise);
    }

    public void enregestre(View view) {
        if (rso.getText().toString().isEmpty()|| adr.getText().toString().isEmpty()||cpt.getText().toString().isEmpty()){
            Toast.makeText(this, "voudever repliserles champs", Toast.LENGTH_SHORT).show();

        }else {
            Entreprise E = new Entreprise();
            E.setID(1);
            E.setRaison_Sociale(rso.getText().toString());
            E.setAdresse(adr.getText().toString());
            E.setCapitale(Double.parseDouble(cpt.getText().toString()));


            if (MyDatabase.AddEntreprise(db.getWritableDatabase(), E) == -1)
                Toast.makeText(this, "Insertion non reausite", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(this, "Insertion reussie avec succe", Toast.LENGTH_SHORT).show();

        }
}

    public void anuller(View view) {
        finish();
    }
    }