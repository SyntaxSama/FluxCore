module net.syntaxsama.fluxcore {
    requires javafx.controls;
    requires javafx.fxml;


    opens net.syntaxsama.fluxcore to javafx.fxml;
    exports net.syntaxsama.fluxcore;
}