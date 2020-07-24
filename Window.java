import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.*;
import java.util.*;

public class Window {
    
    public static void display(Database base, String name){
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);   
        window.setTitle("Search Result");
        window.setWidth(200);
        window.setHeight(200);

        List<String> list = base.search(name);
        ListView<String> result = new ListView<String>();
        ObservableList<String> items = FXCollections.observableArrayList(list);

        result.setItems(items);

        result.setPrefHeight(100);
        result.setPrefWidth(70);

        VBox layBox = new VBox(10);
        layBox.getChildren().addAll(result);
        layBox.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layBox);
        window.setScene(scene);
        window.showAndWait();
    }
}