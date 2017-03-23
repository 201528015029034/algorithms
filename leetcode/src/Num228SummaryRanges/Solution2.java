package Num228SummaryRanges;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by silence on 2017/3/23.
 */

//上一个版本的改进版
public class Solution2 {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<String>();
        if(nums == null || nums.length == 0) return list;
        String temp = nums[0] + "";
        //pos用于记录temp的开始位置
        int pos = 0;
        for(int i=1; i<nums.length; i++) {
            if(nums[i] != nums[i-1]+1) {
                //当temp的开始位置和结束位置不是同一个时，就组合字符串
                if(pos != i-1) temp = temp + "->" + nums[i-1];
                list.add(temp);
                temp = nums[i] + "";
                pos = i;
            }
        }
        //判断nums数组的最后一个元素，是自己一个，还是和前面的一起，即是否需要和前面的组合
        if(nums.length == 1 || nums[nums.length-1] != nums[nums.length-2]+1) {
            list.add(temp);
        }else{
            list.add(temp + "->" + nums[nums.length-1]);
        }

        return list;
    }
}
