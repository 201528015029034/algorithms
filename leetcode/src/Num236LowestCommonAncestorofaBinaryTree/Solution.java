package Num236LowestCommonAncestorofaBinaryTree;

import java.util.LinkedList;

/**
 * Created by test on 2017/3/28.
 */


public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        LinkedList<TreeNode> pPath = new LinkedList<TreeNode>();
        pPath.add(root);
        LinkedList<TreeNode> qPath = new LinkedList<TreeNode>();
        qPath.add(root);
        findPath(root, p, pPath);
        findPath(root, q, qPath);
        TreeNode commonAncestor = null;
        while((p=pPath.pollFirst()) != null && (q=qPath.pollFirst()) != null) {
            if(p == q) commonAncestor = p;
        }

        return commonAncestor;
    }

    private boolean findPath(TreeNode root, TreeNode target, LinkedList<TreeNode> path) {
        if(root == null) return false;
        if(root == target) {
            return true;
        }
        path.add(root.left);
        if(findPath(root.left, target, path)) return true;
        path.removeLast();

        path.add(root.right);
        if(findPath(root.right, target, path)) return true;
        path.removeLast();

        return false;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
