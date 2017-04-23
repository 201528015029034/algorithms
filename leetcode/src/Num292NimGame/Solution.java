package Num292NimGame;

/**
 * Created by test on 2017/4/12.
 */
public class Solution {
    public boolean canWinNim(int n) {
        if(n <= 3)
            return true;
        else
            return !(loseNim(n-1) && loseNim(n-2) && loseNim(n-3));
    }

    private boolean loseNim(int n) {
        if(n <= 3)
            return true;
        else
            return !(canWinNim(n-1) && canWinNim(n-2) && canWinNim(n-3));
    }
}
