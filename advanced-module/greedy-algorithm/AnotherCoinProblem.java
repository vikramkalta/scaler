public class AnotherCoinProblem {
    public static void main(String args[]) {
        // System.out.println(solve(47));
        System.out.println(solve(9));
    }
    public static int solve(int A) {
        int totalCoins = 0;
        
        int totalValue = 0;

        int originalA = A;
        while (totalValue < originalA) {
            int currValue = 1;
            while( currValue <= A ) {
                currValue *= 5;
            }
            if (currValue > A) {
                currValue /= 5;
            }
            totalValue += currValue;
            A -= currValue;
            totalCoins++;
        }

        return totalCoins;
    }
}
