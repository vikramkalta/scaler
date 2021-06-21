import java.util.ArrayList;

public class FindNonRepeating {
    public static void main(String args[]) {
        int[] arr = { 3, 3, 3, 4, 4, 4, 5 };
        // int[] arr = { 3, 3, 3, 5, 5, 5, 6, 6, 6, 7 };
        // int[] arr = { 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7 };
        // int[] arr = { 0, 4, 7, 9 };
        // int[] arr = { 1, 2, 4, 3, 3, 2, 2, 3, 1, 1 };
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++)
            A.add(arr[i]);
        System.out.println(solve(A));
        int x = 1;
        x = 2 << x;
        // System.out.println(x);
    }

    public static int solve(ArrayList<Integer> A) {
        int len = A.size();
        int bitLen = 32;
        StringBuilder binaryRep = new StringBuilder();
        for (int i = 0; i < bitLen; i++) {
            int sum = 0;
            for (int j = 0; j < len; j++) {
                int curr = A.get(j);
                if (((curr >> i) & 1) == 1) {
                    sum++;
                }
            }
            if (sum % 3 == 0) {
                binaryRep.append("0");
            } else {
                binaryRep.append("1");
            }
        }

        int ans = 0;
        for (int i = 0; i < bitLen; i++) {
            if (binaryRep.charAt(i) == '1') {
                // int powOf2 = 1 << (bitLen - 1 - i);
                int powOf2 = 1 << i;
                ans += powOf2;
            }
        }
        return ans;
    }
}
