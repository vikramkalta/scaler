import java.util.ArrayList;

public class BinarySearchNonRepeating {
    public static void main(String args[]) {
        // int[] arr = { 4, 4, 5, 5, 6, 7, 7, 8, 8 };
        int[] arr = { 1, 1, 2, 2, 3 };
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++)
            A.add(arr[i]);
        // System.out.println(solve(A, 42));
        // System.out.println(solve(A, 902));
        System.out.println(solve(A));
    }

    public static int solve(ArrayList<Integer> A) {
        int len = A.size();
        int ans = -1;
        int l = 0, r = len - 1, m = (l + r) / 2;
        while (l <= r) {
            int elMid = A.get(m);
            if ((m - 1) < 0) {
                ans = A.get(0);
                break;
            }
            if ((m + 1) >= len) {
                ans = A.get(len - 1);
                break;
            }
            int elMidLeft = A.get(m - 1);
            int elMidRight = A.get(m + 1);
            if (elMid != elMidLeft && elMid != elMidRight) {
                ans = elMid;
                break;
            } else if (elMidLeft == elMid) {
                if ((m - 1) % 2 == 0) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            } else if (elMidRight == elMid) {
                if (m % 2 == 0) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
            m = (l + r) / 2;
        }

        return ans;
    }
}
