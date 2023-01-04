import java.util.ArrayList;
import java.util.HashMap;

public class EdgeInMST {
    public static void main(String args[]) {
        // int A = 3;
        // int[][] B = {
        // { 1, 2, 2 },
        // { 1, 3, 2 },
        // { 2, 3, 3 } };
        // int A = 7;
        // int[][] B = {
        //         { 1, 2, 468 },
        //         { 2, 3, 335 },
        //         { 3, 1, 501 },
        //         { 2, 4, 170 },
        //         { 2, 5, 725 },
        //         { 2, 7, 479 },
        //         { 4, 6, 359 },
        //         { 5, 6, 963 } };
        // int A = 2;
        // int[][] B = {{1, 2, 42}};
        int A = 52;
        int[][] B = {
          {44, 50, 42},
          {23, 26, 468},
          {20, 45, 335},
          {4, 26, 501},
          {12, 33, 170},
          {9, 41, 725},
          {30, 51, 479},
          {2, 26, 359},
          {2, 23, 963},
          {16, 18, 465},
          {32, 51, 706},
          {30, 49, 146},
          {46, 52, 282},
          {13, 31, 828},
          {2, 37, 962},
          {11, 44, 492},
          {22, 23, 996},
          {31, 40, 943},
          {1, 5, 828},
          {13, 44, 437},
          {6, 13, 392},
          {23, 37, 605},
          {29, 37, 903},
          {8, 43, 154},
          {13, 37, 293},
          {30, 36, 383},
          {11, 39, 422},
          {11, 42, 717},
          {29, 32, 719},
          {28, 32, 896},
          {26, 37, 448},
          {28, 45, 727},
          {7, 31, 772},
          {15, 46, 539},
          {31, 51, 870},
          {15, 19, 913},
          {22, 36, 668},
          {6, 47, 300},
          {10, 48, 36},
          {19, 27, 895},
          {2, 19, 704},
          {11, 40, 812},
          {33, 35, 323},
          {8, 38, 334},
          {38, 43, 674},
          {3, 36, 665},
          {1, 16, 142},
          {22, 32, 712},
          {18, 20, 254},
          {31, 43, 869},
          {18, 44, 548},
          {5, 33, 645},
          {21, 42, 663},
          {17, 29, 758},
          {2, 51, 38},
          {12, 19, 860},
          {13, 47, 724},
          {18, 38, 742},
          {22, 27, 530},
          {15, 21, 779},
          {10, 31, 317},
          {16, 20, 36},
          {44, 45, 191},
          {2, 11, 843},
          {7, 36, 289},
          {8, 47, 107},
          {25, 38, 41},
          {10, 36, 943},
          {1, 41, 265},
          {5, 49, 649},
          {11, 38, 447},
          {32, 40, 806},
          {32, 37, 891},
          {17, 45, 730},
          {6, 37, 371},
          {2, 10, 351},
          {13, 48, 7},
          {3, 26, 102},
          {5, 9, 394},
          {43, 50, 549},
          {17, 52, 630},
          {2, 42, 624},
          {10, 27, 85},
          {24, 37, 955},
          {37, 51, 757},
          {10, 29, 841},
          {24, 46, 967},
          {38, 46, 377},
          {46, 51, 932},
          {14, 44, 309},
          {6, 39, 945},
          {31, 35, 440},
          {39, 41, 627},
          {2, 15, 324},
          {3, 13, 538},
          {16, 27, 539},
          {20, 23, 119},
          {16, 28, 83},
          {12, 20, 930},
          {3, 4, 542},
          {26, 35, 834},
          {12, 50, 116},
          {35, 41, 640},
          {21, 30, 659},
          {27, 52, 705},
          {2, 45, 931},
          {23, 45, 978},
          {14, 51, 307},
        };
        System.out.println(solve(A, B));
    }

    public static int[] solve(int A, int[][] B) {
        int len = B.length;
        int[] result = new int[len];
        int[][] matrix = new int[A][A];
        for (int i = 0; i < len; i++) {
            int vertex = B[i][0] - 1;
            int edge = B[i][1] - 1;
            int weight = B[i][2];
            matrix[vertex][edge] = weight;
            matrix[edge][vertex] = weight;
        }
        int[] visited = new int[A];
        int[] key = new int[A];
        int[] parent = new int[A];
        for (int i = 0; i < key.length; i++) {
            key[i] = Integer.MAX_VALUE;
            parent[i] = -1;
        }

        ArrayList<int[]> heap = new ArrayList<>();
        insert(heap, new int[] { 0, 0 });
        key[0] = 0;
        parent[0] = 0;
        while (heap.size() > 0) {
            int[] min = remove(heap);
            visited[min[1]] = 1;

            for (int i = 0; i < A; i++) {
                int weight = matrix[min[1]][i];
                if (visited[i] == 0 && weight != 0) {
                    if (weight < key[i]) {
                        key[i] = weight;
                        parent[i] = min[1];
                        insert(heap, new int[] { weight, i });
                    }
                }
            }
        }

        for (int i = 0; i < B.length; i++) {
            int edge = B[i][0] - 1;
            int vertex = B[i][1] - 1;
            if (key[edge] != Integer.MAX_VALUE && parent[edge] == vertex) {
                result[i] = 1;
            } else if (key[vertex] != Integer.MAX_VALUE && parent[vertex] == edge) {
                result[i] = 1;
            }
        }
        return result;
    }

    public static void minHeap(ArrayList<int[]> heap, int root) {
        int x = root;
        int leftChild = 2 * root + 1;
        int rightChild = 2 * root + 2;
        if (leftChild < heap.size() && heap.get(leftChild)[0] < heap.get(root)[0]) {
            root = leftChild;
        }
        if (rightChild < heap.size() && heap.get(rightChild)[0] < heap.get(root)[0]) {
            root = rightChild;
        }
        if (x != root) {
            int[] temp = heap.get(root);
            heap.set(root, heap.get(x));
            heap.set(x, temp);
            minHeap(heap, root);
        }
    }

    public static void insert(ArrayList<int[]> heap, int[] val) {
        heap.add(val);
        int parent = (heap.size() - 1) / 2;
        int child = heap.size() - 1;
        while (parent > 0) {
            if (heap.get(parent)[0] > heap.get(child)[0]) {
                int[] temp = heap.get(parent);
                heap.set(parent, heap.get(child));
                heap.set(child, temp);
            }
            child = parent;
            parent = parent / 2;
        }
    }

    public static int[] remove(ArrayList<int[]> heap) {
        int[] x = heap.get(0);
        int[] last = heap.get(heap.size() - 1);
        heap.set(0, last);
        heap.remove(heap.size() - 1);
        minHeap(heap, 0);
        return x;
    }
}