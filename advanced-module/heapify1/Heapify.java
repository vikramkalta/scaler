import java.util.ArrayList;

public class Heapify {
    public static void main(String args[]) {
        ArrayList<Integer> array = new ArrayList<>();
        int size = array.size();

        Heapify h = new Heapify();
        h.insert(array, 3);
        h.insert(array, 4);
        h.insert(array, 9);
        h.insert(array, 5);
        h.insert(array, 2);

        System.out.println("Max-Heap array: ");
        h.printArray(array, size);
    }

    void printArray(ArrayList<Integer> array, int size) {
        for (Integer i : array) {
            System.out.println(i + " ");
        }
        System.out.println();
    }

    void insert(ArrayList<Integer> hT, int newNum) {
        int size = hT.size();
        if (size == 0) {
            hT.add(newNum);
        } else {
            hT.add(newNum);
            for (int i = size / 2 - 1; i >= 0; i--) {
                heapify(hT, i);
            }
        }
    }

    void heapify(ArrayList<Integer> hT, int i) {
        int size = hT.size();
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        if (l < size && hT.get(l) > hT.get(largest)){
            largest = l;
        }
        if (r < size && hT.get(r) > hT.get(largest)) {
            largest = r;
        }
        if (largest != i) {
            int temp = hT.get(largest);
            hT.set(largest, hT.get(i));
            hT.set(i, temp);
            
            heapify(hT, largest);
        }
    }
}
