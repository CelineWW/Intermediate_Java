/**
 * @Author: Celine Wang
 * classname: CISC 191
 * GCD Class get the greatest common divisor of two integers
 * @Version: 1.0
 */

public class GCD {
    public static int getGCD(int m, int n) {
        if (m == 0 && n == 0)
            return 0;
        else if (n == 0)   // Can be replaced by if ((n != 0) && (m % n == 0))
            return m;
        else
            return getGCD(n, m % n);
    }
}