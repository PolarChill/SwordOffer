package problem10;

import org.junit.Test;

/**
 * Description : 二进制中1的个数
 * 考虑负数右移高位补1导致死循环的问题
 * n&(n-1) 会将整数n最右边的1变成0
 * Created By Polar on 2017/10/18
 */
public class NumberOf1InBinary {

    private int numberOF1Two(int n) {
        int count = 0;
        while (n != 0) {
            ++count;
            // 将n最右边的1变为0
            n = (n - 1) & n;
        }
        return count;
    }


    private int numberOf1One(int n) {
        int count = 0;
        int flag = 1;

        // 循环次数为int的长度
        while (flag != 0) {
            // 原数字和 flag进行与运算, 若结果大于0,则1的个数加加
            if ((n & flag) != 0)
                count++;

            // 将flag左移1位,继续比较
            flag = flag << 1;
        }
        return count;
    }

    @Test
    public void testNumberOf1() {


        System.out.println(numberOf1One(Integer.MAX_VALUE));
        System.out.println(numberOf1One(Integer.MIN_VALUE));
        System.out.println(numberOf1One(3));

        System.out.println(numberOF1Two(Integer.MAX_VALUE));
        System.out.println(numberOF1Two(Integer.MIN_VALUE));
        System.out.println(numberOF1Two(3));

    }
}
