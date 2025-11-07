//Juan Macias Vasquez
//Bellevue University 
//CSD420-H323 Advanced Java Programming (2261-DD)
//Jack Lusby
//November 6th, 2025
//RemoveDuplicatesTest.java 

package assignmentM3;

import java.util.ArrayList;
import java.util.Random;

public class RemoveDuplicatesTest {

    public static void main(String[] args) {
        // Make an ArrayList with 50 random integers from 1 to 20
        ArrayList<Integer> originalList = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < 50; i++) {
            originalList.add(rand.nextInt(20) + 1); // values 1–20
        }

        // Show the original list
        System.out.println("Original List (with duplicates):");
        System.out.println(originalList);

        // Get rid of duplicates using the generic method
        ArrayList<Integer> uniqueList = removeDuplicates(originalList);

        // Show the new list without duplicates
        System.out.println("\nList after removing duplicates:");
        System.out.println(uniqueList);
    }

    // Generic method to remove duplicates
    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
        ArrayList<E> newList = new ArrayList<>();

        for (E element : list) {
            if (!newList.contains(element)) {
                newList.add(element);
            }
        }

        return newList;
    }
}
