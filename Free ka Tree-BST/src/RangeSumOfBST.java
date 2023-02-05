public class RangeSumOfBST {
    static int sum;

    public static void main(String[] args) {
//        Tree Structure used throughout
//            10
//          /     \
//        5       15
//       /  \       \
//      3    7       18
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.right = new TreeNode(18);

        System.out.println("Range sum BST b/w 7 and 15 is " + rangeSumBST(root, 7, 15));
    }

    private static int rangeSumBST(TreeNode root, int low, int high) {
        sum = 0;
        helper(root, low, high);
        return sum;
    }

    private static int helper(TreeNode node, int low, int high) {
        if (node != null) {
            if (node.data >= low && node.data <= high) sum += node.data;

            if (low < node.data) helper(node.left, low, high);
            if (high > node.data) helper(node.right, low, high);
        }
        return sum;
    }
}
