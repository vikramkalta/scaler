import java.util.ArrayList;

public class BlackShapes {
    public static void main(String args[]) {
        String[] a = {"XXX","XXX","XXX"};
        ArrayList<String>A=new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            A.add(a[i]);
        }
        System.out.println(solve(A));
    }

    public static Boolean[][] visited;

    public static void dfs(ArrayList<String> A, int i, int j, int rows, int cols) {
        visited[i][j] = true;
        int[] iAdj = {i-1, i, i+1, i};
        int[] jAdj = {j, j+1, j, j-1};
        for (int position = 0 ; position < iAdj.length; position++) {
            int _i = iAdj[position];
            int _j = jAdj[position];
            if (getIsSafe(_i, _j, rows, cols) && !visited[_i][_j] && A.get(_i).charAt(_j) == 'X') {
                dfs(A, _i, _j, rows, cols);
            }
        }
    }

    public static boolean getIsSafe(int i,int j,int rows, int cols) {
        return i >= 0 && i < rows && j >= 0 && j < cols;
    }

    public static int solve(ArrayList<String> A) {
        int rows = A.size();
        int cols = A.get(0).length();
        visited = new Boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                visited[i][j] = false;
            }
        }
        int ans = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                char curr = A.get(i).charAt(j);
                if (!visited[i][j] && curr == 'X') {
                    dfs(A, i, j, rows, cols);
                    ans++;
                }
            }
        }
        return ans;
    }
}
