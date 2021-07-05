import java.util.ArrayList;

public class ClosestPair {
    public static void main(String args[]) {
        // int[] arr = { 1, 2, 3, 4, 5 };
        // int[] arr = { 5, 10, 20 };
        int[] arr = { 1 };
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++)
            A.add(arr[i]);
        // int[] arr1 = { 2, 4, 6, 8 };
        // int[] arr1 = { 1, 2, 30 };
        int[] arr1 = { 2, 4 };
        ArrayList<Integer> B = new ArrayList<>();
        for (int i = 0; i < arr1.length; i++)
            B.add(arr1[i]);
        // System.out.println(solve(A, B, 9));
        // System.out.println(solve(A, B, 13));
        System.out.println(solve(A, B, 4));
    }

    public static ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B, int C) {
        int lenA = A.size();
        int lenB = B.size();
        int pointer1 = 0, pointer2 = lenB - 1;
        int min = Integer.MAX_VALUE;
        int aIndex = -1, bIndex = -1;
        while (pointer1 < lenA && pointer2 >= 0) {
            int curr1 = A.get(pointer1);
            int curr2 = B.get(pointer2);
            int diff = Math.abs((curr1 + curr2) - C);
            if (min > diff) {
                aIndex = pointer1;
                bIndex = pointer2;
                min = diff;
            }
            if (min == diff && pointer2 < bIndex && pointer1 <= aIndex) {
                bIndex = pointer2;
            }
            if (curr1 > curr2) {
                int p2 = pointer2 == 0 ? pointer2 : pointer2 - 1;
                int futureDiff = Math.abs((B.get(p2) + curr1) - C);
                if (futureDiff < diff) {
                    pointer2--;
                } else {
                    pointer1++;
                }
            } else if (curr2 > curr1) {
                int p1 = pointer1 == lenA - 1 ? pointer1 : pointer1 + 1;
                int futureDiff = Math.abs((A.get(p1) + curr2) - C);
                if (futureDiff < diff) {
                    pointer1++;
                } else {
                    pointer2--;
                }
            } else if (curr2 == curr1) {
                pointer1++;
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        result.add(A.get(aIndex));
        result.add(B.get(bIndex));
        return result;
    }

    public static ArrayList<Integer> solve1(ArrayList<Integer> A, ArrayList<Integer> B, int C) {
        int lenA = A.size();
        int lenB = B.size();
        int pointer1 = 0, pointer2 = lenB - 1;
        int min = Integer.MAX_VALUE;
        int aIndex = -1, bIndex = -1;
        while (pointer1 < lenA && pointer2 >= 0) {
            int curr1 = A.get(pointer1);
            int curr2 = B.get(pointer2);
            int diff = Math.abs((curr1 + curr2) - C);
            if (diff > C) {
                if (min > diff) {
                    aIndex = pointer1;
                    bIndex = pointer2;
                    min = diff;
                }
                pointer2--;
            } else if (diff == min) {
                if (min > diff) {
                    aIndex = pointer1;
                    bIndex = pointer2;
                    min = diff;
                }
                pointer2--;
            } else {
                if (min > diff) {
                    aIndex = pointer1;
                    bIndex = pointer2;
                    min = diff;
                }
                pointer1++;
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        result.add(A.get(aIndex));
        result.add(B.get(bIndex));
        return result;
    }
}
