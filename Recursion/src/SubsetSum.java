import java.util.ArrayList;
import java.util.Collections;

public class SubsetSum {
    public static void main(String[] args) {
        int[] arr = {2, 3};
        ArrayList<Integer> ans=subsetSum(arr);
        Collections.sort(ans);
        System.out.println(ans);
    }
    private static ArrayList<Integer> subsetSum(int[] arr){
        ArrayList<Integer> ans=new ArrayList<>() ;
        helper(0,0,ans,arr) ;
        return ans;
    }
    private static void helper(int idx,int sum,ArrayList<Integer> ans,int[] arr){
        if(idx==arr.length)
        {
            ans.add(sum) ;
            return;
        }
        helper(idx+1,sum+arr[idx],ans,arr);
        helper(idx+1,sum,ans,arr);
    }
}
