package Num227BasicCalculatorII;

/**
 * Created by silence on 2017/3/23.
 */
public class FastSolution {
    public int calculate(String s) {
        if (s == null) return 0;
        //这里是正则表达式，表示将一个或一个以上" "替换为"" ，去掉字符串内部的空格
        s = s.trim().replaceAll(" +", "");
        int length = s.length();

        int res = 0; //保存二元运算的结果
        long preVal = 0; // initial preVal is 0 这个运算都是二元运算，preVal保存第一个运算符
        char sign = '+'; // initial sign is +  初始化符号为'+'，当读入第一个数字之后，进入sign=='+'，res += 0;
        int i = 0;
        while (i < length) {
            long curVal = 0;
            //读入一个数字
            while (i < length && (int)s.charAt(i) <= 57 && (int)s.charAt(i) >= 48) { // int
                curVal = curVal*10 + (s.charAt(i) - '0');
                i++;
            }
            if (sign == '+') {
                res += preVal;  // update res  直到遇到"+" "-"才更新结果
                preVal = curVal;
            } else if (sign == '-') {
                res += preVal;  // update res
                preVal = -curVal;
            } else if (sign == '*') {
                preVal = preVal * curVal; // not update res, combine preVal & curVal and keep loop
            } else if (sign == '/') {
                preVal = preVal / curVal; // not update res, combine preVal & curVal and keep loop
            }
            if (i < length) { // getting new sign
                sign = s.charAt(i);
                i++;
            }
        }
        res += preVal; //将最后一个结果加进来
        return res;
    }/*
    例如下面这样
    3+2*2*3+5  遇到+5时，preVal保存了2*2*3的结果，sign更新为'+'和读入5之后，将2*2*3的结果更新进去，再将preVal=curVal=5

    */
}
