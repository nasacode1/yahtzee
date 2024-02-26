package yahtzee;
import java.util.*;
public class player {
	private int currScore;
	private String nickname;

	public void setName(String nickname) {
		this.nickname = nickname;
	}
	
	public String getName() {
		return this.nickname;
	}
	
	public player(){
		this.currScore = 0;
	}
	
	public int totalDices(int[] values) {
		int total= 0;
		for(int value: values) {
			total += value;
		}
		return total;
	}
	
	public boolean verifyCount(int[] values, int reqCount, int num) {
		int countTrack = 0;
		for(int value:values) {
			if(value == num) {
				countTrack += 1;
			}
		}
		return (countTrack == reqCount) ? true: false;
	}
	
	public boolean hasSequence(int[] values, int length) {
		int pointer = 0;
		int countTrack = 0;
		Arrays.sort(values);
		int prev = values[0];
		while(pointer < 5) {
			if(values[pointer]-values[prev] > 1) {
				countTrack = 0;
			}
			countTrack += 1;
			prev = pointer;
			pointer += 1;
		}
		return (countTrack == length) ? true:false;
		
	}
	
	public int getScore() {
		return this.currScore;
	}
	
	
	public void calculateScore(int[] values, Scanner scanner) {
		System.out.println("Enter which category to calculate score in:");
		System.out.println("1. Aces\n2. Twos\n3. Threes\n4. Fours\n5. Fives\n6. Sixes\n7.3 of a kind\n8.4 of a kind\n9. Full house\n10. Small straight\n11.Large straight\n12. Yahtzee\n13. Chance");
		int category = scanner.nextInt();
		if(category < 7) {
			for(int value:values) {
				if(value == category) {
					this.currScore += value;
				}
			}
		}
		switch(category) {
		case 7:
			System.out.println("Enter which number comes 3 of a kind");
			int n1 = scanner.nextInt();
			if(verifyCount(values, 3, n1)) {
				this.currScore += totalDices(values);
			}
			else {
				System.out.println("You dont fit in category "+ category);
			}
		case 8:
			System.out.println("Enter which number comes 4 of a kind");
			int n2 = scanner.nextInt();
			if(verifyCount(values, 4, n2)) {
				this.currScore += totalDices(values);
			}
			else {
				System.out.println("You dont fit in category "+ category);
			}
		case 9:
			System.out.println("This is full-house, ie, both 3 of a number and 2 of another number");
			System.out.println("Enter which is 3 of a kind");
			int n3= scanner.nextInt();
			System.out.println("Enter which is 2 of a kind");
			int n4= scanner.nextInt();
			if(verifyCount(values, 3, n3) && verifyCount(values, 2, n4)) {
				this.currScore +=25;
			}
		case 10:
			System.out.println("This is small straight, ie, sequence of 4 continuous numbers");
			this.currScore += (hasSequence(values, 4)) ? 30: 0;

		case 11:
			System.out.println("This is small straight, ie, sequence of 4 continuous numbers");
			this.currScore += (hasSequence(values, 5)) ? 40: 0;
		
		case 12: 
			System.out.println("This is yahtzee");
			System.out.println("Enter which number occurs in a count of 5.");
			int n8 = scanner.nextInt();
			this.currScore += (verifyCount(values, 5, n8)) ? 50:0;

	}
		
}
}
