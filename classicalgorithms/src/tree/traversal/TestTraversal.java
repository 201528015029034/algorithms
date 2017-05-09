package tree.traversal;

import org.junit.jupiter.api.Test;
import tree.TreeGenerator;

/**
 * Created by silence on 2017/4/3.
 */
public class TestTraversal {

    @Test
    public void testPreorder() {
        Traversal.preorder(TreeGenerator.generateWithOneTreeNode());
        System.out.println();
        Traversal.preorder(TreeGenerator.generate());
        System.out.println();
        Traversal.preorderWithStack(TreeGenerator.generate());
    }/*
    1 2 4 8 5 3 6 7
    */
}
