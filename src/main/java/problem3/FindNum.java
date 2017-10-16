package problem3;

import org.junit.Test;

/**
 * Description : 二维数组查找值, 每一行, 每一列 依次递增
 * 核心思想: 从数组右上角开始查找, 若该值大于目标值, 则当前行抛弃,
 * 若该值小于目标值, 则当前列不在查询范围内,抛弃
 * Created By Polar on 2017/10/16
 */
public class FindNum {
    public Boolean findInPartiallySortedMatrix(int[][] matrix, int x) {
        if (null == matrix || matrix.length < 0) {
            return false;
        }
        int row = 0;
        int column = matrix[0].length - 1;

        while(column >= 0 && row <= matrix.length - 1) {
            // 从右上角开始查找
            if (x == matrix[row][column]) {
                System.out.println("row: " + row + "   column: " + column);
                return true;
            } else if (x > matrix[row][column]) {
                // 当前行不纳入查询范围
                row++;
            } else {
                // 当前列不纳入查询范围
                column--;
            }

        }
        return false;
    }


    @Test
    public void testFIndNum() {
        int[][] matrix = {{1, 2, 4, 8}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        System.out.println(findInPartiallySortedMatrix(matrix, 1));

    }


}
