import java.util.ArrayList;

public class RotatedSortedSearch {
    public static void main(String args[]) {
        // int[] arr = { 4, 5, 6, 7, 0, 1, 2, 3 };
        int[] arr = { 180, 181, 182, 183, 184, 187, 188, 189, 191, 192, 193, 194, 195, 196, 201, 202, 203, 204, 3, 4, 5,
                6, 7, 8, 9, 10, 14, 16, 17, 18, 19, 23, 26, 27, 28, 29, 32, 33, 36, 37, 38, 39, 41, 42, 43, 45, 48, 51,
                52, 53, 54, 56, 62, 63, 64, 67, 69, 72, 73, 75, 77, 78, 79, 83, 85, 87, 90, 91, 92, 93, 96, 98, 99, 101,
                102, 104, 105, 106, 107, 108, 109, 111, 113, 115, 116, 118, 119, 120, 122, 123, 124, 126, 127, 129, 130,
                135, 137, 138, 139, 143, 144, 145, 147, 149, 152, 155, 156, 160, 162, 163, 164, 166, 168, 169, 170, 171,
                172, 173, 174, 175, 176, 177 };
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++)
            A.add(arr[i]);
        System.out.println(solve(A, 42));
    }

    public static int solve(ArrayList<Integer> A, int B) {
        int len = A.size();
        int ans = -1;
        int l = 0, r = len - 1, m = (l + r) / 2;
        while (l <= r) {
            // 4,5,6,7,0,1,2,3
            int elLeft = A.get(l);
            int elMid = A.get(m);
            if (elLeft == B) {
                ans = l;
                break;
            } else if (elMid == B) {
                ans = m;
                break;
            } else if (elLeft > B && elMid > B && elLeft > elMid) {
                r = m;
                m = (l + r) / 2;
            } else if (elLeft > B && elMid > B) { // 3
                l = m + 1;
                m = (l + r) / 2;
            } else if (elLeft > B && elMid < B) { // 3
                l = m + 1;
                m = (l + r) / 2;
            } else if (elLeft < B && elMid > B) { // 8
                r = m;
                m = (l + r) / 2;
            } else if (elLeft < B && elMid < B) { // 8
                l = m + 1;
                m = (l + r) / 2;
            }
        }
        return ans;
    }
}
