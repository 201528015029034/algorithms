package sort;

/**
 * Created by test on 2017/3/22.
 * 快速排序，详细思路见绿皮笔记本
 */
public class QuickSort {
    //这里有一个问题，如果用Comparable的话，就不能用基本类型了，因为基本类型没有实现Comparable
    public static void sort(Comparable[] a) {
        sort(a, 0, a.length-1);
    }

    /**
     * 快排
     */
    private static void sort(Comparable[] a, int lo, int hi) {
        if(lo >= hi) return;
        int part = partition(a, lo, hi);
        sort(a, lo, part-1);
        sort(a, part+1, hi);
    }

    /**
     * 分区操作
     * @param a 要分区的数组
     * @param lo 要分区的左边界索引
     * @param hi 要分区的右边界索引
     * @return pivot 一个中心点，
     *          保证当i<pivot,Comparable[i] <= Comparable[pivot]；当i>pivot,Comparable[i]>=Comparable[pivot]
     */
    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo, j = hi+1;
        while(true) {
            //这里在判断的时候是不是应该加上等于，即只找到左边大于Comparable[lo]的数
//            while(less(a[++i], a[lo])) {
            //这个要等于，把等于留在左边，所以讲less(a[++i], a[lo])换成了!less(a[lo], a[++i])
            while(!less(a[lo], a[++i])) {
                if(i == hi)
                    break;
            }
            //这里是不是应该也该加上等号，不过，就要在for循坏里面判断左边界。这个不能加等于，思想就是等于出现的时候，也要和左边交换
            while(less(a[lo], a[--j]));
            if(i >= j) break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }

    private static boolean less(Comparable i, Comparable j) {
        return i.compareTo(j) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[j];
        a[j] = a[i];
        a[i] = temp;
    }
}
