package Num273IntegertoEnglishWords;

/**
 * Created by silence on 2017/3/19.
 */
public class Main {
    public static void main(String[] args) {
        int num = 12345;
        System.out.println(System.currentTimeMillis());
        System.out.println(new Solution().numberToWords(num));
        System.out.println(System.currentTimeMillis());
    }
}
