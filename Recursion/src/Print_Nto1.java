import java.util.Scanner;

public class Print_Nto1 {
    public static void main(String[] args) {
        System.out.println("Enter a number");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        printNto1(n);
    }

    private static void printNto1(int n) {
        if (n <= 1) {
            System.out.println(n);
            return;
        }
        System.out.println(n);
        printNto1(n - 1);

    }
}
