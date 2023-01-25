import java.util.Scanner;

public class Linear_Search {
    public static void main(String[] args) {
        System.out.println("Enter size of array:");
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();

        int[] arr = new int[size];

        System.out.println("Enter elements: ");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Enter element to be searched:");
        int target=sc.nextInt() ;

        int search=search(arr,target) ;
        if(search==-1)
            System.out.println("Element not present");
        else
            System.out.println("Element present at index: "+search);

    }

    private static int search(int[] arr, int x) {
        int N = arr.length;
        for (int i = 0; i < N; i++) {
            if (arr[i] == x)
                return i;
        }
        return -1;
    }
}
