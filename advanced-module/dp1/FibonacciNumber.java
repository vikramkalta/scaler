import java.util.ArrayList;
import java.util.Scanner;

public class FibonacciNumber {
    public static void main(String args[]) {
        ArrayList<Integer> A = new ArrayList<>();
        // int n = 6;
        Scanner sc = new Scanner(System.in);  
        int n = sc.nextInt();
        sc.close();
        for (int i = 0; i < n; i++) A.add(-1);
        System.out.println(fib(n, A));
    }

    private static int i = 0;
    public static int fib(int n, ArrayList<Integer> A) {
        // i++;
        // System.out.println("i: " + i);
        if (n <= 2) {
            A.set(n - 1, 1);
            return 1;
        }
        if (A.get(n - 1) != -1) {
            return A.get(n - 1);
        }
        int x = fib(n - 1, A);
        int y = fib(n - 2, A);
        int sum = x + y;
        A.set(n - 1, sum);
        return sum;
    }
}
