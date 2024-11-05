package net.syntaxsama.fluxcore.gui;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.Group;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

public class Buttons {

    private final Map<String, Button> buttonGroup;
    private final Group group;

    public Buttons(Group group) {
        this.buttonGroup = new HashMap<>();
        this.group = group;
    }

    public void addButton(String id, String text, double x, double y, double width, double height, String graphicPath, Runnable action) {
        Button button = new Button(text);
        button.setId(id);
        button.setLayoutX(x);
        button.setLayoutY(y);
        button.setMinSize(width, height);
        button.setMaxSize(width, height);

        try {
            if (graphicPath != null && !graphicPath.isEmpty()) {
                Image graphic = new Image(new FileInputStream(graphicPath));
                ImageView imageView = new ImageView(graphic);

                button.setGraphic(imageView);
                button.setStyle("-fx-background-color: transparent;");
                button.setMinSize(width, height);
                button.setMaxSize(width, height);

                if (action != null) {
                    button.setOnAction(event -> action.run());
                }

                imageView.setOnMouseClicked(event -> button.fire());
                imageView.setLayoutX(x);
                imageView.setLayoutY(y);
                imageView.setFitWidth(width);
                imageView.setFitHeight(height);
                imageView.setPreserveRatio(true);

                group.getChildren().add(imageView);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Something went wrong when trying to add the button with id '" + id + "' with the graphic " + graphicPath);
        }


        if (action != null) {
            button.setOnAction(event -> action.run());
        }

        buttonGroup.put(id, button);
        group.getChildren().add(button);
    }

    public Button getButton(String id) {
        return buttonGroup.get(id);
    }

    public void removeButton(String id) {
        Button button = buttonGroup.remove(id);
        if (button != null) {
            group.getChildren().remove(button);
        }
    }
}
