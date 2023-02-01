import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ChildrenSumProperty {
    public static void main(String[] args) {
//        Tree Structure used throughout
//             1
//          /     \
//        2        3
//       /  \     /  \
//      4    5   6    7

//    Modified Tree should be:-
//             22
//          /      \
//        9         13
//      /   \     /    \
//     4     5   6      7

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        System.out.println("Before Modification" + inOrder(root));
        childrenSum(root);
        System.out.println("After Modification" + inOrder(root));
        System.out.println("Does the modified tree follows child Sum Property? " + (isSum(root) ? "Yes" : "No"));
    }

    private static void childrenSum(TreeNode root) {
        if (root == null) return;
        int childrenSum = 0;
        if (root.left != null) childrenSum += root.left.data;
        if (root.right != null) childrenSum += root.right.data;

        if (childrenSum > root.data) root.data = childrenSum;
        else {
            if (root.left != null) root.left.data = root.data;
            else if (root.right != null) root.right.data = root.data;
        }

        childrenSum(root.left);
        childrenSum(root.right);

        int total = 0;
        if (root.left != null) total += root.left.data;
        if (root.right != null) total += root.right.data;
        if (root.left != null || root.right != null) root.data = total;
    }

    private static boolean isSum(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int rootSum = node.data;
            int childSum = 0;

            if (node.left != null) {
                queue.add(node.left);
                childSum += node.left.data;
            }

            if (node.right != null) {
                queue.add(node.right);
                childSum += node.right.data;
            }

            if (childSum != 0 && childSum != rootSum)
                return false;
        }
        return true;
    }

    static ArrayList<Integer> inOrder(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (true) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                if (stack.isEmpty()) break;
                node = stack.pop();
                ans.add(node.data);
                node = node.right;
            }
        }
        return ans;
    }
}
