//Liam Houghton hough084x500
import java.util.Random;
public class Pile {
	private class Layer{
		private Card card;
		private Layer next;
		
		private Layer(Card card, Layer next) {
			this.card = card;
			this.next = next;
		}
	}
	private Layer top;
	public Pile() {
		top = null;
	}
	
	public boolean isEmpty() {
		return top == null;
	}
	
	public Card draw() {
		if(isEmpty()) {
			throw new IllegalStateException("There is no cards in this pile");
		}
		else {
			Card temp = top.card;
			top = top.next;
			return temp;
			
		}
		
	}
	
	public void add(Card card) {
		top = new Layer(card, top);
	}
	
}
