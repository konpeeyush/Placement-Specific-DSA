public class LCA {
    public static void main(String[] args) {
//        Tree Structure used throughout
//             1
//          /     \
//        2        3
//       /  \     /  \
//      4    5   8    9
//          / \
//         6   7
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(6);
        root.left.right.right = new TreeNode(7);
        root.right.left = new TreeNode(8);
        root.right.right = new TreeNode(9);
        System.out.println("Lowest common ancestor of 4 and 7 is: " + lowestCommonAncestor(root, root.left.left, root.left.right.right).data);
    }
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // base case
        if (root == null || root == p || root == q)
            return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
//        Returns other node when anyone is null
//        Leaf node will have both left and right null
        if (left == null)
            return right;
        else if (right == null)
            return left;
        else
            return root;
    }
}
