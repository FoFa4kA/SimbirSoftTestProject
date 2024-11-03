package util;

public class FibonacciNumber {

    public static int getFibonacciNumber(int n) {
        if (n <= 1) {
            return 0;
        } else if (n == 2) {
            return 1;
        } else  {
            return getFibonacciNumber(n - 1) + getFibonacciNumber(n - 2);
        }
    }
}
