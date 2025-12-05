package com.budget.GestionnaireDeBudgetPersonnel.objectif;

import java.time.LocalDate;

public final class objectifEpargne extends object {
    private double montantCible;
    private double montantActuel;
    private double progression; // en %
    private String dateCible;

    public ObjectifEpargne(String nom, double montantCible, double montantActuel,
                           double progression, String dateCible) {
        super(nom);
        this.montantCible = montantCible;
        this.montantActuel = montantActuel;
        this.progression = progression;
        this.dateCible = dateCible;
    }

    public double getMontantCible() {
        return montantCible;
    }

    public void setMontantCible(double montantCible) {
        this.montantCible = montantCible;
    }

    public double getMontantActuel() {
        return montantActuel;
    }

    public void setMontantActuel(double montantActuel) {
        this.montantActuel = montantActuel;
    }

    public double getProgression() {
        return progression;
    }

    public void setProgression(double progression) {
        this.progression = progression;
    }

    public String getDateCible() {
        return dateCible;
    }

    public void setDateCible(String dateCible) {
        this.dateCible = dateCible;
    }
}
