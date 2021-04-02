public class CountSetBits {
    public static void main(String args[]) {
        int n = 3;
        int count = countSetBits(n);
        System.out.println("count :" + count);
    }

    public static int countSetBits(int a) {
        // long rev = 0;
        int count = 0;
        while (a > 0) {
            // rev <<= 1;
            if ((int)(a&1)==1) {
                count++;
            }
            a >>= 1;
        }
        return count;
    }
}