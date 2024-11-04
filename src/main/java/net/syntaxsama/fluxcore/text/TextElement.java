package net.syntaxsama.fluxcore.text;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class TextElement {

    private Text text;

    public TextElement(String content, double x, double y, double fontSize, Color color) {
        text = new Text(content);
        text.setX(x);
        text.setY(y);
        text.setFont(new Font(fontSize));
        text.setFill(color);
    }

    public Text getText() {
        return text;
    }

    public void setContent(String content) {
        text.setText(content);
    }

    public void setPosition(double x, double y) {
        text.setX(x);
        text.setY(y);
    }

    public void setFontSize(double fontSize) {
        text.setFont(new Font(fontSize));
    }

    public void setColor(Color color) {
        text.setFill(color);
    }
}
