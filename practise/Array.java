public class Array {
    public static void main(String args[]) {
        int n = 10;
        int[] array = new int[n];
        System.out.println("Array length " + array.length);
        for (int i = 0, len = array.length; i < len; i++) {
            array[i] = i;
        }
        for (int i = 0, len = array.length; i < len; i++) {
            System.out.println("array[i] " + array[i]);
        }


    }
}
