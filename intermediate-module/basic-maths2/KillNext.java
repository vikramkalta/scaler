public class KillNext {
    public static void main(String args[]) {
        System.out.println(killNext(100));
    }

    public static int killNext(int A) {
        int powerOf2 = getPowerOf2(A);
        int expOf2 = getExpOf2(powerOf2);
        int t = A - expOf2;
        t = 2*t + 1;
        return t;
    }

    public static int getPowerOf2(int A) {
        int count = 0;
        while (A > 1) {
            A >>= 1;
            count++;
        }
        return count;
    }
    private static int getExpOf2(int A) {
        return 1 << A;
    }
}
