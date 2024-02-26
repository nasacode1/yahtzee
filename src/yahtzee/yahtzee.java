package yahtzee;
import java.util.*;
public class yahtzee {
	private dice die;
	

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		yahtzee game = new yahtzee();
		game.startGame(scanner);
	}
	
	public void startGame(Scanner scanner) {
		int number = 5;
		die = new dice();
		int[] finaldices = new int[number];
		int pointer = 0;
		for(int i=0; i<3;i++) {
			int[] values = die.roll(number);
			System.out.println("This is round "+ i+1);
			for(int j=0; j<number;j++) {
				System.out.println("dice " + j+1 + ": " + values[j]);
			}
			System.out.println("Enter dice number you want to retain any dices : enter 7 to stop.");
			int u=scanner.nextInt();
			while(u != 7) {
				finaldices[pointer] = values[u-1];
				pointer += 1;
				number -= 1;
				u = scanner.nextInt();
			}
		}
		//calculateScore
	}
}
