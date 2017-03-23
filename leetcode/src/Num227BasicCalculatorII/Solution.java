package Num227BasicCalculatorII;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * Created by silence on 2017/3/22.
 */
public class Solution {
    public int calculate(String s) {
        if(s == null) return 0;
        HashSet<Character> operatorSet = new HashSet<Character>(Arrays.asList('+', '-', '*', '/'));
        LinkedList<Integer> digitList = new LinkedList<Integer>();
        LinkedList<Character> operatorList = new LinkedList<Character>();

        //注意这里的regex，如果写成"[+-*/]"就是错误的
        //根据操作分裂字符串，将字符串分为数字digits和操作符operator
        String[] digits = s.split("[+-/*]");
        for(int i=0; i<s.length(); i++) {
            if(operatorSet.contains(s.charAt(i))) {
                operatorList.add(s.charAt(i));
            }
        }
        //数字去空格
        for(String digit : digits) {
            digitList.add(Integer.valueOf(digit.trim()));
        }
        int len = operatorList.size();
        char c = ' ';
        int x=0, y=0;
        //先完成*/的运算
        while(len-- > 0) {
            c = operatorList.removeFirst();
            x = digitList.removeFirst();
            if(c == '+' || c == '-') {
                operatorList.add(c);
                digitList.add(x);
                continue;
            }
            y = digitList.removeFirst();
            digitList.addFirst(c == '*' ? x * y : x / y);
        }
        digitList.add(digitList.removeFirst());

        //完成+-的运算，从先往后运算
        while(!operatorList.isEmpty()) {
            c = operatorList.removeFirst();
            x = digitList.removeFirst();
            y = digitList.removeFirst();
            digitList.addFirst(c == '+' ? x + y : x - y);
        }
        return digitList.getFirst();
    }
}
