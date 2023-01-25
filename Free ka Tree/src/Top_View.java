import java.util.*;

class Pair {
    TreeNode node;
    int col;

    public Pair(TreeNode node, int col) {
        this.node = node;
        this.col = col;
    }
}

public class Top_View {
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

        System.out.println("Top View of the Tree is: " + topView(root));
    }

    private static ArrayList<Integer> topView(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));
        while (!queue.isEmpty()) {
            Pair it = queue.poll();
            TreeNode temp = it.node;
            int col = it.col;

//            Top View
            if(!map.containsKey(col))
                map.put(col, temp.data);
//      <------------------------------------->
//            Bottom View
//            map.put(col, temp.data);

            if (temp.left != null)
                queue.add(new Pair(temp.left, col - 1));

            if (temp.right != null)
                queue.add(new Pair(temp.right, col + 1));
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            ans.add(entry.getValue());
        }
        return ans;
    }
}
