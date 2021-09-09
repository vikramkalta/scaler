import java.util.ArrayList;

public class ThreeSum {
    public static void main(String args[]) {
        // int[] arr = { -1, 2, 1, -4 };
        // int[]arr = {1, 2, 3};
        // int[] arr = {5, -2, -1, -10, 10};
        // int[]arr = {-6, 1, -4, -1, 8, -4, 9, 0, -3, 7, -3, 2, -4, -2, 3, -4, 10, 0, 9, 6, 1, 3, 4, 2};
        // int[]arr = {-3, 7, -3, 2, -4, -2, 3};
        int[] arr = {-5, 1, 4, -7, 10, -7, 0, 7, 3, 0, -2, -5, -3, -6, 4, -7, -8, 0, 4, 9, 4, 1, -8, -6, -6, 0, -9, 5, 3, -9, -5, -9, 6, 3, 8, -10, 1, -2, 2, 1, -9, 2, -3, 9, 9, -10, 0, -9, -2, 7, 0, -4, -3, 1, 6, -3};
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++)
            A.add(arr[i]);
        // System.out.println(solve(A, 1));
        // System.out.println(solve(A, 6));
        // System.out.println(solve(A, 5));
        System.out.println(solve(A, -1));
        // System.out.println(solve(A, -3));
        // System.out.println(solve(A, -5));
        // System.out.println(solve(A, -2));
    }

    public static int solve(ArrayList<Integer> A, int B) {
        int len = A.size();
        merge(A, 0, len - 1);

        int minDiff = Integer.MAX_VALUE;
        int ans = 0;

        for (int i = 0; i < len; i++) {
            int currI = A.get(i);
            int start = i + 1, end = len - 1;
            // 5, -2, -1, -10, 10
            // -10, -2, -1, 5, 10
            // -4,-3,-3,-2,2,3,7
            int x = Math.abs(currI - B);
            // System.out.println("x:" +x);
            while (start < end) {
                int currStart = A.get(start);
                int currEnd = A.get(end);
                
                int y = currStart + currEnd;
                // System.out.println("y:"+y);
                int sum = currI + currStart + currEnd;
                int diff = Math.abs(sum - B);
                if (minDiff > diff) {
                    minDiff = diff;
                    // System.out.println("x" +currI + " y "  + currStart + " z " + currEnd);
                    System.out.println("diff: " + diff);
                    System.out.println("i:" + i + " s:" + start + " e:" + end + " sum: " + sum);
                    // System.out.println("x" +currI + " y "  + currStart + " z " + currEnd);
                    ans = sum;
                }
                if (y == x) {
                    break;
                } else if (y > x) {
                    end--;
                } else {
                    start++;
                }
            }
        }

        return ans;
    }

    public static int solve2(ArrayList<Integer> A, int B) {
        int len = A.size();

        int x = 0, y = 1, z = 2;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        int ansX = -1, ansY = -1, ansZ = -1;
        // -4,-1,1,2
        while (y < z && x < y && z < len) {
            int a = A.get(x);
            int b = A.get(y);
            int c = A.get(z);
            sum = a + b + c;
            int diff = Math.abs(sum - B);
            if (min > diff) {
                ansX = x;
                ansY = y;
                ansZ = z;
                min = diff;
            }
            if (z < len - 1) {
                z++; // reach last
            } else if (z == len - 1 && y < len - 2) {
                y++;
                z = y + 1;
            } else if (z == len - 1 && y == len - 2) {
                x++;
                y = x + 1;
                z = y + 1;
            }
        }
        int elX = A.get(ansX), elY = A.get(ansY), elZ = A.get(ansZ);
        int elSum = elX + elY + elZ;

        return elSum;
    }

    public static int solve1(ArrayList<Integer> A, int B) {
        int len = A.size();
        merge(A, 0, len - 1);

        int x = 0, y = 1, z = len - 1;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        int ansX = -1, ansY = -1, ansZ = -1;
        // -4,-1,1,2
        while (y < z && x < y) {
            int a = A.get(x);
            int b = A.get(y);
            int c = A.get(z);
            sum = a + b + c;
            int diff = Math.abs(sum - B);
            if (min > diff) {
                ansX = x;
                ansY = y;
                ansZ = z;
                min = diff;
            }
            if (z - y != 1) {
                y++;
            } else if (y - x != 1) {
                x++;
            } else {
                x++;
            }
        }
        int elX = A.get(ansX), elY = A.get(ansY), elZ = A.get(ansZ);
        int elSum = elX + elY + elZ;
        // int ans = 0;
        // if (elSum == B || len <= 3) {
        // ans = elSum;
        // } else if (elSum < 0 && B < 0) {
        // ans = Math.abs(elSum - B);
        // ans = -ans;
        // } else {
        // if (elSum > B) {
        // ans = elSum - B;
        // } else if (elSum < B) {
        // ans = B - elSum;
        // }
        // }
        return elSum;
    }

    private static void merge(ArrayList<Integer> A, int l, int r) {
        if (l >= r) {
            return;
        }
        int m = (l + r) / 2;
        merge(A, l, m);
        merge(A, m + 1, r);
        mergeSort(A, l, m, r);
    }

    private static void mergeSort(ArrayList<Integer> A, int l, int m, int r) {
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
    }
}
