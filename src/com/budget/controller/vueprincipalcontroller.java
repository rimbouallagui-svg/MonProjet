package com.budget.controller;



import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class vueprincipalcontroller {


    @FXML
    private Label labelSolde;

    @FXML
    private Label labelRevenus;

    @FXML
    private Label labelDepenses;


    @FXML
    private PieChart chartDepenses;


    @FXML
    private TableView<ObjectifView> tableObjectifs;

    @FXML
    private TableColumn<ObjectifView, String> colNom;

    @FXML
    private TableColumn<ObjectifView, String> colProgression;

    @FXML
    private TableColumn<ObjectifView, String> colDateCible;


    public static class ObjectifView {
        private final String nom;
        private final String progression;
        private final String dateCible;

        public ObjectifView(String nom, String progression, String dateCible) {
            this.nom = nom;
            this.progression = progression;
            this.dateCible = dateCible;
        }

        public String getNom() { return nom; }
        public String getProgression() { return progression; }
        public String getDateCible() { return dateCible; }
    }


    @FXML
    public void initialize() {


        labelSolde.setText("0.00 dt");
        labelRevenus.setText("0.00 dt");
        labelDepenses.setText("0.00 dt");


        chartDepenses.setData(FXCollections.observableArrayList(
                new PieChart.Data("Loyer", 400),
                new PieChart.Data("Nourriture", 250),
                new PieChart.Data("Transport", 80),
                new PieChart.Data("Autres", 120)
        ));


        ObservableList<ObjectifView> objectifs = FXCollections.observableArrayList(
                new ObjectifView("Épargne voiture", "40%", "12/2025"),
                new ObjectifView("Voyage", "10%", "06/2026")
        );

        tableObjectifs.setItems(objectifs);
    }



    @FXML
    private void afficherDashboard() {
        System.out.println("Afficher tableau de bord");
    }

    @FXML
    private void afficherTransactions() {
        System.out.println("Afficher transactions");
    }

    @FXML
    private void afficherObjectifs() {
        System.out.println("Afficher objectifs");
    }

    @FXML
    private void afficherFamille() {
        System.out.println("Afficher gestion familiale");
    }

    @FXML
    private void afficherRapports() {
        System.out.println("Afficher rapports");
    }
}