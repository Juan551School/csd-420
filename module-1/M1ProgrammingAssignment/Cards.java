//Juan Macias Vasquez
//Bellevue University 
//CSD420-H323 Advanced Java Programming (2261-DD)
//Jack Lusby
//October 26th, 2025
//Cards.java 

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cards extends Application {

    private static final int NUM_CARDS = 4; // Will find four cards
    private static final String CARD_PATH = "cards"; // Finds the folder where images are in
    private final HBox cardBox = new HBox(10);

    @Override
    public void start(Stage primaryStage) {
        cardBox.setAlignment(Pos.CENTER);

        // Load and display the first set of random cards
        displayRandomCards();

        // Refresh button with the Lambda Expression
        Button refreshButton = new Button("Refresh");
        refreshButton.setOnAction(e -> displayRandomCards());

        // Layout
        VBox root = new VBox(15, cardBox, refreshButton);
        root.setAlignment(Pos.CENTER);

        // Scene setup
        Scene scene = new Scene(root, 600, 400);
        primaryStage.setTitle("Random Card Display");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void displayRandomCards() {
        cardBox.getChildren().clear();
        List<Integer> deck = new ArrayList<>();

        // uses all of the deck with numbers 1–52
        for (int i = 1; i <= 52; i++) {
            deck.add(i);
        }

        // Shuffle/randomizes the deck and then picks the first 4 cards
        Collections.shuffle(deck);

        for (int i = 0; i < NUM_CARDS; i++) {
            String imagePath = CARD_PATH + File.separator + deck.get(i) + ".png";
            Image image = new Image(new File(imagePath).toURI().toString());
            ImageView imageView = new ImageView(image);
            imageView.setFitWidth(100);
            imageView.setPreserveRatio(true);
            cardBox.getChildren().add(imageView);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
