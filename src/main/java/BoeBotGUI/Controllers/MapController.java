package BoeBotGUI.Controllers;

import BoeBotGUI.sceneSwitcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.stage.Stage;

import java.io.IOException;

public class MapController {

    @FXML
    void switchToControls(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        sceneSwitcher sceneSwitcher = new sceneSwitcher(stage);
        sceneSwitcher.switchToControls();
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
