package com.eni.demojpa.otm.bi;

import javax.persistence.*;

    @Entity(name = "adresse_OTM_bi")
    @Table(name = "adresse_OTM_bi")
    public class Adresse {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        private String codePostal;
        private String ville;
        @ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
        private Personne personne;
        public Adresse() {
        }
        public Adresse(String codePostal, String ville) {
            this.codePostal = codePostal;
            this.ville = ville;
        }

        public Personne getPersonne() {return personne;}
        public void setPersonne(Personne personne) {this.personne = personne;}

        public int getId() {
            return id;
        }
        public void setId(int id) {
            this.id = id;
        }
        public String getCodePostal() {
            return codePostal;
        }
        public void setCodePostal(String codePostal) {
            this.codePostal = codePostal;
        }
        public String getVille() {
            return ville;
        }
        public void setVille(String ville) {
            this.ville = ville;
        }
        @Override
        public String toString() {
            return "Adresse [id=" + id + ", codePostal=" + codePostal + ", ville=" + ville + "]";
        }
    }
