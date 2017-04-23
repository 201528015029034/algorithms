package Num306AdditiveNumber;

/**
 * Created by test on 2017/4/14.
 */
public class Solution {
    private boolean result = false;
    public boolean isAdditiveNumber(String num) {
        if(num == null || num.length() < 3) return false;
        long[] nums = new long[3];
        nums[0] = num.charAt(0) - '0';
        compute(num, nums, 1, 0);
        return result;
    }

    private void compute(String num, long[] nums, int indexOfNum, int posOfNums) {
        //如果已经到了num的末尾，还满足additive，就true
//        System.out.println(nums[0] + " " + nums[1] + " " + nums[2]);
        if(indexOfNum == num.length()) {
            if(nums[0] + nums[1] == nums[2] || nums[1] + nums[2] == nums[0] || nums[2] + nums[0] == nums[1]) {
                result = true;
//                System.out.println(nums[0] + " " + nums[1] + " " + nums[2]);
            }
            return;
        }
        //①新增数添加到前数，未处理大数越界的情况
        if(!result && nums[posOfNums%3] < Long.MAX_VALUE/10 && nums[posOfNums%3] != 0){
            nums[posOfNums%3] = nums[posOfNums%3] * 10 + (num.charAt(indexOfNum) - '0');
            compute(num, nums, indexOfNum+1, posOfNums);
            nums[posOfNums%3] = (nums[posOfNums%3] - (num.charAt(indexOfNum) - '0')) / 10;
        }
        //②新增数自己成一数
        posOfNums++;
        int i = posOfNums % 3;
        if((!result && posOfNums >=3 && nums[i] + nums[(i+1)%3] == nums[(i+2)%3]) || posOfNums < 3) {
            long tmp = nums[i];
            nums[i] = num.charAt(indexOfNum) - '0';
            compute(num, nums, indexOfNum+1, posOfNums);
            nums[i] = tmp;
        }
    }
}
