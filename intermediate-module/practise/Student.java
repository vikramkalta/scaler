class GFG {
    public int roll_no;
    public String name;
    GFG(int roll_no, String name) {
        this.roll_no = roll_no;
        this.name = name;
    }
    // public static void main(String args[]) {
    //     GFG gfg = new GFG();
    //     // gfg;
    // }
}

// Elements of the array are objects of a class
public class Student {
    public static void main(String[] args)
    {
        GFG[] arr;
        arr = new GFG[5];

        arr[0] = new GFG(1, "aman");
        arr[1] = new GFG(2, "vaibhav");
        arr[2] = new GFG(3, "shikhar");

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) {
                System.out.println("Element at " + i + " : " + arr[i].roll_no + " " + arr[i].name);
            }
        }
    }
}