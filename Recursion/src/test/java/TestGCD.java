/**
 * @Author: Celine Wang
 * classname: CISC 191
 * TestGCD Class take user input two integers and display their GCD
 * @Version: 1.0
 */

import java.util.Scanner;

public class TestGCD {
    public static void main(String[] args) {

        // Get user input of two integers
        System.out.print("Enter the first integer: ");
        int m = getInteger();
        System.out.print("Enter the second integer: ");
        int n = getInteger();

        // Invoke GCD class to display gcd
        int result = GCD.getGCD(m, n);
        System.out.println("The GCD of " + m + " and " + n + " is " + result);
    }

    public static int getInteger() {

        // Create a Scanner
        Scanner input = new Scanner(System.in);

        // Continuously prompt user for input if it is invalid
        while (!input.hasNextInt()){
            System.out.print("Invalid Number! Please enter an integer: ");
            input.next();   // Consume the invalid input
        }
        return input.nextInt();
    }
}

