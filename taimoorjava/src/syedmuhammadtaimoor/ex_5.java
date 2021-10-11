package syedmuhammadtaimoor;
import java.util.Scanner;


public class ex_5 {
    public static void main(String[] args) {
        // PRACTICE PROBLEM 1
//        String str = "*";
//        Scanner input = new Scanner(System.in);
//        int num = input.nextInt();
//        for (int i = num; i > 0 ; i--) {
//            System.out.println(str.repeat(i));
//        }

        // PRACTICE PROBLEM 2
//        Scanner input = new Scanner(System.in);
//        System.out.print("How much Even numbers you want the sum of : ");
//        int num = input.nextInt();
//        int sum = 0;
//        int start = 0;
//        int even;
//        while (start<num){
//            even = 2*start;
//            sum+=even;
//            start++;
//        }
//        System.out.printf("Sum of First %d Even Numbers is %d....", num, sum);

        // PRACTICE PROBLEM 4
//        Scanner input = new Scanner(System.in);
//        System.out.print("Which Number Table you want : ");
//        int num = input.nextInt();
//        for (int i = 10; i > 0; i--) {
//            System.out.printf("%d x %d : %d \n",num, i, num*i);
//        }

        // PRACTICE PROBLEM 6
//        Scanner input = new Scanner(System.in);
//        System.out.print("Factorial of which number do you want : ");
//        int num = input.nextInt();
//        int fact=1;
//        int range=1;
//        while (range<=num){
//            fact*=range;
//            range++;
//        }
//        System.out.printf("Factorial of %d is %d...", num, fact);
//    }
        // PRACTICE PROBLEM 9
        int end = 10;
        int num = 8;
        int sum = 0;
        for (int i = 1; i <= end; i++) {
            sum += (num * i);
        }
        System.out.print("Sum of Table of 8 : ");
        System.out.println(sum);
    }
}