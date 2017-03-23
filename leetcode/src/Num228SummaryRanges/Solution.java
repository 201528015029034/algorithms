package Num228SummaryRanges;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by silence on 2017/3/23.
 */
public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<String>();
        if(nums == null || nums.length == 0) return list;
        String temp = nums[0] + "";
        //list大概是这个样子{"1->2->3->4",7}
        for(int i=1; i<nums.length; i++) {
            if(nums[i] == nums[i-1]+1) {
                temp = temp + "->" + nums[i];
            }else {
                list.add(temp);
                temp = nums[i] + "";
            }
        }
        list.add(temp);
        //用"->"分裂字符串，如果分裂后的数组长度大于2就取两端的
        for(int i=0; i<list.size(); i++) {
            temp = list.get(i);
            String[] digits = temp.split("->");
            if(digits.length > 2) {
                list.set(i, digits[0] + "->" + digits[digits.length-1]);
            }
        }

        return list;
    }
}
