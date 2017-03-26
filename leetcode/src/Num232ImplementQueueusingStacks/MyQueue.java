package Num232ImplementQueueusingStacks;

import java.util.LinkedList;

/**
 * Created by silence on 2017/3/26.
 */
public class MyQueue {

    private LinkedList<Integer> stack;
    private int popValue;

    /** Initialize your data structure here. */
    public MyQueue() {
        stack = new LinkedList<Integer>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        implPop();
        return popValue;
    }

    private void implPop() {
        int m = stack.pop();
        if(stack.isEmpty()) {
            popValue = m;
        }else {
            implPop();
            stack.push(m);
        }
    }

    /** Get the front element. */
    public int peek() {
        implPeek();
        return popValue;
    }

    private void implPeek() {
        int m = stack.pop();
        if(stack.isEmpty()) {
            popValue = m;
        }else {
            implPeek();
        }
        stack.push(m);
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.isEmpty();
    }
}
