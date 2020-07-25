import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
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

    public static void alertBox(Integer response){
        Stage alert = new Stage();
        alert.initModality(Modality.APPLICATION_MODAL);   
        alert.setTitle("Notice!");
        alert.setHeight(90);
        alert.setWidth(90); 

        Label result = new Label();
        if(response == 1){
            result.setText("Inserted!");
        } else if (response == 2) {
            result.setText("Written Out!");
        } else {
            result.setText("Action Failed.");
        }

        Button close = new Button("Close");
        HBox cBox = new HBox();                
        cBox.setAlignment(Pos.BOTTOM_CENTER);
        cBox.getChildren().add(close);

        close.setOnAction(e -> alert.close());
        
        VBox layout = new VBox();
        layout.getChildren().addAll(result, cBox);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        alert.setScene(scene);
        alert.showAndWait();
    }
}