package com.budget.controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


import com.budget.GestionnaireDeBudgetPersonnel.Utilisateur.Utilisateur;
//import com.budget.GestionnaireDeBudgetPersonnel.Compte;
//import com.budget.GestionnaireDeBudgetPersonnel.Budget;
import com.budget.GestionnaireDeBudgetPersonnel.objectif.object;

public class utilisateurcontroller {


    @FXML
    private TextField champId;

    @FXML
    private ComboBox<String> champRole;


    @FXML
    private TableView<Compte> tableComptes;

    @FXML
    private TableColumn<Compte, String> colIdCompte;

    @FXML
    private TableColumn<Compte, String> colSolde;

    @FXML
    private TableColumn<Compte, String> colType;

    @FXML
    private TableColumn<Compte, String> colActionsCompte;

    private final ObservableList<Compte> comptes = FXCollections.observableArrayList();

    // ---------------- Budgets ----------------
    @FXML
    private TableView<Budget> tableBudgets;

    @FXML
    private TableColumn<Budget, String> colIdBudget;

    @FXML
    private TableColumn<Budget, String> colCategorie;

    @FXML
    private TableColumn<Budget, String> colMontantLimite;

    @FXML
    private TableColumn<Budget, String> colActionsBudget;

    private final ObservableList<Budget> budgets = FXCollections.observableArrayList();


    @FXML
    private TableView<object> tableObjectifs;

    @FXML
    private TableColumn<object, String> colIdObjectif;

    @FXML
    private TableColumn<object, String> colTypeObjectif;

    @FXML
    private TableColumn<object, String> colMontantObjectif;

    @FXML
    private TableColumn<object, String> colStatutObjectif;

    @FXML
    private TableColumn<object, String> colActionsObjectif;

    private final ObservableList<object> objectifs = FXCollections.observableArrayList();


    @FXML
    public void initialize() {


        champRole.setItems(FXCollections.observableArrayList("ADMIN", "MEMBRE"));
        champRole.getSelectionModel().select("MEMBRE");


        tableComptes.setItems(comptes);
        tableBudgets.setItems(budgets);
        tableObjectifs.setItems(objectifs);
    }



    @FXML
    private void ajouterCompte() {
        System.out.println("Ajouter un compte");
        // Ajouter logique ici pour ouvrir formulaire compte
        comptes.add(new Compte("C001", "1000", "Courant"));
    }

    @FXML
    private void ajouterBudget() {
        System.out.println("Ajouter un budget");
        // Ajouter logique ici pour ouvrir formulaire budget
        budgets.add(new Budget("B001", "Alimentation", "500"));
    }

    @FXML
    private void ajouterObjectif() {
        System.out.println("Ajouter un objectif");

        objectifs.add(new object("O001", "Épargne", "1000", "En cours"));
    }

    @FXML
    private void enregistrerUtilisateur() {
        String id = champId.getText().trim();
        String role = champRole.getSelectionModel().getSelectedItem();

        if (id.isEmpty()) {
            System.out.println("ID utilisateur obligatoire !");
            return;
        }

        Utilisateur u = new Utilisateur(id, objectifs, role);
        System.out.println("Utilisateur enregistré : " + u);
    }

    @FXML
    private void annuler() {
        champId.clear();
        champRole.getSelectionModel().select("MEMBRE");
        comptes.clear();
        budgets.clear();
        objectifs.clear();
    }
}