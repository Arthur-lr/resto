package com.example.resto.Modele;

public class Restaurant {


        protected String nom;
        protected String adresse;
        protected String style;
        protected String horaire;
        protected String telephone;

        public Restaurant(String nom, String adresse, String style, String horaire, String telephone) {
            this.nom = nom;
            this.adresse = adresse;
            this.style = style;
            this.horaire = horaire;
            this.telephone = telephone;
        }

        public String getNom() {
            return nom;
        }

        public void setNom(String nom) {
            this.nom = nom;
        }

        public String getAdresse() {
            return adresse;
        }

        public void setAdresse(String adresse) {
            this.adresse = adresse;
        }

        public String getStyle() {
            return style;
        }

        public void setStyle(String style) {
            this.style = style;
        }

        public String getHoraire() {
            return horaire;
        }

        public void setHoraire(String horaire) {
            this.horaire = horaire;
        }

        public String getTelephone() {
            return telephone;
        }

        public void setTelephone(String telephone) {
            this.telephone = telephone;
        }
    }



