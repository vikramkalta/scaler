import java.util.ArrayList;

public class SquareGranites {
    public static void main(String args[]) {
        // System.out.println(squareGranites(6, 6, 4));
        System.out.println(squareGranites(766, 970, 766));
    }

    public static int squareGranites(int A, int B, int C) {
        int rows = A % C != 0 ? A/C+1 : A/C;
        int cols = B % C != 0 ? B/C+1 : B /C;
        return rows * cols;
    }
}
