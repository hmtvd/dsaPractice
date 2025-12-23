package Tree;

public class LCABST {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return helper(root, p, q);
    }

    private static TreeNode helper(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;

        if (p.val == root.val || q.val == root.val)
            return root;

        if (p.val > root.val && q.val > root.val) {
            return helper(root.right, p, q);
        }

        if (p.val > root.val || q.val > root.val)
            return root;

        return helper(root.left, p, q);
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        TreeNode p = root.left;              
        TreeNode q = root.left.right.right; 

        TreeNode lca = lowestCommonAncestor(root, p, q);
        System.out.println(lca.val); 
    }
}
