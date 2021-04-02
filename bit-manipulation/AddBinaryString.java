import java.math.BigInteger;

public class AddBinaryString {
    public static void main(String args[]) {
        // System.out.println(getBinarySumString("10001100010111000101100010100110001001101010000010011010", "101111000100100100111110010010101110101001100100101001111010011000000110"));
        // System.out.println("a+b " + getBinarySumString("10001100010111000101100010100110001001101010000010011010", "101111000100100100111110010010101110101001100100101001111010011000000110"));
        // System.out.println("a+b " + getBinarySumString("1010110111001101101000", "1000011011000000111100110"));
        // System.out.println(getBinarySumString("001","110"));
        // System.out.println(calculateExponent(72, 1));
        System.out.println(calcExponent(62, 1));
    }
    
    public static String getBinarySumString(String A, String B) {
        BigInteger _a = new BigInteger(A, 2);
        BigInteger _b = new BigInteger(B, 2);
        long a = getDecimal(A);
        long b = getDecimal(B);
        long c = a + b;

        String result = getBinary(c);
        long test =getDecimal(result);
        // System.out.println("result: " + result);
        return result;
    }

    public static long getDecimal(String a) {
        int len = a.length();
        long sum = 0;
        int init = 0;
        for (int i = len -1; i >= 0; i--) {
            int curr = Character.getNumericValue(a.charAt(i));

            if ((int)(curr&1) == 1) {
                sum = sum + calculateExponent(init, 1);
            }
            init++;
        }
        return sum;
        // long result = 0;
        // for (int i = 0; i < len; i++) {
        //     long num1 = Character.getNumericValue(a.charAt(i));
        //     result+=num1*(long)Math.pow(2, len - 1 - i);
        // }
        // return result;
    }

    public static long calculateExponent(int a, long result) {
        while(a > 0) {
            result *= 2;
            a--;
        }
        return result;
    }

    public static long calcExponent(int a, long result) {
        return result << a;
        // while(a > 0) {
        //     result *= 2;
        //     a--;
        // }
        // return result;
    }

    public static String getBinary(long a) {
        String s = new String();
        while (a > 0) {
            if ((int)(a&1) == 1) {
                s+="1";
            }else {
                s+="0";
            }
            a = a / 2;
        }
        String newS = new String();
        int strLen = s.length();
        for (int i = strLen - 1; i >= 0; i--) {
            Character ch = s.charAt(i);
            newS += ch;
        }
        return newS;
    }
}