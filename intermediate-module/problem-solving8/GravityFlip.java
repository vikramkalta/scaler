import java.util.ArrayList;

public class GravityFlip {
    public static void main(String args[]) {
        int[] arr = { 3, 4, 2, 1 };
        
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++)
            A.add(arr[i]);
        System.out.println(gravityFlip(A));
    }

    public static ArrayList<Integer> gravityFlip(ArrayList<Integer> A) {
        int len = A.size();

        mergeSort(A, 0, len - 1);
        return A;
    }

    public static void mergeSort(ArrayList<Integer> arr, int l, int r) {
        if (l>=r) {
            return;
        }
        int m = (l+r)/2;
        mergeSort(arr, l, m);
        mergeSort(arr, m+1, r);
        merge(arr, l, r, m);
    }

    private static ArrayList<Integer> merge(ArrayList<Integer> arr, int l, int r, int m) {
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();
        for (int i = l; i <= m; i++) {
            arr1.add(arr.get(i));
        }
        for (int i = m+1; i <= r; i++) {
            arr2.add(arr.get(i));
        }
        int len1 = m+1-l;
        int len2 = r-m;
        int i = 0, j = 0, k = l;
        while(i < len1 && j < len2) {
            int curr1 = arr1.get(i);
            int curr2 = arr2.get(j);
            if (curr1 <= curr2) {
                arr.set(k, curr1);
                i++;
            } else {
                arr.set(k, curr2);
                j++;
            }
            k++;
        }
        while(i < len1) {
            arr.set(k, arr1.get(i));
            i++;
            k++;
        }
        while(j<len2) {
            arr.set(k, arr2.get(j));
            j++;
            k++;
        }
        return arr;
    }
}
