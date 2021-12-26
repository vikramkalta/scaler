import java.util.ArrayList;

public class CaptureRegions {
    public static Boolean[][] visited; //public static Boolean[][] captured;
    public static void main(String args[]) {
        char[][] a1 = {
            {'X', 'X', 'X', 'X'}, 
            {'X', 'O', 'O', 'X'}, 
            {'X', 'X', 'O', 'X'},
            {'X', 'O', 'X', 'X'}};
        // char[][] a = {{'X', 'O', 'O'}, {'X', 'O', 'X'}, {'O','O','O'}};
        ArrayList<ArrayList<Character>> A = new ArrayList<>();
        // XOXXXXOOXX XOOOOXOOXX OXXOOXXXOO OXXXOOOXXO OXXXXXOOXX OXXXXXXOXO OOXXXXOXOO 
        char[][] a3 = 
              { { 'X', 'O', 'X', 'X', 'X', 'X', 'O', 'O', 'X', 'X' },
                { 'X', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'X', 'X' },
                { 'O', 'X', 'X', 'O', 'O', 'X', 'X', 'X', 'O', 'O' },
                { 'O', 'X', 'O', 'X', 'O', 'O', 'O', 'X', 'X', 'O' },
                { 'O', 'X', 'O', 'O', 'X', 'X', 'O', 'O', 'X', 'X' },
                { 'O', 'X', 'X', 'X', 'O', 'X', 'X', 'O', 'X', 'O' },
                { 'O', 'O', 'X', 'X', 'X', 'X', 'O', 'X', 'O', 'O' } };
        char[][] a4 = {
            {'O','O','O','X','X','X','O'},
            {'X','X','X','O','O','O','O'},
            {'X','X','O','X','O','X','O'},
            {'O','X','O','X','O','X','O'},
            {'X','X','O','X','O','X','X'},
            {'X','O','O','O','X','X','O'},
            {'O','X','X','O','X','O','O'},
            {'O','X','O','O','X','O','X'}
        };
        char[][] a= {{'X','X','X'},{'X','O','X'},{'X','X','X'}};
        for (int i = 0; i < a.length; i++) {
            ArrayList<Character> innerArr = new ArrayList<>();
            for (int j = 0; j < a[i].length; j++)
                innerArr.add(a[i][j]);
            A.add(innerArr);
        }
        System.out.println(solve(A));
    }
    public static void dfs(ArrayList<ArrayList<Character>> A, int i, int j, int rows, int cols, ArrayList<ArrayList<Integer>> connectedSet) {
        visited[i][j] = true;
        int[] iAdj = { i - 1, i, i + 1, i };
        int[] jAdj = { j, j + 1, j, j - 1 };
        for (int pos = 0; pos < iAdj.length; pos++) {
            int _i = iAdj[pos];
            int _j = jAdj[pos];
            if (getIsSafe(_i, _j, rows, cols) && !visited[_i][_j]) {
                char curr = A.get(_i).get(_j);
                if (curr == 'O') {
                    ArrayList<Integer> connectedSetIndices = new ArrayList<>();
                    connectedSetIndices.add(_i);
                    connectedSetIndices.add(_j);
                    if (isOnBoundary(_i, _j, rows, cols)) {
                        connectedSetIndices.add(-1);
                        connectedSet.add(connectedSetIndices);
                    } else {
                        connectedSet.add(connectedSetIndices);
                        dfs(A, _i, _j, rows, cols, connectedSet);
                    }
                }
            }
        }
    }
    public static boolean getIsSafe(int i, int j, int rows, int cols) {
        return i >= 0 && i < rows && j >= 0 && j < cols;
    }
    public static boolean isOnBoundary(int i, int j, int rows, int cols) {
        return i == 0 || j == 0 || i == rows - 1 || j == cols - 1;
    }
    public static ArrayList<ArrayList<Character>> solve(ArrayList<ArrayList<Character>> a) {
        int rows = a.size();
        int cols = a.get(0).size();
        visited = new Boolean[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                visited[i][j] = false;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                ArrayList<ArrayList<Integer>> connectedSet = new ArrayList<>();
                char curr = a.get(i).get(j);
                if (!isOnBoundary(i, j, rows, cols) && curr == 'O' && !visited[i][j]) {
                    ArrayList<Integer> connectedSetIndices = new ArrayList<>();
                    connectedSetIndices.add(i);
                    connectedSetIndices.add(j);
                    connectedSet.add(connectedSetIndices);
                    dfs(a, i, j, rows, cols, connectedSet);
                    int len = connectedSet.size();
                    boolean capture = true;
                    for (int k = 0; k < len; k++) {
                        if (connectedSet.get(k).size() == 3) {
                            capture = false;
                            break;
                        }
                    }
                    if (capture) {
                        for (int k = 0; k < len; k++) {
                            int _i = connectedSet.get(k).get(0);
                            int _j = connectedSet.get(k).get(1);
                            a.get(_i).set(_j, 'X');
                        }
                    }
                }
            }
        }
        return a;
    }
}