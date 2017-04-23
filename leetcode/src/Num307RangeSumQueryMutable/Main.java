package Num307RangeSumQueryMutable;

/**
 * Created by test on 2017/4/9.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
        NumArray obj = new NumArray(new int[]{9, -8});
//        System.out.println(obj.sumRange(4, 4));
//        System.out.println(obj.sumRange(2, 4));
//        System.out.println(obj.sumRange(3, 3));
        obj.update(0, 3);
//        obj.update(1, 7);
//        obj.update(0, 8);
        System.out.println(obj.sumRange(1, 1));
//        obj.update(1, 9);
//        System.out.println(obj.sumRange(4, 4));
//        obj.update(3, 4);
//        System.out.println(obj.updates);
        System.out.println(System.currentTimeMillis());
    }
}
