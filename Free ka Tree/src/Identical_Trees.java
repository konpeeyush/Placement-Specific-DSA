public class Identical_Trees {
    public static void main(String[] args) {
        //        Tree Structure used throughout
//             1
//          /     \
//        2        3
//       /  \     /  \
//      4    5   6    7
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);
        p.left.left = new TreeNode(4);
        p.left.right = new TreeNode(5);
        p.right.left = new TreeNode(6);
        p.right.right = new TreeNode(7);

        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(2);
        q.right = new TreeNode(3);
        q.left.left = new TreeNode(4);
        q.left.right = new TreeNode(5);
        q.right.left = new TreeNode(6);
        q.right.right = new TreeNode(7);

        System.out.println("Are trees identical? "+(identical(p,q)?"Yes":"No"));
    }
    private static boolean identical(TreeNode p, TreeNode q){
        if(p==null || q==null)
            return p==q ;

        return (p.data == q.data) && identical(p.left,q.left) && identical(p.right,q.right) ;
    }
    //For mirror tree send left with right
}
