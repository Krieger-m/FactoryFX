package com.krieger.factoryFX;

import javafx.scene.layout.VBox;
import javafx.scene.Node;

public class VBoxFactory implements ViewFactory { // Implementiert ViewFactory
    @Override
    public Node createView() { // Erzeugt eine VBox
        return new VBox();
    }
}