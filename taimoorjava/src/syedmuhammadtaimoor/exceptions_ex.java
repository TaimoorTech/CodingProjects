package syedmuhammadtaimoor;
import java.util.Scanner;

class invalidinput extends Exception{
    public invalidinput(){
        System.out.println("kindly, Enter the Correct Index...");
    }
}

public class exceptions_ex {

    public static void main(String[] args) throws invalidinput {
        System.out.println(8/0);
        /* Problem 2
        try{
            int c = 6/0;
        }
        catch (ArithmeticException e){
            System.out.println("HEHE");
        }
        catch (IllegalArgumentException e){
            System.out.println("HAHA");
        }
        */

        // Problem 3
        int [] arr = {88,77,66,99,55};
        int tries = 1;
        boolean flag = false;
        Scanner input = new Scanner(System.in);
        int index;
        while (true){
            try{
                System.out.println("Enter the Index of Array : ");
                index = input.nextInt();
                System.out.println(arr[index]);
                flag = true;
            }
            catch (Exception e){
                throw new invalidinput();
            }
            if (flag == true){
                System.out.println("Thanks for using this program !!!");
                break;
            }
            else if (flag == false && tries > 5){
                System.out.println("Error...");
            }
            tries++;
        }
    }
}
