/**
 * Module information.
 *
 * @author Will Kaye.
 */
module com.example.jewelchase230 {
    requires javafx.controls;
    requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.base;
	requires java.desktop;


    opens com.example.jewelchase230 to javafx.fxml, javafx.base;
    exports com.example.jewelchase230;
    exports com.example.jewelchase230.vectors;
    opens com.example.jewelchase230.vectors to javafx.fxml, javafx.base;
    exports com.example.jewelchase230.items;
    opens com.example.jewelchase230.items to javafx.fxml, javafx.base;
    exports com.example.jewelchase230.menus;
    opens com.example.jewelchase230.menus to javafx.fxml, javafx.base;
    exports com.example.jewelchase230.characters;
    opens com.example.jewelchase230.characters to javafx.fxml, javafx.base;
    exports com.example.jewelchase230.profiles;
    opens com.example.jewelchase230.profiles to javafx.fxml, javafx.base;

}