module com.krieger.FactoryFX {
    requires javafx.controls;
    requires javafx.fxml;


    exports com.krieger.factoryFX;
    opens com.krieger.factoryFX to javafx.fxml;
}