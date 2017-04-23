package Num292NimGame;

/**
 * Created by test on 2017/4/12.
 */
public class FastSolution {
        public boolean canWinNim(int n) {
            if(n <= 3)  return true;
            boolean[] moveResult = new boolean[3];
            moveResult[0] = true;
            moveResult[1] = true;
            moveResult[2] = true;
            // boolean moveOne = true, moveTwo = true, moveThree = true;
            int i = 3;
            for(; i<n; i++) {
                moveResult[i % 3] = !(moveResult[0] && moveResult[1] && moveResult[2]);
            }

            return moveResult[(i-1) % 3];
        }
}
