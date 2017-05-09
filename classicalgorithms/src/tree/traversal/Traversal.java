package tree.traversal;

import tree.TreeNode;

import java.util.LinkedList;

/**
 * 采用递归和非递归方式实现树的前序、中序和后续遍历
 */
public class Traversal {
    /**
     * 递归实现前序
     */
    public static void preorder(TreeNode root) {
        if(root == null) return;
        visit(root);
        preorder(root.left);
        preorder(root.right);
    }

    /**
     * 采用栈非递归实现前序
     */
    public static void preorderWithStack(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        if(root == null) return;
        stack.push(root);
        TreeNode node = null;
        while(!stack.isEmpty()) {
            node = stack.pop();
            visit(node);
            //先放树节点的右子节点，再放树节点的左子节点
            if(node.right != null) stack.push(node.right);
            if(node.left != null) stack.push(node.left);
        }
    }

    public static void visit(TreeNode node) {
        System.out.print(node.val + " ");
    }
}
