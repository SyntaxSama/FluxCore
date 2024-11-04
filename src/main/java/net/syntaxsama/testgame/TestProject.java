package net.syntaxsama.testgame;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import net.syntaxsama.fluxcore.windows.Window;
import net.syntaxsama.fluxcore.windows.WindowContent;
import net.syntaxsama.fluxcore.windows.WindowControls;

import java.io.IOException;

public class TestProject extends Application {

    private Window newStage;

    @Override
    public void start(Stage stage) throws IOException {
        newStage = new Window("Test", 500, 350, false);

        setupInitialContent();
    }

    private void setupInitialContent() {
        Group root = new Group();
        WindowContent content = new WindowContent(root, 500, 350);
        content.addSprite("/Users/syntaxsama/IdeaProjects/FluxCore/src/main/resources/smile.png", 100, 100, 100, 100);

        WindowControls controls = new WindowControls(content, content.getSprite(), 50.0, 10.0);
        controls.bindKey(KeyCode.W, controls::moveUp);
        controls.bindKey(KeyCode.A, controls::moveLeft);
        controls.bindKey(KeyCode.S, controls::moveDown);
        controls.bindKey(KeyCode.D, controls::moveRight);

        controls.bindKey(KeyCode.ENTER, () -> setNewWindowContent());

        newStage.setWindow(content);
    }

    private void setNewWindowContent() {
        Group newRoot = new Group();
        WindowContent newContent = new WindowContent(newRoot, 500, 350);

        newContent.addSprite("/Users/syntaxsama/IdeaProjects/FluxCore/src/main/resources/smile.png", 150, 110, 200, 200);

        newStage.getScene().setFill(Color.AQUA);

        newStage.setWindow(newContent);
    }

    public static void main(String[] args) {
        launch();
    }
}
