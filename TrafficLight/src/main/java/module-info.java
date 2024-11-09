module cisc191.trafficlight {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;

    opens cisc191.trafficlight to javafx.fxml;
    exports cisc191.trafficlight;
}