package problem5;

import org.junit.Test;

/**
 * Description : 逆序打印列表
 * 递归的本质上就是一个栈结构
 * Created By Polar on 2017/10/17
 */
public class PrintListReverse {
    public void printListReverse(Node head) {
        if (head == null)
            return;


        if (head != null) {

            if (head.next != null) {
                // 存在下一个结点, 递归调用
                printListReverse(head.next);
            }
            System.out.println(head.data);
        }

    }

    @Test
    public void testPrintReverse() {

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        printListReverse(head);

    }


}

class Node {
    int data;
    Node next = null;

    public Node(int data) {
        this.data = data;
    }
}
