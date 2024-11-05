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
    private double jumpHeight;
    private boolean isJumping;
    private boolean diagonalMovementEnabled;
    private boolean jumpingEnabled;
    private Map<KeyCode, Runnable> keyBindings;
    private Map<KeyCode, Boolean> keyStates;

    public WindowControls(Scene scene, ImageView sprite, double speed, double jumpHeight) {
        this.sprite = sprite;
        this.speed = speed;
        this.jumpHeight = jumpHeight;
        this.isJumping = false;
        this.diagonalMovementEnabled = false;
        this.jumpingEnabled = false;
        this.keyBindings = new HashMap<>();
        this.keyStates = new HashMap<>();
        initControls(scene);
    }

    private void initControls(Scene scene) {
        scene.setOnKeyPressed(this::handleKeyPressed);
        scene.setOnKeyReleased(this::handleKeyReleased);
    }

    private void handleKeyPressed(KeyEvent keyEvent) {
        keyStates.put(keyEvent.getCode(), true);
        Runnable action = keyBindings.get(keyEvent.getCode());
        if (action != null) {
            action.run();
        }

        if (keyEvent.getCode() == KeyCode.SPACE && jumpingEnabled && !isJumping) {
            jump();
        }

        if (diagonalMovementEnabled) {
            checkDiagonalMovement();
        }
    }

    private void handleKeyReleased(KeyEvent keyEvent) {
        keyStates.put(keyEvent.getCode(), false);
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

    private void checkDiagonalMovement() {
        if (keyStates.getOrDefault(KeyCode.W, false) && keyStates.getOrDefault(KeyCode.A, false)) {
            moveUp();
            moveLeft();
        } else if (keyStates.getOrDefault(KeyCode.W, false) && keyStates.getOrDefault(KeyCode.D, false)) {
            moveUp();
            moveRight();
        } else if (keyStates.getOrDefault(KeyCode.S, false) && keyStates.getOrDefault(KeyCode.A, false)) {
            moveDown();
            moveLeft();
        } else if (keyStates.getOrDefault(KeyCode.S, false) && keyStates.getOrDefault(KeyCode.D, false)) {
            moveDown();
            moveRight();
        }
    }

    public void jump() {
        isJumping = true;
        sprite.setY(sprite.getY() - jumpHeight);

        new Thread(() -> {
            try {
                Thread.sleep(500);
                sprite.setY(sprite.getY() + jumpHeight);
            } catch (InterruptedException e) {
                System.err.println("Jump thread was interrupted: " + e.getMessage());
            } finally {
                isJumping = false;
            }
        }).start();
    }

    public void bindKey(KeyCode key, Runnable action) {
        keyBindings.put(key, action);
    }

    public void setDiagonalMovementEnabled(boolean enabled) {
        this.diagonalMovementEnabled = enabled;
    }

    public void setJumpingEnabled(boolean enabled) {
        this.jumpingEnabled = enabled;
    }
}
