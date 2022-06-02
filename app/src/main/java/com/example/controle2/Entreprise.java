package com.example.controle2;

import java.io.Serializable;

public class Entreprise implements Serializable {

    private int ID;
    private String Raison_Sociale;
    private String Adresse;
    private double Capitale;
public Entreprise(){
    
}
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getRaison_Sociale() {
        return Raison_Sociale;
    }

    public void setRaison_Sociale(String raison_Sociale) {
        Raison_Sociale = raison_Sociale;
    }

    public String getAdresse() {
        return Adresse;
    }

    public void setAdresse(String adresse) {
        Adresse = adresse;
    }

    public double getCapitale() {
        return Capitale;
    }

    public void setCapitale(double capitale) {
        Capitale = capitale;
    }

    public Entreprise(int ID, String raison_Sociale, String adresse, double capitale) {
        this.ID = ID;
        Raison_Sociale = raison_Sociale;
        Adresse = adresse;
        Capitale = capitale;
    }
}

