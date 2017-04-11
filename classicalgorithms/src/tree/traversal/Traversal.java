package tree.traversal;

import tree.TreeNode;

/**
 * Created by silence on 2017/4/3.
 */
public class Traversal {
    public static void preorder(TreeNode root) {
        if(root == null) return;
        visit(root);
        preorder(root.left);
        preorder(root.right);
    }

    public static void visit(TreeNode node) {
        System.out.print(node.val + " ");
    }
}
