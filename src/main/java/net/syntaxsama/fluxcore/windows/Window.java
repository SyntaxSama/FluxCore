package net.syntaxsama.fluxcore.windows;

import javafx.scene.Group;
import javafx.stage.Stage;

public class Window extends Stage {

    private WindowContent currentContent;

    public Window(String title, int width, int height, Boolean resizable) {
        this.setTitle(title);
        this.setWidth(width);
        this.setHeight(height);
        this.setResizable(resizable);

        Group root = new Group();
        currentContent = new WindowContent(root, width, height);
        this.setScene(currentContent);

        this.show();
    }

    public void setWindow(WindowContent newContent) {
        this.setScene(newContent);
        currentContent = newContent;
    }

    public WindowContent getCurrentContent() {
        return currentContent;
    }
}
