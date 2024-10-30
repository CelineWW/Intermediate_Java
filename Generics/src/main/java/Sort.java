/**
 * @Author: Celine Wang
 * classname: CISC191
 * Sort an ArrayList of comparable objects
 * @Version: 1.0
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Sort {
    public static void main(String[] args) {
        // Create an Integer array
        ArrayList<Integer> intArray = new ArrayList<>();
        Scanner input = new Scanner(System.in);

        System.out.print("Enter 10 integers:");
        for (int i = 0; i < 10; i++){
            int num = getInteger(input);
            intArray.add(num);
        }
        // Close the scanner, otherwise input never ends
        input.close();

        // Invoke sort method to sort the array
        sort(intArray);

        // Display the sorted Array
        System.out.println("The sorted numbers are:");
        for (int i = 0; i < 10; i++) {
            System.out.print(intArray.get(i) + " ");
        }
    }

    public static <E extends Comparable<E>> void sort(ArrayList<E> list) {
        sort(list, 0);
    }

    // Helper method
    public static <E extends Comparable<E>> void sort(ArrayList<E> list, int start) {
        // Base case: if start reaches the last element, sort ends
        if (start >= list.size() - 1) {
            return;
        }

        // Find the minimum element in the sublist
        int currentMinIndex = start;
        E currentMin = list.get(start);
        for (int i = start + 1; i < list.size(); i++) {
            if (list.get(i).compareTo(currentMin) < 0) {
                currentMin = list.get(i);
                currentMinIndex = i;
            }
        }

        // Switch currentMinIndex element and start element
        list.set(currentMinIndex, list.get(start));
        list.set(start, currentMin);

        // Recursively sort the rest of the sublist
        sort(list, start + 1);
    }

    public static int getInteger(Scanner input) {
        // Continuously prompt user for input if no invalid integer detected
        while (!input.hasNextInt()){
            System.out.print("Invalid Number! Please enter an integer: ");
            input.next();   // Consume the invalid input
        }
        return input.nextInt();
    }
}
