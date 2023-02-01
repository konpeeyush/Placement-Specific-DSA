import java.util.ArrayList;

public class Root_to_Leaf_Path {
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
        System.out.println("Paths to Leaf Nodes are: "+ Paths(root)) ;
    }
    public static ArrayList<ArrayList<Integer>> Paths(TreeNode root){
        // Code here
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>() ;
        if(root==null) return ans ;
        ArrayList<Integer> temp=new ArrayList<>() ;
        helper(root,ans,temp) ;
        return ans ;
    }
    private static void helper(TreeNode root,ArrayList<ArrayList<Integer>> ans,ArrayList<Integer> temp){
        if(root==null) return ;

        temp.add(root.data) ;
        //Conditions for a leaf node
        if(root.left==null && root.right==null)
        {
            ans.add(new ArrayList<>(temp)) ;
            temp.remove(temp.size()-1) ;
            return ;
        }
        helper(root.left,ans,temp) ;
        helper(root.right,ans,temp) ;
        temp.remove(temp.size()-1) ;
    }
}
