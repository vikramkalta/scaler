import java.util.ArrayList;

public class SearchRowColumn {
    public static void main(String args[]) {
        // int[][] arr = { { 1, 1 }, { 1, 1 } };
        int[][] arr ={{1,2,3},{2,3,4},{3,4,5}};
        // int[][] arr = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        // int[][] arr = { { 1, 1, 1 }, { 1,1,1 }, { 1,1,1 } };
        // int[][] arr = { { 1, 2, 3,4 }, { 5,6,7,8 }, { 9,10,11,12 }, {13,14,15,16} };
        ArrayList<ArrayList<Integer>> main = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            int[] curr = arr[i];
            ArrayList<Integer> innerA = new ArrayList<>();
            for (int j = 0; j < curr.length; j++) {
                innerA.add(curr[j]);
            }
            main.add(innerA);
        }
        System.out.println(search(main,2));
    }
    
    public static int search(ArrayList<ArrayList<Integer>> A, int B) {
        int row = A.size();
        int col = A.get(0).size();

        int _ans = 1009;
        int ans = Integer.MAX_VALUE;
        int i = 0, j = col - 1;
        boolean found = false;
        while (j >= 0 && i < row) {
            int curr = A.get(i).get(j);
            if (curr == B) {
                found = true;
                int x = ((i + 1) * _ans) + (j + 1);
                if (ans > x) {
                    ans = x;
                }
                j--;
                continue;
            } else if (curr > B) {
                j--;
                continue;
            } else if (curr < B) {
                i++;
                continue;
            }
        }
        if (!found) {
            return -1;
        }
        // i++;j++;
        return ans;
    }
}
