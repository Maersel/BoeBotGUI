package BoeBotGUI;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import jssc.SerialPortException;

import java.io.IOException;

public class sceneSwitcher {

    Stage stage;
    Scene controls;
    Scene map;

    private BoeBotController boeBotController;

    public sceneSwitcher(Stage stage) {
        this.stage = stage;
    }

    public void switchToControls() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("BoeBotGUI.fxml"));
        controls = new Scene(fxmlLoader.load(), 960, 540);
        stage.setTitle("BoeBot GUI");
        stage.setScene(controls);
    }

    public void switchToMap() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("map.fxml"));
        map = new Scene(fxmlLoader.load(), 960, 540);
        stage.setTitle("BoeBot GUI");
        stage.setScene(map);
    }
}
