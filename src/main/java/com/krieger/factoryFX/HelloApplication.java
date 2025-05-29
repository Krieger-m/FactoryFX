package com.krieger.factoryFX;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.Parent; // Wichtig: Parent ist die Basisklasse für Layout-Container
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    private Stage primaryStage;
    private Scene mainScene; // Wir verwenden eine einzige Scene
    private Parent view1Content; // Inhalt für die erste Ansicht
    private Parent view2Content; // Inhalt für die zweite Ansicht

    @Override
    public void start(Stage stage) throws IOException {
        this.primaryStage = stage;

        // --- Inhalt für Ansicht 1 erstellen ---
        ViewFactory vboxFactory1 = new VBoxFactory();
        VBox vbox1 = (VBox) vboxFactory1.createView();

        LabelFactory labelFactory1 = new LabelFactory("Willkommen in Ansicht 1!");
        Label label1 = (Label) labelFactory1.createView();

        Button switchToView2Button = new Button("Zu Ansicht 2 wechseln");
        switchToView2Button.setOnAction(event -> showView2());

        vbox1.getChildren().addAll(label1, switchToView2Button);
        this.view1Content = vbox1; // Speichere den Inhalt der ersten Ansicht

        // --- Inhalt für Ansicht 2 erstellen (wird erst bei Bedarf sichtbar) ---
        ViewFactory vboxFactory2 = new VBoxFactory();
        VBox vbox2 = (VBox) vboxFactory2.createView();

        LabelFactory labelFactory2 = new LabelFactory("Sie sind jetzt in Ansicht 2.");
        Label label2 = (Label) labelFactory2.createView();

        Button switchToView1Button = new Button("Zurück zu Ansicht 1");
        switchToView1Button.setOnAction(event -> showView1());

        vbox2.getChildren().addAll(label2, switchToView1Button);
        this.view2Content = vbox2; // Speichere den Inhalt der zweiten Ansicht

        // --- Initialisiere die Haupt-Scene mit dem Inhalt von Ansicht 1 ---
        // Die Scene wird nur einmal erstellt
        mainScene = new Scene(view1Content, 400, 300); // Startet mit Ansicht 1

        primaryStage.setTitle("Einzelfenster-Anwendung");
        primaryStage.setScene(mainScene);
        primaryStage.show();
    }

    /**
     * Wechselt den Inhalt der Scene zur Ansicht 1.
     */
    private void showView1() {
        mainScene.setRoot(view1Content); // Setzt den Root-Node der bestehenden Scene auf Ansicht 1
        primaryStage.setTitle("Einzelfenster-Anwendung - Ansicht 1");
    }

    /**
     * Wechselt den Inhalt der Scene zur Ansicht 2.
     */
    private void showView2() {
        mainScene.setRoot(view2Content); // Setzt den Root-Node der bestehenden Scene auf Ansicht 2
        primaryStage.setTitle("Einzelfenster-Anwendung - Ansicht 2");
    }

    public static void main(String[] args) {
        launch();
    }
}