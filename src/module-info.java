module com.example.pizzaparty {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.pizzaparty to javafx.fxml;
    exports com.example.pizzaparty;
    exports Controllers;
    opens Controllers to javafx.fxml;
}