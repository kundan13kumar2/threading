package leetHard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DuplicateSubtree {

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

    List<TreeNode> result;
    Map<String, Integer> map;

    public String recur(TreeNode root) {
        if (root == null) return "N";

        String value = root.val + recur(root.left) + recur(root.right);
        int p = map.getOrDefault(value, 0);
        map.put(value, p + 1);
        if (map.get(value) == 2)
            result.add(root);
        return value;
    }


    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        result = new ArrayList<>();
        map = new HashMap<>();
        recur(root);
        return result;
    }
}
