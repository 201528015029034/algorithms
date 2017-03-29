package Num236LowestCommonAncestorofaBinaryTree;

/**
 * Created by test on 2017/3/28.
 */
public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        TreeNode p = root.left;
        TreeNode q = root.left.left;
        System.out.println(new Solution().lowestCommonAncestor(root, p, q).val);
    }
}
