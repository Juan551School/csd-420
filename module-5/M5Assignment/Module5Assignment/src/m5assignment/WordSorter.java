//Juan Macias Vasquez
//Bellevue University 
//CSD420-H323 Advanced Java Programming (2261-DD)
//Jack Lusby
//November 16th, 2025
//WordSorter.java 

package m5assignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.ArrayList;

public class WordSorter {

    public static void main(String[] args) {

        // Checks to automatically removes duplicates and keeps the words in a sorted order
        Set<String> wordsAscending = new TreeSet<>();

        try {
            File file = new File("collection_of_words.txt"); //The name of the file
            Scanner scanner = new Scanner(file);

            while (scanner.hasNext()) {
                wordsAscending.add(scanner.next().toLowerCase());
            }

            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("The file collection_of_words.txt was not found.");
            return;
        }

        // Display in ascending order
        System.out.println("Ascending Order:");
        for (String word : wordsAscending) {
            System.out.println(word);
        }

        // Create descending order version
        ArrayList<String> descending = new ArrayList<>(wordsAscending);
        descending.sort((a, b) -> b.compareTo(a));

        System.out.println("\nDescending Order:");
        for (String word : descending) {
            System.out.println(word);
        }

        // Run test code
        runTests(wordsAscending, descending);
    }

    // The Test Code
    public static void runTests(Set<String> asc, ArrayList<String> desc) {
        System.out.println("\n=== Running Tests ===");

        // Test 1: Ascending set has no duplicates
        boolean noDuplicates = asc.size() == new ArrayList<>(asc).size();
        System.out.println("Test 1 - No Duplicates: " + (noDuplicates ? "PASS" : "FAIL"));

        // Test 2: Ascending list is sorted A -> Z
        boolean ascendingSorted = isAscending(new ArrayList<>(asc));
        System.out.println("Test 2 - Ascending Sorted: " + (ascendingSorted ? "PASS" : "FAIL"));

        // Test 3: Descending list is sorted Z -> A
        boolean descendingSorted = isDescending(desc);
        System.out.println("Test 3 - Descending Sorted: " + (descendingSorted ? "PASS" : "FAIL"));
    }

    private static boolean isAscending(ArrayList<String> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).compareTo(list.get(i + 1)) > 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean isDescending(ArrayList<String> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).compareTo(list.get(i + 1)) < 0) {
                return false;
            }
        }
        return true;
    }
}
