package BoeBotGUI;

import BoeBotGUI.Controllers.BoeBotGuiController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.IOException;
import java.io.Reader;
import java.security.Key;
import java.util.Scanner;

public class BoeBotGUI extends Application {

    Scene controls;
    Scene map;

    Stage stage;

    BoeBotGuiController controller;
    BoeBotController boeBotController;

    sceneSwitcher sceneSwitcher;

    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;
        controller = new BoeBotGuiController();

        stage.setResizable(false);
        Image image = new Image("C:\\Users\\niekh\\IdeaProjects\\Github\\BoeBotGUI\\src\\main\\resources\\BoeBotGUI\\images\\goat_2.jpg");
        stage.getIcons().add(image);

        sceneSwitcher = new sceneSwitcher(stage);

        sceneSwitcher.switchToMap();
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}
