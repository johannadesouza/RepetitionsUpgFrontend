module com.example.repetitionfx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.repetitionfx to javafx.fxml;
    exports com.example.repetitionfx;
}