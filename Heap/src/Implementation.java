class Heap{
    int[] arr;
    int size;
    int capacity;
    public Heap(int[] arr) {
        this.arr = arr;
        this.size = arr.length;
        this.capacity = arr.length;
    }
    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public void insert(int data) {
        if (size == capacity) {
            System.out.println("Heap is full");
            return;
        }
        size++;
        arr[size - 1] = data;
        for (int i = size - 1; i != 0 && arr[parent(i)] > arr[i]; ) {
            swap(i, parent(i));
            i = parent(i);
        }
    }
    public void delete() {
        if (size == 0) {
            System.out.println("Heap is empty");
            return;
        }
        swap(0, size - 1);
        size--;
        heapify(0);
    }
    private void heapify(int i) {
        int l = left(i);
        int r = right(i);
        int smallest = i;
        if (l < size && arr[l] < arr[i]) {
            smallest = l;
        }
        if (r < size && arr[r] < arr[smallest]) {
            smallest = r;
        }
        if (smallest != i) {
            swap(i, smallest);
            heapify(smallest);
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
}
public class Implementation {

    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        Heap heap = new Heap(arr);
        heap.print();
        heap.insert(6);
        heap.print();
        heap.delete();
        heap.print();
    }
}
