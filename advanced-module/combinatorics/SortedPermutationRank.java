import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SortedPermutationRank {
    public static void main(String args[]) {
        // char a = 'a';int _a = a;char b = (char) _a;
        // System.out.println(_a);System.out.println(b);
        // System.out.println(solve("dbac"));
        // System.out.println(solve("bcad"));
        // System.out.println(solve("VIEW"));
        System.out.println(solve("DTNGJPURFHYEW"));
        System.out.println(solve("ZCSFLVHXRYJQKWABGT"));
    }

    public static int solve(String A) {
        int len = A.length();
        if (len == 1)
            return 1;

        ArrayList<Character> stringArr = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            stringArr.add(A.charAt(i));
        }

        mergeSort(stringArr, 0, len - 1);

        long rank = 0;
        long[] fact = fact((long) (len));
        for (int i = 0; i < len; i++) {
            char curr = A.charAt(i);
            long pos = 0;
            for (int j = 0; j < len; j++) {
                char currJ = stringArr.get(j);
                pos++;
                if (curr == currJ) {
                    break;
                }
            }

            pos--;
            stringArr.remove((int) pos);
            long x = fact[len - 1 - i];
            rank += (x * pos);
        }
        rank++;
        return (int) rank % 1000003;
    }

    private static long[] fact(long A) {
        long mod = 1000003l;
        long[] result = new long[(int) A];
        long ans = 1;
        result[1] = ans;
        for (int i = 2; i < A; i++) {
            ans = (ans * i) % mod;
            result[i] = ans;
        }
        return result;
    }

    public static void mergeSort(ArrayList<Character> arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int m = (l + r) / 2;
        mergeSort(arr, l, m);
        mergeSort(arr, m + 1, r);
        merge(arr, l, m, r);
    }

    private static void merge(ArrayList<Character> arr, int l, int m, int r) {
        ArrayList<Character> arr1 = new ArrayList<>();
        ArrayList<Character> arr2 = new ArrayList<>();
        for (int i = l; i <= m; i++) {
            arr1.add(arr.get(i));
        }
        for (int i = m + 1; i <= r; i++) {
            arr2.add(arr.get(i));
        }
        int len1 = arr1.size();
        int len2 = arr2.size();
        int i = 0, j = 0, k = l;

        while (i < len1 && j < len2) {
            int curr1 = arr1.get(i);
            int curr2 = arr2.get(j);
            if (curr1 <= curr2) {
                arr.set(k, (char) curr1);
                i++;
            } else {
                arr.set(k, (char) curr2);
                j++;
            }
            k++;
        }
        while (i < len1) {
            arr.set(k, (char) arr1.get(i));
            i++;
            k++;
        }
        while (j < len2) {
            arr.set(k, (char) arr2.get(j));
            j++;
            k++;
        }
    }
}

class Queue {
    int start = -1;
    int end = 0;

    Queue() {

    }
}