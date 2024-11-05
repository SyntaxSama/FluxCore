package net.syntaxsama.fluxcore.gui;

import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;

public class Sliders {

    private Slider slider;
    private Label label;

    public Sliders(Group parentGroup, String labelText, double min, double max, double value, double labelX, double labelY, double sliderX, double sliderY) {
        label = new Label(labelText);
        label.setLayoutX(labelX);
        label.setLayoutY(labelY);

        slider = new Slider(min, max, value);
        slider.setLayoutX(sliderX);
        slider.setLayoutY(sliderY);

        parentGroup.getChildren().addAll(label, slider);
    }

    public void setLabelText(String text) {
        label.setText(text);
    }

    public double getValue() {
        return slider.getValue();
    }

    public void setValue(double value) {
        slider.setValue(value);
    }
}