package sort;

/**
 * Created by test on 2017/3/22.
 * 快速排序，详细思路见绿皮笔记本
 */
public class QuickSort {
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
            while(less(a[++i], a[lo])) {
                if(i == hi)
                    break;
            }
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
