import java.util.ArrayList;

public class MagicianAndChocolates {
    public static void main(String args[]) {
        int[] arr = { 2, 4, 6, 8, 10 };
        // int[] arr = { 6, 5 };
        ArrayList<Integer> B = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            B.add(arr[i]);
        }
        // System.out.println(nchoc(5, B));
        System.out.println(nchoc(3, B));
    }

    public static int nchoc(int A, ArrayList<Integer> B) {
        for (int i = (B.size() - 1) / 2; i >= 0; i--) {
            maxHeapify(B, i);
        }
        long mod = 1000000007l;
        int i = 0;
        long sum = 0l;
        while (i < A) {
            int max = extractMax(B);
            sum = sum + (1l * max);
            sum = sum % mod;
            int magicNum = (max / 2);
            insert(B, magicNum);
            i++;
        }
        if (sum < 0) {
            sum += mod;
        }
        return (int)sum;
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

    public static int extractMax(ArrayList<Integer> nums) {
        int temp = nums.get(0);
        nums.set(0, nums.get(nums.size() - 1));
        nums.remove(nums.size() - 1);
        maxHeapify(nums, 0);
        return temp;
    }

    public static void insert(ArrayList<Integer> nums, int val) {
        nums.add(val);
        int i = nums.size() - 1;
        while (i > 0 && nums.get((i - 1) / 2) < nums.get(i)) {
            int parentIndex = (i - 1) / 2;
            int temp = nums.get(i);
            nums.set(i, nums.get(parentIndex));
            nums.set(parentIndex, temp);
            i = parentIndex;
        }
    }
}
