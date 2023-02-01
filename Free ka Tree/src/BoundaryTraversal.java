import java.util.*;


public class BoundaryTraversal {
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
        System.out.println("Boundary level traversal: " + boundaryTraverse(root));
    }

    private static ArrayList<Integer> boundaryTraverse(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (!isLeaf(root))
            ans.add(root.data);
//        Add Left Nodes
        addLeft(root, ans);
//        Add Leaf Nodes
        addLeaves(root, ans);
//        Add Right Nodes but in reverse
        addRight(root, ans);
        return ans;
    }

    private static boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }

    private static void addLeft(TreeNode node, ArrayList<Integer> ans) {
        TreeNode curr = node.left;
        while (curr != null) {
            if (!isLeaf(curr)) ans.add(curr.data);
            if (curr.left != null) curr = curr.left;
            else curr = curr.right;
        }
    }

    private static void addLeaves(TreeNode node, ArrayList<Integer> ans) {
        if (isLeaf(node)) {
            ans.add(node.data);
            return;
        }
        if (node.left != null) addLeaves(node.left, ans);
        if (node.right != null) addLeaves(node.right, ans);
    }

    private static void addRight(TreeNode node, ArrayList<Integer> ans) {
        TreeNode curr = node.right;
        while (curr != null) {

            if (!isLeaf(curr)) ans.add(curr.data);

            if(curr.right!=null) curr=curr.right ;
            else curr=curr.left ;

            Collections.reverse(ans);
        }
    }

}
