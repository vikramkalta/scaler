import java.util.ArrayList;

public class MaxSumBNegations {
    public static void main(String args[]) {
        int[] arr = {24,-68,-29,-9,84};
        int B = 4;
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            A.add(arr[i]);
        }
        System.out.println(largestSumAfterKNegations(arr, B));
    }

    public static int largestSumAfterKNegations(int[] nums, int k) {
        for (int i = nums.length / 2; i >= 0; i--) {
            minHeapify(nums, i);
        }

        int i = 0;
        while(i < k) {
            extractMin(nums);
            i++;
        }
        int sum = 0;
        for (int index = 0, len = nums.length; index < len; index++) {
            int curr = nums[index];
            sum += curr;
        }
        return sum;
    }

    public static void minHeapify(int[] nums, int root) {
        int smallest = root;
        int leftChild = 2 * root + 1;
        int rightChild = 2 * root + 2;
        if (leftChild < nums.length && nums[leftChild] < nums[root]) {
            smallest = leftChild;
        }
        if (rightChild < nums.length && nums[rightChild] < nums[smallest]) {
            smallest = rightChild;
        }
        if (smallest != root) {
            int temp = nums[smallest];
            nums[smallest] = nums[root];
            nums[root] = temp;
            minHeapify(nums, smallest);
        }
    }
    public static void extractMin(int[] nums) {
        int temp = nums[0];
        temp = temp * -1;
        nums[0] = temp;
        minHeapify(nums, 0);
        return;
    }
}
