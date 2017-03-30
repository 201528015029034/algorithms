package Num241DifferentWaystoAddParentheses;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by silence on 2017/3/30.
 */
public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        if(input == null || input.length() == 0) return new ArrayList<Integer>();
        return fun(input);
    }

    /**
     * 本题目的主要思路就是分治递归，divide and conker
     */
    private List<Integer> fun(String input) {
        List<Integer> list = new ArrayList<Integer>();
        int num = 0;
        boolean hasOperator = false;
        for(int i=0; i<input.length(); i++) {
            //只要遇到一个操作符，就将字符串分治，将其分为操作符左边部分和操作符右边部分，递归调用
            if(!Character.isDigit(input.charAt(i))) {
                //对返回的两个list中的数字，进行全排列操作，并加入列表
                for(int m : fun(input.substring(0, i))) {
                    for(int n: fun(input.substring(i+1, input.length()))) {
                        switch(input.charAt(i)) {
                            case '*':
                                list.add(m*n);
                                break;
                            case '+':
                                list.add(m+n);
                                break;
                            case '-':
                                list.add(m-n);
                                break;
                        }
                    }
                }
                num = 0;
                hasOperator = true;
                continue;
            }
            //将字符串转化为数字
            num = num * 10 + (input.charAt(i) - '0');
        }
        //如果字符串只是一个数字时，那么就返回该数字的list
        //如果字符串中已经出现了操作符，那么我们在for循环中得到的list就是完整的list，返回该list
        if(!hasOperator) list.add(num);
        return list;
    }
}
