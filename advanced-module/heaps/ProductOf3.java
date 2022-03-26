import java.util.ArrayList;

public class ProductOf3 {
    public static void main(String args[]) {
        // int[] nums = { 10, 2, 13, 4 };
        int[] nums = { 1, 2, 3, 4, 5 };
        int[] b = maximumProduct(nums);
        System.out.println(b);
    }

    public static int[] maximumProduct(int[] nums) {
        int len = nums.length;
        int[] b = new int[len];
        ArrayList<Integer> c = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            insert(c, nums[i]);
            if (i < 2) {
                b[i] = -1;
            } else {
                int x = getMax(c);
                int y = getMax(c);
                int z = getMax(c);
                insert(c, x);
                insert(c, y);
                insert(c, z);
                b[i] = x * y * z;
            }
        }
        return b;
    }

    public static void maxHeapify(ArrayList<Integer> nums, int root) {
        int largest = root;
        int leftChild = 2 * root + 1;
        int rightChild = 2 * root + 2;
        if (leftChild < nums.size() && nums.get(leftChild) > nums.get(root)) {
            largest = leftChild;
        }
        if (rightChild < nums.size() && nums.get(rightChild) > nums.get(largest)) {
            largest = rightChild;
        }
        if (largest != root) {
            int temp = nums.get(root);
            nums.set(root, nums.get(largest));
            nums.set(largest, temp);
            maxHeapify(nums, largest);
        }
    }

    public static void insert(ArrayList<Integer> nums, int val) {
        nums.add(val);
        int i = nums.size() - 1;
        while (i > 0 && nums.get(i) > nums.get((i - 1) / 2)) {
            int temp = nums.get(i);
            int parentIndex = (i - 1) / 2;
            nums.set(i, nums.get(parentIndex));
            nums.set(parentIndex, temp);
            i = parentIndex;
        }
    }
    public static int getMax(ArrayList<Integer> nums) {
        int temp = nums.get(0);
        nums.set(0, nums.get(nums.size() - 1));
        nums.remove(nums.size() - 1);
        maxHeapify(nums, 0);
        return temp;
    }
}