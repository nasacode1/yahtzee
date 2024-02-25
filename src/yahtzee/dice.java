package yahtzee;
import java.util.*;

public class dice {
	public int[] roll(int number){
		Random random = new Random();
	
		int[] values = new int[number];
		for(int i=0;i<number;i++) {
			values[i] = random.nextInt(6) + 1;
		}
		return values;
	}

}
