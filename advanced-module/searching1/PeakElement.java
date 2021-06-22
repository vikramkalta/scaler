import java.util.ArrayList;

public class PeakElement {
    public static void main(String args[]) {
        int[] arr = { 5, 17, 100, 11 };
        // int[] arr = { 2, 3 };
        // int[] arr = { 1, 2, 3, 4, 5 };
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++)
            A.add(arr[i]);
        System.out.println(solve(A));
    }

    public static int solve(ArrayList<Integer> A) {
        int len = A.size();
        int l = 0, r = len - 1, m = (l + r) / 2;
        int ans = -1;
        while (l <= r) {
            int elMid = A.get(m);

            int elMidRight = 0;
            if ((m + 1) >= len) {
                elMidRight = m;
            } else {
                elMidRight = A.get(m + 1);
            }
            int elMidLeft = 0;
            if ((m - 1) < 0) {
                elMidLeft = m;
            } else {
                elMidLeft = A.get(m - 1);
            }

            if (elMid >= elMidLeft && elMid >= elMidRight) {
                ans = elMid;
                break;
            } else if (elMid < elMidLeft) {
                r = m - 1;
            } else if (elMid < elMidRight) {
                l = m + 1;
            }
            m = (l + r) / 2;
        }
        return ans;
    }
}
