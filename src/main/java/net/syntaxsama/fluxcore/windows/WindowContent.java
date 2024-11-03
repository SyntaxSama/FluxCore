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

    public WindowContent(Group root, int width, int height) {
        super(root, width, height);
        this.root = root;

        canvas = new Canvas(width, height);
        gc = canvas.getGraphicsContext2D();
        root.getChildren().add(canvas);
    }

    public void addSprite(String spritePath, double x, double y, double width, double height) {
        try {
            Image sprite = new Image(new FileInputStream(spritePath));
            ImageView imageView = new ImageView(sprite);

            imageView.setFitWidth(width);
            imageView.setFitHeight(height);
            imageView.setX(x);
            imageView.setY(y);
            imageView.setPreserveRatio(true);

            root.getChildren().add(imageView);
        } catch (FileNotFoundException e) {
            System.err.println("Something went wrong when trying to add sprite " + spritePath);
        }
    }
}
