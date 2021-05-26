public class ReverseBit2 {
    public static void main(String args[]) {
        int n = 3;
        long result = reverseBits(n);
        System.out.println("result: " + result);
    }

    public static long reverseBits(int n) {
        // long binary = Integer.parseInt(n, 2);
        int bits = 32;
        
        long rev = 0;

        for (int i = 0; i < bits; i++) {
            rev <<= 1;

            if ((int)(n&1) == 1) {
                rev ^= 1;
            }

            n >>= 1;
        }
        return rev;
    }
}
