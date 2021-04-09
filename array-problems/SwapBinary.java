import java.util.ArrayList;

public class SwapBinary {
    public static void main(String args[]) {
        // String A = "1010110011";
        // String A = "111011101";
        String A = "110011";
        // String A = "1101001100101110";
        System.out.println(longestConsecutive(A));
    }

    public static int longestConsecutive(String A) {
        int len = A.length();

        ArrayList<Integer> arr = new ArrayList<>();

        int count1 = 0;
        int total1 = 0;
        for (int i = 0; i < len; i++) {
            Character ch = A.charAt(i);
            if (ch == '1') {
                total1++;
                count1++;
            }
            if (ch == '0') {
                if (count1 > 0) {
                    arr.add(count1);
                }
                count1 = 0;
                arr.add(0);
            }
        }

        if (count1 > 0) {
            arr.add(count1);
        }

        // System.out.println(total1);
        // System.out.println(arr);

        int arrLen = arr.size();

        int maxLen = arr.get(0);

        for (int i = arrLen - 1; i >= 0; i--) {
            int curr = arr.get(i);

            if (curr != 0) {
                if (maxLen <= curr) {
                    maxLen = curr;
                }
            }

            if (curr == 0) {
                int next = i != 0 ? arr.get(i - 1) : 0;
                int prev = i != arrLen - 1 ? arr.get(i + 1) : 0;
                int sum = 0;
                // if (prev != 0) {
                //     sum = prev + 1;
                //     if (sum > total1) {
                //         sum = prev;
                //     }
                //     if ()
                // }

                // if (prev != 0 && next != 0) {
                    if (prev != 0 || next != 0) {
                    sum = prev + next + 1;
                    if (sum > total1) {
                        sum = prev + next;
                    }

                    if (sum > maxLen) {
                        maxLen = sum;
                    }
                }
            }
        }
        // System.out.println(arr);
        return maxLen;
    }
}
