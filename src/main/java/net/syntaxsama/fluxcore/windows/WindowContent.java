package net.syntaxsama.fluxcore.windows;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

public class WindowContent extends Scene {

    private Canvas canvas;
    private GraphicsContext gc;
    private Group root;
    private Map<String, ImageView> sprites;

    public WindowContent(Group root, int width, int height) {
        super(root, width, height);
        this.root = root;
        this.canvas = new Canvas(width, height);
        this.gc = canvas.getGraphicsContext2D();
        this.sprites = new HashMap<>();

        root.getChildren().add(canvas);
    }

    public void addSprite(String id, String spritePath, double x, double y, double width, double height) {
        try {
            Image spriteImage = new Image(new FileInputStream(spritePath));
            ImageView sprite = new ImageView(spriteImage);

            sprite.setFitWidth(width);
            sprite.setFitHeight(height);
            sprite.setX(x);
            sprite.setY(y);
            sprite.setPreserveRatio(true);

            root.getChildren().add(sprite);
            sprites.put(id, sprite);
        } catch (FileNotFoundException e) {
            System.err.println("Something went wrong when trying to add sprite " + spritePath);
        }
    }

    public ImageView getSprite(String id) {
        return sprites.get(id);
    }

    public void removeSpriteById(String id) {
        ImageView sprite = sprites.remove(id);
        if (sprite != null) {
            root.getChildren().remove(sprite);
        }
    }

    public boolean hasSprite(String id) {
        return sprites.containsKey(id);
    }
}
