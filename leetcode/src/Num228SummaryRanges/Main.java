package Num228SummaryRanges;

/**
 * Created by silence on 2017/3/19.
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{-2147483648,-2147483647,2147483647};
//        int[] nums = new int[]{0,1,2,4,5,7};
        System.out.println(System.currentTimeMillis());
        System.out.println(new Solution2().summaryRanges(nums));
        System.out.println(System.currentTimeMillis());
    }
}
