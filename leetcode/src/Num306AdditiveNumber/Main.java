package Num306AdditiveNumber;

/**
 * Created by test on 2017/4/9.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
        System.out.println(new Solution().isAdditiveNumber("199100199"));
        System.out.println(System.currentTimeMillis());
        System.out.println("--------------------------------------------------------------");
        System.out.println(System.currentTimeMillis());
        System.out.println(new RightSolution().isAdditiveNumber("199100199"));
        System.out.println(System.currentTimeMillis());
    }
}
