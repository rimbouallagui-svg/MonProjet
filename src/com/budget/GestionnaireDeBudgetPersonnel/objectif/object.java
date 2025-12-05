package com.budget.GestionnaireDeBudgetPersonnel.objectif;

import java.time.LocalDate;

public sealed abstract class object permits objectDette,objectifEpargne,objectInvess {
    protected String nom;

    public object(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
