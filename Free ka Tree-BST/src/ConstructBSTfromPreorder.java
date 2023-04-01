public class ConstructBSTfromPreorder {
    public static void main(String[] args) {
        int[] preorder = {8, 5, 1, 7, 10, 12};
        System.out.println(preorder(constructBST(preorder)));
    }

    private static TreeNode constructBST(int[] preorder) {
        return helper(preorder, Integer.MAX_VALUE, new int[]{0});
    }

    private static TreeNode helper(int[] preorder, int bound, int[] i) {
        if (i[0] == preorder.length || preorder[i[0]] > bound) return null;
        TreeNode root = new TreeNode(preorder[i[0]++]);
        root.left = helper(preorder, root.data, i);
        root.right = helper(preorder, bound, i);
        return root;
    }

    private static String preorder(TreeNode root) {
        if (root == null) return "";
        return root.data + " " + preorder(root.left) + preorder(root.right);
    }
}
