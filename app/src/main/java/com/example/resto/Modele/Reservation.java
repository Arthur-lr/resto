package com.example.resto.Modele;

public class Reservation {


        protected String nomrestau;
        protected String nomresa;
        protected String horaire;
        protected String nbpersonnes;

    public Reservation(String nom, String nomresa, String nbpersonnes, String horaire) {
        this.nomrestau = nom;
        this.nomresa = nomresa;
        this.horaire = horaire;
        this.nbpersonnes = nbpersonnes;
    }

    public String getNomrestau() {
        return nomrestau;
    }

    public void setNomrestau(String nom) {
        this.nomrestau = nomrestau;
    }

    public String getNomresa() {
        return nomresa;
    }

    public void setNomresa(String nomresa) {
        this.nomresa = nomresa;
    }

    public String getHoraire() {
        return horaire;
    }

    public void setHoraire(String horaire) {
        this.horaire = horaire;
    }

    public String getNbpersonnes() {
        return nbpersonnes;
    }

    public void setNbpersonnes(String nbpersonnes) {
        this.nbpersonnes = nbpersonnes;
    }
}



