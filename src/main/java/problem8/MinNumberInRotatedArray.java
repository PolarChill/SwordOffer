package problem8;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * Description : 寻找递增数组的旋转数组的最小值
 * 二分查找思想, 降低时间复杂度
 * Created By Polar on 2017/10/17
 */
public class MinNumberInRotatedArray {

    public int minNumberInRotatedArray(int[] a) {

        int indexLeft = 0;
        int indexRight = a.length - 1;
        // 若未进入到循环, 则最小值为最左边的索引
        int indexMid = indexLeft;


        while (a[indexLeft] >= a[indexRight]) {

            if ((indexRight - indexLeft) == 1) {
                indexMid = indexRight;
                break;
            }

            indexMid = (indexLeft + indexRight) / 2;

            // 如果indexLeft indexRight indexMid指向的三个数字相等, 只能采用顺序查找
            if (a[indexLeft] == a[indexRight] && a[indexLeft] == a[indexMid]) {
                return MinOrder(a);
            }

            if (a[indexMid] >= a[indexLeft]) {
                indexLeft = indexMid;
            } else if (a[indexMid] <= a[indexRight]) {
                indexRight = indexMid;
            }
        }
        System.out.println("index is " + indexMid);

        return a[indexMid];
    }

    private int MinOrder(int[] a) {

        // 顺序查找最小值
        int min = a[0];
        for (int i = 0; i < a.length; i++) {
            if (a[i] < min) {
                min = a[i];
            }

        }
        return min;
    }


    @Test
    public void testMinNumber() throws Exception {

        int[] a = {3, 4, 5, 1, 2};
        int[] b = {1, 2, 3, 4, 5};
        int[] c = {2, 3, 4, 5, 1,};
        System.out.println(minNumberInRotatedArray(a));
        System.out.println(minNumberInRotatedArray(b));
        System.out.println(minNumberInRotatedArray(c));
    }

    /**
     * 年龄排序, 计数排序, O(n)
     *
     * @param ages
     */
    public void sortAges(int[] ages) {
        int oldestAge = 100;
        int[] timesAge = new int[oldestAge];
        for (int i = 0; i < ages.length; i++) {
            if (ages[i] > 0 && ages[i] < oldestAge) {
                // 统计每个年龄出现的次数
                ++timesAge[ages[i]];
            } else {
                System.out.println("age data is error");
                return;
            }
        }
        int index = 0;
        for (int i = 1; i < oldestAge; i++) {
            // 赋值
            for (int j = 0; j < timesAge[i]; j++) {
                ages[index++] = i;

            }
        }
    }

    @Test
    public void testSortedAges() {
        int[] ages = new int[50];
        Random random = new Random();
        for (int i = 0; i < 50; i++) {
            ages[i] = random.nextInt(99) + 1;
        }
        sortAges(ages);
        System.out.println(Arrays.toString(ages));
    }
}
