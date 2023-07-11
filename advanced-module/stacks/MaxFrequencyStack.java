import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class MaxFrequencyStack {
    public static void main(String[] args) {
        // int[][] A = {
        // {1, 2},
        // {1, 2},
        // {1, 1},
        // {1, 3},
        // {1, 3},
        // {1, 3},
        // {2, 0},
        // {2, 0},};
        // -1,4,-1,9,-1,-1,6
        // 90,93

        // 90
        // 93
        // 13
        int[][] A = {
        { 1, 46 }, { 2, 0 }, { 1, 11 }, { 1, 38 }, { 2, 0 },
        { 1, 71 }, { 2, 0 }, { 2, 0 }, { 1, 45 }, { 2, 0 },
        { 1, 27 }, { 1, 23 }, { 2, 0 }, { 1, 69 }, { 2, 0 },
        { 2, 0 }, { 1, 76 }, { 1, 64 }, { 2, 0 }, { 2, 0 },
        { 1, 13 }, { 1, 13 }, { 1, 93 }, { 1, 90 }, { 2, 0 },
        { 2, 0 }, { 2, 0 }, { 1, 4 },
        { 1, 63 }, { 2, 0 }, { 1, 9 }, { 2, 0 }, { 1, 26 }, { 1, 29 }, { 2, 0 }, { 2,
        0 }, { 1, 26 }, { 2, 0 },
        { 1, 91 }, { 1, 52 }, { 1, 89 }, { 1, 8 }, { 1, 95 }, { 2, 0 }, { 2, 0 }, {
        2, 0 }, { 2, 0 }, { 2, 0 },
        { 2, 0 }, { 1, 38 }, { 2, 0 }, { 2, 0 }, { 1, 65 } };
        // int[][] A = {
        // { 1, 4 },
        // { 2, 0 },
        // { 1, 9 },
        // { 2, 0 },
        // { 1, 6 },
        // { 1, 6 },
        // { 2, 0 } };
        // -1,-1,9,9,1
        // int[][] A = {
        // {1,9},
        // {1,6},
        // {2,0},
        // {2,0},
        // {1,1}};
        // -1,-1,8,-1,8
        // int[][] A = {
        //         { 1, 8 },
        //         { 1, 8 },
        //         { 2, 0 },
        //         { 1, 3 },
        //         { 2, 0 } };
        // int[][] A = {{1,2},{1,3},{2,0},{2,0},{1,5},{1,5},{1,1},{2,0},{1,6}};
        System.out.println(solve(A));
    }

    public static int[] solve(int[][] A) {
        int len = A.length;
        int[] ans = new int[len];
        HashMap<Integer, Integer> countMap = new HashMap<>();
        Stack<Integer> stack = new Stack<Integer>();
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < len; i++) {
            int op = A[i][0];
            int num = A[i][1];
            // if (num == 90) {
            //     System.out.println();
            // }
            if (op == 1) {
                int x = countMap.getOrDefault(num, 0);
                if (x+1 > max) {
                    max = x+1;
                }
                countMap.put(num, x+1);
                stack.push(num);
                ans[i] = -1;
            } else {
                ArrayList<Integer> random = new ArrayList<>();
                while (!stack.isEmpty() && countMap.get(stack.peek()) != max) {
                    int x = stack.pop();
                    random.add(x);
                }
                int x = stack.pop();
                countMap.put(x, countMap.get(x) - 1);
                // max--;
                if (countMap.get(x)==0){
                    countMap.remove(x);
                }
                max = Integer.MIN_VALUE;
                for (int key: countMap.keySet()) {
                    int countOccurred = countMap.get(key);
                    if (countOccurred > max) {
                        max = countOccurred;
                    }
                }
                ans[i] = x;
                for (int j = random.size()-1; j >= 0; j--) {
                    stack.push(random.get(j));
                }
            }
        }
        return ans;
    }
}
