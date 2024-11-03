package net.syntaxsama.fluxcore.windows;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class WindowContent extends Scene {

    private Canvas canvas;
    private GraphicsContext gc;
    private Group root;
    private ImageView sprite;

    public WindowContent(Group root, int width, int height) {
        super(root, width, height);
        this.root = root;

        canvas = new Canvas(width, height);
        gc = canvas.getGraphicsContext2D();
        root.getChildren().add(canvas);
    }

    public void addSprite(String spritePath, double x, double y, double width, double height) {
        try {
            Image spriteImage = new Image(new FileInputStream(spritePath));
            sprite = new ImageView(spriteImage);

            sprite.setFitWidth(width);
            sprite.setFitHeight(height);
            sprite.setX(x);
            sprite.setY(y);
            sprite.setPreserveRatio(true);

            root.getChildren().add(sprite);
        } catch (FileNotFoundException e) {
            System.err.println("Something went wrong when trying to add sprite " + spritePath);
        }
    }

    public ImageView getSprite() {
        return sprite;
    }
}
