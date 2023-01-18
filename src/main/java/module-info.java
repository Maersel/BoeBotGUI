module com.example.boebotgui {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires jssc;


    opens BoeBotGUI to javafx.fxml;
    exports BoeBotGUI;
    exports BoeBotGUI.Controllers;
    opens BoeBotGUI.Controllers to javafx.fxml;
}