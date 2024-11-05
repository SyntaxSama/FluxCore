package net.syntaxsama.testgame;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import net.syntaxsama.fluxcore.gui.Buttons;
import net.syntaxsama.fluxcore.gui.Sliders;
import net.syntaxsama.fluxcore.text.TextManager;
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
        TextManager text = new TextManager(root);
        content.addSprite("1", "/Users/syntaxsama/IdeaProjects/FluxCore/src/main/resources/smile.png", 100, 100, 100, 100);

        text.addText("1", "Test Text", 100, 90, 90, Color.BLACK);

        WindowControls controls = new WindowControls(content, content.getSprite("1"), 50.0, 10.0);
        controls.bindKey(KeyCode.W, controls::moveUp);
        controls.bindKey(KeyCode.A, controls::moveLeft);
        controls.bindKey(KeyCode.S, controls::moveDown);
        controls.bindKey(KeyCode.D, controls::moveRight);
        controls.setDiagonalMovementEnabled(true);
        controls.setJumpingEnabled(true);

        controls.bindKey(KeyCode.ENTER, () -> setNewWindowContent());

        newStage.setWindow(content);
    }

    private void setNewWindowContent() {
        Group newRoot = new Group();
        WindowContent newContent = new WindowContent(newRoot, 500, 350);

        Sliders volume = new Sliders(newRoot, "Volume", 0, 100, 50, 100, 100, 150, 100);

        Buttons buttonManager = new Buttons(newRoot);
        buttonManager.addButton("clickHere", null, 100, 100, 90, 90, "/Users/syntaxsama/IdeaProjects/FluxCore/src/main/resources/smile.png", () -> {
            System.out.println("You clicked a button!");
        });

        newStage.setWindow(newContent);
    }

    public static void main(String[] args) {
        launch();
    }
}
