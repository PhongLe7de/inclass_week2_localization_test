module org.example.inclass_week2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.inclass_week2 to javafx.fxml;
    exports org.example.inclass_week2;
}