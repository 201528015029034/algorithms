package Num275HIndexII;

/**
 * Created by silence on 2017/4/2.
 */

public class Solution {
    /**
     * 这里注意[0, ..., ]的情况，所以需要一个 hIndex 变量，它只有在第一次 citations[mid] >= len - mid 时才更新
     * 如果没有更新就代表 hIndex = 0 了，返回 hIndex 即可
     */
    public int hIndex(int[] citations) {
        if(citations == null) return 0;
        int len = citations.length;
        int lo = 0, hi = len - 1, mid = 0;
        int hIndex = 0;
        while(lo <= hi) {
            mid = lo + (hi-lo)/2;
            if(citations[mid] >= len - mid) {
                hi = mid - 1;
                hIndex = len - mid;
            }else {
                lo = mid + 1;
            }
        }

        return hIndex;
    }
}
