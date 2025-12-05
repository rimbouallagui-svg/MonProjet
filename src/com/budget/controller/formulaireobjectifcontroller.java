package com.budget.controller;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class formulaireobjectifcontroller {
    @FXML
    private TextField fieldNom;

    @FXML
    private TextField fieldMontantCible;

    @FXML
    private DatePicker dateCible;

    @FXML
    private CheckBox checkEpargne;

    @FXML
    private CheckBox checkInvestissement;

    @FXML
    private CheckBox checkDette;

    @FXML
    private VBox panelEpargne;

    @FXML
    private VBox panelDette;

    @FXML
    private VBox panelInvestissement;
    @FXML
    private TextField fieldTauxEpargne;
    @FXML
    private TextField fieldCreancier;

    @FXML
    private TextField fieldTauxInteret;
    @FXML
    private ComboBox<String> comboTypeInvestissement;

    @FXML
    private TextField fieldRendement;


    @FXML
    private void initialize() {


        comboTypeInvestissement.getItems().addAll(
                "Actions",
                "Crypto",
                "Obligations",
                "Immobilier",
                "Fonds indiciels"
        );


        setPanelVisibility(null);
        checkEpargne.setOnAction(e -> setPanelVisibility("epargne"));
        checkInvestissement.setOnAction(e -> setPanelVisibility("investissement"));
        checkDette.setOnAction(e -> setPanelVisibility("dette"));
    }

    private void setPanelVisibility(String type) {

        panelEpargne.setVisible("epargne".equals(type));
        panelInvestissement.setVisible("investissement".equals(type));
        panelDette.setVisible("dette".equals(type));


        if (type != null) {
            checkEpargne.setSelected("epargne".equals(type));
            checkInvestissement.setSelected("investissement".equals(type));
            checkDette.setSelected("dette".equals(type));
        }
    }



    public String getNom() {
        return fieldNom.getText();
    }

    public double getMontantCible() {
        try { return Double.parseDouble(fieldMontantCible.getText()); }
        catch (Exception e) { return 0; }
    }

    public String getType() {
        if (checkEpargne.isSelected()) return "Epargne";
        if (checkInvestissement.isSelected()) return "Investissement";
        if (checkDette.isSelected()) return "Dette";
        return null;
    }

    public Object getDetails() {
        if (checkEpargne.isSelected())
            return "Taux épargne: " + fieldTauxEpargne.getText() + "%";

        if (checkDette.isSelected())
            return "Créancier: " + fieldCreancier.getText() +
                    ", Taux: " + fieldTauxInteret.getText() + "%";

        if (checkInvestissement.isSelected())
            return "Type: " + comboTypeInvestissement.getValue() +
                    ", Rendement: " + fieldRendement.getText() + "%";

        return null;
    }
}