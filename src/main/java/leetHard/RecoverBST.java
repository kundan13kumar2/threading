package leetHard;

public class RecoverBST {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    TreeNode first = null;
    TreeNode second = null;

    TreeNode prev = new TreeNode(Integer.MIN_VALUE);

    public void inOrder(TreeNode root) {
        if (root == null) return;

        inOrder(root.left);

        if (first == null && prev.val > root.val)
            first = prev;

        if (first != null && prev.val > root.val)
            second = root;
        prev = root;

        inOrder(root.right);
    }

    public void recoverTree(TreeNode root) {
        inOrder(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;

    }
}
