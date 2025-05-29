package com.krieger.factoryFX;

import javafx.scene.layout.HBox;
import javafx.scene.Node;

public class HBoxFactory implements ViewFactory {

    @Override
    public Node createView() {
        return new HBox();
    }
}