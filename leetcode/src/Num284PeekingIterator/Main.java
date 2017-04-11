package Num284PeekingIterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by silence on 2017/4/6.
 */
public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
        PeekingIterator pi = new PeekingIterator(list.iterator());
        System.out.println(pi.peek());
        System.out.println(pi.peek());
        System.out.println(pi.next());
        System.out.println(pi.peek());
        System.out.println(pi.next());
    }
}
