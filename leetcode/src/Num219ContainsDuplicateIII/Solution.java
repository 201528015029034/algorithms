package Num219ContainsDuplicateIII;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by test on 2017/3/17.
 */
public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(k < 1 || t < 0) return false;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int key = 0;
        for(int i=0; i<nums.length; i++) {
            key = nums[i] / Math.max(1, t);
            for(int j=key-1; j<=key+1; j++) {
                if(map.containsKey(j) && Math.abs(nums[i]-map.get(j)) <= t) {
                    return true;
                }
            }
            map.put(key, nums[i]);
        }
        return false;
    }
}
