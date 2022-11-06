package com.example.u4_playingcards;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.scene.image.ImageView;

public class U4_PlayingCards extends Application {
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        // Create a pane to hold the image views
        HBox hbox = new HBox();

        hbox.getChildren().add(new ImageView("EightClubs.png"));
        hbox.getChildren().add(new ImageView("JackDiamonds.png"));
        hbox.getChildren().add(new ImageView("NineHearts.png"));
        hbox.getChildren().add(new ImageView("ThreeSpades.png"));


        // Create a scene and place it in the stage
        Scene scene = new Scene(hbox);
        primaryStage.setTitle("Four Playing Cards"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }

    public static void main(String[] args) {
        launch();
    }
}