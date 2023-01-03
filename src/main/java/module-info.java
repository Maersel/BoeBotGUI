module com.example.boebotgui {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens BoeBotGUI to javafx.fxml;
    exports BoeBotGUI;
    exports BoeBotGUI.Controllers;
    opens BoeBotGUI.Controllers to javafx.fxml;
}