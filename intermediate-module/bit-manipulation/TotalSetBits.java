public class TotalSetBits {
    public static void main(String args[]) {
        // System.out.println("x : " + solve(10));
        // System.out.println(getLog(8));
        System.out.println(solve(4));
    }
    public static int solve(int A) {
        int logA = getLog(A);
        int count = 0;
        // 0 0 0
        // 0 0 1
        // 0 1 0
        // 0 1 1
        // 1 0 0
        // --------
        // 1 0 1

        int rowCount = A + 1;
        int range = calcExponent(logA, 1);
        for (int i = 0; i < logA; i++) {
            int correctedI = i + 1;

            int expValue = calcExponent(correctedI, 1);
            // when first is 2, this means start part of 2 is 0 and rest part is 1;
            // i = 0 => 1 => 2/2=1
            // i = 1 => 2 => 4/2=2
            // i = 2 => 3 => 8/2=4

            int div = range / expValue;
            // int mod = range % rowCount;
            // int countOfOne = div - (mod / expValue);
            // int finalCount = countOfOne * expValue / 2;
            // count += finalCount;

            // int countOfOne = 0;
            // int div = rowCount / expValue;
            // if (div < 1) {
            //     countOfOne = expValue - rowCount;
            // }
            // int mod = rowCount % expValue;
            // if (mod != 0) {
            //     countOfOne = div * expValue / 2;
            //     countOfOne = countOfOne + mod;
            // } else {
            //     countOfOne = div * expValue;
            // }
            // for (int j = 0; j < div; j++) {
            // // countOfOne = countOfOne * expValue;
            // }
            // count += countOfOne;
        }
        return count;
    }

    public static int getLog(int A) {
        int count = 0;
        while (A > 0) {
            count++;
            A >>= 1;
        }
        return count;
    }

    public static int getCountOfSetBits(int a) {
        int count = 0;
        while (a > 0) {
            if ((int) (a & 1) == 1) {
                count++;
            }
            a >>= 1;
        }
        return count;
    }

    public static int calcExponent(int a, int result) {
        return result << a;
    }

        // public static int solve(int A) {
    // int count = 0;
    // for (int i = 1; i <= A; i++) {
    // int countOfSetBits = getCountOfSetBits(i);
    // count += countOfSetBits;
    // }
    // count = count % 1000000007;
    // return count;
    // }

}

// 0 0
// 0 1
// 1 0
// 1 1

// 0 0
// 0 1
// 1 0
// 1 1