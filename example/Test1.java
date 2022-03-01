import java.util.HashMap;

public class Test1 {
    public static void main(String args[]) {
        // int[][] edges = {{1,2},{2,3},{4,2}};
        int[][] edges = {{1,2},{5,1},{1,3},{1,4}};
        System.out.println(findCenter(edges));
    }

    public static int findCenter(int[][] edges) {
        HashMap<Integer, Integer> vertexCountMap = new HashMap<>();
        int len = edges.length;
        int max = Integer.MIN_VALUE;
        int star = -1;
        for (int i = 0; i < len; i++) {
            int v = edges[i][0];
            int e = edges[i][1];
            if (vertexCountMap.containsKey(v)) {
                int countV = vertexCountMap.get(v) + 1;
                if (countV > max) {
                    max = countV;
                    star = v;
                }
                vertexCountMap.put(v, countV);
            } else {
                vertexCountMap.put(v, 1);
            }
            if (vertexCountMap.containsKey(e)) {
                int countE = vertexCountMap.get(e) + 1;
                if (countE > max) {
                    max = countE;
                    star = e;
                }
                vertexCountMap.put(e, vertexCountMap.get(e) + 1);
            } else {
                vertexCountMap.put(e, 1);
            }
        }
        return star;
    }
}