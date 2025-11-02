//Juan Macias Vasquez
//Bellevue University 
//CSD420-H323 Advanced Java Programming (2261-DD)
//Jack Lusby
//November 1st, 2025
//ReadData.java 

package m2Project;

import java.io.*;
import java.util.Scanner;

public class ReadData {
    public static void main(String[] args) {
        String fileName = "Macias_datafile.dat"; // The name of the file  

        try (Scanner input = new Scanner(new File(fileName))) {
            System.out.println("Reading data from " + fileName + ":\n");
            while (input.hasNextLine()) {
                System.out.println(input.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        }
    }
}
