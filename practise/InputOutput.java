import java.util.Scanner;

public class InputOutput {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int input1 = scanner.nextInt();
        int input2= scanner.nextInt();
        scanner.close();
        System.out.println(input1);
        System.out.println(input2);
    }
}
