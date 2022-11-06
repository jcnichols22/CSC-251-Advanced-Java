module com.example.u4_playingcards {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.u4_playingcards to javafx.fxml;
    exports com.example.u4_playingcards;
}