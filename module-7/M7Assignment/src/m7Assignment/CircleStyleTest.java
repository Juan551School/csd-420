//Juan Macias Vasquez
//Bellevue University 
//CSD420-H323 Advanced Java Programming (2261-DD)
//Jack Lusby
//November 30rd, 2025
//CircleStyleTest.java 
package m7Assignment;

import javafx.scene.shape.Circle;

public class CircleStyleTest {

    public static void main(String[] args) {
        testCircleStyles();
    }

    public static void testCircleStyles() {
        Circle testWhite = new Circle(50);
        testWhite.getStyleClass().add("plaincircle");

        Circle testRed = new Circle(50);
        testRed.setId("redcircle");

        Circle testGreen = new Circle(50);
        testGreen.setId("greencircle");

        assert testWhite.getStyleClass().contains("plaincircle") : "White circle class not applied";
        assert testRed.getId().equals("redcircle") : "Red circle ID not applied"; 
        //check if the color red was added
        assert testGreen.getId().equals("greencircle") : "Green circle ID not applied";
        //check if the color Green was added

        System.out.println("All style tests passed!");
    }
}
