import java.util.ArrayList;
import java.util.List;

public class FindMissingNumbers {
    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println("Missing numbers are: " + missingNumbers(arr));
    }

    private static List<Integer> missingNumbers(int[] arr) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            int curr = Math.abs(arr[i]);
            arr[curr - 1] = -(Math.abs(arr[curr - 1]));
        }
        for (int i = 0; i < arr.length; i++)    if(arr[i]>0) ans.add(i+1) ;
        return ans ;
    }
}
