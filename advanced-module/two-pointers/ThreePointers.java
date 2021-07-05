import java.util.ArrayList;

public class ThreePointers {
    public static void main(String args[]) {
        // int[] arr1 = { 1, 4, 10 };
        // int[] arr2 = { 2, 15, 20 };
        // int[] arr3 = { 10, 12 };
        int[] arr1 = { 1 };
        int[] arr2 = { 1 };
        int[] arr3 = { 1 };
        ArrayList<Integer> A = new ArrayList<>();
        ArrayList<Integer> B = new ArrayList<>();
        ArrayList<Integer> C = new ArrayList<>();
        for (int i = 0; i < arr1.length; i++)
            A.add(arr1[i]);
        for (int i = 0; i < arr2.length; i++)
            B.add(arr2[i]);
        for (int i = 0; i < arr3.length; i++)
            C.add(arr3[i]);
        System.out.println(solve(A, B, C));
    }

    public static int solve(ArrayList<Integer> A, ArrayList<Integer> B, ArrayList<Integer> C) {
        int a = 0, b = 0, c = 0;
        int lenA = A.size(), lenB = B.size(), lenC = C.size();
        int ans = Integer.MAX_VALUE;
        while (true) {
            int currA = A.get(a);
            int currB = B.get(b);
            int currC = C.get(c);
            int[] min = getMin(currA, currB, currC);
            int[] max = getMax(currA, currB, currC);
            int diff = (max[0] - min[0]);
            if (ans > diff) {
                ans = diff;
                if (ans == 0) {
                    break;
                }
            }
            if (min[1] == 0 && a < lenA - 1) {
                a++;
            } else if (min[1] == 1 && b < lenB - 1) {
                b++;
            } else if (min[1] == 2 && c < lenC - 1) {
                c++;
            } else {
                // a=min and equal to len, choose from b or c
                if (min[1] == 0) {
                    if (currB < currC && b < lenB - 1) {
                        b++;
                    } else {
                        if (c == lenC - 1) {
                            b++;
                        } else {
                            c++;
                        }
                    }
                } else if (min[1] == 1) {
                    if (currC < currA && c < lenC - 1) {
                        c++;
                    } else {
                        if (a == lenA - 1) {
                            c++;
                        } else {
                            a++;
                        }
                    }
                } else {
                    if (currA < currB && a < lenA - 1) {
                        a++;
                    } else {
                        if (b == lenB - 1) {
                            a++;
                        } else {
                            b++;
                        }

                    }
                }
            }

            if (a == lenA - 1 && b == lenB - 1 && c == lenC - 1) {
                break;
            }
        }
        return ans;
    }

    private static int[] getMin(int a, int b, int c) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        int[] arr = { a, b, c };
        for (int i = 0; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
                minIndex = i;
            }
        }
        int[] ans = { min, minIndex };
        return ans;
    }

    private static int[] getMax(int a, int b, int c) {
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;
        int[] arr = { a, b, c };
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
                maxIndex = i;
            }
        }
        int[] ans = { max, maxIndex };
        return ans;
    }
}
