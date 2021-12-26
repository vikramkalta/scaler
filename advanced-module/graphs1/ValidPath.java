import java.util.ArrayList;

public class ValidPath {
    public static void main(String args[]) {
        // int[] e = { 2 };
        // int[] f = { 3 };
        // int[] e = { 0 };
        // int[] f = { 0 };
        int[] e= {0, 0, 0};
        int[] f= {21, 20, 43};
        ArrayList<Integer> E = new ArrayList<>();
        ArrayList<Integer> F = new ArrayList<>();
        for (int i = 0; i < e.length; i++)
            E.add(e[i]);
        for (int i = 0; i < f.length; i++)
            F.add(f[i]);
        // System.out.println(solve(2, 3, 1, 1, E, F));
        // System.out.println(solve(1, 1, 1, 1, E, F));
        System.out.println(solve(0, 91, 3, 5, E, F));
    }

    public static Boolean[][] visited;
    public static Boolean[][] blocked;

    public static void DFS(int i, int j, int rows, int cols) {
        visited[i][j] = true;
        int[] iAdj = { i - 1, i - 1, i, i + 1, i + 1, i + 1, i, i - 1 };
        int[] jAdj = { j, j + 1, j + 1, j + 1, j, j - 1, j - 1, j - 1 };
        for (int pos = 0; pos < iAdj.length; pos++) {
            int iCurr = iAdj[pos];
            int jCurr = jAdj[pos];
            if (getIsSafe(iCurr, jCurr, rows+1, cols+1) && !visited[iCurr][jCurr] && !blocked[iCurr][jCurr]) {
                DFS(iCurr, jCurr, rows, cols);
            }
        }
    }

    public static String solve(int A, int B, int C, int D, ArrayList<Integer> E, ArrayList<Integer> F) {
        blocked = new Boolean[A+1][B+1];
        visited = new Boolean[A+1][B+1];

        for (int i = 0; i <= A; i++) {
            for (int j = 0; j <= B; j++) {
                visited[i][j] = false;
                boolean isBlocked = false;
                for (int k = 0; k < C; k++) {
                    int xCenter = E.get(k);
                    int yCenter = F.get(k);
                    double distance = getDistanceFromCenter(i, j, xCenter, yCenter);
                    double dist = distance;
                    if (dist <= D) {
                        isBlocked = true;
                        break;
                    }
                }
                blocked[i][j] = isBlocked;
            }
        }
        // If x,y is blocked return false.
        if (blocked[A][B] || blocked[0][0]) {
            return "NO";
        }
        DFS(0, 0, A, B);
        return !visited[A][B] ? "NO" : "YES";
    }

    public static boolean getIsSafe(int i, int j, int rows, int cols) {
        return i >= 0 && i < rows && j >= 0 && j < cols;
    }

    public static double getDistanceFromCenter(int x1, int y1, int x2, int y2) {
        int xDiff = x2 - x1;
        int yDiff = y2 - y1;
        xDiff = xDiff * xDiff;
        yDiff = yDiff * yDiff;
        int sum = xDiff + yDiff;
        double ans = Math.sqrt(sum);
        return ans;
    }
}
