import java.util.Scanner;

public class stream {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        String userString = scanner.next();
        int userInt = scanner.nextInt();
        scanner.close();
        System.out.println("myString is: " + userString);
        System.out.println("myInt is: " + userInt);
    }
}