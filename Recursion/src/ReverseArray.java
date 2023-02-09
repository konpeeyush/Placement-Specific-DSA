import java.util.Arrays;

public class ReverseArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
//        reverse(arr, 0, arr.length - 1);
        reverse2(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void reverse(int[] arr, int low, int high) {
        if (low >= high) return;

        swap(low, high, arr);
        reverse(arr, low + 1, high - 1);
    }

    private static void swap(int low, int high, int[] arr) {
        int temp = arr[low];
        arr[low] = arr[high];
        arr[high] = temp;
    }

    private static void reverse2(int[] arr, int low, int high) {
        if (low >= arr.length / 2) return;
        swap(low, arr.length - low - 1, arr);
        reverse(arr, low + 1, high - 1);
    }
}
