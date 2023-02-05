import java.util.ArrayList;
import java.util.Arrays;

public class DuplicateNumber {
    public static void main(String[] args) {
        int arr[]={4,3,2,7,8,2,3,1};
        System.out.println("Duplicate elements in "+ Arrays.toString(arr)+" are "+findDuplicates(arr));
    }
    private static ArrayList<Integer> findDuplicates(int[] arr){
        ArrayList<Integer> ans=new ArrayList<>() ;
        for (int i = 0; i < arr.length;i++){
            int curr=Math.abs(arr[i]) ;
            if(arr[curr-1]<0)
                ans.add(Math.abs(arr[i])) ;
            else
                arr[curr-1]=-1*Math.abs(arr[curr-1]) ;
        }
        return ans ;
    }
}
