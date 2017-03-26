package Num232ImplementQueueusingStacks;

/**
 * Created by silence on 2017/3/19.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        System.out.println(queue.peek());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.empty());
        System.out.println(System.currentTimeMillis());
    }
}
