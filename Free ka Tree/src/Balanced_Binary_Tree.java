public class Balanced_Binary_Tree {
    public static void main(String[] args) {
        //        Tree Structure used throughout
//             1
//          /     \
//        2        3
//       /  \     /  \
//      4    5   6    7
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        System.out.println("Is this a balanced binary tree? " + (balancedBinary(root)?"Yes":"No"));
    }

    static boolean balancedBinary(TreeNode root) {
        if (root == null) return true;
        int lh = height(root.left);
        int rh = height(root.right);

        if (Math.abs(lh - rh) > 1) return false;

        boolean left = balancedBinary(root.left);
        boolean right = balancedBinary(root.right);

        return left && right;
    }

    static int height(TreeNode root) {
        if (root == null)
            return 0;
        int lh = height(root.left);
        int rh = height(root.right);
        return 1 + Math.max(lh, rh);
    }
}
