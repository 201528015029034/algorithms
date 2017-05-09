package tree;

/**
 * Created by silence on 2017/4/3.
 */
public class TreeGenerator {
//            1
//          /   \
//         2     3
//        / \   / \
//       4   5 6   7
//      /
//     8
    public static TreeNode generate() {

        TreeNode root = new TreeNode(1);
        TreeNode rootLeft = new TreeNode(2);
        TreeNode rootRight = new TreeNode(3);
        root.left = rootLeft;
        root.right = rootRight;
        TreeNode rootLeftLeft = new TreeNode(4);
        rootLeft.left = rootLeftLeft;
        rootLeft.right = new TreeNode(5);
        rootRight.left = new TreeNode(6);
        rootRight.right = new TreeNode(7);
        rootLeftLeft.left = new TreeNode(8);
        return root;
    }

    public static TreeNode generateWithOneTreeNode() {
        return new TreeNode(1);
    }
}
