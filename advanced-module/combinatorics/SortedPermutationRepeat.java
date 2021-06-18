import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SortedPermutationRepeat {
    public static void main(String args[]) {
        // System.out.println(solve("bbbbaaaa"));
        // System.out.println(solve("aba"));
        // System.out.println(solve("baa"));
        // System.out.println(solve("aabb"));
        // System.out.println(solve("abab"));
        // System.out.println(solve("abba"));
        // System.out.println(solve("baab"));
        // System.out.println(solve("baba"));
        System.out.println(solve("bbaa"));
        // System.out.println(solve("acb"));
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

        HashMap<Character, ArrayList<Integer>> charMap = new HashMap<>();
        int uniqueChars = 0;

        for (int i = 0; i < len; i++) {
            char curr = stringArr.get(i);
            if (charMap.containsKey(curr)) {
                int val = charMap.get(curr).get(0);
                val++;
                charMap.get(curr).set(0, val);
            } else {
                uniqueChars++;
                ArrayList<Integer> arr = new ArrayList<>();
                arr.add(1);
                arr.add(uniqueChars);
                charMap.put(curr, arr);
            }
        }

        long[] facts = fact(len);
        long ans = 0l;

        long countOfRemoved = 0;
        for (int i = 0; i < len; i++) {
            char curr = A.charAt(i);
            ArrayList<Integer> val = charMap.get(curr);
            long pos = val.get(1);
            int count = val.get(0);
            count--;

            if (countOfRemoved > 0) {
                pos = pos - countOfRemoved;
            }

            long perms = perm(facts, charMap, len - i);
            long div = perms / uniqueChars;

            if (count <= 0) {
                charMap.remove(curr);
                uniqueChars--;
                countOfRemoved++;
            } else {
                charMap.get(curr).set(0, count);
            }

            pos--;

            long x = div * pos;
            ans = ans + x;
        }
        return (int) ans + 1;
    }

    private static long perm(long[] facts, HashMap<Character, ArrayList<Integer>> charMap, int index) {
        long ans = 1l;
        long fact = facts[index];
        long divisor = 1l;
        for (Map.Entry hm : charMap.entrySet()) {
            ArrayList<Integer> value = (ArrayList<Integer>) hm.getValue();
            divisor = divisor * facts[value.get(0)];
        }
        ans = fact / divisor;
        return ans;
    }

    private static long[] fact(long n) {
        long[] result = new long[(int) n + 1];
        result[0] = 1;
        for (int i = 1; i <= n; i++) {
            result[i] = result[i - 1] * i;
        }
        return result;
    }

    public static void mergeSort(ArrayList<Character> arr, int l, int r) {
        if (l >= r)
            return;
        int m = (l + r) / 2;
        mergeSort(arr, l, m);
        mergeSort(arr, m + 1, r);
        merge(arr, l, m, r);
    }

    private static void merge(ArrayList<Character> arr, int l, int m, int r) {
        ArrayList<Character> arr1 = new ArrayList<>();
        ArrayList<Character> arr2 = new ArrayList<>();
        for (int i = l; i <= m; i++)
            arr1.add(arr.get(i));
        for (int i = m + 1; i <= r; i++)
            arr2.add(arr.get(i));
        int len1 = arr1.size();
        int len2 = arr2.size();
        int i = 0, j = 0, k = l;

        while (i < len1 && j < len2) {
            int curr1 = arr1.get(i);
            int curr2 = arr2.get(j);
            if (curr1 <= curr2) {
                arr.set(k, (char) arr1.get(i));
                i++;
            } else {
                arr.set(k, (char) arr2.get(j));
                j++;
            }
            k++;
        }
        while (i < len1) {
            arr.set(k, arr1.get(i));
            i++;
            k++;
        }
        while (j < len2) {
            arr.set(k, arr2.get(j));
            j++;
            k++;
        }
    }
}

// class Queue1 {
// int[] arr;
// int start = 0;
// int end = 0;
// int len = 0;

// Queue1(int l) {
// arr = new int[l];
// len = l;
// }

// public void enqueue(int n) {
// if (start == len){
// System.out.println("Not allowed");
// System.exit(1);
// }
// arr[end]=n;
// end++;
// end = end%len;
// }
// public int dequeue() {
// if (start == end) {
// System.out.println("Not allowed");
// System.exit(1);
// }
// int n = arr[start];
// start++;
// start = start%len;
// return n;
// }
// }
