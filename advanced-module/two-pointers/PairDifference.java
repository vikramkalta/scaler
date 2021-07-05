import java.util.ArrayList;

public class PairDifference {
    public static void main(String args[]) {
        // int[] arr = { 1, 3, 4, 2, 5 };
        // int[] arr = { 8, 12, 16, 4, 0, 20 };
        // int[] arr = { 1, 1, 1, 2, 2 };
        int[] arr = { 1, 8, 2, 8, 8, 8, 8, 4, 4, 6, 10, 10, 9, 2, 9, 3, 7 };
        // int[] arr = { 1, 2 };
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++)
            A.add(arr[i]);
        // System.out.println(solve(A, 3));
        // System.out.println(solve(A, 4));
        // System.out.println(solve(A, 0));
        System.out.println(solve(A, 1));
        // System.out.println(solve(A, 0));
    }

    public static int solve(ArrayList<Integer> A, int B) {
        int len = A.size();
        merge(A, 0, len - 1);
        int start = 0, end = 1;
        int count = 0;
        while (start <= end && start < len - 1 && end < len) {
            int currStart = A.get(start);
            int currEnd = A.get(end);
            int diff = currEnd - currStart;
            // || end - start == 1
            // && start != end
            if (diff == B) {
                count++;
                // while (currStart == A.get(start) && start < end) {
                // start++;
                // }
                while (end < len && currEnd == A.get(end)) {
                    end++;
                }
            } else if (diff < B) {
                end++;
            } else if (diff > B) {
                start++;
            }
        }
        return count;
    }

    public static void merge(ArrayList<Integer> A, int l, int r) {
        if (l >= r) {
            return;
        }
        int m = (l + r) / 2;
        merge(A, l, m);
        merge(A, m + 1, r);
        mergeSort(A, l, m, r);
    }

    public static void mergeSort(ArrayList<Integer> A, int l, int m, int r) {
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();
        for (int i = l; i <= m; i++)
            arr1.add(A.get(i));
        for (int i = m + 1; i <= r; i++)
            arr2.add(A.get(i));
        int len1 = arr1.size(), len2 = arr2.size();
        int i = 0, j = 0, k = l;
        while (i < len1 && j < len2) {
            int curr1 = arr1.get(i);
            int curr2 = arr2.get(j);
            if (curr1 <= curr2) {
                A.set(k, arr1.get(i));
                i++;
            } else {
                A.set(k, arr2.get(j));
                j++;
            }
            k++;
        }
        while (i < len1) {
            A.set(k, arr1.get(i));
            i++;
            k++;
        }
        while (j < len2) {
            A.set(k, arr2.get(j));
            j++;
            k++;
        }
    }
}
