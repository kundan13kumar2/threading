package leetHard;

import scala.Int;

import java.util.ArrayList;
import java.util.List;

public class ModeBST {

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

    List<Integer> res = new ArrayList<>();
    Integer prev = null;
    int counter = 0;
    int maxCounter = 1;

    public void recur1(TreeNode root) {
        if (root == null) return;

        recur1(root.left);
        if (prev != null && root.val == prev) {
            counter++;
        } else {
            prev = root.val;
            counter = 1;
        }

        if (counter > maxCounter) {
            res.clear();
            res.add(root.val);
            maxCounter = counter;
        } else if (counter == maxCounter)
            res.add(root.val);

        recur1(root.right);
    }


    public int[] findMode(TreeNode root) {
        if (root == null) return new int[1];
        if (root.left == null && root.right == null) return new int[]{root.val};

        recur1(root);
        return res.stream().mapToInt(i -> i).toArray();
    }

    int sumTill = 0;

    public void recur(TreeNode root) {
        if (root == null) return;

        recur(root.right);

        root.val += sumTill;
        sumTill = root.val;

        recur(root.left);
    }


    public TreeNode convertBST(TreeNode root) {
        recur(root);
        return root;
    }


    public static void main(String[] args) {

    }
}
