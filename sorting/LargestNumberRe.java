import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class LargestNumberRe {
    public static void main(String args[]) {
        int[] arr = { 3, 30, 34, 5, 9 };
        // int[] arr = {980, 674, 250, 359, 98, 969, 143, 379, 363, 106, 838, 923, 969, 880, 997, 664, 152, 329, 975, 377, 995, 943, 369, 515, 722, 302, 496, 124, 692, 993, 341, 785, 400, 113, 302, 563, 121, 230, 358, 911, 437, 438, 494, 599, 168, 866, 689, 444, 684, 365, 470, 176, 910, 204, 324, 657, 161, 884, 623, 814, 231, 694, 399, 126, 426 };
        // int[] arr = {8, 89};
        // int[] arr = {9, 99, 999, 9999, 9998};
        // int[] arr = {0, 0, 0, 0, 0};
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            A.add(arr[i]);
        }
        System.out.println(largestNumber(A));
    }

    private class LargerNumberComparator implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            String order1 = a + b;
            String order2 = b+a;
            return order2.compareTo(order1);
        }
    }

    public static String largestNumber(ArrayList<Integer> A) {
        int len = A.size();

        String[] AStr = new String[len];

        for (int i = 0; i < len; i++) {
            int curr = A.get(i);
            String currStr = String.valueOf(curr);
            AStr[i]= currStr;
        }

        // Arrays.sort(AStr, new LargerNumberComparator());

        if (AStr[0].equals("0")) {
            return "0";
        }
        String largestNumberStr = new String();
        for (String numAsStr : AStr) {
            largestNumberStr += numAsStr;
        }
        return largestNumberStr;





        // int max = 0;
        // int maxIndex = 0;

        // for (int i = 0; i < len; i++) {
        //     String currStrI = AStr.get(i);
        //     char chI = currStrI.charAt(0);
        //     int currI = Character.getNumericValue(chI);
        //     max = currI;
        //     maxIndex = i;

        //     for (int j = i; j < len; j++) {
        //         String currStrJ = AStr.get(j);
        //         char chJ = currStrJ.charAt(0);
        //         int currJ = Character.getNumericValue(chJ);

        //         if (max < currJ) {
        //             max = currJ;
        //             maxIndex = j;
        //         }

        //         if (max == currJ) {
        //             int currInt = Integer.parseInt(currStrJ);
        //             int prevMaxInt = Integer.parseInt(AStr.get(maxIndex));

        //             if (currInt > prevMaxInt) {
        //                 maxIndex = j;
        //             }
        //         }
        //     }

        //     String temp = AStr.get(i);
        //     AStr.set(i, AStr.get(maxIndex));
        //     AStr.set(maxIndex, temp);
        // }

        // StringBuilder sb = new StringBuilder();
        // boolean isZero = true;
        // String prevStr = new String();

        // for (int i = 0; i < len; i++) {
        //     String curr = AStr.get(i);

        //     if (!curr.equals("0")) {
        //         isZero = false;
        //     }

        //     if (i == 0) {
        //         if (!isZero) {
        //             prevStr = curr;
        //             sb.append(curr);
        //         }
        //     }
            
        //     if (i != 0) {
        //         // String prevStr = AStr.get(i-1);
        //         String str1 = prevStr + curr;
        //         int int1 = Integer.parseInt(str1);
        //         String str2 = curr + prevStr;
        //         int int2 = Integer.parseInt(str2);

        //         if (int1 < int2) {
        //             int prevStrLen = prevStr.length();
        //             int sbLen = sb.length();
        //             sb.delete(sbLen - prevStrLen, sbLen);
        //             sb.append(curr);
        //             sb.append(prevStr);
        //         } else {
        //             if (!isZero) {
        //                 prevStr = curr;
        //                 sb.append(curr);
        //             }
        //         }
        //     }

        //     if (isZero && i == len - 1) {
        //         sb.append(curr);
        //     }
        // }
        // return new String(sb);
    }
}
