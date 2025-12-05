package com.budget.GestionnaireDeBudgetPersonnel;
import com.budget.GestionnaireDeBudgetPersonnel.Utilisateur.Familleutilisateur;
import com.budget.GestionnaireDeBudgetPersonnel.Utilisateur.Utilisateur;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import javax.management.relation.Role;
import java.util.Optional;
public class GestionBudgetPersonnel extends Application {
    private static GestionBudgetPersonnel instance;
    private Utilisateur utilisateurCourant;
    private Familleutilisateur familleCourante;
    public static GestionBudgetPersonnel getInstance() {
        return instance;
    }

    public static void main(String[] args) {

        initialiserDonneesTest();
        launch(args);
    }

    private static void initialiserDonneesTest() {
        /
        System.out.println("Initialisation des données de test...");
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/budget/view/Login.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root, 900, 600);
            scene.getStylesheets().add(getClass().getResource("/com/budget/styles/styles.css").toExternalForm());

            primaryStage.setTitle("Gestion de Budget Personnel - Connexion");
            primaryStage.setScene(scene);
            primaryStage.setMinWidth(800);
            primaryStage.setMinHeight(600);
            primaryStage.show();

            } catch (Exception e) {
                showErrorAlert("Erreur au démarrage", "Impossible de démarrer l'application: " + e.getMessage());
                e.printStackTrace();
            }
        }

    private void showErrorAlert(String erreurAuDémarrage, String s) {
    }


    public void demarrerApplication(Utilisateur utilisateur) {
        this.utilisateurCourant = utilisateur;
        chargerDashboard();
    }

    private void chargerDashboard() {
        try {
            Stage stage = getPrimaryStage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/budget/view/Dashboard.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root, 1200, 800);
            scene.getStylesheets().add(getClass().getResource("/com/budget/styles/styles.css").toExternalForm());

            stage.setTitle("Gestion de Budget Personnel - Tableau de bord");
            stage.setScene(scene);
            stage.centerOnScreen();

        } catch (Exception e) {
            showErrorAlert("Erreur", "Impossible de charger le tableau de bord: " + e.getMessage());
        }
    }

    private Stage getPrimaryStage() {
    }

    public void naviguerVers(String fxmlFile, String titre) {
        try {
            Stage stage = getPrimaryStage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/budget/view/" + fxmlFile));
            Parent root = loader.load();

            Scene scene = stage.getScene();
            if (scene == null) {
                scene = new Scene(root, 1200, 800);
                scene.getStylesheets().add(getClass().getResource("/com/budget/styles/styles.css").toExternalForm());
            } else {
                scene.setRoot(root);
            }

            stage.setTitle("Gestion de Budget Personnel - " + titre);

        } catch (Exception e) {
            showErrorAlert("Erreur de navigation", "Impossible de charger la vue: " + e.getMessage());
        }
    }

    public void deconnecter() {
        this.utilisateurCourant = null;
        this.familleCourante = null;

        Stage stage = getPrimaryStage();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/budget/view/Login.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root, 900, 600);
            scene.getStylesheets().add(getClass().getResource("/com/budget/styles/styles.css").toExternalForm());

            stage.setTitle("Gestion de Budget Personnel - Connexion");
            stage.setScene(scene);
            stage.centerOnScreen();

        } catch (Exception e) {
            showErrorAlert("Erreur", "Impossible de se déconnecter: " + e.getMessage());
        }
    }


    public void showInfoAlert(String titre, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titre);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public boolean showConfirmationAlert(String titre, String message) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(titre);
        alert.setHeaderText(null);
        alert.setContentText(message);

        Optional<javafx.scene.control.ButtonType> result = alert.showAndWait();
        return result.isPresent() && result.get() == javafx.scene.control.ButtonType.OK;
    }

    public Utilisateur getUtilisateurCourant() {
        return utilisateurCourant;
    }

    public void setUtilisateurCourant(Utilisateur utilisateurCourant) {
        this.utilisateurCourant = utilisateurCourant;
    }

    public Familleutilisateur getFamilleCourante() {
        return familleCourante;
    }

    public void setFamilleCourante(Familleutilisateur familleCourante) {
        this.familleCourante = familleCourante;
    }

    public boolean estAdministrateur() {
        return utilisateurCourant != null && utilisateurCourant.role() == role.ADMIN;
    }
}




    }
