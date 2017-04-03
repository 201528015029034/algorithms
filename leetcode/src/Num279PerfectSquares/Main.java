package Num279PerfectSquares;

/**
 * Created by silence on 2017/4/3.
 */
public class Main {
    public static void main(String[] args) {
        int n = 100000-1;
        System.out.println(System.currentTimeMillis());
        System.out.println(new Solution().numSquares(n));
        System.out.println(System.currentTimeMillis());
    }
}
