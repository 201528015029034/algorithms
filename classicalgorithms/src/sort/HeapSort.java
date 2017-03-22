package sort;

/**
 * Created by test on 2017/3/22.
 * 基于数组实现堆排序，详细思路见绿皮笔记本
 * 可以将int变为Comparable
 */
public class HeapSort {
    public static void sort(int[] nums) {
        int N = nums.length;
        //建堆操作
        for(int i=N/2; i>=0; i--) {
            sink(nums, i, N);
        }
        //堆排序
        while(N > 1) {
            exch(nums, 0, --N);
            sink(nums, 0, N);
        }
    }

    /**
     * 下沉操作，如果当前节点小于它子节点，就交换它和它的子节点
     * @param nums 存放堆的数组
     * @param i 下沉节点的开始索引
     * @param N 下沉操作的尾边界，不包含N
     */
    private static void sink(int[] nums, int i, int N) {
        //i*2+1代表它的右子节点的索引，保证小于尾边界N
        while(i*2+1 < N) {
            int k = 2*i+1;
            if(k < N-1 && nums[k+1] > nums[k]) k++;
            if(nums[k] < nums[i]) break;
            exch(nums, i, k);
            i = k;
        }
    }

    private static void exch(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
}
