public class Maximum_Path_Sum {
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

        System.out.println("Max Path sum: " + maxPath(root));
    }

    private static int maxPath(TreeNode root) {
        int[] maxPath = new int[1];
        maxPath[0] = Integer.MIN_VALUE;
        helper(root, maxPath);
        return maxPath[0];
    }

    private static int helper(TreeNode node, int[] maxPath) {
        if (node == null) return 0;
        int left = Math.max(0, helper(node.left, maxPath));
        int right = Math.max(0, helper(node.right, maxPath));
        maxPath[0] = Math.max(maxPath[0], left + right + node.data);
        return Math.max(left, right) + node.data;
    }
}
