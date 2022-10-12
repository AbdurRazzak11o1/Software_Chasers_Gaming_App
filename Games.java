import java.util.Scanner;

public class Games {
	public static void main(String[] args) {

System.out.println("Welcome to Software Chasers Games!");
System.out.println("Press 1 to play Mastermind game!");
System.out.println("Press 2 to play Hangman game!");
System.out.println("Press 3 to play BattleShip game!");
System.out.println("Press 4 to play SnakeAndLadder game!");
Scanner scan = new Scanner (System.in);
int game_page = scan.nextInt();

if(game_page==1) {
	MastermindGame.main(args); 
}
if (game_page==2) {	
	HangmanGame.main(args);
}
if(game_page==3) {
	BattleShipGame.main(args);
}
if(game_page==4) {
	SnakesAndLadder.main(args);
}
else {
	System.out.println("Invalid Input!Please enter your choice again.");
	Scanner Scan = new Scanner (System.in);
	int game = Scan.nextInt();
	if(game==1) {
		MastermindGame.main(args); 
	}
	if (game==2) {	
		HangmanGame.main(args);
	}
	if(game==3) {
		BattleShipGame.main(args);
	}
	if(game==4) {
		SnakesAndLadder.main(args);
	}

}

}
	}
