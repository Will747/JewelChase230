module com.example.jewelchase230 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.jewelchase230 to javafx.fxml;
    exports com.example.jewelchase230;
}