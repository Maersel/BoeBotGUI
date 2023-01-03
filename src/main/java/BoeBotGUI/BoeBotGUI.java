package BoeBotGUI;

import BoeBotGUI.Controllers.BoeBotGuiController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
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

    Scene controls;
    Scene map;

    Stage stage;

    BoeBotGuiController controller;

    sceneSwitcher sceneSwitcher;

    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;
        controller = new BoeBotGuiController();

        stage.setResizable(false);

        sceneSwitcher = new sceneSwitcher(stage);

        sceneSwitcher.switchToControls();
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}
