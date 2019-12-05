module com.mycompany.sustainia {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.sustainia to javafx.fxml;
    exports com.mycompany.sustainia;
}