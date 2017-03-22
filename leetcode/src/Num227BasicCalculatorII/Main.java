package Num227BasicCalculatorII;

/**
 * Created by silence on 2017/3/19.
 */
public class Main {
    public static void main(String[] args) {
        String s = "1+1-1";
        System.out.println(System.currentTimeMillis());
        System.out.println(new Solution().calculate(s));
        System.out.println(System.currentTimeMillis());
    }
}
