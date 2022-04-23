package com.linkai.practise.queue;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通栈的全部四种操作（push、top、pop 和 empty）。
 *
 * 实现 MyStack 类：
 * ● void push(int x) 将元素 x 压入栈顶。
 * ● int pop() 移除并返回栈顶元素。
 * ● int top() 返回栈顶元素。
 * ● boolean empty() 如果栈是空的，返回 true ；否则，返回 false 。
 *
 * 注意：
 * 你只能使用队列的基本操作 —— 也就是 push to back、peek/pop from front、size 和 is empty 这些操作。
 * 你所使用的语言也许不支持队列。 你可以使用 list （列表）或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
 *
 *
 * 示例：
 * 输入：
 * ["MyStack", "push", "push", "top", "pop", "empty"]
 * [[], [1], [2], [], [], []]
 * 输出：
 * [null, null, null, 2, 2, false]
 *
 * 解释：
 * MyStack myStack = new MyStack();
 * myStack.push(1);
 * myStack.push(2);
 * myStack.top(); // 返回 2
 * myStack.pop(); // 返回 2
 * myStack.empty(); // 返回 False
 */
public class LeetCode225 {

    static class MyStack {

        private Queue<Integer> queue1;
        private Queue<Integer> queue2;

        public MyStack() {
            queue1 = new ArrayDeque<>();
            queue2 = new ArrayDeque<>();
        }

        public void push(int x) {
            queue1.add(x);
        }

        public int pop() {
            int topValue;
            while (!queue1.isEmpty()) {
                topValue = queue1.poll();
                if (queue1.isEmpty()) {
                    return topValue;
                }
                queue2.add(topValue);
            }

            while (!queue2.isEmpty()) {
                topValue = queue2.poll();
                if (queue2.isEmpty()) {
                    return topValue;
                }
                queue1.add(topValue);
            }
            throw new RuntimeException();
        }

        public int top() {
            int topValue;
            while (!queue1.isEmpty()) {
                topValue = queue1.poll();
                queue2.add(topValue);
                if (queue1.isEmpty()) {
                    return topValue;
                }
            }

            while (!queue2.isEmpty()) {
                topValue = queue2.poll();
                queue1.add(topValue);
                if (queue2.isEmpty()) {
                    return topValue;
                }
            }
            throw new RuntimeException();
        }

        public boolean empty() {
            return queue1.isEmpty() && queue2.isEmpty();
        }
    }

    public static void main(String[] args) {
        example1();
    }

    public static void example1() {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.top(); // 返回 2
        myStack.pop(); // 返回 2
        myStack.empty(); // 返回 False
    }
}
