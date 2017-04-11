package Num260SingleNumberIII;

/**
 * Created by test on 2017/4/1.
 */
public class Solution {
    public int[] singleNumber(int[] nums) {
        int first = 0, second = 0;
        int pivot = 0;
        int lo = 0, hi = nums.length-1;
        while(lo < hi && (first == 0 || second == 0)) {
            pivot = partition(nums, lo, hi);
            first = xor(nums, lo, pivot);
            second = xor(nums, pivot+1, hi);
            if(first == 0)
                lo = pivot+1;
            else
                hi = pivot;
        }
        return new int[]{first, second};

    }

    private int partition(int[] nums, int lo, int hi) {
        int i = lo, j = hi+1;
        while(true) {
            while(nums[++i] <= nums[lo]) {
                if(i == hi)
                    break;
            }
            while(nums[lo] < nums[--j]) ;
            if(i >= j) break;
            exch(nums, i, j);
        }
        exch(nums, lo, j);
        return j;
    }

    private void exch(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private int xor(int[] nums, int lo, int hi) {
        if(lo > hi) return 0;
        int r = nums[lo];
        for(int i=lo+1; i<=hi; i++) {
            r = r ^ nums[i];
        }
        return r;
    }
}
