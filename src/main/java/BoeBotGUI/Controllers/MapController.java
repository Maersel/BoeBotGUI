package BoeBotGUI.Controllers;

import BoeBotGUI.BoeBotController;
import BoeBotGUI.locationRecorder;
import BoeBotGUI.sceneSwitcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.Optional;

public class MapController {

    private locationRecorder location;
    private BoeBotController boeBotController;

    private boolean placeGoatFeedClicked = false;
    private boolean placeStartingPointClicked = false;

    private boolean dropOffSelected = false;
    private int dropOffNumber;

    @FXML
    private Circle goatFeed;
    @FXML
    private Circle startingPoint;
    @FXML
    private ImageView mapImage;


    @FXML
    void initialize() {
        location = new locationRecorder();
        boeBotController = new BoeBotController();
        boeBotController.startBluetooth();
    }

    @FXML
    void switchToControls(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        sceneSwitcher sceneSwitcher = new sceneSwitcher(stage);
        sceneSwitcher.switchToControls();
    }

    public void onMouseClicked(javafx.scene.input.MouseEvent event) {
        if (placeGoatFeedClicked) {
            location.setGoatFeedCoords(event.getSceneX() + 10, event.getSceneY() + 10);
            //move goat feed circle into selected position
            this.goatFeed.setLayoutX((int)event.getSceneX() + 10);
            this.goatFeed.setLayoutY((int)event.getSceneY() + 10);
            goatFeed.setOpacity(100);
            //setting cursor to default
            Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            Scene scene = stage.getScene();
            scene.setCursor(Cursor.DEFAULT);
            //debug
//            System.out.println("Goat feed placed at (" + (int)event.getSceneX() + 10 + ", " + (int)event.getSceneY() + 10 + ")");
//            System.out.println("Actual location: " + goatFeed.getLayoutX() + ", " + goatFeed.getLayoutY());

            placeGoatFeedClicked = false;
        }
        if (placeStartingPointClicked) {
            location.setStartingPointCoords(event.getSceneX() + 10, event.getSceneY() + 10);
            //move starting point circle into selected position
            this.startingPoint.setLayoutX((int)event.getSceneX() + 10);
            this.startingPoint.setLayoutY((int)event.getSceneY() + 10);
            startingPoint.setOpacity(100);
            //setting cursor to default
            Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            Scene scene = stage.getScene();
            scene.setCursor(Cursor.DEFAULT);
            //debug
//            System.out.println("Starting point placed at (" + (int)event.getSceneX() + 10 + ", " + (int)event.getSceneY() + 10 + ")");

            placeStartingPointClicked = false;
        }
    }

    @FXML
    void placeGoatFeed(ActionEvent event) {
        placeStartingPointClicked = false;
        placeGoatFeedClicked = true;
        //setting cursor to circle
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        Scene scene = stage.getScene();
        SnapshotParameters sp = new SnapshotParameters();
        sp.setFill(Color.TRANSPARENT);
        Image image = goatFeed.snapshot(sp, null);
        scene.setCursor(new ImageCursor(image));

        goatFeed.setOpacity(0);
        //debug
//        System.out.println("Goat feed selected");
    }

    @FXML
    void placeStartingPoint(ActionEvent event) {
        placeGoatFeedClicked = false;
        placeStartingPointClicked = true;
        //setting cursor to circle
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        Scene scene = stage.getScene();
        SnapshotParameters sp = new SnapshotParameters();
        sp.setFill(Color.TRANSPARENT);
        Image image = startingPoint.snapshot(sp, null);
        scene.setCursor(new ImageCursor(image));

        startingPoint.setOpacity(0);
//        System.out.println("Starting point selected");
    }

    @FXML
    void onConfirmButton(ActionEvent event) {
        if (goatFeed.getLayoutX() != 124 && goatFeed.getLayoutY() != 521 &&
                startingPoint.getLayoutX() != 144 && startingPoint.getLayoutY() != 488 && dropOffSelected) {
            Alert confirm = new Alert(AlertType.CONFIRMATION);
            confirm.setTitle("confirm");
            confirm.setContentText("Confirm selected locations?");
            Optional<ButtonType> choice = confirm.showAndWait();
            if (choice.get() == ButtonType.OK) {
                location.setDropOff(dropOffNumber);
                boeBotController.followRoute();
            }
        } else {
            Alert error = new Alert(AlertType.ERROR);
            error.setTitle("error");
            error.setContentText("You haven't selected all locations yet");
            Optional<ButtonType> choice = error.showAndWait();
            if (choice.get() == ButtonType.OK) {

            }
        }
    }

    @FXML
    void onButton1(ActionEvent event) {
        dropOffSelected = true;
        dropOffNumber = 1;
        unselectAllDropOffButtons();
        button1.setStyle("-fx-background-color: green");
    }

    @FXML
    void onButton2(ActionEvent event) {
        dropOffSelected = true;
        dropOffNumber = 2;
        unselectAllDropOffButtons();
        button2.setStyle("-fx-background-color: green");
    }

    @FXML
    void onButton3(ActionEvent event) {
        dropOffSelected = true;
        dropOffNumber = 3;
        unselectAllDropOffButtons();
        button3.setStyle("-fx-background-color: green");
    }

    @FXML
    void onButton4(ActionEvent event) {
        dropOffSelected = true;
        dropOffNumber = 4;
        unselectAllDropOffButtons();
        button4.setStyle("-fx-background-color: green");
    }

    @FXML
    void onButton5(ActionEvent event) {
        dropOffSelected = true;
        dropOffNumber = 5;
        unselectAllDropOffButtons();
        button5.setStyle("-fx-background-color: green");
    }

    @FXML
    void onButton6(ActionEvent event) {
        dropOffSelected = true;
        dropOffNumber = 6;
        unselectAllDropOffButtons();
        button6.setStyle("-fx-background-color: green");
    }

    @FXML
    void onButton7(ActionEvent event) {
        dropOffSelected = true;
        dropOffNumber = 7;
        unselectAllDropOffButtons();
        button7.setStyle("-fx-background-color: green");
    }

    @FXML
    void onButton8(ActionEvent event) {
        dropOffSelected = true;
        dropOffNumber = 8;
        unselectAllDropOffButtons();
        button8.setStyle("-fx-background-color: green");
    }

    @FXML
    void onButton9(ActionEvent event) {
        dropOffSelected = true;
        dropOffNumber = 9;
        unselectAllDropOffButtons();
        button9.setStyle("-fx-background-color: green");
    }

    @FXML
    void onButton10(ActionEvent event) {
        dropOffSelected = true;
        dropOffNumber = 10;
        unselectAllDropOffButtons();
        button10.setStyle("-fx-background-color: green");
    }

    @FXML
    void onButton11(ActionEvent event) {
        dropOffSelected = true;
        dropOffNumber = 11;
        unselectAllDropOffButtons();
        button11.setStyle("-fx-background-color: green");
    }

    @FXML
    void onButton12(ActionEvent event) {
        dropOffSelected = true;
        dropOffNumber = 12;
        unselectAllDropOffButtons();
        button12.setStyle("-fx-background-color: green");
    }

    @FXML
    void onButton13(ActionEvent event) {
        dropOffSelected = true;
        dropOffNumber = 13;
        unselectAllDropOffButtons();
        button13.setStyle("-fx-background-color: green");
    }

    @FXML
    void onButton14(ActionEvent event) {
        dropOffSelected = true;
        dropOffNumber = 14;
        unselectAllDropOffButtons();
        button14.setStyle("-fx-background-color: green");
    }

    @FXML
    void onButton15(ActionEvent event) {
        dropOffSelected = true;
        dropOffNumber = 15;
        unselectAllDropOffButtons();
        button15.setStyle("-fx-background-color: green");
    }

    @FXML
    void onButton16(ActionEvent event) {
        dropOffSelected = true;
        dropOffNumber = 16;
        unselectAllDropOffButtons();
        button16.setStyle("-fx-background-color: green");
    }

    @FXML
    void onButton17(ActionEvent event) {
        dropOffSelected = true;
        dropOffNumber = 17;
        unselectAllDropOffButtons();
        button17.setStyle("-fx-background-color: green");
    }

    @FXML
    void onButton18(ActionEvent event) {
        dropOffSelected = true;
        dropOffNumber = 18;
        unselectAllDropOffButtons();
        button18.setStyle("-fx-background-color: green");
    }

    @FXML
    void onButton19(ActionEvent event) {
        dropOffSelected = true;
        dropOffNumber = 19;
        unselectAllDropOffButtons();
        button19.setStyle("-fx-background-color: green");
    }

    @FXML
    void onButton20(ActionEvent event) {
        dropOffSelected = true;
        dropOffNumber = 20;
        unselectAllDropOffButtons();
        button20.setStyle("-fx-background-color: green");
    }

    @FXML
    private Button button1;
    @FXML
    private Button button2;
    @FXML
    private Button button3;
    @FXML
    private Button button4;
    @FXML
    private Button button5;
    @FXML
    private Button button6;
    @FXML
    private Button button7;
    @FXML
    private Button button8;
    @FXML
    private Button button9;
    @FXML
    private Button button10;
    @FXML
    private Button button11;
    @FXML
    private Button button12;
    @FXML
    private Button button13;
    @FXML
    private Button button14;
    @FXML
    private Button button15;
    @FXML
    private Button button16;
    @FXML
    private Button button17;
    @FXML
    private Button button18;
    @FXML
    private Button button19;
    @FXML
    private Button button20;

    private void unselectAllDropOffButtons() {
        button1.setStyle("");
        button2.setStyle("");
        button3.setStyle("");
        button4.setStyle("");
        button5.setStyle("");
        button6.setStyle("");
        button7.setStyle("");
        button8.setStyle("");
        button9.setStyle("");
        button10.setStyle("");
        button11.setStyle("");
        button12.setStyle("");
        button13.setStyle("");
        button14.setStyle("");
        button15.setStyle("");
        button16.setStyle("");
        button17.setStyle("");
        button18.setStyle("");
        button19.setStyle("");
        button19.setStyle("");
        button20.setStyle("");
    }

}
