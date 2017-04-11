package Num284PeekingIterator;

import java.util.Iterator;

/**
 * Created by silence on 2017/4/6.
 */
public class PeekingIterator implements Iterator<Integer> {
    Iterator<Integer> it = null;
    Integer peekValue = null;
    Integer tmp = null;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        it = iterator;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if(peekValue == null) {
            peekValue = it.next();
        }
        return peekValue;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if(peekValue != null){
            tmp = peekValue;
            peekValue = null;
            return tmp;
        }else {
            return it.next();
        }
    }

    @Override
    public boolean hasNext() {
        return (peekValue != null || it.hasNext());
    }
}
