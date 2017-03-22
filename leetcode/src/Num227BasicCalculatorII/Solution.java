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

        String[] digits = s.split("[+-/*]");
        for(int i=0; i<s.length(); i++) {
            if(operatorSet.contains(s.charAt(i))) {
                operatorList.add(s.charAt(i));
            }
        }
        for(String digit : digits) {
            digitList.add(Integer.valueOf(digit.trim()));
        }
        int len = operatorList.size();
        char c = ' ';
        int x=0, y=0;
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

        while(!operatorList.isEmpty()) {
            c = operatorList.removeFirst();
            x = digitList.removeFirst();
            y = digitList.removeFirst();
            digitList.addFirst(c == '+' ? x + y : x - y);
        }
        return digitList.getFirst();
    }
}
