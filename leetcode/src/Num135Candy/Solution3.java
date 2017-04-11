package Num135Candy;

/**
 * Created by test on 2017/4/9.
 */
public class Solution3 {
    public int candy(int[] ratings) {
        if(ratings == null || ratings.length == 0) return 0;
        if(ratings.length == 1) return 1;
        int countDown = 0, tot = 0, prev = 1;
        if(ratings[0] > ratings[1])
            countDown++;
        else
            tot += prev;
        for(int i=1; i<ratings.length-1; i++) {
            if(ratings[i] > ratings[i-1]) {
                if(countDown != 0) {
                    tot += (countDown+1)*countDown/2;
                    countDown = 0;
                }
                if(ratings[i] < ratings[i+1]) {
                    prev = prev + 1;
                    tot += prev;
                }else {
                    countDown++;
                    prev = 1;
                }
            }else if(ratings[i] == ratings[i-1]) {
                if(countDown != 0) {
                    tot += (countDown+1)*countDown/2;
                    countDown = 0;
                }
                if(ratings[i] < ratings[i+1]) {
                    prev = 1;
                    tot += prev;
                }else {
                    countDown++;
                    prev = 1;
                }
            }else {
                countDown++;
                prev = 1;
            }
        }
        if(countDown != 0) {
            tot += (countDown+1)*countDown/2;
        }
        if(ratings[ratings.length-1] > ratings[ratings.length-2]) {
            tot += 2;
        }else if(ratings[ratings.length-1] == ratings[ratings.length-2]) {
            tot += 1;
        }else {
            tot += (countDown + 1);
        }
        return tot;
    }
}
