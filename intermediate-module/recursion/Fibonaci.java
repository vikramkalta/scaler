public class Fibonaci {
    public static void main(String args[]) {
        System.out.println(fibonacci(3));
    }

    public static int fibonacci(int A) {
        if (A==0){
            return 0;
        }
        if (A <= 2) {
            return 1;
        }
        int a = A - 1;
        int b = A - 2;
        return 0 + fibonacci(a) + fibonacci(b);
    }
}
