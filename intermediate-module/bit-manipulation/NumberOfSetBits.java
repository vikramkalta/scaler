public class NumberOfSetBits {
    public static void main(String args[]) {
        System.out.println("count --> " + getTotalSetBits(3));
    }

    public static int getTotalSetBits(int A) {
        int count = 0;
        for (int i = 1; i <= A; i++) {
            int countOfSetBits = getCountOfSetBits(i);
            count = count + countOfSetBits;
        }
        count = count % 1000000007;
        return count;
    }

    public static int getCountOfSetBits(int a) {
        int count = 0;
        while (a > 0) {
            if ((int)(a&1)==1) {
                count++;
            }
            a >>= 1;
        }
        return count;
    }
}
