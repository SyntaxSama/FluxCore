package net.syntaxsama.fluxcore.windows;

import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.HashMap;
import java.util.Map;

public class WindowControls {

    private ImageView sprite;
    private double speed;
    private Map<KeyCode, Runnable> keyBindings;

    public WindowControls(Scene scene, ImageView sprite, double speed) {
        this.sprite = sprite;
        this.speed = speed;
        this.keyBindings = new HashMap<>();
        initControls(scene);
    }

    private void initControls(Scene scene) {
        scene.setOnKeyPressed(this::handleKeyPressed);
    }

    private void handleKeyPressed(KeyEvent keyEvent) {
        Runnable action = keyBindings.get(keyEvent.getCode());
        if (action != null) {
            action.run();
        }
    }

    public void moveUp() {
        sprite.setY(sprite.getY() - speed);
    }

    public void moveDown() {
        sprite.setY(sprite.getY() + speed);
    }

    public void moveLeft() {
        sprite.setX(sprite.getX() - speed);
    }

    public void moveRight() {
        sprite.setX(sprite.getX() + speed);
    }

    public void bindKey(KeyCode key, Runnable action) {
        keyBindings.put(key, action);
    }
}
