package BoeBotGUI.Controllers;

import BoeBotGUI.locationRecorder;
import BoeBotGUI.sceneSwitcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.awt.event.MouseEvent;
import java.io.IOException;

public class MapController {

    private locationRecorder location;

    private boolean placeGoatFeedClicked = false;
    private boolean placeStartingPointClicked = false;

    @FXML
    private Circle goatFeed;
    @FXML
    private Circle startingPoint;
    @FXML
    private ImageView mapImage;



    @FXML
    void initialize() {
        location = new locationRecorder();
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
            System.out.println("Goat feed placed at (" + (int)event.getSceneX() + 10 + ", " + (int)event.getSceneY() + 10 + ")");
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
            System.out.println("Starting point placed at (" + (int)event.getSceneX() + 10 + ", " + (int)event.getSceneY() + 10 + ")");

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
        System.out.println("Goat feed selected");
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
        System.out.println("Starting point selected");
    }

    @FXML
    void onButton1(ActionEvent event) {

    }

    @FXML
    void onButton10(ActionEvent event) {

    }

    @FXML
    void onButton11(ActionEvent event) {

    }

    @FXML
    void onButton12(ActionEvent event) {

    }

    @FXML
    void onButton13(ActionEvent event) {

    }

    @FXML
    void onButton14(ActionEvent event) {

    }

    @FXML
    void onButton15(ActionEvent event) {

    }

    @FXML
    void onButton16(ActionEvent event) {

    }

    @FXML
    void onButton17(ActionEvent event) {

    }

    @FXML
    void onButton2(ActionEvent event) {

    }

    @FXML
    void onButton3(ActionEvent event) {

    }

    @FXML
    void onButton4(ActionEvent event) {

    }

    @FXML
    void onButton5(ActionEvent event) {

    }

    @FXML
    void onButton6(ActionEvent event) {

    }

    @FXML
    void onButton7(ActionEvent event) {

    }

    @FXML
    void onButton8(ActionEvent event) {

    }

    @FXML
    void onButton9(ActionEvent event) {

    }

    @FXML
    void onButton18(ActionEvent event) {
    }
}
