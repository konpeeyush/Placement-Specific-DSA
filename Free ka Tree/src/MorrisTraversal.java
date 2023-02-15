import java.util.ArrayList;

public class MorrisTraversal {
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
        System.out.println("Morris Traversal for given tree is: " + morrisInorder(root));
    }

    private static ArrayList<Integer> morrisInorder(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        TreeNode curr = root;
        while (curr != null) {
//            If left is null, add curr and move to right
            if (curr.left == null) {
                ans.add(curr.data);
                curr=curr.right;
            }
            else{
                TreeNode prev=curr.left ;
//              Figuring out the last node in rightMost in left subtree and making a thread to curr
                while(prev.right!=null && prev.right!=curr) prev=prev.right;

//                Make a thread to curr
                if(prev.right==null){
                    prev.right=curr;
                    curr=curr.left;
                }
//                Break the thread and move to right
                else{
                    prev.right=null;
                    ans.add(curr.data);
                    curr=curr.right;
                }
            }
        }
        return ans;
    }
}
