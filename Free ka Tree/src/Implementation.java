import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data) {
        this.data = data;
    }

    public static TreeNode insertNode() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Insert root");
        int data = sc.nextInt();
        TreeNode root = new TreeNode(data);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            System.out.println("Insert left child of " + temp.data);
            int left = sc.nextInt();
            if (left != -1) {
                temp.left = new TreeNode(left);
                queue.offer(temp.left);
            }
            System.out.println("Insert right child of " + temp.data);
            int right = sc.nextInt();
            if (right != -1) {
                temp.right = new TreeNode(right);
                queue.offer(temp.right);
            }
        }
        return root ;
    }
}

public class Implementation {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
    }
}
