//import java.util.Arrays;
//import java.util.Scanner;
//
//public class Array_Operations {
//    public static void main(String[] args) {
//        System.out.println("Enter size of array:");
//        Scanner sc = new Scanner(System.in);
//        int size = sc.nextInt();
//
//        int[] arr = new int[size];
//
//        System.out.println("Enter elements: ");
//        for (int i = 0; i < size; i++)
//            arr[i] = sc.nextInt();
//
//
//        System.out.println("Array before insertion: " + Arrays.toString(arr));
//
//        System.out.println("Enter the index of the element to be inserted: ");
//        int index = sc.nextInt();
//
//        System.out.println("Enter element to be inserted: ");
//        int element = sc.nextInt();
//
//        int n = insert(index, arr, arr.length * 2 + 10, element);
//        System.out.println("Array after insertion: " + Arrays.toString(arr));
//    }
//
//    private static int insert(int index, int[] arr, int capacity, int element) {
//        if (index >= capacity)
//            return index;
//
//        arr[index] = element;
//
//        return (index + 1);
//    }
//
//    private static int search(int[] arr, int x) {
//        int N = arr.length;
//        for (int i = 0; i < N; i++) {
//            if (arr[i] == x)
//                return i;
//        }
//        return -1;
//    }
//
//    private static int deleteElement(int arr[], int n, int key) {
//        int pos = search(arr, n, key);
//
//        if (pos == -1) {
//            System.out.println("Element not found");
//            return n;
//        }
//
//        int i;
//        for (i = pos; i < n - 1; i++)
//            arr[i] = arr[i + 1];
//
//        return n - 1;
//    }
//
//}
