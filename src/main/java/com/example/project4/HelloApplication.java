package com.example.project4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Driver class for starting the javafx project 4
 * @author Christian Osma, Liam Smith
 */
public class HelloApplication extends Application {
    /**
     * Overriden method that is the main entry point of the application
     * @param stage Stage that is to be displayed
     * @throws IOException Exception object representing an error that occured
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("MainView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 450);
        stage.setTitle("RU Cafe");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * This method is responsible for starting up the javafx application
     * @param args array of Strings
     */
    public static void main(String[] args) {
        launch();
    }
}
