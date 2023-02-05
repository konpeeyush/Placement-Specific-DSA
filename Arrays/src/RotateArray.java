public class RotateArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        rotateArray(arr, 3);
    }

    private static void rotateArray(int[] arr, int k) {
        int n = arr.length;
        k=k%n ;
        reverse(arr,0,n-k-1);
        reverse(arr,n-k,n-1);
        reverse(arr,0,n-1);
    }

    private static void reverse(int[] arr, int low, int high) {
        while (low < high) {
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            low++ ;
            high--;
        }
    }
}
