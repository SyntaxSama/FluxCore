package net.syntaxsama.testgame;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import net.syntaxsama.fluxcore.windows.Window;
import net.syntaxsama.fluxcore.windows.WindowContent;
import net.syntaxsama.fluxcore.windows.WindowControls;

import java.io.IOException;

public class TestProject extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        Window newStage = new Window("Test", 500, 350, false);
        Group root = new Group();

        WindowContent content = (WindowContent) newStage.getScene();
        content.addSprite("/Users/syntaxsama/IdeaProjects/FluxCore/src/main/resources/smile.png", 100, 100, 100, 100);

        WindowControls controls = new WindowControls(content, content.getSprite(), 50.0, 10.0);
        controls.bindKey(KeyCode.W, controls::moveUp);
        controls.bindKey(KeyCode.A, controls::moveLeft);
        controls.bindKey(KeyCode.S, controls::moveDown);
        controls.bindKey(KeyCode.D, controls::moveRight);

    }

    public static void main(String[] args) {
        launch();
    }
}