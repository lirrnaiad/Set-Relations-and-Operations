module com.sets.discremathsets {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.sets.discremathsets to javafx.fxml;
    exports com.sets.discremathsets;
    exports com.sets.discremathsets.logic;
    opens com.sets.discremathsets.logic to javafx.fxml;
}