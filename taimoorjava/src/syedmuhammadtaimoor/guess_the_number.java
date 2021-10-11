package syedmuhammadtaimoor;
import java.util.Random;
import java.util.Scanner;

class Game{
    private int noOfGuesses;
    private int value;

    public Game() {
        Random num = new Random();
        this.value = num.nextInt(101);
    }

    public int getNoOfGuesses() {
        return noOfGuesses;
    }

    public void setNoOfGuesses(int noOfGuesses) {
        this.noOfGuesses = noOfGuesses;
    }

    public int takeUserInput(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the Number between 0 to 100 : ");
        int user_value = input.nextInt();
        this.noOfGuesses+=1;
        return user_value;
    }

    public boolean isCorrectNumber(int num){
        if (num == this.value) {
            System.out.println("Your Guess is Correct.................");
            return true;
        }
        else if (num > this.value){
            System.out.println("Your Guess is Greater.................");
            return false;
        }
        else {
            System.out.println("Your Guess is Lesser.................");
            return false;
        }
    }
}

public class guess_the_number {
    public static void main(String[] args) {
        Game guess = new Game();
        System.out.println("WELCOME TO THE GUESS THE NUMBER GAME.................");
        while (true){
            int val = guess.takeUserInput();
            boolean correct = guess.isCorrectNumber(val);
            if (correct == true){
                System.out.println("Total No of Guesses : "+guess.getNoOfGuesses());
                break;
            }
        }
    }
}
