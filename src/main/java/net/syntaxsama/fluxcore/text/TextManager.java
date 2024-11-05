package net.syntaxsama.fluxcore.text;

import javafx.scene.Group;
import javafx.scene.paint.Color;

import java.util.HashMap;
import java.util.Map;

public class TextManager {

    private Group root;
    private Map<String, TextElement> textElements;

    public TextManager(Group root) {
        this.root = root;
        this.textElements = new HashMap<>();
    }

    public void addText(String id, String content, double x, double y, double fontSize, Color color) {
        TextElement textElement = new TextElement(content, x, y, fontSize, color);
        textElements.put(id, textElement);
        root.getChildren().add(textElement.getText());
    }

    public TextElement getTextById(String id) {
        return textElements.get(id);
    }

    public void removeTextById(String id) {
        TextElement textElement = textElements.remove(id);
        if (textElement != null) {
            root.getChildren().remove(textElement.getText());
        }
    }

    public boolean hasText(String id) {
        return textElements.containsKey(id);
    }

    public void setText(String id, String newText) {
        TextElement textElement = textElements.get(id);
        if (textElement != null) {
            textElement.setContent(newText); 
        }
    }
}
