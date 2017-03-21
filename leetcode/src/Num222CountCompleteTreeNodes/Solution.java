package Num222CountCompleteTreeNodes;

/**
 * Created by silence on 2017/3/21.
 */
public class Solution {
    static int num = 0;
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        root.val = 1;
        findLast(root);
        return num;
    }

    private void findLast(TreeNode root) {
        if(root == null) return;
        TreeNode leftNode = root;
        while(leftNode.left != null) {
            leftNode.left.val = leftNode.val * 2;
            leftNode = leftNode.left;
        }
        TreeNode rightNode = root;
        while (rightNode.right != null) {
            rightNode.right.val = rightNode.val * 2 + 1;
            rightNode = rightNode.right;
        }

        if(rightNode.val >= leftNode.val) {
            num = rightNode.val > num ? rightNode.val : num;
        } else {
            findLast(root.left);
            findLast(root.right);
        }

    }
}

 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
