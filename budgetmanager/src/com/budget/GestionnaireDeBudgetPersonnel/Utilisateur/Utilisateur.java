package com.budget.GestionnaireDeBudgetPersonnel.Utilisateur;
import com.budget.GestionnaireDeBudgetPersonnel.objectif.object;
import com.budget.GestionnaireDeBudgetPersonnel.role;

import java.util.List;
import java.util.ArrayList;

public record Utilisateur(
        String id,
        //List<Compte> comptes ,
        //List<Budget> budgets ,
        List<object> objectifs ,
        role role

) {
    public Utilisateur {

        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("L'ID ne peut pas être vide");
        }
        //if (comptes == null) comptes = new ArrayList<>();
        //if (budgets == null) budgets = new ArrayList<>();
        if (objectifs == null) objectifs = new ArrayList<>();
        if (role == null) role = role.MEMBRE;
    }
}


    /*public Utilisateur(String id, role role) {
        this(id, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), role);
    }*/


    /*public Utilisateur avecCompte(Compte nouveauCompte) {
        List<Compte> nouveauxComptes = new ArrayList<>(comptes);
        nouveauxComptes.add(nouveauCompte);
        return new Utilisateur(id, nouveauxComptes, budgets, objectifs, role);
    }*/


    /*public Utilisateur sansCompte(String compteId) {
        List<Compte> nouveauxComptes = comptes.stream()
                .filter(compte -> !compte.id().equals(compteId))
                .collect(Collectors.toList());
        return new Utilisateur(id, nouveauxComptes, budgets, objectifs, role);
    }*/


    /*public Optional<Compte> trouverCompte(String compteId) {
        return comptes.stream()
                .filter(compte -> compte.id().equals(compteId))
                .findFirst();
    }

    public utilisateur avecBudget(Budget nouveauBudget) {
        List<Budget> nouveauxBudgets = new ArrayList<>(budgets);
        nouveauxBudgets.add(nouveauBudget);
        return new Utilisateur(id, comptes, nouveauxBudgets, objectifs, role);
    }


    public Utilisateur sansBudget(String budgetId) {
        List<Budget> nouveauxBudgets = budgets.stream()
                .filter(budget -> !budget.id().equals(budgetId))
                .collect(Collectors.toList());
        return new Utilisateur(id, comptes, nouveauxBudgets, objectifs, role);
    }


    public Optional<Budget> trouverBudget(String budgetId) {
        return budgets.stream()
                .filter(budget -> budget.id().equals(budgetId))
                .findFirst();
    }*/

    /*public Utilisateur avecObjectif(Objectif nouvelObjectif) {
        List<Objectif> nouveauxObjectifs = new ArrayList<>(objectifs);
        nouveauxObjectifs.add(nouvelObjectif);
        return new Utilisateur(id, comptes, budgets, nouveauxObjectifs, role);
    }


    public utilisateur sansObjectif(String objectifId) {
        List<objectif> nouveauxObjectifs = objectifs.stream()
                .filter(objectif -> !objectif.id().equals(objectifId))
                .collect(Collectors.toList());
        return new utilisateur(id, comptes, budgets, nouveauxObjectifs, role);
    }
    public Optional<objectif> trouverObjectif(String objectifId) {
        return objectifs.stream()
                .filter(objectif -> objectif.id().equals(objectifId))
                .findFirst();
    }

    public Utilisateur avecRole(Role nouveauRole) {
        return new Utilisateur(id, comptes, budgets, objectifs, nouveauRole);
    }
}*/