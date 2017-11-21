package problem7;

import org.junit.Test;

import java.util.Stack;

/**
 * Description : 使用两个栈完成队列操作
 * 当需要add时, 直接将数据添加到栈1中
 * 当需要remove时, 若栈2不为空, 则直接移除, 否则将栈1中的数据全部出栈亚茹道栈2中
 * Created By Polar on 2017/10/17
 */
public class QueueWithStacks {

    Stack<Integer> stackOne = new Stack<>();
    Stack<Integer> stackTwo = new Stack<>();


    public void add(Integer x) {
        stackOne.push(x);
    }

    public Integer remove() {
        if (stackTwo.empty() && stackOne.empty()) {
            return null;
        }

        if (stackTwo.empty()) {
            while (!stackOne.empty()) {
                stackTwo.push(stackOne.pop());
            }
        }
        return stackTwo.pop();
    }

    @Test
    public void testQueue() {
        QueueWithStacks queueWithStacks = new QueueWithStacks();
        queueWithStacks.add(1);
        queueWithStacks.add(2);
        queueWithStacks.add(3);
        System.out.println(queueWithStacks.remove());
        queueWithStacks.add(4);
        System.out.println(queueWithStacks.remove());
        System.out.println(queueWithStacks.remove());
        queueWithStacks.add(5);
        System.out.println(queueWithStacks.remove());
        System.out.println(queueWithStacks.remove());


    }


}
