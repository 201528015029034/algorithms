package sort;

/**
 * Created by test on 2017/3/22.
 * 基于数组实现堆排序，详细思路见绿皮笔记本
 * 可以将int变为Comparable
 */
public class HeapSort {
    public static void sort(int[] nums) {
        int N = nums.length;
        //建堆操作，大根堆，堆索引是从0开始的
        for(int i=N/2; i>=0; i--) {
            sink(nums, i, N);
        }
        //堆排序，堆索引是从0开始的
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
        //节点索引是从0开始的，i*2+1代表它的左子节点的索引，保证小于尾边界N
        //      0
        //     / \
        //    1  2
        while(i*2+1 < N) {
            int k = i*2+1;
            //如果右子节点存在，且大于左子节点
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
