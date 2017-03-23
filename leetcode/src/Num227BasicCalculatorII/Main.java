package Num227BasicCalculatorII;

/**
 * Created by silence on 2017/3/19.
 */
public class Main {
    public static void main(String[] args) {
        String s = "5*4-3";
        System.out.println(System.currentTimeMillis());
        System.out.println(new FastSolution().calculate(s));
        System.out.println(System.currentTimeMillis());
    }
}
