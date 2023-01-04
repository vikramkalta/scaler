public class DSU {
    public static int[] parent;
    public static int[] rank;
    public static void main(String[] args) {
        int[] x = {1,2,3,4};
        parent = new int[x.length];
        rank = new int[x.length];
        for (int i = 0; i < x.length; i++) {
            make_set(x[i] - 1);
            rank[i] = 0;
        }
        union_sets(x[0]-1, x[1]-1);
        union_sets(x[2]-1, x[3]-1);
        union_sets(x[1]-1, x[2]-1);
        System.out.println();
        // union_sets(0, 0);
    }
    public static void make_set(int v) {
        parent[v] = v;
    }
    public static int find_set(int v) {
        if (v == parent[v]) {
            return v;
        }
        return find_set(parent[v]);
    } 
    // public static void union_sets1(int a, int b) {
    //     a = find_set(a);
    //     b = find_set(b);
    //     if (a!=b) {
    //         parent[b] = a;
    //     }
    // }
    public static void union_sets(int a, int b) {
        a = find_set(a);
        b = find_set(b);
        if (a!=b) {
            if (rank[a] < rank[b]) {
                int temp = a;
                a = b;
                b = temp;
            }
            parent[b] = a;
            if (rank[a] == rank[b]) {
                rank[a]++;
            }
        }
    }
}