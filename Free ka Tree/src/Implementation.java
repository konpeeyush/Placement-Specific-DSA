class TreeNode {
    int data ;
    TreeNode left ;
    TreeNode right ;
    public TreeNode(int data){
        this.data =data ;
    }
}
public class Implementation {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(1) ;
        root.left= new TreeNode(2) ;
        root.right=new TreeNode(3) ;
    }
}
