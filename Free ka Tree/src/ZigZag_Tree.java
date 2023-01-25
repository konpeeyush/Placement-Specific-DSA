import java.util.*;

public class ZigZag_Tree {
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

        System.out.println("ZigZag Traversal of Tree is: " + zigzag(root));
    }

    private static List<List<Integer>> zigzag(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean flag = false;
        while (!queue.isEmpty()) {
            int level = queue.size();
            LinkedList<Integer> subList = new LinkedList<>();

            for (int i = 0; i < level; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                if (flag)
                    subList.addFirst(node.data);
                else
                    subList.addLast(node.data);
            }
            flag = !flag;
            ans.add(subList);
        }
        return ans;
    }
}
