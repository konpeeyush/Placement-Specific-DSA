import java.util.ArrayList;
import java.util.Arrays;

public class Subsets {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> output = new ArrayList<>();
        subsets(arr, ans, output, 0);
        System.out.println("All possibles subsets of " + Arrays.toString(arr) + " are " + ans);
        System.out.println("Number of subsets: "+numberOfSubsets(arr,ans,output,0));
    }

    private static void subsets(int[] arr, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> output, int index) {

        if (index >= arr.length) {
            ans.add(new ArrayList<>(output));
            return;
        }

//        Include
        int element=arr[index] ;
        output.add(element) ;
        subsets(arr,ans,output,index+1);

//        Exclude
        output.remove(output.size()-1) ;
        subsets(arr,ans,output,index+1);
    }
    private static int numberOfSubsets(int[] arr, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> output, int index){
        if(index>=arr.length){
            return 1 ;
        }
        int left=numberOfSubsets(arr,ans,output,index+1) ;
        int right=numberOfSubsets(arr,ans,output,index+1) ;
        return left+right ;
    }
}
