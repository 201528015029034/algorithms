package Num135Candy;

/**
 * Created by test on 2017/4/9.
 */
//通过
public class Solution2 {
    public int candy(int[] ratings) {
        if(ratings == null || ratings.length == 0) return 0;
        if(ratings.length == 1) return 1;
        int len = ratings.length;
        //要初始化每个元素为1？ 不需要
        int[] numCandies = new int[len];
        int[] revNumCandies = new int[len];
        //顺序计算minCandies
        if(ratings[0] > ratings[1]) numCandies[0] = 1;
        for(int i=1; i<len-1; i++) {
            if(ratings[i] > ratings[i-1]) {
                numCandies[i] = numCandies[i-1] + 1;
            }else if(ratings[i] > ratings[i+1]) {
                numCandies[i] = 1;
            }
        }
        if(ratings[len-1] > ratings[len-2]) numCandies[len-1] = numCandies[len-2] + 1;
        //反序计算minCandies
        if(ratings[len-1] > ratings[len-2]) revNumCandies[len-1] = 1;
        for(int i=len-2; i>0; i--) {
            if(ratings[i] > ratings[i+1]) {
                revNumCandies[i] = revNumCandies[i+1] + 1;
            }else if(ratings[i] > ratings[i-1]) {
                revNumCandies[i] = 1;
            }
        }
        if(ratings[0] > ratings[1]) revNumCandies[0] = revNumCandies[1] + 1;



        int tot = numCandies.length;
        for(int i=0; i<numCandies.length; i++) {
            tot += Math.max(numCandies[i], revNumCandies[i]);
        }
        return tot;
    }
}
