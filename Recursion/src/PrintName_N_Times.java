import java.util.Scanner;

public class PrintName_N_Times {
    public static void main(String[] args) {
        System.out.println("Enter your name:");
        Scanner sc = new Scanner(System.in);
        String name = sc.next();
        System.out.println("Enter how many times you want to print your name:");
        int n = sc.nextInt();
        printN(name, n);
    }

    private static void printN(String name, int n) {
        if (n <= 0) return;
        System.out.println(name);
        printN(name, n - 1);
    }
}
