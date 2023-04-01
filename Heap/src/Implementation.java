import java.util.Arrays;

class Heap {
    int[] arr;
    int size;
    int capacity;

    public Heap(int[] arr) {
        this.arr = arr;
        this.size = arr.length;
        this.capacity = arr.length;
    }

    private void heapify(int i) {
        int l = left(i);
        int r = right(i);
        int largest = i;
        if (l < size && arr[l] > arr[i]) {
            largest = l;
        }
        else
            largest = i;
        if (r < size && arr[r] > arr[largest]) {
            largest = r;
        }
        if (largest != i) {
            swap(i, largest);
            heapify(largest);
        }
    }

    private void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int left(int i) {
        return 2 * i + 1;
    }

    private int right(int i) {
        return 2 * i + 2;
    }

    public void heapSort(int[] arr) {
        Heap heap = new Heap(arr);
        heap.buildMaxHeap(arr);
        for (int i = arr.length - 1; i >= 0; i--) {
            swap(0, i);
            size--;
            heapify(0);
        }
    }

    public void buildMaxHeap(int[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            heapify(i);
        }
    }
}

public class Implementation {

    public static void main(String[] args) {
        int[] arr = {40,10,30,50,60,15};
        Heap heap = new Heap(arr);

        System.out.println("Before building Max Heap: ");
        System.out.println(Arrays.toString(arr));
        System.out.println();
        System.out.println("After building Max Heap: ");
        heap.buildMaxHeap(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println();

        System.out.println("Before Sorting: ");
        System.out.println(Arrays.toString(arr));
        System.out.println();
        heap.heapSort(arr);
        System.out.println("After Sorting: ");
        System.out.println(Arrays.toString(arr));
    }
}
