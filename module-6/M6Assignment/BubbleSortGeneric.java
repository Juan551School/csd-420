//Juan Macias Vasquez
//Bellevue University 
//CSD420-H323 Advanced Java Programming (2261-DD)
//Jack Lusby
//November 23rd, 2025
//BubbleSortGeneric.java 

package assignmentM6;

import java.util.Comparator;

public class BubbleSortGeneric {
// The first method using the Comparable interface and second uses the Comparator interface
    public static void main(String[] args) {
    	// Test with numbers first 
        // Comparable sort (Integers)
        Integer[] numbers1 = {5, 3, 4, 9, 0, 1, 2, 7, 6, 8};

        System.out.println("Original Integer array:");
        printArray(numbers1);

        bubbleSort(numbers1);
        System.out.println("Sorted using Comparable:");
        printArray(numbers1);


        // Comparator sort (Integers ascending)
        Integer[] numbers2 = {5, 3, 4, 9, 0, 1, 2, 7, 6, 8};

        bubbleSort(numbers2, (a, b) -> a.compareTo(b));
        System.out.println("Sorted using Comparator:");
        printArray(numbers2);

        // Test with words 
        // Strings using Comparable
        String[] words1 = {"banana", "apple", "kiwi", "orange", "mango"};

        System.out.println("Original string array:");
        printArray(words1);
        
        bubbleSort(words1);
        System.out.println("Sorted Strings using Comparable:");
        printArray(words1);


        // Strings using Comparator (reverse)
        String[] words2 = {"banana", "apple", "kiwi", "orange", "mango"};

        bubbleSort(words2, (a, b) -> b.compareTo(a));
        System.out.println("Sorted Strings using Comparator but in reverse:");
        printArray(words2);
    }


    // GENERIC BUBBLE SORT USING Comparable<E>
    public static <E extends Comparable<E>> void bubbleSort(E[] list) {
        boolean swapped;

        for (int i = 0; i < list.length - 1; i++) {
            swapped = false;

            for (int j = 0; j < list.length - 1 - i; j++) {
                if (list[j].compareTo(list[j + 1]) > 0) {
                    E temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) break;
        }
    }

    // GENERIC BUBBLE SORT USING Comparator
    public static <E> void bubbleSort(E[] list, Comparator<? super E> comparator) {
        boolean swapped;

        for (int i = 0; i < list.length - 1; i++) {
            swapped = false;

            for (int j = 0; j < list.length - 1 - i; j++) {
                if (comparator.compare(list[j], list[j + 1]) > 0) {
                    E temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) break;
        }
    }

    public static <E> void printArray(E[] array) {
        System.out.print("[ ");
        for (E e : array) {
            System.out.print(e + " ");
        }
        System.out.println("]");
    }
}