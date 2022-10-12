
public class Calculate_Score {

	//Print'+' if the colour code is in right code and right position. Print '-' if the colour code is in right code but wrong position. 
	//The game will first execute all the code which are in right position to display '+' signs first.
	public static void DisplaySymbols(String GuessColour, String SecretColour) {
		if(GuessColour.charAt(0)==SecretColour.charAt(0)){
			System.out.print("+");
		}
		if(GuessColour.charAt(1)==SecretColour.charAt(1)){
			System.out.print("+");
		}
		if(GuessColour.charAt(2)==SecretColour.charAt(2)){
			System.out.print("+");
		}
		if(GuessColour.charAt(3)==SecretColour.charAt(3)){
			System.out.print("+");
		}
		if (GuessColour.charAt(0)==SecretColour.charAt(1) || GuessColour.charAt(0)==SecretColour.charAt(2) || GuessColour.charAt(0)==SecretColour.charAt(3)){
			System.out.print("-");
		}
		if(GuessColour.charAt(1)==SecretColour.charAt(0) || GuessColour.charAt(1)==SecretColour.charAt(2) || GuessColour.charAt(1)==SecretColour.charAt(3)){
			System.out.print("-");
		}
		if(GuessColour.charAt(2)==SecretColour.charAt(0) || GuessColour.charAt(2)==SecretColour.charAt(1) || GuessColour.charAt(2)==SecretColour.charAt(3)){
			System.out.print("-");
		}
		if(GuessColour.charAt(3)==SecretColour.charAt(0) || GuessColour.charAt(3)==SecretColour.charAt(1) || GuessColour.charAt(3)==SecretColour.charAt(2)){
			System.out.print("-");
		}

		System.out.println(" ");
	}

	public static void MastermindScore (String GuessColour, String SecretColour, int code_size, int guess_number, int guess_count, int score,boolean correct_code) {
		// right_p is for right colour in right position. wrong_p is for right colour is in wrong position.
		int right_p=0;
		int wrong_p=0;

		//when a right colour is in right position 1 will be added with right_p, when a right colour is in wrong position 1 will be added with wrong_p.
		//Here right_p=1, wrong_p=-1.
		if(GuessColour.charAt(0)==SecretColour.charAt(0)){
			right_p=right_p+1;
		}
		if(GuessColour.charAt(1)==SecretColour.charAt(1)){
			right_p=right_p+1;
		}
		if(GuessColour.charAt(2)==SecretColour.charAt(2)){
			right_p=right_p+1;
		}
		if(GuessColour.charAt(3)==SecretColour.charAt(3)){
			right_p=right_p+1;
		}

		if (GuessColour.charAt(0)==SecretColour.charAt(1) || GuessColour.charAt(0)==SecretColour.charAt(2) || GuessColour.charAt(0)==SecretColour.charAt(3)){
			wrong_p=wrong_p+1;
		}
		if(GuessColour.charAt(1)==SecretColour.charAt(0) || GuessColour.charAt(1)==SecretColour.charAt(2) || GuessColour.charAt(1)==SecretColour.charAt(3)){
			wrong_p=wrong_p+1;
		}
		if(GuessColour.charAt(2)==SecretColour.charAt(0) || GuessColour.charAt(2)==SecretColour.charAt(1) || GuessColour.charAt(2)==SecretColour.charAt(3)){
			wrong_p=wrong_p+1;
		}
		if(GuessColour.charAt(3)==SecretColour.charAt(0) || GuessColour.charAt(3)==SecretColour.charAt(1) || GuessColour.charAt(3)==SecretColour.charAt(2)){
			wrong_p=wrong_p+1;
		}		
		int Remaining_guesses = guess_number-guess_count;

		// Add remaining number of guesses with right_p and wrong_p for the score.
		score= (Remaining_guesses + right_p) + (- wrong_p);
		System.out.println("Your score is:" + score);
		//When the player wins the Player score is updated by adding one and the game also shows the player Vs computer score.
		//when the computer wins computer score gets updated by adding 1. 
		int player=0;
		int computer =0;
		if(correct_code) {
			player=player+1;
			System.out.println("Player score: "+ player);
		}else {
			computer=computer+1;
			System.out.println("Computer score: "+computer);
		}
		System.out.println("Player vs Computer score is: " + player +" Vs " +computer);
	}
}

