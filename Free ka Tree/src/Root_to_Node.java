import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Root_to_Node {
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
        System.out.println("Path to Node 6 is: "+ (getPath(root, 6)));
    }

    private static List<Integer> getPath(TreeNode root, int targetNode) {
        List<Integer> ans = new ArrayList<>();
        helper(root, targetNode, ans);
        return ans;
    }

    private static boolean helper(TreeNode node, int targetNode, List<Integer> ans) {
        if (node == null) return false;

        ans.add(node.data) ;
        if(node.data==targetNode)
            return true ;
        boolean isPresentInLeft=helper(node.left,targetNode,ans) ;
        boolean isPresentInRight=helper(node.right,targetNode,ans) ;

        if(isPresentInLeft || isPresentInRight)
            return true ;
        else{
            ans.remove(ans.size()-1) ;
            return false ;
        }
    }
}
