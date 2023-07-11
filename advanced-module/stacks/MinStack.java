// import java.util.Stack;

public class MinStack {
    public static void main(String[] args) {
        // push(1);
        // push(2);
        // push(-2);
        // System.out.println(getMin());
        // pop();
        // System.out.println(getMin());
        // top();
        // push(2);
        // // System.out.println(getMin());
        // pop();
        // // System.out.println(getMin());
        // pop();
        push(1);
        // pop();
        System.out.println(getMin());
        push(3);
        System.out.println(getMin());
        push(-2);
        System.out.println(getMin());
        pop();
        push(4);
        System.out.println(getMin());
    }
    static public class Pair {
        int v = 0;
        int m = 0;
        Pair(int v, int m) {
            this.v = v;
            this.m = m;
        }
    }
    public static int maxLen = 10000000;
    static public class Stack {
        int top = -1;
        int len = 0;
        Pair[] stack;
        Stack(int n) {
            len = n;
            stack = new Pair[n];
        }
        public void push(Pair p) {
            if (isFull()) {
                return;
            }
            top++;
            stack[top] = p;
        }
        public Pair pop() {
            if (isEmpty()) {
                return null;
            }
            Pair temp = stack[top];
            top--;
            return temp;
        }
        public Pair peek() {
            if (isEmpty()) {
                return new Pair(-1, -1);
            }
            return stack[top];
        }
        public boolean isEmpty() {
            return top == -1;
        }
        public boolean isFull() {
            return top == maxLen;
        }
    }

    static Stack stack = new Stack(maxLen);
    public static void push(int x) {
        if (stack.isEmpty()) {
            stack.push(new Pair(x, x));
        } else {
            int min = stack.peek().m;
            if (x < min) {
                min = x;
            }
            stack.push(new Pair(x, min));
        }
    }

    public static void pop() {
        stack.pop();
    }

    public static int top() {
        return stack.peek().v;
    }

    public static int getMin() {
        if (stack.isEmpty()) {
            return -1;
        } else {
            return stack.peek().m;
        }
    }
}