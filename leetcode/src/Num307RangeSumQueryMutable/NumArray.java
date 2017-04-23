package Num307RangeSumQueryMutable;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by test on 2017/4/15.
 */
public class NumArray {

    private int[] nums = null;
    private long[] sums = null;
    public TreeMap<Integer, Integer> updates = null;
    public NumArray(int[] nums) {
        this.nums = nums;
        sums = new long[nums.length];
        if(nums.length > 0) {
            sums[0] = nums[0];
            updates = new TreeMap<Integer, Integer>();
            for(int i=1; i<nums.length; i++) {
                sums[i] = sums[i-1] + nums[i];
            }
        }
    }

    public void update(int i, int val) {
        updates.put(i, val - nums[i]);
    }

    public int sumRange(int i, int j) {
        Map<Integer, Integer> subMap = updates.subMap(i, j+1);
        long update = 0;
        for(int val : subMap.values()) {
            update += val;
        }
        if(i == 0)
            return (int)(sums[j] + update);
        return (int)(sums[j] - sums[i-1] + update);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */
