import java.util.ArrayList;
import java.util.HashMap;

public class SmallestSequence {
    public static void main(String args[]) {
        // int[]arr={5,4,3,2,1};
        int[] arr = { 5, 3, 2 };
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++)
            A.add(arr[i]);
        // System.out.println(smallestSeq(2, 3, 5, 5));
        System.out.println(smallestSeq(3, 11, 7, 50));
        // mergeSort(A, 0, arr.length - 1);
        // System.out.println(A);
    }

    public static ArrayList<Integer> smallestSeq(int A, int B, int C, int D) {
        ArrayList<Integer> primeArr = new ArrayList<>();
        primeArr.add(A);
        primeArr.add(B);
        primeArr.add(C);
        mergeSort(primeArr, 0, 2);
        A = primeArr.get(0);
        B = primeArr.get(1);
        C = primeArr.get(2);
        ArrayList<Integer> result = new ArrayList<>();

        int i = 0;
        result.add(A);
        HashMap<Integer, Boolean> hm = new HashMap<>();
        hm.put(A, true);
        int aCounter = 0, bCounter = 0, cCounter = 0;

        int numA = A * result.get(aCounter), numB = B, numC = C;

        aCounter++;

        i++;

        while (i < D) {
            ArrayList<Integer> min = getMin(numA, numB, numC);
            int _min = min.get(0);
            if (!hm.containsKey(_min)) {
                hm.put(_min, true);
                result.add(_min);
                i++;
            }
            
            int minIndex = min.get(1);
            if (minIndex == 0) {
                numA = A * result.get(aCounter);
                aCounter++;
            } else if (minIndex == 1) {
                numB = B * result.get(bCounter);
                bCounter++;
            } else {
                numC = C * result.get(cCounter);
                cCounter++;
            }
        }
        return result;
    }

    private static ArrayList<Integer> getMin(int A, int B, int C) {
        int arr[] = { A, B, C };
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < 3; i++) {
            int curr = arr[i];
            if (min > curr) {
                min = curr;
                minIndex = i;
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        result.add(min);
        result.add(minIndex);
        return result;
    }

    private static void mergeSort(ArrayList<Integer> arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int m = (l + r) / 2;
        mergeSort(arr, l, m);
        mergeSort(arr, m + 1, r);
        merge(arr, l, m, r);
    }

    private static ArrayList<Integer> merge(ArrayList<Integer> A, int l, int m, int r) {
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();
        for (int i = l; i <= m; i++) {
            arr1.add(A.get(i));
        }
        for (int i = m + 1; i <= r; i++) {
            arr2.add(A.get(i));
        }
        int len1 = arr1.size();
        int len2 = arr2.size();
        int i = 0, j = 0, k = l;
        while (i < len1 && j < len2) {
            int curr1 = arr1.get(i);
            int curr2 = arr2.get(j);
            if (curr1 <= curr2) {
                A.set(k, curr1);
                i++;
            } else {
                A.set(k, curr2);
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
        return A;
    }
}
