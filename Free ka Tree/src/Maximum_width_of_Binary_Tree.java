import java.util.LinkedList;
import java.util.Queue;

public class Maximum_width_of_Binary_Tree {
    static class Pair {
        TreeNode node;
        int index;

        public Pair(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }

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
        System.out.println("Max width of binary tree: " + maxWidth(root));
    }

    private static int maxWidth(TreeNode root) {
        if (root == null) return 0;
        Queue<Pair> queue = new LinkedList<>();
        int width = 0;
        queue.offer(new Pair(root, 0));

        while (!queue.isEmpty()) {
            int size = queue.size();
            int minIndex = queue.peek().index;
            int firstIndex = 0, lastIndex = 0;
            for (int i = 0; i < size; i++) {
                int currIndex = queue.peek().index - minIndex;
                TreeNode node = queue.peek().node;
                queue.poll();
                if (i == 0) firstIndex = currIndex;
                if (i == size - 1) lastIndex = currIndex;
                if (node.left != null)
                    queue.offer(new Pair(node.left, currIndex * 2 + 1));
                if (node.right != null)
                    queue.offer(new Pair(node.right, currIndex * 2 + 2));
            }
            width = Math.max(width, lastIndex - firstIndex + 1);
        }
        return width;
    }
}
