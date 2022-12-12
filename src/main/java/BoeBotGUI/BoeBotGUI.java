package BoeBotGUI;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.io.Reader;
import java.security.Key;
import java.util.Scanner;

public class BoeBotGUI extends Application {


    Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(BoeBotGUI.class.getResource("BoeBotGUI.fxml"));
        scene = new Scene(fxmlLoader.load(), 960, 540);
        stage.setTitle("BoeBot GUI");
        stage.setScene(scene);
        stage.show();
    }



    public static void main(String[] args) {
        launch();
    }
}
