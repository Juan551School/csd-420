//Juan Macias Vasquez
//Bellevue University 
//CSD420-H323 Advanced Java Programming (2261-DD)
//Jack Lusby
//November 1st, 2025
//WriteData.java 

package m2Project;
import java.io.*;
import java.util.Random;

public class WriteData {
    public static void main(String[] args) {
        String fileName = "Macias_datafile.dat"; //The name of the file
        Random rand = new Random();

        try (PrintWriter output = new PrintWriter(new FileWriter(fileName, true))) {
            // Write 5 random integers from 0-99
            output.print("Integers: ");
            for (int i = 0; i < 5; i++) {
                int value = rand.nextInt(100); // Random int 0–99
                output.print(value + " ");
            }

            output.println(); // New line

            // Write 5 random doubles
            output.print("Doubles: ");
            for (int i = 0; i < 5; i++) {
                double value = rand.nextDouble() * 100; // Random double 0–100
                output.printf("%.2f ", value);
            }

            output.println(); // New line
            output.println("-----------------------------");

            System.out.println("Data successfully written to " + fileName);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}
