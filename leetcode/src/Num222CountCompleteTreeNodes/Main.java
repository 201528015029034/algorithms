package Num222CountCompleteTreeNodes;

/**
 * Created by silence on 2017/3/19.
 */
public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(2);
        System.out.println(System.currentTimeMillis());
        System.out.println(new Solution().countNodes(root));
        System.out.println(System.currentTimeMillis());
    }
}
