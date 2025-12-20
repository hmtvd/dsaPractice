package Tree;

public class MaximumPathSum {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    static int maxSum = Integer.MIN_VALUE;

    static int maxPath(TreeNode root) {
        if (root == null) return 0;

        int left = Math.max(0, maxPath(root.left));
        int right = Math.max(0, maxPath(root.right));

        maxSum = Math.max(maxSum, root.val + left + right);

        return root.val + Math.max(left, right);
    }

    static int maxPathSum(TreeNode root) {
        maxPath(root);
        return maxSum;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(maxPathSum(root));
    }
}

