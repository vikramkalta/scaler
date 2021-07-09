import java.util.ArrayList;
import java.util.Collections;

public class BClosestPoints {
    public static void main(String args[]) {
        // int[][] arr = { { 1, 3 }, { -2, 2 } };
        int[][] arr = { { -100000, 100000 } };
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            ArrayList<Integer> _A = new ArrayList<>();
            _A.add(arr[i][0]);
            _A.add(arr[i][1]);
            A.add(_A);
        }
        System.out.println(solve(A, 1));
    }

    public static ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A, int B) {
        int len = A.size();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<ArrayList<Long>> aux = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            ArrayList<Integer> curr = A.get(i);
            long euclidean = euclidean(curr);
            ArrayList<Long> _aux = new ArrayList<>();
            _aux.add(euclidean);
            _aux.add((long) i);
            aux.add(_aux);
        }
        // Collections.sort(aux);
        merge(aux, 0, len - 1);
        for (int i = 0; i < B; i++) {
            long index = aux.get(i).get(1);
            result.add(A.get((int) index));
        }
        return result;
    }

    private static long euclidean(ArrayList<Integer> A) {
        long xx = (long) A.get(0);
        long x = 1l * xx;
        long _x = 1l * (x * x);
        long yy = (long) A.get(1);
        long y = 1l * yy;
        long _y = 1l * (y * y);
        long sum = _x + _y;
        // long ans = (long) Math.sqrt(sum);
        // long mod = 1000000007l;
        // long ans = sum % mod;
        // if (ans < 0)
        // ans += mod;
        return sum;
    }

    public static void merge(ArrayList<ArrayList<Long>> A, int l, int r) {
        if (l >= r) {
            return;
        }
        int m = (l + r) / 2;
        merge(A, l, m);
        merge(A, m + 1, r);
        mergeSort(A, l, m, r);
    }

    public static void mergeSort(ArrayList<ArrayList<Long>> A, int l, int m, int r) {
        ArrayList<ArrayList<Long>> arr1 = new ArrayList<>();
        ArrayList<ArrayList<Long>> arr2 = new ArrayList<>();
        for (int i = l; i <= m; i++)
            arr1.add(A.get(i));
        for (int i = m + 1; i <= r; i++)
            arr2.add(A.get(i));
        int len1 = arr1.size();
        int len2 = arr2.size();
        int i = 0, j = 0, k = l;
        while (i < len1 && j < len2) {
            long curr1 = arr1.get(i).get(0);
            long curr2 = arr2.get(j).get(0);
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
