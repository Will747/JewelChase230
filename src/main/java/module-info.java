module com.example.jewelchase230 {
    requires javafx.controls;
    requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.base;


    opens com.example.jewelchase230 to javafx.fxml;
    exports com.example.jewelchase230;
    exports com.example.jewelchase230.vectors;
    opens com.example.jewelchase230.vectors to javafx.fxml;
    exports com.example.jewelchase230.items;
    opens com.example.jewelchase230.items to javafx.fxml;
    exports com.example.jewelchase230.menus;
    opens com.example.jewelchase230.menus to javafx.fxml;
    exports com.example.jewelchase230.characters;
    opens com.example.jewelchase230.characters to javafx.fxml;
}