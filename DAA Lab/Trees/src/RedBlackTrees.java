public class RedBlackTrees {

    public static class TreeNode {
        int data;
        TreeNode left, right;
        int color;

        public TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
            this.color = 1;
//            1 -> Red
//            0 -> Black
        }
    }

    public static TreeNode root;

    public static void main(String[] args) {

        RedBlackTrees tree = new RedBlackTrees();
        tree.root = new TreeNode(10);
        tree.root.left = new TreeNode(5);
        tree.root.right = new TreeNode(15);
        tree.root.left.left = new TreeNode(3);
        tree.root.left.right = new TreeNode(7);
        tree.root.right.left = new TreeNode(12);
        tree.root.right.right = new TreeNode(18);
        tree.root.left.left.left = new TreeNode(1);
        tree.root.left.left.right = new TreeNode(4);
        tree.root.left.right.left = new TreeNode(6);
        tree.root.left.right.right = new TreeNode(8);
        tree.root.right.left.left = new TreeNode(11);
        tree.root.right.left.right = new TreeNode(13);
        tree.root.right.right.left = new TreeNode(17);
        tree.root.right.right.right = new TreeNode(20);

        tree.root.color = 0;

        System.out.println("Inorder traversal of the given tree");
        tree.inorder();

        System.out.println();
        System.out.println("Inorder traversal of the modified tree");
        tree.insert(9);
        tree.inorder();

    }

    public void inorder() {
        inorder(root);
    }

    public void inorder(TreeNode node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }

    public void insert(int data) {
        root = insert(root, data);
        root.color = 0;
    }

    public TreeNode insert(TreeNode node, int data) {
        if (node == null) {
            return new TreeNode(data);
        }

        if (data < node.data) {
            node.left = insert(node.left, data);
        } else if (data > node.data) {
            node.right = insert(node.right, data);
        } else {
            return node;
        }

        if (node.right != null && node.right.color == 1 && (node.left == null || node.left.color == 0)) {
            node = leftRotate(node);
        }

        if (node.left != null && node.left.color == 1 && node.left.left != null && node.left.left.color == 1) {
            node = rightRotate(node);
        }

        if (node.left != null && node.left.color == 1 && node.right != null && node.right.color == 1) {
            flipColors(node);
        }

        return node;
    }

    public TreeNode leftRotate(TreeNode node) {
        TreeNode x = node.right;
        node.right = x.left;
        x.left = node;
        x.color = node.color;
        node.color = 1;
        return x;
    }

    public TreeNode rightRotate(TreeNode node) {
        TreeNode x = node.left;
        node.left = x.right;
        x.right = node;
        x.color = node.color;
        node.color = 1;
        return x;
    }

    public void flipColors(TreeNode node) {
        node.color = 1;
        node.left.color = 0;
        node.right.color = 0;
    }


}
