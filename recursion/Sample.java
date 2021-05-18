import java.util.ArrayList;

public class Sample {
    public static void main(String args[]) {
        // int[] arr = {8,7,6,5,4,3,2,1};
        int[] arr = {8,7,6,5,4,3,2,1,9};
        // int[] arr = {9, 47, 17, 39, 35, 35, 20, 18, 15, 34, 11, 2, 45, 46, 15, 33, 47, 47, 10, 11, 27};
        // int[] arr = {4,3,2,1,5};
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) A.add(arr[i]);
        // System.out.println(mergeSort(A, 0, arr.length-1));
        mergeSort(A, 0, arr.length-1);
    }

    public static void mergeSort(ArrayList<Integer> arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int m = (l + r) / 2;
        mergeSort(arr, l, m);
        mergeSort(arr, m + 1, r);
        // System.out.println("l:" + l + ",r:" + r + ",m:" + m);
        merge(arr, l, r, m, arr.size());
        System.out.println(arr);
        // return 0;
    }

    public static ArrayList<Integer> merge(ArrayList<Integer> arr, int l, int r, int m, int len) {
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
        int i = 0;
        int j = 0;
        int k = l;
        while (i < len1 && j < len2) {
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

        while (i < len1) {
            arr.set(k, arr1.get(i));
            i++;
            k++;
        }
        while(j < len2) {
            arr.set(k, arr2.get(j));
            j++;
            k++;
        }
        return arr;
    }
}
