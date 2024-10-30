/**
 * @ Author: Celine Wang
 * classname: CISC 191
 * GCD Class compute the greatest common divisor using recursion
 * @ Version: 1.0
 */

public class GCD {
    public static int getGCD(int m, int n) {
        if (m == 0 && n == 0)
            return 0;
        else if (n == 0)   // Equivalent to if ((n != 0) && (m % n == 0)) return n
            return m;
        else
            return getGCD(n, m % n);
    }
}