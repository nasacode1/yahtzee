package yahtzee;
import java.util.*;
import java.lang.*;

public class yahtzee {
	private dice die;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		yahtzee game = new yahtzee();
		game.startGame(scanner);
	}
	
	public void startGame(Scanner scanner) {
		System.out.println("How many player game do you want to play?");
		int playerCount = scanner.nextInt();
		player[] players = new player[playerCount];
		System.out.println("Enter each player's name");
		for(int i=0;i<playerCount;i++) {
			System.out.println("Player "+ (i+1) + " :");
			players[i] = new player();
			players[i].setName(scanner.next());
		}
		
		for(int q=0; q<13;q++) {
			
			for(player p:players) {
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
					if(i == 2) {
						for(int value:values) {
							finaldices[pointer] = value;
							pointer += 1;
						}
					}
					else {
					System.out.println("Enter dice number you want to retain any dices : enter 7 to stop.");
					int u=scanner.nextInt();
					while(u != 7) {
						finaldices[pointer] = values[u-1];
						pointer += 1;
						number -= 1;
						u = scanner.nextInt();
					}
				}
				}
				p.calculateScore(finaldices, scanner);
			}
		}
		int maxi = 0;
		String winner="";
		for(player p: players) {
			if (p.getScore() > maxi) {
				winner = p.getName();
				maxi = p.getScore();
			}
		}
		System.out.println("The winner is "+ winner + " with a score of "+ maxi);
		
	}
}
					