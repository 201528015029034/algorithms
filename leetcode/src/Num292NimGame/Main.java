package Num292NimGame;

/**
 * Created by test on 2017/4/9.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
        System.out.println(new Solution().canWinNim(6));
        System.out.println(System.currentTimeMillis());

        System.out.println(System.currentTimeMillis());
        System.out.println(new FastSolution().canWinNim(1348820612));
        System.out.println(System.currentTimeMillis());
//        for(int i=1; i<=42; i++) {
//
//            if (new Solution().canWinNim(i) != new FastSolution().canWinNim(i)) {
//                System.out.println("error");
//            }
//        }
    }
}
