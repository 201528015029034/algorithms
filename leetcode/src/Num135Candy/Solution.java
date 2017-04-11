package Num135Candy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by test on 2017/4/9.
 */
//时间复杂度O(n2) 超时
public class Solution {
    public int candy(int[] ratings) {
        if(ratings == null || ratings.length == 0) return 0;
        if(ratings.length == 1) return 1;
        //要初始化每个元素为1？ 不需要
        int[] numCandies = new int[ratings.length];
        int minR = min(ratings);
        HashSet<Integer> list = new HashSet<>();
        while(minR != Integer.MAX_VALUE) {
            for(int i=0; i<ratings.length; i++) {
                if(ratings[i] == minR) {
                    if(i==0) {
                        if (ratings[i+1] == Integer.MAX_VALUE) {
                            numCandies[i] = numCandies[i+1] + 1;
                        }
                    }else if(i==ratings.length-1) {
                        if (ratings[i-1] == Integer.MAX_VALUE) {
                            numCandies[i] = numCandies[i-1] + 1;
                        }
                    }else if(ratings[i-1] == Integer.MAX_VALUE || ratings[i+1] == Integer.MAX_VALUE) {
                        //错误1：忘记加1
                        //错误3：[1, 2, 4, 4, 3] 当两个相邻的数字相等时，那么他们多彼此是没有影响的,答案应该是[1, 2, 3, 2, 1]
                        if(ratings[i-1] == ratings[i]) {
                            numCandies[i] = numCandies[i+1] + 1;
                        }else {
                            numCandies[i] = Math.max(numCandies[i-1], numCandies[i+1]) + 1;
                        }
                    }
                    list.add(i);
                }
            }
            //rating[i]提前变为Integer.MAX_VALUE，导致相邻MinR计算错误
            for (int j : list)
                ratings[j] = Integer.MAX_VALUE;
            //错误2：MinR计算位置错误，导致多算一轮
            minR = min(ratings);
        }
        int tot = numCandies.length;
        for(int i=0; i<numCandies.length; i++) {
            System.out.println("numsC " +  numCandies[i]);
            tot += numCandies[i];
        }
        return tot;
    }

    private int min(int[] nums) {
        int min = Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] < min)
                min = nums[i];
        }
        return min;
    }
}
