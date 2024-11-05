package net.syntaxsama.fluxcore.gui;

import javafx.scene.Group;
import javafx.scene.input.KeyCode;

import java.util.HashMap;
import java.util.Map;

public class KeyBinds {

    private final Group group;
    private final Map<KeyCode, Runnable> keyBindings;

    public KeyBinds(Group group) {
        this.group = group;
        this.keyBindings = new HashMap<>();
        initializeKeyHandler();
    }

    private void initializeKeyHandler() {
        group.setOnKeyPressed(event -> {
            KeyCode code = event.getCode();
            Runnable action = keyBindings.get(code);
            if (action != null) {
                action.run();
            }
        });
    }

    public void bindKey(KeyCode keyCode, Runnable action) {
        keyBindings.put(keyCode, action);
    }

    public void unbindKey(KeyCode keyCode) {
        keyBindings.remove(keyCode);
    }

    public void clearBindings() {
        keyBindings.clear();
    }
}