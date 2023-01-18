package BoeBotGUI.Controllers;

import BoeBotGUI.BoeBotController;
//import BoeBotGUI.locationRecorder;
import BoeBotGUI.sceneSwitcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

public class MapController {

    //    private locationRecorder location;
    private BoeBotController boeBotController;

    private boolean placeGoatFeedPlaceClicked = false;
    private boolean placeStartingPointClicked = false;
    private boolean placeGoatFeedPickupClicked = false;

    private int intGoatFeed;
    private int intGoatFeedMode;
    private int intStartingPoint = 15;

    private int buttonsRemoveGoatFeed = 1;
    private int buttonsRemoveStartingPoint = 16;

    private boolean goatFeedPointSelected = false;
    private boolean startingPointSelected = true;

    @FXML
    private Circle goatFeed;
    @FXML
    private Circle startingPoint;
    @FXML
    private ImageView mapImage;

    @FXML
    void initialize() {
        button16.setStyle("-fx-background-color: #00ff00");
//        location = new locationRecorder();
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
//        if (placeGoatFeedClicked) {
//            location.setGoatFeedCoords(event.getSceneX() + 10, event.getSceneY() + 10);
//            //move goat feed circle into selected position
//            this.goatFeed.setLayoutX((int) event.getSceneX() + 10);
//            this.goatFeed.setLayoutY((int) event.getSceneY() + 10);
//            goatFeed.setOpacity(100);
//            //setting cursor to default
//            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//            Scene scene = stage.getScene();
//            scene.setCursor(Cursor.DEFAULT);
//            //debug
////            System.out.println("Goat feed placed at (" + (int)event.getSceneX() + 10 + ", " + (int)event.getSceneY() + 10 + ")");
////            System.out.println("Actual location: " + goatFeed.getLayoutX() + ", " + goatFeed.getLayoutY());
//
//            placeGoatFeedClicked = false;
//        }
//        if (placeStartingPointClicked) {
//            location.setStartingPointCoords(event.getSceneX() + 10, event.getSceneY() + 10);
//            //move starting point circle into selected position
//            this.startingPoint.setLayoutX((int) event.getSceneX() + 10);
//            this.startingPoint.setLayoutY((int) event.getSceneY() + 10);
//            startingPoint.setOpacity(100);
//            //setting cursor to default
//            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//            Scene scene = stage.getScene();
//            scene.setCursor(Cursor.DEFAULT);
//            //debug
////            System.out.println("Starting point placed at (" + (int)event.getSceneX() + 10 + ", " + (int)event.getSceneY() + 10 + ")");
//
//            placeStartingPointClicked = false;
//        }
    }

    @FXML
    void placeStartingPoint(ActionEvent event) {
        placeStartingPointClicked = true;
        placeGoatFeedPickupClicked = false;
        placeGoatFeedPlaceClicked = false;
        selectButtonPress(placeStartingPoint);
    }

    @FXML
    void placeGoatFeedPickup(ActionEvent event) {
        placeStartingPointClicked = false;
        placeGoatFeedPickupClicked = true;
        placeGoatFeedPlaceClicked = false;
        selectButtonPress(placeGoatFeedPickup);
    }

    @FXML
    void placeGoatFeedPlace(ActionEvent event) {
        placeStartingPointClicked = false;
        placeGoatFeedPickupClicked = false;
        placeGoatFeedPlaceClicked = true;
        selectButtonPress(placeGoatFeedPlace);
    }

    @FXML
    void onConfirmButton(ActionEvent event) {
        if (goatFeedPointSelected && startingPointSelected && intStartingPoint != intGoatFeed) {
            Alert confirm = new Alert(AlertType.CONFIRMATION);
            confirm.setTitle("confirm");
            confirm.setContentText("Confirm selected locations?");
            Optional<ButtonType> choice = confirm.showAndWait();
            if (choice.get() == ButtonType.OK) {
//                location.setDropOff(dropOffNumber);
                boeBotController.sendRoute(intStartingPoint, intGoatFeed, intGoatFeedMode);

                System.out.println("startingPoint n" + intStartingPoint + " | p" + buttonsRemoveStartingPoint + "\t\t" + "goatFeed n" + intGoatFeed + " | p" + buttonsRemoveGoatFeed + " || m" + intGoatFeedMode);
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

    private void buttonPress(Button button, int boeBotInt, int buttonInt) {
        unselectAllOtherDropOffButtons();
        if (placeStartingPointClicked) {
            intStartingPoint = boeBotInt;
            buttonsRemoveStartingPoint = buttonInt;
            startingPointSelected = true;
            button.setStyle("-fx-background-color: #00ff00");
        }
        if (placeGoatFeedPlaceClicked) {
            intGoatFeed = boeBotInt;
            intGoatFeedMode = 41;
            buttonsRemoveGoatFeed = buttonInt;
            goatFeedPointSelected = true;
            button.setStyle("-fx-background-color: #ff7a00");
        }
        if (placeGoatFeedPickupClicked) {
            intGoatFeed = boeBotInt;
            intGoatFeedMode = 42;
            buttonsRemoveGoatFeed = buttonInt;
            goatFeedPointSelected = true;
            button.setStyle("-fx-background-color: #ff0000");
        }
    }

    private void selectButtonPress(Button button) {
        unselectOtherSelectButtons();
        button.setStyle("-fx-background-color: #a5a5a5");
    }

    @FXML
    void onButton1(ActionEvent event) {
        buttonPress(button1, 26, 1);
    }

    @FXML
    void onButton2(ActionEvent event) {
        buttonPress(button2, 18, 2);
    }

    @FXML
    void onButton3(ActionEvent event) {
        buttonPress(button3, 19, 3);
    }

    @FXML
    void onButton4(ActionEvent event) {
        buttonPress(button4, 25, 4);
    }

    @FXML
    void onButton5(ActionEvent event) {
        buttonPress(button5, 31, 5);
    }

    @FXML
    void onButton6(ActionEvent event) {
        buttonPress(button6, 32, 6);
    }

    @FXML
    void onButton7(ActionEvent event) {
        buttonPress(button7, 27, 7);
    }

    @FXML
    void onButton8(ActionEvent event) {
        buttonPress(button8, 28, 8);
    }

    @FXML
    void onButton9(ActionEvent event) {
        buttonPress(button9, 20, 9);
    }

    @FXML
    void onButton10(ActionEvent event) {
        buttonPress(button10, 24, 10);
    }

    @FXML
    void onButton11(ActionEvent event) {
        buttonPress(button11, 17, 11);
    }

    @FXML
    void onButton12(ActionEvent event) {
        buttonPress(button12, 13, 12);
    }

    @FXML
    void onButton13(ActionEvent event) {
        buttonPress(button13, 14, 13);
    }

    @FXML
    void onButton14(ActionEvent event) {
        buttonPress(button14, 21, 14);
    }

    @FXML
    void onButton15(ActionEvent event) {
        buttonPress(button15, 16, 15);
    }

    @FXML
    void onButton16(ActionEvent event) {
        buttonPress(button16, 15, 16);
    }

    @FXML
    void onButton17(ActionEvent event) {
        buttonPress(button17, 30, 17);
    }

    @FXML
    void onButton18(ActionEvent event) {
        buttonPress(button18, 29, 18);
    }

    @FXML
    void onButton19(ActionEvent event) {
        buttonPress(button19, 23, 19);
    }

    @FXML
    void onButton20(ActionEvent event) {
        buttonPress(button20, 22, 20);
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

    private ArrayList<Button> buttons;

    private void unselectAllOtherDropOffButtons() {
        this.buttons = new ArrayList<>();

        buttons.add(button1);
        buttons.add(button2);
        buttons.add(button3);
        buttons.add(button4);
        buttons.add(button5);
        buttons.add(button6);
        buttons.add(button7);
        buttons.add(button8);
        buttons.add(button9);
        buttons.add(button10);
        buttons.add(button11);
        buttons.add(button12);
        buttons.add(button13);
        buttons.add(button14);
        buttons.add(button15);
        buttons.add(button16);
        buttons.add(button17);
        buttons.add(button18);
        buttons.add(button19);
        buttons.add(button20);

        if (placeGoatFeedPlaceClicked || placeGoatFeedPickupClicked) {
            buttons.remove(buttonsRemoveStartingPoint - 1);
        }
        if (placeStartingPointClicked) {
            buttons.remove(buttonsRemoveGoatFeed - 1);
        }
        for (Button button : buttons) {
            button.setStyle("");
        }
    }

    @FXML
    private Button placeStartingPoint;
    @FXML
    private Button placeGoatFeedPickup;
    @FXML
    private Button placeGoatFeedPlace;

    private ArrayList<Button> selectButtons;

    private void unselectOtherSelectButtons() {
        this.selectButtons = new ArrayList<>();

        selectButtons.add(placeStartingPoint);
        selectButtons.add(placeGoatFeedPickup);
        selectButtons.add(placeGoatFeedPlace);

        for (Button selectButton : selectButtons) {
            selectButton.setStyle("");
        }
    }


}
