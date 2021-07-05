import java.util.ArrayList;

public class NegativePostive {
    public static void main(String args[]) {
        // int[] arr = { 2, -1, -2, -3, 4, 5, -1 };
        // int[] arr = { -1, -2, -3, 4, 5 };
        // int[] arr = { 5, -17, -100, -11 };
        // int[] arr = { -23, -24, -1, -25, 22, 1, 22, -28, 0, 3, -24, 6, 0, -23, 7, 5,
        // 17, 18, 14, 5, 20, -25, -13, 26,
        // 13, -29, -7, 5, -4, 9, -30, 20, 11, -11, 22, 1, -19, 24, -15, 3, 17, -28, 30,
        // -20, 30, 20, -14, -28, 18,
        // 10, -28, -25, -12, -21, 15, 0, 6, -15, 25, -25, 13, -24, 14, -22, 9, -23, 5,
        // -12, 6, -11, -12, 10, -12,
        // -2, -8, 4, 17, -11, -4, 18, 11, -1, 1, -21, 14, -11, -18, 19, 17, 9, -5, 8,
        // -3, -6, -18, 19, -18, -5,
        // -8, -29, -4, -27, 12, 2, 30, 8, 19, 11, -16, 20, -22, 8, -27, -15, -12, 9,
        // -10, 10, 22, 16, -9, -12, 9,
        // -28, 2, 18, -28, -26, 21, 27, -18, -13, -17, 20, 2, 11, 16, -11 };
        int[] arr = { 24, -8, 7, 20, -19, -13, -3, 25, -10, 10, -25, 7, 22, -15, 23, 6, -2, 26, 10, -14, -8, 5, -7, 27,
                19, 15, -28, -30, 9, -19, -30, -2, -27, -9, 4, 14, -8, -4, 15, 24, -8, -27, -16, -11, 1, 18, -2, -5, 9,
                28, -23, 23, -26, 8, -17, 20, -7, 5, -18, 8, -24, -20, 20, -28, -3, -18, 1, -8, 26, 14, -6, 15, 9, 12,
                -1, 29, -12, -3, 8, 23, -21, 0, -7, -4, -25, -18, -12, -17, -15, -11, -3, -29, -13, 10, 1, 11, 11, 15,
                -9, -29, 12, -21, -17, 1, 7, 11, 7, 15, 21, -4, -20, 17, -8, 1, -3, 28, -8, -29, 9, 29, 26, -16, -21,
                -23, -5, 25, -13, -1, -29, 25, 17, 3, 11, 26, 14, -30, 12, -4, 29, 21, -25, 8, -4, 11, -28, -16, -26 };
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++)
            A.add(arr[i]);
        // System.out.println(solve(A));
        System.out.println(solve(A));
    }

    public static ArrayList<Integer> solve(ArrayList<Integer> A) {
        int len = A.size();
        // -1,-2,-3,7,5
        // 5,-17,-100,-11
        int flip = A.get(0) < 0 ? 0 : 1;
        for (int i = 0; i < len - 1; i++) {
            int curr = A.get(i);
            if (A.get(i) >= 0 && i == 0) {
                for (int j = i + 1; j < len; j++) {
                    int currJ = A.get(j);
                    if (currJ < 0) {
                        A.remove(j);
                        A.add(i, currJ);
                        flip = 1;
                        break;
                    }
                }
                continue;
            }
            if (A.get(i + 1) < 0 && flip == 1 && i != 0) {
                flip = 0;
                continue;
            }
            if (A.get(i + 1) >= 0 && flip == 0 && i != 0) {
                flip = 1;
                continue;
            }
            if (curr > 0 && flip == 1) {
                for (int j = i + 1; j < len; j++) {
                    int currJ = A.get(j);
                    if (currJ < 0) {
                        A.remove(j);
                        A.add(i + 1, currJ);
                        // A.add(i, currJ);
                        flip = 1;
                        break;
                    }
                }
            }
            if (curr <= 0 && flip == 0) {
                for (int j = i + 1; j < len; j++) {
                    int currJ = A.get(j);
                    if (currJ >= 0) {
                        A.remove(j);
                        A.add(i + 1, currJ);
                        flip = 1;
                        // i--;
                        break;
                    }
                }
            }
        }
        return A;
    }

    public static ArrayList<Integer> solve1(ArrayList<Integer> A) {
        int len = A.size();
        int negPlacedCount = 0;
        for (int i = 0; i < len; i++) {
            int curr = A.get(i);
            if (curr < 0 && negPlacedCount == 0) {
                A.remove(i);
                A.add(negPlacedCount, curr);
                negPlacedCount += 2;
            } else if (curr < 0 && negPlacedCount < len) {
                if (negPlacedCount < i && A.get(negPlacedCount) >= 0) {
                    A.remove(i);
                    A.add(negPlacedCount, curr);
                    negPlacedCount += 2;
                }
            } else if (curr > 0 && negPlacedCount - 1 >= 0) {
                if (negPlacedCount < len) {
                    A.remove(i);
                    A.add(negPlacedCount - 1, curr);
                    negPlacedCount += 2;
                }

            }
        }
        if (negPlacedCount == 0) {
            return A;
        }
        return A;
    }
}
