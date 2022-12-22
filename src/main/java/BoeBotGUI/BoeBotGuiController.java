package BoeBotGUI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;

import java.awt.event.KeyEvent;
import java.io.IOException;

public class BoeBotGuiController {

    ObservableList<String> modes = FXCollections.observableArrayList("Map", "Controls");


    @FXML
    void onBackwardsClick() {
        System.out.println("backwards");
    }

    @FXML
    void onForwardClick() {
        System.out.println("forward");
    }

    @FXML
    void onLeftClick() {
        System.out.println("left");
    }

    @FXML
    void onRightClick() {
        System.out.println("right");
    }

    @FXML
    void onBuzzerClick() {
        System.out.println("buzzer");
    }

    @FXML
    void onGripperClick() {
        System.out.println("gripper");
    }

    @FXML
    void onLightsClick() {
        System.out.println("lights");
    }

    @FXML
    void onButtonClick() throws IOException {
        java.awt.Desktop.getDesktop().browse(java.net.URI.create("https://www.youtube.com/watch?v=dQw4w9WgXcQ"));
    }

    @FXML
    private ComboBox<String> modeSelection;

    @FXML
    void initialize() {

        modeSelection.setValue("Mode");
        modeSelection.setItems(modes);
    }


    public void keyPressed(javafx.scene.input.KeyEvent keyEvent) {
        switch (keyEvent.getCode()) {
            case W -> onForwardClick();
            case S -> onBackwardsClick();
            case A -> onLeftClick();
            case D -> onRightClick();
            case G -> onGripperClick();
            case H -> onBuzzerClick();
            case J -> onLightsClick();
            default -> {
            }
        }
    }
}
