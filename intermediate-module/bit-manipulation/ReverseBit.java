public class ReverseBit {
    public static int reverseBits(int A) {
        int rev = 0;

        // traversing bits of 'n'
        // from the right
        while(A > 0) {
            // bitwise left shift
            // 'rev' by 1
            rev <<= 1;
            // if current bit is '1'
            if ((int)(A&1) == 1) {
                rev ^= 1;
            }
            // bitwise right shift
            A >>= 1;
        }
        return rev;
   }
    public static void main(String args[]) {
        int n = 3;
        System.out.println(reverseBits(n));
    }
}
// 1 0 1 1
// rev = 0 <<= 0
// rev = 0 ^ 1 = 1
// A >>=1 -> 0 1 0 1 -> 5
// rev = 1 -> 0 0 0 1 <<=1 -> 0 0 1 0 -> 2
// A&1 = 0 1 0 1 & 0 0 0 1 -> 0 0 0 1
// rev = 0 0 1 0 ^ 0 0 0 1 -> 0 0 1 1 -> 3
// A >>=1 -> 0 0 1 0 -> 2
// rev = 0 0 1 1 <<= 1 -> 0 1 1 0 -> 6
// A&1 = 1 0 & 0 1 -> 0 0
// A >>=1 -> 0 0 0 1 -> 1
// rev = 1 1 0 0 -> 12
// A&1 0 1 & 0 1 -> 1
// rev = 1 1 0 0 ^= 0 0 0 1 -> 1 1 0 1 = 13


// 11 / 2 = 5 = 1
// 5 / 2 = 2 = 1
// 2 / 2 = 1 = 0
// 1 / 2 = 1 = 1
// 1 0 1 1
// reverse: 1 1 0 1
// <<1 = 0 1 1 0 -> 6
// 0 1 1 0 ^ 0 0 0 1 -> 0 1 1 1 -> 7
// >>1 = 0 1 0 1
// >>2 = 0 0 1 0
// 2^0+2^1+2^3
// 1+2+8
// 11
// 0 1 1
// 2^2 + 2^1
// 10 / 2 = 5 = 0
// 5 / 2 = 2 = 1
// 2 / 2 = 1 = 0
// 1 / 2 = 0 = 1
// 1 0 1 0
// 2^3+2^1
// 8+2