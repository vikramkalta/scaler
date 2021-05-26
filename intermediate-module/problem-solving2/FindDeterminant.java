import java.util.ArrayList;

public class FindDeterminant {
    public static void main(String args) {}

    public static int findDeterminant(ArrayList<ArrayList<Integer>> A) {
        int len = A.size();

        int ans = 0;
        if (len == 2) {
            int d1 = A.get(0).get(0) * A.get(1).get(1);
            int d2 = A.get(1).get(0) * A.get(0).get(1);
            ans = d1 - d2;
            // ans = ans < 0 ? -ans : ans;
        } else {
            int d1 = A.get(0).get(0) * ((A.get(1).get(1) * A.get(2).get(2)) - (A.get(1).get(2) * A.get(2).get(1)));
            int d2 = A.get(0).get(1) * ((A.get(1).get(0) * A.get(2).get(2)) - (A.get(1).get(2) * A.get(2).get(0)));
            int d3 = A.get(0).get(2) * ((A.get(1).get(0) * A.get(2).get(1)) - (A.get(1).get(1) * A.get(2).get(0)));
            ans = d1 - d2 + d3;
            // ans = ans < 0 ? -ans : ans;
        }
        return ans;
        
    }
}
