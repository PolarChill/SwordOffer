package problem6;

import org.junit.Test;

import java.util.Arrays;

/**
 * Description : 根据先序和中序构建二叉树
 * 先序的首位为根结点, 中序中根节点左边为左子树, 右边为右子树, 递归构建
 * Created By Polar on 2017/10/17
 */
public class ConstructBinaryTree {

    private BinaryTreeNode constructBinaryTree(int[] preOrder, int[] inOrder) throws Exception {
        if (null == preOrder || null == inOrder)
            return null;
        if (preOrder.length != inOrder.length)
            throw new Exception("the input is illegal");


        BinaryTreeNode root = null;


        for (int i = 0; i < inOrder.length; i++) {
            if (inOrder[i] == preOrder[0]) {
                // 先序的首位为根节点
                root = new BinaryTreeNode(inOrder[i]);
                // Arrays.CopyOfRange 复制到新的数组中, 左闭右开
                root.left = constructBinaryTree(Arrays.copyOfRange(preOrder, 1, i + 1),
                        Arrays.copyOfRange(inOrder, 0, i));
                root.right = constructBinaryTree(Arrays.copyOfRange(preOrder, i + 1, preOrder.length),
                        Arrays.copyOfRange(inOrder, i + 1, inOrder.length));
            }
        }
        return root;


    }

    @Test
    public void testConstruct() throws Exception {
        int[] preOrder = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] inOrder = {4, 7, 2, 1, 5, 3, 8, 6};
        BinaryTreeNode root = constructBinaryTree(preOrder, inOrder);
        printByPostOrder(root);

    }

    private void printByPostOrder(BinaryTreeNode root) {
        if (root != null) {
            printByPostOrder(root.left);
            printByPostOrder(root.right);
            System.out.print(root.data + " ");

        }


    }


}

class BinaryTreeNode {
    int data;
    BinaryTreeNode left = null;
    BinaryTreeNode right = null;

    public BinaryTreeNode(int data) {
        this.data = data;
    }
}
