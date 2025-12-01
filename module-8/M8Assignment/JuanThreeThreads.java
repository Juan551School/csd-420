//Juan Macias Vasquez
//Bellevue University 
//CSD420-H323 Advanced Java Programming (2261-DD)
//Jack Lusby
//November 30rd, 2025
//JuanThreeThreads.java 

package module8Assignment;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.Random;

public class JuanThreeThreads extends Application {

    private static final int OUTPUT_COUNT = 10000;
    private TextArea textArea = new TextArea();

    // Counters for verification
    private int letterCount = 0;
    private int numberCount = 0;
    private int symbolCount = 0;

    @Override
    public void start(Stage primaryStage) {
        BorderPane pane = new BorderPane();
        textArea.setEditable(false);
        pane.setCenter(textArea);

        Scene scene = new Scene(pane, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Three Threads Output Demo");
        primaryStage.show();

        // Create threads
        Thread letterThread = createLetterThread();
        Thread numberThread = createNumberThread();
        Thread symbolThread = createSymbolThread();

        // Start threads
        letterThread.start();
        numberThread.start();
        symbolThread.start();

        // Thread to wait for all 3 threads to finish, then show test results (it might take a few seconds so don't think it froze)
        new Thread(() -> {
            try {
                letterThread.join();
                numberThread.join();
                symbolThread.join();

                // Append test results AFTER all 10,000 characters
                Platform.runLater(() -> {
                    textArea.appendText("\n\n=== TEST RESULTS ===\n");
                    textArea.appendText("Letter count: " + letterCount + "\n");
                    textArea.appendText("Number count: " + numberCount + "\n");
                    textArea.appendText("Symbol count: " + symbolCount + "\n");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    private Thread createLetterThread() {
        return new Thread(() -> {
            Random r = new Random();
            for (int i = 0; i < OUTPUT_COUNT; i++) {
                char letter = (char) ('a' + r.nextInt(26));
                appendText(letter);
                letterCount++;
            }
        });
    }

    private Thread createNumberThread() {
        return new Thread(() -> {
            Random r = new Random();
            for (int i = 0; i < OUTPUT_COUNT; i++) {
                char digit = (char) ('0' + r.nextInt(10));
                appendText(digit);
                numberCount++;
            }
        });
    }

    private Thread createSymbolThread() {
        return new Thread(() -> {
            char[] symbols = {'!', '@', '#', '$', '%', '&', '*'};
            Random r = new Random();
            for (int i = 0; i < OUTPUT_COUNT; i++) {
                char symbol = symbols[r.nextInt(symbols.length)];
                appendText(symbol);
                symbolCount++;
            }
        });
    }

    private void appendText(char c) {
        Platform.runLater(() -> textArea.appendText(String.valueOf(c)));
    }

    public static void main(String[] args) {
        launch(args);
    }
}
