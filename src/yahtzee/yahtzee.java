package yahtzee;
import java.util.*;
public class yahtzee {
	private dice die;
	

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		yahtzee game = new yahtzee();
		game.startGame();
	}
	
	public void startGame() {
		int number = 5;
		die = new dice();
		for(int i=0; i<3;i++) {
			die.roll(number);
		}
		
		
	}

}
