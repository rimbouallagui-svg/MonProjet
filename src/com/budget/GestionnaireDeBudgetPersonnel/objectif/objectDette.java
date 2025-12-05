package com.budget.GestionnaireDeBudgetPersonnel.objectif;

import java.time.LocalDate;

public final class objectDette extends object {
    private double montantRestant;
    private String creancier;
    private double tauxInteret;

    public objectDette(String nom, double montantRestant,
                         String creancier, double tauxInteret) {
        super(nom);
        this.montantRestant = montantRestant;
        this.creancier = creancier;
        this.tauxInteret = tauxInteret;
    }

    public double getMontantRestant() {
        return montantRestant;
    }

    public void setMontantRestant(double montantRestant) {
        this.montantRestant = montantRestant;
    }

    public String getCreancier() {
        return creancier;
    }

    public void setCreancier(String creancier) {
        this.creancier = creancier;
    }

    public double getTauxInteret() {
        return tauxInteret;
    }

    public void setTauxInteret(double tauxInteret) {
        this.tauxInteret = tauxInteret;
    }
}
