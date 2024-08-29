/**
 * Array Manipulation Program performs various operations on arrays, including:
 * initialization, calculation of statistical measures, and searching for specific values
 *
 * @Author: Celine Wang
 * classname: CISC 191
 * @Version: 1.0
 */

import java.util.Arrays;
import java.util.Scanner;

public class ArrayManipulation {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            // Input array size
            System.out.print("Enter the number of elements in the array: ");
            int size = validateInput(scanner);      // int size = scanner.nextInt();
            int[] numbers = new int[size];
            // Input array elements
            System.out.println("Enter " + size + " integers:");
            for (int i = 0; i < size; i++) {
                numbers[i] = validateInput(scanner);     // numbers[i] = scanner.nextInt();
            }
            // Display results
            System.out.println("Original Array: " + Arrays.toString(numbers));
            // Display the sum, average, maximum, minimum
            System.out.println("The sum of the elements in the array is: " + getSumOfArray(numbers));
            System.out.println("The average of the elements in the array is: " + String.format("%.2f", getAverageOfArray(numbers)));
            System.out.println("The maximum value in the array is: " + getMaxInArray(numbers));
            System.out.println("The minimum value in the array is: " + getMinInArray(numbers));

            // Search a value in the array
            System.out.print("Enter the value you are searching for: ");
            int search = scanner.nextInt();
            int found = linearSearch(numbers, search);
            if (found == -1) {
                System.out.println(search + " is not found.");
            }
            else {
                System.out.println(search + " is found at index " + found + " in the original array.");
            }

            // Display sorted array, and reversed array
            sortArray(numbers);
            System.out.println("The array after sorting: " + Arrays.toString(numbers));
            System.out.println("The reversed array: " + Arrays.toString(reverseArray(numbers)));

            // Close the scanner
            scanner.close();
        }

        /** Validate integer scanner */
        public static int validateInput(Scanner scanner) {
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Enter a integer: ");
                scanner.next();
            }
            return scanner.nextInt();
        }

        /** Calculate the sum of the array elements */
        public static int getSumOfArray(int[] numbers) {
            int total = 0;
            for (int number : numbers) {
                total += number;
            }
            return total;
        }

        /** Calculate the average of the array elements */
        public static double getAverageOfArray(int[] numbers) {
            double average;
            average = (double)getSumOfArray(numbers) / numbers.length;
            return average;
        }

        /** Find the maximum value in the array */
        public static int getMaxInArray(int[] numbers) {
            int max = numbers[0];
            for (int number : numbers) {
                if (number > max) {
                    max = number;
                }
            }
            return max;
        }

        /** Find the minimum value in the array */
        public static int getMinInArray(int[] numbers) {
            int min = numbers[0];
            for (int number : numbers) {
                if (number < min) {
                    min = number;
                }
            }
            return min;
        }

        /** Search for a specific value in the array */
        public static int linearSearch(int[] numbers, int key) {
            int index = -1;
            for (int i = 0; i < numbers.length; i++) {
                if (numbers[i] == key ) {
                    index = i;
                }
            }
            return index;
        }

        /** Sort the array in ascending order */
        public static void sortArray(int[] numbers) {
            Arrays.sort(numbers);
        }

        /** Reverse the array */
        public static int[] reverseArray(int[] numbers) {
            int[] reversed = new int[numbers.length];
            for (int i = 0; i < numbers.length; i++) {
                reversed[numbers.length - 1 - i] = numbers[i];
            }
            return reversed;
        }
}
