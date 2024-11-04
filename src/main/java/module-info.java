module net.syntaxsama.testgame {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens net.syntaxsama.testgame to javafx.fxml;
    exports net.syntaxsama.testgame;
}