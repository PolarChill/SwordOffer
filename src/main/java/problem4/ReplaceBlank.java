package problem4;

import org.junit.Test;

/**
 * Description : 将字符串中的空格替换为"%20"
 * 核心思想: 从后往前复制, 能减少移动次数
 * Created By Polar on 2017/10/16
 */
public class ReplaceBlank {
    public void replaceBlank(String str) {
        char[] a = str.toCharArray();
        int len = a.length;

        // 统计字符串中' '的个数, 计算新数组的大小
        for (int i = 0; i < a.length; i++) {
            if (' ' == a[i]) {
                len += 2;
            }
        }

        char[] b = new char[len];


        int right = b.length - 1;
        int left = a.length - 1;

        while (left > -1) {
            // 非' '字符直接复制
            if (a[left] != ' ') {
                b[right--] = a[left--];

            } else {
                // 将' ' 替换为"%20"
                b[right--] = '0';
                b[right--] = '2';
                b[right--] = '%';
                left--;
            }
        }
        System.out.println(String.valueOf(b));

    }

    @Test
    public void testReplaceBlank() {
        replaceBlank("     ");
    }
}
