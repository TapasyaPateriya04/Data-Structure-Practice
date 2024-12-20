
public class revTree {

    // Definition for a TreeNode
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args) {
        // Constructing the binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        revTree soln = new revTree();
        soln.reverseOddLevels(root);
        soln.printTree(root);  // To verify the output
    }

    public TreeNode reverseOddLevels(TreeNode root) {
        if (root == null || root.left == null || root.right == null) 
            return root;
        
        levelTraverse(root.left, root.right, 1); // Start with level 1 (first odd level)
        return root;
    }

    private void levelTraverse(TreeNode node1, TreeNode node2, int level) {
        if (node1 == null || node2 == null)
            return;

        // Reverse the values at odd levels
        if (level % 2 == 1) {
            int val = node1.val;
            node1.val = node2.val;
            node2.val = val;
        }

        // Traverse to the next level
        levelTraverse(node1.left, node2.right, level + 1);
        levelTraverse(node1.right, node2.left, level + 1);
    }

    // Helper function to print the tree in-order (for verification)
    public void printTree(TreeNode root) {
        if (root == null) return;
        printTree(root.left);
        System.out.print(root.val + " ");
        printTree(root.right);
    }
}
