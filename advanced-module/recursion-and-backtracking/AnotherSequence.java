public class AnotherSequence {
    public static void main(String args[]) {
        // System.out.println(solve(3));
        System.out.println(solve(4));
    }

    public static int solve(int A) {
        int result = getAthNumber(A);
        return result;
    }

    private static int getAthNumber(int A) {
        if (A < 3) {
            if (A==0){
                return 1;
            }else if (A==1){
                return 1;
            }else{
                return 2;
            }
        }
        int x = getAthNumber(A - 1);
        int y = getAthNumber(A - 2);
        int z = getAthNumber(A - 3);
        return x + y + z + A;
    }
}
