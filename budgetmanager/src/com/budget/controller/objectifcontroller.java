package com.budget.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableView;

public class objectifcontroller {

    // === Tables ===
    @FXML
    private TableView<?> tableEpargne;

    @FXML
    private TableView<?> tableDettes;

    @FXML
    private TableView<?> tableInvestissements;


    @FXML
    private void initialize() {
        System.out.println("ObjectifsContr : interface chargée !");
    }



    @FXML
    private void ajouterObjectif() {
        try {
            Dialog<ButtonType> dialog = new Dialog<>();
            dialog.setTitle("Créer un objectif");

            FXMLLoader loader = new FXMLLoader(getClass().getResource("FormulaireObjectif.fxml"));
            DialogPane pane = loader.load();

            dialog.setDialogPane(pane);


            ButtonType btnOk = new ButtonType("Ajouter", ButtonType.OK.getButtonData());
            ButtonType btnCancel = new ButtonType("Annuler", ButtonType.CANCEL.getButtonData());

            dialog.getDialogPane().getButtonTypes().addAll(btnOk, btnCancel);

            dialog.showAndWait().ifPresent(result -> {
                if (result == btnOk) {
                    System.out.println("Nouveau objectif ajouté !");
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Erreur lors du chargement du formulaire.").showAndWait();
        }
    }
}