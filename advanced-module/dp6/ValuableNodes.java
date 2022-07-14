import java.util.ArrayList;

public class ValuableNodes {
    public static void main(String args[]) {
        // int[] A = { 0, 1, 2, 3 };
        // int[] B = { 1, 50, 3, 4 };
        int[] A = {0, 1, 1, 1, 3, 3, 6, 6};
        int[] B = {100, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(solve(A, B));
    }
    public static long mod = 1000000007l;
    public static int solve(int[] A, int[] B) {
        int len = A.length;
        ArrayList<ArrayList<Integer>> child = new ArrayList<>();
        ArrayList<ArrayList<Integer>> parent = new ArrayList<>();
        ArrayList<ArrayList<Integer>> ggc = new ArrayList<>();
        long[] dp = new long[len + 1];
        for (int i = 0; i < len + 1; i++) {
            child.add(new ArrayList<Integer>());
            parent.add(new ArrayList<Integer>());
            ggc.add(new ArrayList<Integer>());
            dp[i] = 0l;
        }
        for (int i = 0; i < len; i++) {
            int curr = A[i];
            child.get(curr).add(i+1);
        }
        for (int i = 0; i < len; i++) {
            int childLen = child.get(i).size();
            for (int j = 0; j < childLen; j++) {
                int childElement = child.get(i).get(j);
                parent.get(childElement).add(i);
            }
        }
        for (int i = 0; i < len; i++) {
            int childLen = child.get(i).size();
            for (int j = 0; j < childLen; j++) {
                int childElement = child.get(i).get(j);
                int parentElement = parent.get(childElement).get(0);
                int grandParentElement = -1;
                if (parent.get(parentElement).size() > 0) {
                    grandParentElement = parent.get(parentElement).get(0);
                }
                int greatGrandParentElement = -1;
                if (grandParentElement > -1 && parent.get(grandParentElement).size() > 0) {
                    greatGrandParentElement = parent.get(grandParentElement).get(0);
                }
                if (greatGrandParentElement > -1 && parent.get(greatGrandParentElement).size() > 0) {
                    ggc.get(greatGrandParentElement).add(childElement);
                }
            }
        }

        getMaxSum(parent, child, ggc, B, dp, 0);

        return (int)dp[1];
    }

    public static void getMaxSum(
        ArrayList<ArrayList<Integer>> parent,
        ArrayList<ArrayList<Integer>> child,
        ArrayList<ArrayList<Integer>> ggc,
        int[] B,
        long[] dp,
        int node
    ) {
        if (node < 0) {
            return;
        }
        long ansWithoutNode = 0l;
        for (int i = 0; i < child.get(node).size(); i++) {
            getMaxSum(parent, child, ggc, B, dp, child.get(node).get(i));
            int childNode = child.get(node).get(i);
            ansWithoutNode += dp[childNode];
            ansWithoutNode = ansWithoutNode % mod;
        }
        if (node >= 1) {
            long ansWithNode = B[node - 1] * 1l;
            for (int i = 0; i < ggc.get(node).size(); i++) {
                int ggcNode = ggc.get(node).get(i);
                ansWithNode += dp[ggcNode];
                ansWithNode = ansWithNode % mod;
            }
            dp[node] = Math.max(ansWithNode, ansWithoutNode);
        }
    }

    public static int getMaxSum1(int[] A, int[] B, int i) {
        if (i < 0) {
            return 0;
        }
        int x = getMaxSum1(A, B, i - 3) + B[i];
        int y = getMaxSum1(A, B, i - 1);
        return Math.max(x, y);
    }
}
