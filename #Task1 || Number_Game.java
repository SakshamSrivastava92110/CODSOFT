import java.util.Scanner;
import java.util.Random;
public class Number_Game{
    Scanner sc = new Scanner(System.in);
    Random obj = new Random();
    int Number_To_Be_Guessed;
    int Guessed_Number;
    int Number_Of_Rounds;
    Number_Game(){

        System.out.println("Welcome to the number guessing game! \nRound : 0");
        Number_To_Be_Guessed = 0;
        Guessed_Number = 0;
        Number_Of_Rounds = 0;
    }
    void play(){
        Number_To_Be_Guessed = obj.nextInt(100)+1;
        System.out.println("Guess a number between 1 and 100:");
        int n = 5;
        while (n!=0) {
            Guessed_Number = sc.nextInt();
            if (Guessed_Number == Number_To_Be_Guessed) {
                System.out.println("Congratulations, you guessed the number! , You won");
                break;
            } else if (Guessed_Number < Number_To_Be_Guessed) {
                --n;
                System.out.println("Your guess is too low.");
                System.out.println("Number of attempts left : "+n);
            } else {
                --n;
                System.out.println("Your guess is too high.");
                System.out.println("Number of attempts left : "+n);
            }
            System.out.println("Try again\n");
        }
        if(n==0)
            System.out.println("You Lose !!");
            System.out.println("Correct Number : "+Number_To_Be_Guessed);
        int flag = 0;
        System.out.println("\nDo you want to play another round ? ");
        System.out.println("Enter 1 for yes \n Any other number for no : \n");
        flag = sc.nextInt();
        if (flag==1) {
            ++Number_Of_Rounds;
            System.out.println("Round : "+Number_Of_Rounds);
            play();
        }
        else {
            if(Number_Of_Rounds <= 3 && flag == Number_Of_Rounds)
                System.out.println("Your Score is 100 , Excellent");
            else if(Number_Of_Rounds > 3 && (flag/2 >= Number_Of_Rounds/2))
                System.out.println("Your Score is 50 , Good");
            else
                System.out.println("Your Score is 0, Bad");
        }
        sc.close();
    }
    public static void main(String[] args) {
        Number_Game ng = new Number_Game();
        ng.play();
    }
}
