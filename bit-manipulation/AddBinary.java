public class AddBinary {
    public static void main(String args[]) {
        // System.out.println(getBinarySum("10001100010111000101100010100110001001101010000010011010",
        // "101111000100100100111110010010101110101001100100101001111010011000000110"));
        // System.out.println("a+b " +
        // getBinarySumString("10001100010111000101100010100110001001101010000010011010",
        // "101111000100100100111110010010101110101001100100101001111010011000000110"));
        // System.out.println(getBinarySum("1010110111001101101000", "1000011011000000111100110"));
        // System.out.println(getBinarySum("001", "110"));
        // System.out.println(getBinarySum("1110000000010110111010100100111", "101001"));
        // String result = getBinarySum("1110000000010110111010100100111", "101001");
        String result = getBinarySum("1", "1");
        String reverseResult = new String();
        int len = result.length();
        for (int i = len - 1; i >= 0; i--) {
            reverseResult += result.charAt(i);
        }
        System.out.println("reverseResult " + reverseResult);
    }

    public static String getBinarySum(String A, String B) {
        int aLen = A.length();
        int bLen = B.length();

        int len = aLen > bLen ? aLen : bLen;

        if (aLen > bLen) {
            int diff = aLen - bLen;
            String preStr = new String();
            for (int i = 0; i < diff; i++) {
                preStr += "0";
            }
            B = preStr + B;
        }
        if (bLen > aLen) {
            int diff = bLen - aLen;
            String preStr = new String();
            for (int i = 0; i < diff; i++) {
                preStr += "0";
            }
            A = preStr + A;
        }

        String resultStr = new String();
        int remainder = 0;
        for (int i = len - 1; i >= 0; i--) {
            int aChar = Character.getNumericValue(A.charAt(i));
            int bChar = Character.getNumericValue(B.charAt(i));

            int cChar = aChar + bChar;

            if (remainder > 0) {
                cChar += remainder;
            }

            String binaryCChar = getBinary(cChar);
            String lastChar = binaryCChar.substring(binaryCChar.length() - 1);

            resultStr += lastChar;

            // If cChar is 2 or 3 -> For 1, there will be no propagator
            if (cChar == 2 || cChar == 3) {
                remainder = 1;
            } else {
                remainder = 0;
            }
        }
        if (remainder > 0) {
            return resultStr += remainder;
        }
        return resultStr;
    }

    public static String getBinary(int a) {
        if (a == 0) {
            return "0";
        }
        String s = new String();
        while (a > 0) {
            if ((int) (a & 1) == 1) {
                s += "1";
            } else {
                s += "0";
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
