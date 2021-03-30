package leetHard;

import java.util.*;

public class FlipMatchPre {

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

    public List<Integer> flipMatch(TreeNode root, int[] voyage) {

        List<Integer> result = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        int i = 0;
        queue.add(root);
        if (voyage[i] != root.val) return Collections.singletonList(-1);
        while (!queue.isEmpty()) {
            TreeNode parent = queue.element();

            int j = i + queue.size();
            int k = i + queue.size() + 1;
            System.out.println(j + " " + k);
            if (j < voyage.length && k < voyage.length
                    && parent.left != null && parent.right != null &&
                    voyage[j] != parent.left.val && voyage[k] != parent.right.val) {
                result.add(parent.val);
                TreeNode temp = parent.left;
                parent.left = parent.right;
                parent.right = temp;
            } else if (j < voyage.length && parent.left != null && voyage[j] == parent.left.val && parent.right == null) {
                return Collections.singletonList(-1);
            } else if (k < voyage.length && parent.right != null && voyage[k] == parent.right.val && parent.left == null)
                return Collections.singletonList(-1);
            if (parent.left != null)
                queue.add(parent.left);
            if (parent.right != null)
                queue.add(parent.right);
            i++;

            queue.poll();
        }

        return result;
    }

    int i = 0;
    int[] v;
    List<Integer> result;

    public boolean dfsRecur(TreeNode node) {
        if (node == null) return true;
        if (node.val != v[i++]) return false;

        if (node.left != null && node.left.val != v[i]) {
            result.add(node.val);
            return dfsRecur(node.right) && dfsRecur(node.left);
        } else return dfsRecur(node.left) && dfsRecur(node.right);

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = null;
        root.right = new TreeNode(2);

        root.right.left = null;
        root.right.right = new TreeNode(3);
       /* root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        root.right.left.left = new TreeNode(6);
        root.right.left.right = new TreeNode(7);*/

        int[] voyage = {1, 3, 2};
        FlipMatchPre pre = new FlipMatchPre();
        System.out.println(pre.flipMatch(root, voyage));

    }
}
