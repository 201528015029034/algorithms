package Num279PerfectSquares;

/**
 * Created by silence on 2017/4/3.
 */

public class Solution {
    /**
     * 本题目的主要思路就是动态规划，例如：
     * f(10) = min(f(9)+f(1), f(4)+f(6), f(1)+f(9))
     * f(12) = min(f(9)+f(3), f(4)+f(8), f(1)+f(11))
     * ···
     * f(99) = min(f(81)+f(18), f(64)+f(35), f(49)+f(50), f(36)+f(63),..., f(1)+f(98))
     * 这样每次得到的都是最小的
     */
    public int numSquares(int n) {
        int sqrt = (int)Math.sqrt(n);
        //错误4：这里当n == sqrt * sqrt 时应该返回1，错误返回成2了
        if(sqrt * sqrt == n) return 1;
        int[] leastNum = new int[n+1];
        leastNum[1] = 1;
        int tmp = 0;
        for(int i=2; i<=n; i++) {
            //错误3：这里把i写成了n
            sqrt = (int)Math.sqrt(i);
            if(sqrt * sqrt == i) {
                leastNum[i] = 1;
                continue;
            }
            leastNum[i] = Integer.MAX_VALUE;
            //错误1：这里重复定义变量i=sqrt
            for(int j=sqrt; j>=1; j--) {
                //错误2：这里leastNum[i - j*j]写成了leastNum[i-sqrt*sqrt]
                tmp = 1 + leastNum[i - j*j];
                if(tmp < leastNum[i])
                    leastNum[i] = tmp;
            }
        }

        return leastNum[n];
    }
}
