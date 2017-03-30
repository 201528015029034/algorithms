package Num241DifferentWaystoAddParentheses;

/**
 * Created by silence on 2017/3/19.
 */
public class Main {
    public static void main(String[] args) {
        String input = "2*3-4*5";
        System.out.println(System.currentTimeMillis());
        System.out.println(new Solution().diffWaysToCompute(input));
        System.out.println(System.currentTimeMillis());
    }
}
