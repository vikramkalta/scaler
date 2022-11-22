import java.util.ArrayList;
import java.util.HashMap;

public class MinWeightCycle {
    public static void main(String args[]) {
        // int A = 4;
        // int[][] B = {
        //     {1,2,2},
        //     {2 ,3 ,3},
        //     {3 ,4 ,1},
        //     {4 ,1 ,4},
        //     {1 ,3 ,15},
        // };
        // int A = 5;
        // int[][] B = {
        //     {1, 2, 1},
        //     {1, 5, 2},
        //     {5, 4, 3},
        //     {4, 3, 1},
        //     {3, 2, 5},
        //     {2, 5, 8},
        //     {5, 3, 6},
        // };
        int A = 6;
        int[][] B = 
        {
          {1, 2, 3},
          {1, 3, 3},
          {2, 3, 3},
          {4, 5, 4},
          {4, 6, 3},
          {5, 6, 1},
        };
        System.out.println(solve(A, B));
    }
    public static int solve(int A, int[][] B) {
        ArrayList<ArrayList<Integer>> sccList = new ArrayList<>();
        for (int i = 0; i < A; i++) {
            sccList.add(new ArrayList<Integer>());
        }
        HashMap<Integer, HashMap<Integer, Integer>> graph = new HashMap<>();
        int[] visited = new int[A];
        for (int i = 0; i < B.length; i++) {
            int vertex = B[i][0] - 1;
            int edge = B[i][1] - 1;
            int weight = B[i][2];
            HashMap<Integer, Integer> innerMap = new HashMap<>();
            if (graph.containsKey(vertex)) {
                innerMap = graph.get(vertex);
                innerMap.put(edge, weight);
                graph.put(vertex, innerMap);
            } else {
                innerMap.put(edge, weight);
                graph.put(vertex, innerMap);
            }
        }
        // Put elements on to the stack as recursion is done.
        Stack stack = new Stack(A);
        for (int i = 0; i < A; i++) {
            if (visited[i] == 0 && graph.containsKey(i)) {
                dfs1(graph, i, visited, stack);
            }
        }
        // Transpose the graph
        visited = new int[A];
        HashMap<Integer, HashMap<Integer, Integer>> _graph = new HashMap<>();
        for (int i = 0; i < B.length; i++) {
            int vertex = B[i][1] - 1;
            int edge = B[i][0] - 1;
            int weight = B[i][2];
            HashMap<Integer, Integer> innerMap = new HashMap<>();
            if (_graph.containsKey(vertex)) {
                innerMap = _graph.get(vertex);
                innerMap.put(edge, weight);
                _graph.put(vertex, innerMap);
            } else {
                innerMap.put(edge, weight);
                _graph.put(vertex, innerMap);
            }
        }
        // Create SCCs.
        while(!stack.isEmpty()) {
            int top = stack.pop();
            dfs2(_graph, top, visited, sccList);
            // if (visited[top] == 0) {
            // }
            numComponents++;
        }
        int isCircleFound = 0;
        int minWeightCycle = Integer.MAX_VALUE;
        for (int i = 0; i < sccList.size(); i++) {
            if (sccList.get(i).size()>1) {
                isCircleFound = 1;
                int sum = 0;
                int innerLen = sccList.get(i).size();
                int prev = sccList.get(i).get(innerLen - 1);
                for (int j = innerLen - 2; j >= 0; j--) {
                    int curr = sccList.get(i).get(j);
                    int x = (graph.get(prev).get(curr));
                    sum = sum + x;
                    prev = curr;
                }
                int x = sccList.get(i).get(innerLen - 1);
                sum = sum + (graph.get(prev).get(x));
                if (minWeightCycle>sum) {
                    minWeightCycle = sum;
                }
            }

        }
        return isCircleFound == 1 ? minWeightCycle : -1;
    }
    public static int numComponents = 0;
    public static void dfs1(HashMap<Integer, HashMap<Integer, Integer>> graph, int node, int[] visited, Stack stack) {
        visited[node] = 1;
        if (graph.containsKey(node)) {
            for (int curr: graph.get(node).keySet()) {
                if (visited[curr] == 0) {
                    dfs1(graph, curr, visited, stack);
                }
            }
        }

        stack.push(node);
    }
    public static void dfs2(HashMap<Integer, HashMap<Integer, Integer>> graph, int node, int[] visited, ArrayList<ArrayList<Integer>> sccList) {
        visited[node] = 1;
        sccList.get(numComponents).add(node);
        if (graph.containsKey(node)) {
            for (int curr: graph.get(node).keySet()) {
                if (visited[curr] == 0) {
                    dfs2(graph, curr, visited, sccList);
                }
            }
        }

    }

    static class Stack {
        int len = 0;
        int top = -1;
        int[] stack;
        Stack(int n) {
            this.len = n;
            stack = new int[n];
        }
        public void push(int n) {
            if (isFull()) {
                System.out.println("err[pu]");
                System.exit(1);
            }
            top++;
            stack[top] = n;
        }
        public int pop() {
            if (isEmpty()) {
                System.out.println("err[po]");
                System.exit(1);
            }
            int temp = stack[top];
            top--;
            return temp;
        }
        public boolean isFull() {
            return top == len;
        }
        public boolean isEmpty() {
            return top == 0;
        }
    }
}
