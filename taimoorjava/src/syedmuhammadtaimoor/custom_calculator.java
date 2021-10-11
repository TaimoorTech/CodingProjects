package syedmuhammadtaimoor;
import java.util.InputMismatchException;
import java.util.Scanner;

//class InvalidInputException extends Exception{
//    public InvalidInputException(){
//        System.out.println("InvalidInput....");
//    }
//}

class MaxInputException extends Exception{
    @Override
    public String toString(){
        return "Max Input Limit is 100000....";
    }

    @Override
    public String getMessage(){
        return "Max Input Limit is 100000....";
    }
}

class MaxMultiplierReachedException extends Exception{
    @Override
    public String toString(){
        return "Max Multiplication Limit is 7000....";
    }

    @Override
    public String getMessage(){
        return "Max Multiplication Limit is 7000....";
    }
}

public class custom_calculator {
    static Scanner input = new Scanner(System.in);

    public void Addition() throws MaxInputException{
        float num1;
        float num2;
        try {
            System.out.print("Enter Number 1 : ");
            num1 = input.nextFloat();
            if(num1 > 100000){
                throw new MaxInputException();
            }
            System.out.print("Enter Number 2 : ");
            num2 = input.nextFloat();
            if(num2 > 100000){
                throw new MaxInputException();
            }
            System.out.printf("The Addition is : %.2f.\n", num1+num2);
        }
        catch (InputMismatchException e){
            System.out.println("Invalid Input....");
        }
//        catch (MaxInputException e){
//            System.out.println(e);
//        }

    }

    public void Subtraction(){
        float num1;
        float num2;
        try {
            System.out.print("Enter Number 1 : ");
            num1 = input.nextFloat();
            if(num1 > 100000){
                throw new MaxInputException();
            }
            System.out.print("Enter Number 2 : ");
            num2 = input.nextFloat();
            if(num2 > 100000){
                throw new MaxInputException();
            }
            System.out.printf("The Subtraction is : %.2f.\n", num1-num2);
        }
        catch (InputMismatchException e){
            System.out.println("Invalid Input....");
        }
        catch (MaxInputException e){
            System.out.println(e);
        }
    }

    public void Multiplication(){
        float num1;
        float num2;
        try {
            System.out.print("Enter Number 1 : ");
            num1 = input.nextFloat();
            if(num1 > 100000){
                throw new MaxInputException();
            }
            System.out.print("Enter Number 2 : ");
            num2 = input.nextFloat();
            if(num2 > 100000){
                throw new MaxInputException();
            }
            float result = num1*num2;
            if(result>7000){
                throw new MaxMultiplierReachedException();
            }
            System.out.printf("The Multiplication is : %.2f.\n", result);
        }
        catch (InputMismatchException e){
            System.out.println("Invalid Input....");
        }
        catch (MaxInputException e){
            System.out.println(e);
        }
        catch (MaxMultiplierReachedException p) {
            System.out.println(p);
        }
    }

    public void Division(){
        float num1;
        float num2;
        try {
            System.out.print("Enter Number 1 : ");
            num1 = input.nextFloat();
            if(num1 > 100000){
                throw new MaxInputException();
            }
            System.out.print("Enter Number 2 : ");
            num2 = input.nextFloat();
            if(num2 > 100000){
                throw new MaxInputException();
            }
            else if(num2 == 0.0f){
                throw new ArithmeticException();
            }
            float result = num1/num2;
            System.out.printf("The Division is : %.2f.\n", result);
        }
        catch (ArithmeticException e){
            System.out.println("Cannot Divide by Zero....");
        }
        catch (InputMismatchException e){
            System.out.println("Invalid Input....");
        }
        catch (MaxInputException e){
            System.out.println(e);
        }

    }
    public static void main(String[] args) throws MaxInputException,MaxMultiplierReachedException {
        custom_calculator calculator = new custom_calculator();

        System.out.print("Press\n(1)Addition\n(2)Subtraction\n(3)Multiplication\n(4)Division\nYour Option : ");
        int num_input = input.nextInt();
        if (num_input == 1) {
            calculator.Addition();
        }
        else if (num_input == 2) {
            calculator.Subtraction();
        }
        else if (num_input == 3) {
            calculator.Multiplication();
        }
        else if (num_input == 4) {
            calculator.Division();
        }
        else {
            System.out.println("Kindly, Press Correct Option....");
        }
    }
}
