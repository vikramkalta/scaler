import java.util.ArrayList;

public class SelectionSort {
    public static void main(String args[]) {
        int[] arr = { 18468, 6335, 26501, 19170, 15725, 11479, 29359, 26963, 24465, 5706, 28146, 23282, 16828, 9962,
                492, 2996, 11943, 4828, 5437, 32392, 14605, 3903, 154, 293, 12383, 17422, 18717, 19719, 19896, 5448,
                21727, 14772, 11539, 1870, 19913, 25668, 26300, 17036, 9895, 28704, 23812, 31323, 30334, 17674, 4665,
                15142, 7712, 28254, 6869, 25548, 27645, 32663, 32758, 20038, 12860, 8724, 9742, 27530, 779, 12317,
                3036 };
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            A.add(arr[i]);
        }
        System.out.println(selectionSort(A));
    }

    public static ArrayList<Integer> selectionSort(ArrayList<Integer> A) {
        int len = A.size();

        int min = 0;
        int minIndex = 0;

        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            min = A.get(i);
            minIndex = i;
            for (int j = i; j < len; j++) {
                int curr = A.get(j);
                if (min > curr) {
                    min = curr;
                    minIndex = j;
                }
            }

            int temp = A.get(i);
            A.set(i, min);
            A.set(minIndex, temp);
            if (i < len - 1)
                result.add(minIndex);
        }

        return result;
    }
}
