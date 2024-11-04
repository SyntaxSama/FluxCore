package net.syntaxsama.fluxcore.windows;

import javafx.scene.Group;
import javafx.stage.Stage;

public class Window extends Stage {


    public Window(String title, int width, int height, Boolean resizable) {
        this.setTitle(title);
        this.setWidth(width);
        this.setHeight(height);
        this.setResizable(resizable);

        Group root = new Group();
        WindowContent content = new WindowContent(root, width, height);
        this.setScene(content);

        this.show();
    }

}