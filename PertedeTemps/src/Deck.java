//Liam Houghton hough084x500
import java.util.Random;

public class Deck{
	private Card [] card;
	int suit = 0;
	int rank = 0;
	int count = 0;
	public Deck() {
		card = new Card[52];
		for(int i = 0; i < card.length; i++) {
			count++;
			card[i] = new Card(rank, suit);
			rank++;
			if(rank > 12) {
				rank = 0;
				suit++;
			}
			
		}
		count = count - 1;
		
	}
	
	public Card deal() {
		if(count < 0) {
			throw new IllegalStateException("The deck has been dealt");
		}
		
		int temp = count;
		count = count - 1;
		return card[temp];
		
	}
	
	public void shuffle() {
		Random r = new Random();
		for(int i = card.length - 1;i >= 1; i--) {
			int j = Math.abs(r.nextInt()) % i;
			card [i] = card[j];
		}
		if(count != 51) {
			throw new IllegalStateException("Cant shuffle after the dealing has started");
		}
	}
	
	
	
	

}
