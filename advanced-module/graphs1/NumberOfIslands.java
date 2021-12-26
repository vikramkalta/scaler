import java.util.ArrayList;

public class NumberOfIslands {
    public static void main(String args[]) {
        int[][] arr = { { 1, 1, 1, 1, 0 }, { 1, 1, 0, 1, 0 }, { 1, 1, 0, 0, 0 }, { 0, 0, 0, 0, 0 } };
        // int[][] arr = { { 1, 1, 0, 0, 0 }, { 1, 1, 0, 0, 0 }, { 0, 0, 1, 0, 0 }, { 0, 0, 0, 1, 1 } };
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            ArrayList<Integer> innerArr = new ArrayList<>();
            for (int j = 0; j < arr[i].length; j++) {
                innerArr.add(arr[i][j]);
            }
            A.add(innerArr);
        }
        System.out.println(solve(A));
    }

    public static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    public static Boolean[][] visited;

    public static void DFS(int i, int j, int rows, int cols, Boolean[][] visited, ArrayList<ArrayList<Integer>> A) {
        visited[i][j] = true;
        int[] cornerI = { i - 1, i - 1, i,     i + 1, i + 1, i + 1, i,     i - 1, };
        int[] cornerJ = { j,     j + 1, j + 1, j + 1, j,     j - 1, j - 1, j - 1 };
        for (int corner = 0; corner < cornerI.length; corner++) {
            boolean isSafe = getIsSafe(cornerI[corner], cornerJ[corner], rows, cols);
            if (isSafe) {
                int _i = cornerI[corner];
                int _j = cornerJ[corner];
                int curr = A.get(_i).get(_j);
                if (curr == 1 && !visited[_i][_j]) {
                    DFS(_i, _j, rows, cols, visited, A);
                }
            }
        }
    }

    public static boolean getIsSafe(int i, int j, int rows, int cols) {
        if (i < rows && i >= 0 && j < cols && j >= 0) {
            return true;
        } else {
            return false;
        }
    }

    public static int solve(ArrayList<ArrayList<Integer>> A) {
        int rows = A.size();
        int cols = A.get(0).size();
        visited = new Boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                visited[i][j] = false;
            }
        }

        int islands = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int curr = A.get(i).get(j);
                if (curr == 1 && !visited[i][j]) {
                    DFS(i, j, rows, cols, visited, A);
                    islands++;
                }
            }
        }
        return islands;
    }
}
