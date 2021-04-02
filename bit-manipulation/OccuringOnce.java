import java.util.ArrayList;
import java.util.List;

public class OccuringOnce {
    public static void main (String args[]) {
        List<Integer> A = new ArrayList<Integer>();
        A.add(1);
        A.add(1);
        A.add(1);
        A.add(2);
        A.add(2);
        A.add(2);
        A.add(3);
        A.add(3);
        A.add(3);
        A.add(4);
        System.out.println(singleNumber(A));
    }

    public static int singleNumber(final List<Integer> A) {
        int len = A.size();

        ArrayList<String> binaryArr = new ArrayList<String>();

        int maxLen = 0;
        for (int i = 0; i < len; i++) {
            String binary = getBinary(A.get(i));
            if (maxLen < binary.length()) {
                maxLen = binary.length();
            }
            binaryArr.add(binary);
        }

        for (int i = 0; i < len; i++) {
            int binaryStrLen = binaryArr.get(i).length();

            String preStr = new String();
            if (binaryStrLen < maxLen) {
                int diff = maxLen - binaryStrLen;
                for (int j = 0; j < diff; j++) {
                    preStr += "0";
                }
                String newStr = preStr + binaryArr.get(i);
                binaryArr.set(i, newStr);
            }
        }

        ArrayList<Integer> sumOfBits = new ArrayList<>();
        for (int i = 0; i < maxLen; i++) {
            sumOfBits.add(0);
        }
        // int sum = 0;
        for (int i = 0; i < len; i++) {
            for (int j = maxLen - 1; j >= 0; j--) {
                int sumOfBit = sumOfBits.get(j);
                int bit = Character.getNumericValue(binaryArr.get(i).charAt(j));
                sumOfBit = sumOfBit + bit;
                sumOfBits.set(j, sumOfBit);
            }
        }

        String resultStr = new String();
        for (int i = 0; i < sumOfBits.size(); i++) {
            int result = sumOfBits.get(i) % 3;
            resultStr += result;
        }
        // printAllInt(sumOfBits);
        // System.out.println(resultStr);
        // printAllStr(binaryArr);
        int result = Integer.parseInt(resultStr, 2);
        return result;
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

    public static void printAllStr(ArrayList<String> a) {
        for (int i = 0; i < a.size(); i++) {
            System.out.println("binary string at " + i + " is " + a.get(i));
        }
    }
    public static void printAllInt(ArrayList<Integer> a) {
        for (int i = 0; i < a.size(); i++) {
            System.out.println("binary string at " + i + " is " + a.get(i));
        }
    }
}

// a: [2,2,2,4]
// 0 1 0
// 0 1 0
// 0 1 0
// 1 0 0
// -------------
// 0 0 0 0 0%3=0
// 1 1 1 0 3%3=0
// 0 0 0 1 1%3=1
// -------------
// 1 1 1 0 0 0 1 -> 4%3 -> 1
// 0 0 0 1 1 1 1 -> 4%3 -> 1
// -------------
// 0 0 1
// 0 0 1
// 0 0 1
// 0 1 0
// 0 1 0
// 0 1 0
// 0 1 1
// 0 1 1
// 0 1 1
// 1 0 0
// -------------
// 1 1 1 0 0 0 1 1 1 0 -> 6 % 3 = 0
// 0 0 0 1 1 1 1 1 1 0 -> 6 % 3 = 0
// 0 0 0 0 0 0 0 0 0 1 -> 1 % 3 = 1
// -------------