import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.IOException;

public class Main extends Application {

    public static void main(String argv[]) {
        launch();
    }

    @Override
    public void start(Stage primarystage) {
        primarystage.setTitle("Welcome");

        // Testing with object Database
        Database base = new Database();

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10.0);
        grid.setVgap(10.0);
        grid.setPadding(new Insets(15, 15, 15, 15));

        Text sceneTitle = new Text("Enter your information");
        sceneTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(sceneTitle, 0, 0, 3, 1);

        Label name = new Label("Name: ");
        grid.add(name, 0, 1);

        TextField nameText = new TextField();
        grid.add(nameText, 1, 1);

        Label age = new Label("Age: ");
        grid.add(age, 0, 2);

        TextField ageText = new TextField();
        grid.add(ageText, 1, 2);

        // Testing purpose of grabbing strings
        /*
        Label lbl = new Label();
        grid.add(lbl, 0, 5);
        */

        Button button = new Button("Submit");
        HBox buttonBox = new HBox();
        buttonBox.setAlignment(Pos.BOTTOM_RIGHT);
        buttonBox.getChildren().add(button);
        grid.add(buttonBox, 1, 4);

        Button write = new Button("Write");
        HBox writeBox = new HBox();
        writeBox.setAlignment(Pos.BOTTOM_CENTER);
        writeBox.getChildren().add(write);
        grid.add(writeBox, 0, 4);

        Button search = new Button("Search");
        HBox searchBox = new HBox();
        searchBox.setAlignment(Pos.BOTTOM_RIGHT);
        searchBox.getChildren().add(search);
        grid.add(searchBox,1,5);

        // Implementing the EventHandler for button
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                String name = nameText.getText();
                Integer age = Integer.parseInt(ageText.getText());
                base.Insert(name, age);
            }
        });

        write.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                try {
                    base.writeOut();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            } 
        });

        //Test calling the display function
        search.setOnAction(e -> Window.display(base, nameText.getText()));

        Scene scene = new Scene(grid, 400, 400);
        primarystage.setScene(scene);
        primarystage.show();
    }
    }


