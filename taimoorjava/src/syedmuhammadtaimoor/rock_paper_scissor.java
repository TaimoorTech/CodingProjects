package syedmuhammadtaimoor;
import java.util.Random;
import java.util.Scanner;


public class rock_paper_scissor {
    public static void main(String[] args){
        int computer_score = 0;
        int user_score = 0;
        int user_value = 1;
        int computer_value;
        Random val = new Random();
        Scanner input = new Scanner(System.in);
        System.out.print("WELCOME TO THE ROCK PAPER SCISSOR GAME SHOW\nNow let's see\nWill you win against the " +
                "Computer....\nRemember: The Default choosen is Rock\n" +
                "The Options are:\n(1)Press R for Rock\n(2)Press S for Scissor\n(3)Press P for Paper\n");
        for (int i = 1; i < 6; i++) {
            System.out.println("-----------------");
            System.out.printf("Round %d : \n", i);
            System.out.println("-----------------");
            computer_value = val.nextInt(1,4);
            System.out.print("Your Turn : ");
            String user_input = input.next();
            switch (user_input){
                case "R" -> user_value = 1;
                case "S" -> user_value = 2;
                case "P" -> user_value = 3;
            }
            if(computer_value==1 && user_value==2){
                System.out.println("Computer wins this Round!!!");
                computer_score+=1;
                System.out.printf("Computer Score : %d \n", computer_score);
                System.out.printf("User Score : %d \n", user_score);
            }
            else if(computer_value==2 && user_value==3){
                System.out.println("Computer wins this Round!!!");
                computer_score+=1;
                System.out.printf("Computer Score : %d \n", computer_score);
                System.out.printf("User Score : %d\n", user_score);
            }
            else if(computer_value==3 && user_value==1){
                System.out.println("Computer wins this Round!!!");
                computer_score+=1;
                System.out.printf("Computer Score : %d\n", computer_score);
                System.out.printf("User Score : %d\n", user_score);
            }
            else if(computer_value==2 && user_value==1){
                System.out.println("User wins this Round!!!");
                user_score+=1;
                System.out.printf("Computer Score : %d\n", computer_score);
                System.out.printf("User Score : %d\n", user_score);
            }
            else if(computer_value==3 && user_value==2){
                System.out.println("User wins this Round!!!");
                user_score+=1;
                System.out.printf("Computer Score : %d\n", computer_score);
                System.out.printf("User Score : %d\n", user_score);
            }
            else if(computer_value==1 && user_value==3){
                System.out.println("User wins this Round!!!");
                user_score+=1;
                System.out.printf("Computer Score : %d\n", computer_score);
                System.out.printf("User Score : %d\n", user_score);
            }
            else if(computer_value == user_value){
                System.out.println("No win this Round!!!");
                System.out.printf("Computer Score : %d\n", computer_score);
                System.out.printf("User Score : %d\n", user_score);
            }
        }
        if(user_score>computer_score){
            System.out.println("The Winner is User......");
        }
        else if(user_score<computer_score){
            System.out.println("The Winner is Computer......");
        }
        else{
            System.out.println("No one wins......");
        }
    }
}
