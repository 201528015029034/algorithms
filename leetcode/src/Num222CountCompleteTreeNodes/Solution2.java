package Num222CountCompleteTreeNodes;

/**
 * Created by silence on 2017/3/21.
 */
public class Solution2 {
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        int lh = getHeight(root.left);
        int rh = getHeight(root.right);
        if(lh == rh)
//      直接用Math.pow会超时，移位操作最好
//            return (int)Math.pow(2, lh) + countNodes(root.right);
            return (1 << lh) + countNodes(root.right);
//        return (int)Math.pow(2, rh) + countNodes(root.left);
        return (1 << rh) + countNodes(root.left);
    }

    private int getHeight(TreeNode root) {
        int h = 0;
        while(root != null) {
            root = root.left;
            h++;
        }
        return h;
    }
}

