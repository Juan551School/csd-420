//Juan Macias Vasquez
//Bellevue University 
//CSD420-H323 Advanced Java Programming (2261-DD)
//Jack Lusby
//November 30rd, 2025
//FourCircleStyle.java 

package m7Assignment;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class FourCircleStyle extends Application {

    @Override
    public void start(Stage stage) {
        // White-filled circles using class
        Circle c1 = new Circle(50);
        c1.getStyleClass().add("plaincircle");

        Circle c2 = new Circle(50);
        c2.getStyleClass().add("plaincircle");

        // Red circle using ID
        Circle c3 = new Circle(50);
        c3.setId("redcircle");

        // Green circle using ID
        Circle c4 = new Circle(50);
        c4.setId("greencircle");

        HBox pane = new HBox(20);
        pane.getChildren().addAll(c1, c2, c3, c4);

        Scene scene = new Scene(pane, 450, 150);

        // Load CSS file
        scene.getStylesheets().add("mystyle.css");

        stage.setTitle("Circle CSS Demo");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
