package leetHard;

public class Diameter {

    public static class TreeNode {
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


    public static int recur(TreeNode root, int[] max) {
        if (root == null) return 0;

        int l = recur(root.left, max);
        int r = recur(root.right, max);
        max[0] = Math.max(max[0], (l + r));
        return Math.max(l, r) + 1;

    }

    public static int diameterOfBinaryTree(TreeNode root) {
        int[] max = {0};
        recur(root, max);
        return max[0];

    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(3);
        TreeNode root4 = new TreeNode(4);
        TreeNode root5 = new TreeNode(5);

        root1.left = root2;
        root1.right = root3;
        root2.left = root4;
        root2.right = root5;
        System.out.println(diameterOfBinaryTree(root1));

    }
}
