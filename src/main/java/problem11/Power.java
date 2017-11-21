package problem11;

import org.junit.Test;

/**
 * Description : 数值的整数次方 边界情况 时间复杂度O(log n)
 * 递归计算其次方, 不选择每次相乘指数的次数
 * a^n =  a^(n/2) * a^(n/2)  n is even
 * a^(n-1)/2 * a^(n-1)/2 * a   n is odd
 * Created By Polar on 2017/11/16
 */
public class Power {

    private double power(int base, int exponent) {
        double result ;
        if (0 == base || exponent == 0) {
            result = 1;
        } else if (exponent < 0) { //负数的情况
            result = 1.0 / powerWithUnsignedExponent(base, -exponent);
        } else {
            result = powerWithUnsignedExponent(base, exponent);
        }

        return result;
    }

    private double powerWithUnsignedExponent(int base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }

        double result = powerWithUnsignedExponent(base, exponent >> 1);

        result *= result;

        if ((exponent & 0x1) == 1) { // exponent为奇数
            result = result * base;
        }
        return result;
    }

    @Test
    public void testPower() {
        System.out.println(1);
        System.out.println(power(5, 5));
    }

}
