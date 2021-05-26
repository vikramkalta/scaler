public class NumberOfPrimes {
    public static void main(String args[]) {}
    public static int winner(int A, int B) {
        if (B == 1) {
            return 2;
        }
        if (A % 2 == 0) {
            return 2;
        } else {
            return 1;
        }
    }
}
