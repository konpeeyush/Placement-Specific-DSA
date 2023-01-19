import java.util.*;

public class Traversal_Techniques {
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
//        System.out.println("Level Order Traversal: " + levelOrder(root));
//        System.out.println("Pre-Order Traversal: " + preOrder(root));
//        System.out.println("In-Order Traversal: " + inOrder(root));
        System.out.println("Post Order Traversal: " + postOrder(root));
    }

    static ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int level = queue.size();
            ArrayList<Integer> output = new ArrayList<>();
            for (int i = 0; i < level; i++) {

                assert queue.peek() != null;
                if (queue.peek().left != null) queue.offer(queue.peek().left);

                assert queue.peek() != null;
                if (queue.peek().right != null) queue.offer(queue.peek().right);

                output.add(Objects.requireNonNull(queue.poll()).data);
            }
            ans.add(output);
        }
        return ans;
    }

    static ArrayList<Integer> preOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            ans.add(root.data);
            if (root.right != null) stack.add(root.right);
            if (root.left != null) stack.add(root.left);
        }
        return ans;
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

    static ArrayList<Integer> postOrder(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<TreeNode> st1 = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();
        st1.push(root);
        while (!st1.isEmpty()) {
            root = st1.pop();
            st2.add(root);
            if (root.left != null) st1.push(root.left);
            if (root.right != null) st1.push(root.right);
        }
        while (!st2.isEmpty()) ans.add(st2.pop().data);

        return ans;
    }
}
