import java.util.ArrayList;

public class Passing {
    public static void main(String args[]) {
        int[] arr = {86, 63, 60, 0, 47, 0, 99, 9, 0, 0};
        ArrayList<Integer>C=new ArrayList<>();
        for (int i = 0; i <arr.length; i++)C.add(arr[i]);
        System.out.println(solve(10, 23, C));
    } 

    public static int solve(int A, int B, ArrayList<Integer>C) {
        Stack s = new Stack(A+1);
        s.push(B);
        int len = C.size();
        for (int i = 0; i < len; i++) {
            int curr = C.get(i);
            if (curr!=0) {
                s.push(curr);
            }else{
                s.pop();
            }
        }
        return s.top();
    }
}

class Stack {
    int top = -1;
    int[] stack;
    Stack(int n) {
        stack = new int[n];
    }
    public void push(int n) {
        top++;
        stack[top]=n;
    }
    public int pop() {
        int temp = stack[top];
        top--;
        return temp;
    }
    public int top() {
        return stack[top];
    }
}