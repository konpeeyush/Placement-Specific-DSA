public class ValidateBST {
    public static void main(String[] args) {
//        Tree Structure used throughout
//             13
//          /     \
//        10       15
//       /  \     /  \
//      7    12  14   17
//        \          /
//         9        16
//        /
//       8
        TreeNode root = new TreeNode(13);
        root.left = new TreeNode(10);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(9);
        root.left.left.right.left = new TreeNode(8);
        root.left.right = new TreeNode(12);
        root.right.left = new TreeNode(14);
        root.right.right = new TreeNode(17);
        root.right.right.left = new TreeNode(16);

        System.out.println(isValid(root) ? "Valid BST" : "Invalid BST");
    }

    private static boolean isValid(TreeNode root) {
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean isValid(TreeNode root, long minValue, long maxValue) {
        if (root == null) return true;
        if (root.data >= maxValue || root.data <= minValue) return false;
        return isValid(root.left, minValue, root.data) && isValid(root.right, root.data, maxValue);
    }
}
