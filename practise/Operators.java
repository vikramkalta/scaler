public class Operators {
    public static int divideNumbers(int a, int b) {
        int div = a / b;
        return div;
    }
    public static void main(String args[]) {
        int number = 0;

        if (number > 0) {
            System.out.println("The number is positive.");
        }

        else if (number < 0) {
            System.out.println("The number is negative.");
        }

        else {
            System.out.print("the number is " + number);
        }

        int n = 5;
        for (int i = 1; i <= n; ++i) {
            System.out.println(i);
        }
        
        int num1 = 25;
        int num2 = 15;
        // create an object of main
        // Operators obj = new Operators();
        int result = Operators.divideNumbers(num1, num2);
        System.out.println("Sum is: " + result);
    }
}
