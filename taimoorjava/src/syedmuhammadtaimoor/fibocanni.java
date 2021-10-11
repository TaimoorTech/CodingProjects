package syedmuhammadtaimoor;
//import java.util.Arrays;
import java.util.Scanner;


public class fibocanni {
    //static int [] change(int [] lst){
        //lst[0] = 77;
        //return lst;
    
    static int calculate_fibocanni_series(int a, int b, int num, int c){
        int result;
        int check = c;
//        if(num==1 ){
//            return 0;
//        }
//        else if(num==2){
//            return 1;
//        }

        if(num==1 || num==2){
            return num-1;
        }

        else {
            int prev = a ;
            int next = b;
            result = (prev+next);
            prev = b;
            next = result;
            check+=1;
            if(check==num-1){
                return result;
            }
            else{
                return calculate_fibocanni_series(prev,next,num, check);
            }

        }
    }


    public static void main(String[] args) {
        // int [] list = {55,99,88};
        // System.out.printf("The old array is : %s.....", Arrays.toString(list));
        // int[] sc = change(list);
        // System.out.printf("\nThe changed array is : %s.....", Arrays.toString(sc));
        Scanner input = new Scanner(System.in);
        System.out.print("Which term of Fibocanni series : ");
        int num = input.nextInt();
        if (num == 1) {
            System.out.printf("The %dst term of Fibocanni series is : %d"
                    , num, calculate_fibocanni_series(0, 1, num, 1));
        }
        else if (num == 2) {
            System.out.printf("The %dnd term of Fibocanni series is : %d"
                    , num, calculate_fibocanni_series(0, 1, num, 1));
        }
        else if (num == 3) {
            System.out.printf("The %drd term of Fibocanni series is : %d"
                    , num, calculate_fibocanni_series(0, 1, num, 1));
        }
        else if (num > 3) {
            System.out.printf("The %dth term of Fibocanni series is : %d"
                    , num, calculate_fibocanni_series(0, 1, num, 1));
        }

    }
}
