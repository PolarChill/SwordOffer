package problem9;

import org.junit.Test;

/**
 * Description : 斐波那契数列
 * 采用从下往上来求解, 避免递归导致的重复计算
 * Created By Polar on 2017/10/18
 */
public class Fibonacci {

    private long fibonacci(int n) {

        int[] result = {0, 1};
        if (n < 2) {
            return result[n];
        }

        long fibNminusOne = 0;
        long fibNminusTwo = 1;
        long fibN = 0;
        for (int i = 2; i <= n; i++) {

            fibN = fibNminusOne + fibNminusTwo;
            fibNminusOne = fibNminusTwo;
            fibNminusTwo = fibN;
        }
        return fibN;
    }

    private long fibonacciRecursive(int n) {
        if (n <= 0)
            return 0;

        if (n == 1)
            return 1;

        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);

    }


    @Test
    public void testFibonacci() {
        System.out.println(fibonacci(40));
        System.out.println(fibonacciRecursive(40));
    }

}
