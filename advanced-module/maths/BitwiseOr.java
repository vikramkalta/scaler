import java.util.ArrayList;

public class BitwiseOr {
    private static ArrayList<ArrayList<Integer>> subSequences = new ArrayList<>();
    public static void main(String args[]) {
        // int[] arr = {1,2,3};
        // int[] arr = {9,10,11};
        int[] arr = {61, 85, 62, 83, 83, 2, 60, 63, 76, 89};
        // int[] arr = {61, 85, 62, 83, 83, 2, 60, 63, 76, 89};
        // int[] arr = { 42, 110, 144, 170, 154, 62, 148, 114, 64, 150, 68, 138, 122, 174, 188, 172, 88, 76, 24, 162, 78, 18, 160, 124, 42, 30, 158, 62, 138, 46, 66, 78, 116, 28, 196, 20, 146, 54        };
        // int[] arr = {1,8,4};
        // int[] arr = {2, 4, 6, 8};
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) A.add(arr[i]);
        System.out.println(solve(A));
        // getSubStr("abc", "");
    }

    public static int solve(ArrayList<Integer> A) {
        int len = A.size();
        int result = 0;
        for (int i = 0; i < len; i++) {
            int curr = A.get(i);
            result = gcd(curr, result);
            if (result == 1) {
                return 1;
            }
        }
        return 0;
    }

    private static int gcd(int A, int B) {
        if (B == 0) {
            return A;
        }
        return gcd(B, A%B);
    }

    public static int solve2(ArrayList<Integer> A) {
        int len = A.size();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            int curr = A.get(i);
            if (max < curr) {
                max = curr;
            }
        }
        max++;
        getSubSeq(A, new ArrayList<>());
        int subSeqLen = subSequences.size();

        for (int i = 0; i < subSeqLen; i++) {
            int ans = bitwiseOr(subSequences.get(i), max);
            if (ans == 1) {
                return 1;
            }
        }
        return 0;
    }

    private static void getSubSeq(ArrayList<Integer> arr, ArrayList<Integer> temp) {
        if (arr.size() == 0) {
            // System.out.println(temp);
            subSequences.add(temp);
            return;
        }
        ArrayList<Integer> copyArr = new ArrayList<>();
        int arrLen = arr.size();
        for (int i = 1; i < arrLen; i++) {
            copyArr.add(arr.get(i));
        }

        ArrayList<Integer> copyTemp = new ArrayList<>();
        int tempLen = temp.size();
        for (int i = 0; i < tempLen; i++) {
            copyTemp.add(temp.get(i));
        }
        copyTemp.add(arr.get(0));
        getSubSeq(copyArr, copyTemp);

        ArrayList<Integer> copyArr2 = new ArrayList<>();
        for (int i = 1; i < arrLen; i++) {
            copyArr2.add(arr.get(i));
        }
        getSubSeq(copyArr2, temp);
    }

    private static int bitwiseOr(ArrayList<Integer> A, int max) {
        int len = A.size();
        int[] count = new int[max];
        for (int i = 0; i < len; i++) {
            int number = A.get(i);
            
            for (int j = 2; j <= number; j++) {
                if (number % j == 0) {
                    count[j]++;
                    if (count[j] == len) {
                        return 0;
                    }
                }
            }
        }
        return 1;
    }

    private static void getSubStr(String str, String s) {
        if (str.length() == 0) {
            System.out.println("Substring: " + s);
            return;
        }
        String s1 = str.substring(1, str.length());
        String _s1 = str.substring(0, 1);
        getSubStr(s1, s + _s1);
        String s2 = str.substring(1, str.length());
        getSubStr(s2, s);
    }

    public static int solve1(ArrayList<Integer> A) {
        int len = A.size();
        boolean isPrimeFound = false;
        for (int i = 0; i < len; i++) {
            int curr = A.get(i);
            boolean isPrime = true;
            for (int j = 2; j * j <= curr; j++) {
                if (curr % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime && curr != 1) {
                isPrimeFound = true;
                break;
            }
        }
        return isPrimeFound ? 1 : 0;
    }
}
