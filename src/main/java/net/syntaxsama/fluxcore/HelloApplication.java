package net.syntaxsama.fluxcore;

import javafx.application.Application;
import javafx.stage.Stage;
import net.syntaxsama.fluxcore.windows.Window;
import net.syntaxsama.fluxcore.windows.WindowContent;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Window newStage = new Window("Test", 500, 350, false);

        WindowContent content = (WindowContent) newStage.getScene();
        content.addSprite("/Users/syntaxsama/IdeaProjects/FluxCore/src/main/resources/smile.png", 100, 100, 100, 100);
    }

    public static void main(String[] args) {
        launch();
    }
}