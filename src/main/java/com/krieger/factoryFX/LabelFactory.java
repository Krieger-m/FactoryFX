package com.krieger.factoryFX;

import javafx.scene.control.Label;
import javafx.scene.Node;

public class LabelFactory implements ViewFactory { // Implementiert ViewFactory

    private String text;

    public LabelFactory(String text) {
        this.text = text;
    }

    @Override
    public Node createView() { // Erzeugt ein Label
        return new Label(this.text);
    }
}