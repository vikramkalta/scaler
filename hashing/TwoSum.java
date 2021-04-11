import java.util.ArrayList;
import java.util.HashMap;

public class TwoSum {
    public static void main(String args[]) {
        // Integer arr[] = {2, 7, 11, 15};
        // Integer arr[] = { 4, 7, -4, 2, 2, 2, 3, -5, -3, 9, -4, 9, -7, 7, -1, 9, 9, 4, 1, -4, -2, 3, -3, -5, 4, -7, 7, 9,
                // -4, 4, -8 };
        // Integer arr[]= {-10, -10, -10};
        Integer arr[] = { 1, 1, 1 };
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            A.add(arr[i]);
        }
        // System.out.println(twoSum(A, -3));
        // System.out.println(twoSum(A, 9));
        // System.out.println(twoSum(A, -5));
        System.out.println(twoSum(A, 2));
    }

    public static ArrayList<Integer> twoSum(ArrayList<Integer> A, int B) {
        int len = A.size();

        HashMap<Integer, ArrayList<Integer>> twoSum = new HashMap<>();

        for (int i = 0; i < len; i++) {
            int curr = A.get(i);
            boolean contains = twoSum.containsKey(curr);

            ArrayList<Integer> arr = new ArrayList<>();
            if (contains) {
                ArrayList<Integer> hashVal = twoSum.get(curr);
                hashVal.add(i + 1);
                twoSum.replace(curr, hashVal);
            } else {
                arr.add(i + 1);
                twoSum.put(curr, arr);
            }
        }

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            int curr = A.get(i);

            int diff = B - curr;

            boolean contains = twoSum.containsKey(diff);

            if (contains) {
                ArrayList<Integer> hashVal = twoSum.get(diff);
                int hashValLen = hashVal.size();

                if (hashValLen != 0) {
                    for (int j = 0; j < hashValLen; j++) {
                        ArrayList<Integer> arr = new ArrayList<>();
                        int hashValEl = hashVal.get(j);

                        int i1 = i+ 1;
                        if (hashValEl != i1) {
                            arr.add(i1);
                            arr.add(hashValEl);
    
                            result.add(arr);
                            ArrayList<Integer> _e = new ArrayList<>();
                            twoSum.replace(diff, _e);
                            twoSum.replace(curr, _e);
                        }
                    }
                }
            }
        }

        int resultLen = result.size();
        int minIndex2 = Integer.MAX_VALUE;
        int minIndex1 = Integer.MIN_VALUE;
        for (int i = 0; i < resultLen; i++) {
            ArrayList<Integer> arr = result.get(i);
            int curr0 = arr.get(0);
            int curr1 = arr.get(1);
            System.out.println(curr0 + " : " + curr1);
            if (minIndex2 > curr1) {
                minIndex2 = curr1;
                minIndex1 = curr0;
            }
        }

        ArrayList<Integer> arr = new ArrayList<>();

        if (resultLen != 0) {
            arr.add(minIndex1);
            arr.add(minIndex2);
        }
        
        return arr;
    }
}

// HashMap<Integer, Integer> twoSum = new HashMap<>();

// for (int i = 0; i < len; i++) {
// int curr = A.get(i);
// twoSum.put(curr, i + 1);
// }

// ArrayList<ArrayList<Integer>> result = new ArrayList<>();
// for (int i = 0; i < len; i++) {
// int curr = A.get(i);

// int diff = B - curr;

// boolean contains = twoSum.containsKey(diff);
// if (contains) {
// int hashVal = twoSum.get(diff);

// if (hashVal != 0) {
// ArrayList<Integer> arr = new ArrayList<>();
// arr.add(i + 1);
// arr.add(hashVal);
// result.add(arr);
// twoSum.replace(diff, 0);
// twoSum.replace(curr, 0);
// }
// }
// }
