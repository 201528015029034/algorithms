package Num287FindtheDuplicateNumber;

/**
 * Created by test on 2017/4/11.
 */
public class Solution {
    //题意的意思是1和n是一定在数组中的，而且只有一个重复数字
    public int findDuplicate(int[] nums) {
        if(nums == null || nums.length < 2) return -1;
        int lo = 1, hi = nums.length-1, mid = 0;
        int count = 0;
        while(lo < hi) {
            mid = lo + (hi-lo)/2;
            for(int num : nums) {
                if(num <= mid)
                    count++;
            }
            if(count > mid)
                hi = mid;
            else
                lo = mid + 1;
            count = 0;
        }

        return lo;
    }
}
