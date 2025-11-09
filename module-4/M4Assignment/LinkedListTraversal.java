//Juan Macias Vasquez
//Bellevue University 
//CSD420-H323 Advanced Java Programming (2261-DD)
//Jack Lusby
//November 6th, 2025
//LinkedListTraversal.java 

package projectM4;

import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListTraversal {

    public static void main(String[] args) {
        // First the test with 50,000 integers
        testTraversalTime(50000);

        // Then test with 500,000 integers
        testTraversalTime(500000);
    }

    /**
     * This will tests traversal performance using iterator and get(index)for the given number of integers.
     */
    
    
    public static void testTraversalTime(int size) {
        LinkedList<Integer> list = new LinkedList<>();

        // Fill the LinkedList
        for (int i = 0; i < size; i++) {
            list.add(i);
        }

        System.out.println("\nTesting with " + size + " integers:");

        //  Traversal using Iterator 
        long startTime = System.nanoTime();
        ListIterator<Integer> iterator = list.listIterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
        long endTime = System.nanoTime();
        long iteratorTime = endTime - startTime;
        System.out.println("Iterator traversal time: " + iteratorTime / 1_000_000.0 + " ms");

        // Traversal using get 
        startTime = System.nanoTime();
        for (int i = 0; i < list.size(); i++) {
            list.get(i);
        }
        endTime = System.nanoTime();
        long getIndexTime = endTime - startTime;
        System.out.println("get(index) traversal time: " + getIndexTime / 1_000_000.0 + " ms");

        System.out.println("Difference (get - iterator): " + 
                           (getIndexTime - iteratorTime) / 1_000_000.0 + " ms");
    }
}
/*
Results:
When you run the program, you will probably notice that:
•	Traversing the LinkedList using an iterator is faster.
•	Traversing using get(index) becomes extremely slow, especially for the 500,000 elements.
Reason:
•	The `get(index)` method in LinkedList requires traversal from the start (or end) of the list to reach the specified index. This makes it **O(n)** per access.
•	When done in a loop (n times), the total time complexity becomes **O(n²)**.
•	The iterator, on the other hand, moves sequentially from one node to the next, which is **O(n)** overall.

After a couple tries 
Average example output:
Testing with 50000 integers:
Iterator traversal time: 1.9 ms
get(index) traversal time: 950 ms

The Testing with 500000 integers:
Iterator traversal time: 5.1 ms
get(index) traversal time: 290000 ms 

In Conclusion
•	The iterator is the correct way to traverse LinkedLists.
•	Using get(index) is inefficient for large lists due to repeated linear scans.
*/

