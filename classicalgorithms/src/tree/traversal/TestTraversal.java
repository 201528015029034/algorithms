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
    }
}
