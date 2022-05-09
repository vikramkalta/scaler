import java.util.ArrayList;

public class DungeonPrincess {
    public static void main(String args[]) {
        // int[][] arr = { { -2, -3, 3 }, { -5, -10, 1 }, { 10, 30, -5 } };
        int[][] A = {{1, -1, 0},{-1, 1, -1},{1, 0, -1}};
        // ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        // for (int i = 0; i < arr.length; i++) {
        //     ArrayList<Integer> innerArr = new ArrayList<>();
        //     for (int j = 0; j < arr[i].length; j++) {
        //         innerArr.add(arr[i][j]);
        //     }
        //     A.add(innerArr);
        // }
        System.out.println(solve(A));
    }

    public static int solve(int[][] dungeon) {
        int rows = dungeon.length;
        int cols = dungeon[0].length;
        int originalStart = dungeon[0][0];

        for (int i = rows - 2; i >= 0; i--) {
            dungeon[i][cols - 1] = dungeon[i + 1][cols - 1] + dungeon[i][cols - 1];
        }
        for (int i = cols - 2; i >= 0; i--) {
            dungeon[rows - 1][i] = dungeon[rows - 1][i + 1] + dungeon[rows - 1][i];
        }

        for (int i = rows - 2; i >= 0; i--) {
            for (int j = cols - 2; j >= 0; j--) {
                int rightSum = dungeon[i][j] + dungeon[i][j + 1];
                int bottomSum = dungeon[i][j] + dungeon[i + 1][j];
                if (Math.abs(rightSum) > Math.abs(bottomSum)) {
                    dungeon[i][j] = bottomSum;
                } else if (Math.abs(rightSum) == Math.abs(bottomSum)) {
                    dungeon[i][j] = Math.max(bottomSum, rightSum);
                } else {
                    dungeon[i][j] = rightSum;
                }
            }
        }
        int ans = 0;
        if (dungeon[0][0] < 0) {
            ans = Math.abs(dungeon[0][0]) + 1;
        } else if (dungeon[0][0] == 0) {
            ans = Math.abs(originalStart) + 1;
        } else {
            ans = originalStart < 0 ? Math.abs(originalStart) + 1 : 1;
        }
        // return dungeon[0][0] < 0 ? Math.abs(dungeon[0][0]) + 1 : 1;
        return ans;
    }

    public static int solve1(ArrayList<ArrayList<Integer>> A) {
        int rows = A.size();
        int cols = A.get(0).size();
        ArrayList<ArrayList<Integer>> dp = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            ArrayList<Integer> innerArr = new ArrayList<>();
            for (int j = 0; j < cols; j++) {
                innerArr.add(0);
            }
            dp.add(innerArr);
        }

        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 0; j--) {
                int curr = A.get(i).get(j);
                if (i == rows - 1 && j == cols - 1) {
                    dp.get(i).set(j, curr);
                } else {
                    int sum = 0;
                    if (i == rows - 1) {
                        int right = dp.get(i).get(j + 1);
                        sum = curr + right;
                    } else if (j == cols - 1) {
                        int down = dp.get(i + 1).get(j);
                        sum = curr + down;
                    } else {
                        int right = dp.get(i).get(j + 1);
                        int down = dp.get(i + 1).get(j);
                        int sum1 = right + curr;
                        int sum2 = down + curr;
                        sum = Math.max(sum1, sum2);
                    }
                    if (sum < 0) {
                        dp.get(i).set(j, sum);
                    }
                }
            }
        }
        int ans = dp.get(0).get(0);
        if (ans < 0) {
            ans = Math.abs(ans) + 1;
        }
        return ans;
    }

    public static int findHealth(ArrayList<ArrayList<Integer>> A, int i, int j, int rows, int cols) {
        if (i >= rows) {
            return 0;
        }
        if (j >= cols) {
            return 0;
        }
        // int ans = 0;
        int currRight = A.get(i).get(j);
        int x = findHealth(A, i, j + 1, rows, cols) + currRight;
        int y = findHealth(A, i + 1, j, rows, cols) + x;
        // int currDown = A.get(i).get(j);
        // System.out.println("y: " + y);
        // int sum = y + currDown;
        return y;
    }
}
