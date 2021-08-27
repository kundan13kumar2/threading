package leetHard;

public class MaxSumBST {

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


    public class Result {
        int sum;
        boolean isBST;
        int maxLeft;
        int minLeft;

        public Result(int sum, boolean isBST, int maxLeft, int minLeft) {
            this.sum = sum;
            this.isBST = isBST;
            this.maxLeft = maxLeft;
            this.minLeft = minLeft;
        }
    }

    public Result recur(TreeNode root) {
        if (root == null) return null;

        Result left = recur(root.left);
        Result right = recur(root.right);
        if (left == null && right == null)
            return new Result(root.val, true, root.val, root.val);
        else if (left != null && right != null && left.isBST && right.isBST && left.maxLeft <= root.val && right.minLeft >= root.val) {
            return new Result(root.val + left.sum + right.sum, true, right.maxLeft, left.minLeft);
        } else if (left != null && right == null && left.isBST && left.maxLeft <= root.val)
            return new Result(root.val + left.sum, true, root.val, left.minLeft);
        else if (right != null && left == null && right.isBST && right.minLeft >= root.val)
            return new Result(root.val + right.sum, true, right.maxLeft, root.val);
        else if (left != null && right != null)
            return new Result(Math.max(left.sum, right.sum), false, left.maxLeft, right.minLeft);
        else
            return new Result(root.val, false, 0, 0);


    }

    public int maxSumBST(TreeNode root) {
        return 1;
    }
}
