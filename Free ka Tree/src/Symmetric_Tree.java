public class Symmetric_Tree {
    public static void main(String[] args) {
        //        Tree Structure used throughout
//             1
//          /     \
//        2        2
//       /  \     /  \
//      4    5   5    4
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(4);
        System.out.println("The tree is symmetric? "+(isSymmetric(root)?"Yes":"No"));
    }
    private static boolean isSymmetric(TreeNode root){
        return root==null || helper(root.left,root.right) ;
    }
    private static boolean helper(TreeNode p,TreeNode q){
        if(p==null || q==null)
            return p==q ;
        return (p.data==q.data) && helper(p.left,q.right) && helper(p.right,q.left) ;
    }
}
