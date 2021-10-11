package syedmuhammadtaimoor;

public class java_methods_Ex {

    // PROBLEM 2
     static void print_pattern(int n){
         for (int i = 1; i <= n; i++) {
             System.out.println("* ".repeat(i));
         }
     }

     // PROBLEM 3
     static int recursive(int n){
         if (n == 0){
             return 0;
         }
         return n + recursive(n-1);
     }

     // PROBLEM 4
    static String print_reverse_pattern(int n){
        for (int i = n; i > 0; i--) {
            System.out.println("* ".repeat(i));
        }
        return null;
    }

    // PROBLEM 8
    static String print_recursive_pattern(int n) {
         if (n==0) {
            return " ";
        }
        else {
            return "* ".repeat(n) + "\n" + print_recursive_pattern(n - 1);
        }
    }

    public static void main(String[] args) {
        // print_pattern(4);
        // print_reverse_pattern(4);
        // System.out.println(recursive(4));
        System.out.println(print_recursive_pattern(4));
     }

}
