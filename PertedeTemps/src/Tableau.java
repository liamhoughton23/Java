//Liam Houghton hough084x500
import java.util.Random;
public class Tableau {
	private Pile [] pile;
	private Deck deck;
	
	public Tableau() {
		pile = new Pile[13];
		deck = new Deck();
		deck.shuffle();
		for(int i = 0; i < pile.length; i++) {
			pile[i] = new Pile();
			pile[i].add(deck.deal());
			pile[i].add(deck.deal());
			pile[i].add(deck.deal());
			pile[i].add(deck.deal());
			
			
		}
		
	}
	
	public void Play() {
		int pileNumber = 0;
		int emptyPiles = 0;
		Card cardOne = pile[pileNumber].draw();
		System.out.println("Got " + cardOne + " from pile " + pileNumber);
		Card cardTwo;

		while(!pile[pileNumber].isEmpty()) {
			cardTwo = pile[pileNumber].draw();
			System.out.println("Got " + cardTwo + " from pile " + pileNumber);
			if(cardOne.getSuit() == cardTwo.getSuit()) {
				pileNumber = cardOne.getRank();
				cardOne = cardTwo;
			}
			else {
				pileNumber = cardTwo.getRank();
				cardOne = cardTwo;
			}
		}
		for(int i = 0; i < pile.length; i++) {
			if(pile[i].isEmpty()) {
				emptyPiles++;
			}
			
		}
		if(emptyPiles == 12) {
			System.out.println("We won!");
		}
		else {
			System.out.println("Pile " + pileNumber + " is empty. We lost!");
		}
	}
}
