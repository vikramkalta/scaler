import java.util.ArrayList;
import java.util.HashMap;

public class BClosestPoints {
    public static void main(String args[]) {
        // int[][] a = { { 1, 3 }, { -2, 2 } };
        int[][] a = { { -1062, 849 }, { 824, -1083 }, { -742, 834 }, { 813, -782 }, { -978, 976 }, { -177, 115 },
                { 476, -232 }, { -72, 138 }, { 411, -58 }, { -162, 354 }, { 426, -27 }, { -209, 33 }, { 306, -46 },
                { -271, 201 }, { 212, -158 }, { -336, 9 }, { 461, -71 }, { -40, 423 }, { 205, -416 }, { -308, 193 },
                { 278, -161 }, { -340, 66 }, { 122, -263 }, { -18, 492 }, { 392, -213 }, { -343, 396 }, { 250, -430 },
                { -75, 429 }, { 272, -488 }, { -497, 345 }, { 358, -357 }, { -244, 6 }, { 57, -122 }, { -415, 142 },
                { 336, -273 }, { -75, 101 }, { 291, -371 }, { -37, 113 }, { 160, -455 }, { -233, 231 }, { 372, -348 },
                { -500, 495 }, { 20, -471 }, { -447, 151 }, { 180, -425 }, { -358, 342 }, { 252, -120 }, { -484, 301 },
                { 376, -198 }, { -198, 286 }, { 328, -498 }, { -205, 120 }, { 336, -90 }, { -201, 406 }, { 249, -203 },
                { -257, 59 }, { 190, -492 }, { -361, 13 }, { 455, -129 }, { -483, 255 }, { 493, -420 }, { -211, 256 },
                { 450, -31 }, { -337, 21 }, { 397, -387 }, { -21, 208 }, { 288, -273 }, { -45, 118 }, { 111, -380 },
                { -253, 385 }, { 328, -420 }, { -58, 190 }, { 231, -233 }, { -391, 412 }, { 434, -115 }, { -180, 59 },
                { 381, -488 }, { -200, 392 }, { 386, -478 }, { -230, 309 }, { 49, -95 }, { -343, 406 }, { 28, -377 },
                { -480, 84 }, { 103, -21 }, };

        int[][] t = new int[2][2];
        t[0] = new int[]{1,2};

        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            ArrayList<Integer> innerList = new ArrayList<>();
            innerList.add(a[i][0]);
            innerList.add(a[i][1]);
            A.add(innerList);
        }
        int B = 1;
        // System.out.println(solve(A, B));
        System.out.println(solve(A, 80));
    }

    public static ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A, int B) {
        int len = A.size();
        HashMap<Integer, ArrayList<ArrayList<Integer>>> distMap = new HashMap<>();
        ArrayList<Integer> heap = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            int dist = getDist(A.get(i));
            ArrayList<ArrayList<Integer>> distList = new ArrayList<>();
    
            if (distMap.containsKey(dist)) {
                distList = distMap.get(dist);
                distList.add(A.get(i));
            } else {
                distList.add(A.get(i));
            }
            distMap.put(dist, distList);
            heap.add(dist);
        }
        for (int i = (len - 2) / 2; i >= 0; i--) {
            minHeapify(heap, i);
        }
        int i = 0;
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        while (i < B) {
            int min = extractMin(heap);
            ArrayList<ArrayList<Integer>> mappedList = distMap.get(min);
            ans.add(mappedList.get(mappedList.size() - 1));
            mappedList.remove(mappedList.size() - 1);
            if (mappedList.size() == 0) {
                distMap.remove(min);
            } else {
                distMap.put(min, mappedList);
            }
            i++;
        }
        return ans;
    }

    public static int getDist(ArrayList<Integer> A) {
        int x = A.get(0);
        int y = A.get(1);
        int x1 = 0 - x;
        int y1 = 0 - y;
        int x1Sqr = x1 * x1;
        int y1Sqr = y1 * y1;
        return x1Sqr + y1Sqr;
    }

    public static void minHeapify(ArrayList<Integer> A, int root) {
        int smallest = root;
        int leftChild = 2 * root + 1;
        int rightChild = 2 * root + 2;
        int len = A.size();
        if (leftChild < len && A.get(leftChild) < A.get(root)) {
            smallest = leftChild;
        }
        if (rightChild < len && A.get(rightChild) < A.get(smallest)) {
            smallest = rightChild;
        }
        if (smallest != root) {
            int temp = A.get(smallest);
            A.set(smallest, A.get(root));
            A.set(root, temp);
            minHeapify(A, smallest);
        }
    }

    public static int extractMin(ArrayList<Integer> A) {
        int smallest = A.get(0);
        A.set(0, A.get(A.size() - 1));
        A.remove(A.size() - 1);
        minHeapify(A, 0);
        return smallest;
    }
}