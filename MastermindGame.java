import java.util.Scanner;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
public class MastermindGame{

	public static void main(String[] args) {
		//Initialise the variables
		int guess_number=0;
		int colour_range=0;
		int code_size= 0;
		String SecretColour =" ";
		String GuessColour = "";
		int guess_count=0;
		int score=0;
		boolean correct_code =true;
		boolean play_again= true;
		/*do while loop for playing again.do while loop starts at the very beginning and ends at the end of the game to ensure that all the codes
        are executed again if the player wants to play again*/
		do{ 
			Scanner scan = new Scanner (System.in);
			System.out.println("Welcome to my Mastermind Game!");
			System.out.println("The colour code is formed by using the first letters of the colours.The colours are: ");
			System.out.println("R=Red, G=Green, B=Blue, Y=Yellow, O=Orange, V=Violet, W=White, P=Pink, M=Magenta, J=Jade");
			//player can start the game, see instructions and exit game. Player can start the game after executing the instructions.  
			System.out.println("Press 0 to Start the game!");
			System.out.println("Press 1 for instructions.");
			System.out.println("Press 2 for exit the game.");
			int welcome_page = scan.nextInt();
			if(welcome_page == 0){
				System.out.println("Game started!");
			}
			else{
				if(welcome_page== 1) {
					System.out.println("1.The range of colour code should be six to ten.If the colour range is 6 you should use first six colours.");
					System.out.println("2.You can choose colour code size 3 or 4.");
					System.out.println( "4.The maximum number of guesses must be 12 or less.");
					System.out.println("3.Enter your guess as a String. Use Capital letters for the colour code. Error massage will be shown for wrong inputs.");
				}
				else if(welcome_page == 2) {
					System.out.println(" Game Terminated!");
					System.exit(0);
				}
				else {
					System.out.println("Sorry, Invalid input!");
					System.exit(0);
				}
				System.out.println("Press 0 to Start the Game!");
				welcome_page = scan.nextInt();
				System.out.println("Game started!");
			}
			// "Sorry, Invalid input!" will be displayed and the game will be terminated for any wrong input.
			//Player can choose the maximum number of guesses but that should not be greater than 12.

			System.out.println("Enter the number of guess: ");
			guess_number = scan.nextInt();
			if(guess_number <= 12) {
				System.out.println(" ");
			}
			else {
				System.out.println("Sorry, Invalid input!");
				System.exit(0);
			}
			// The range of colour code should be minimum six and maximum ten.
			System.out.println("Enter the range of colour code: ");
			colour_range = scan.nextInt();
			if(colour_range >= 6  && colour_range <=10) {
				System.out.println(" ");
			}
			else {
				System.out.println("Invalid Input!");
				System.exit(0);
			}
			//player can choose 3 or 4 as colour size.
			System.out.println("Enter the size of colour code: ");
			code_size = scan.nextInt();
			if(code_size== 3  || code_size == 4) {
				System.out.println(" ");
			}
			else {
				System.out.println("Invalid input!");
				System.exit(0);
			}
			//Computer generates a random colour code .
			//The code is generated as ArrayList. Then it is converted into set for avoiding repeated colours.At last it is converted into a String.

			Set<String> colour_set = new HashSet<String>();
			while(colour_set.size()<code_size) {
				colour_set= new HashSet<String>();
				ArrayList<String> colours;
				colours =  new ArrayList <String>();
				Random RanColour = new Random();
				for (int k= 0; k <code_size; k++) {
					int ColourNo = RanColour.nextInt(colour_range) ;

					if (ColourNo == 1) {
						colours.add("R");
					}
					else if (ColourNo == 2) {
						colours.add("G");
					}
					else if (ColourNo == 3) {
						colours.add("B");
					}
					else if (ColourNo == 4) {
						colours.add("Y");
					}
					else if(ColourNo == 5) {
						colours.add("W");
					}
					else if(ColourNo ==6) {
						colours.add("M");
					}
					else if(ColourNo ==7) {
						colours.add("V");
					}
					else if(ColourNo ==8) {
						colours.add("P");
					}
					else if(ColourNo==9) {
						colours.add("O");
					}
					else if(ColourNo==10) {
						colours.add("J");
					}
					colour_set.addAll(colours);
					if( colour_set.size()==code_size ) {

						SecretColour = String.join ("", colour_set);
					}
				}
			}
			//Player enters guess as String. Player enters the guess until reaches the maximum number of guesses or the correct code.
			//If the guess is correct while loop will break and show the winning massage.

			while (guess_count<guess_number ) {
				Scanner Scan = new Scanner(System.in);
				System.out.println("Enter your guess : ");
				GuessColour= Scan.nextLine();
				guess_count++;
				Calculate_Score.DisplaySymbols(GuessColour, SecretColour);
				correct_code = GuessColour.equals(SecretColour); 
				if(correct_code) {
					System.out.println("Congratulations! You have won!!!");
					break;}
				else {
					continue;}
			}
			//If the guesses are not correct and the player reaches the maximum number of guesses the game will display a losing massage and reveal the secret code. 
			if(guess_count==guess_number && !correct_code ) {
				System.out.println("You have lost!!!");
				System.out.println("The secret colour code is: "+ SecretColour);
			}
			//Prints all the scores.
			Calculate_Score.MastermindScore(GuessColour, SecretColour, code_size, guess_number, guess_count, score, correct_code);
			//The player must enter Y or y for playing again .The game will be terminated for any other input.
			Scanner SCan = new Scanner (System.in);
			System.out.println ("Do you want to Play again? Y=Yes or N=No ");
			String yn= SCan.nextLine();

			if (yn.equals("Y")||yn.equals("y"))
			{
				play_again=true;
			}
			else
			{
				play_again=false;
				System.exit(0);
			}
		}while (play_again=true);
	}
}



