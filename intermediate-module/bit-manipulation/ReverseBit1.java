public class ReverseBit1 {
    public static void main(String args[]) {
        System.out.println("Testing our reverseBits() method by reversing ints in Java");
        String number = "000000000000000000000000000001";
        String expected = "10000000000000000000000000000000";

        int binary = Integer.parseInt(number, 2);
        int actual = reverseBits(binary);

        System.out.println("original number : " + number);
        System.out.println("reversed number : " + Integer.toBinaryString(actual));
        System.out.println(expected.equals(Integer.toBinaryString(actual)));
    }

    /**
     * Java method to reverse bits of specified integer
     */
    public static int reverseBits(int number) {
        int sizeOfInt= 32;
        int reverse = 0;
        for (int position = sizeOfInt - 1; position > 0; position--) {
            reverse += ((number & 1) << position);
            number >>= 1;
        }
        return reverse;
    }
}
