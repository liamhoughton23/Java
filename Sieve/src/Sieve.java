//Liam Houghton - hough084x500


public class Sieve 
{
	private boolean[] numbers;
	private int interval;
	
	public Sieve(int max) {
		numbers = new boolean[max];
		interval = max;
		if(max < 2) {
			throw new IllegalArgumentException("Sieve size must be at least 2 ");
			
		}
		numbers[0] = false;
		numbers[1] = false;
		for(int index = 2; index < max; index++) {
			numbers[index] = true;
		}
	
		
	}
	
	public void findPrimes() {
		for(int index = 2; index < interval; index++) {
			if(numbers[index]) {
				for(int j = index; j*index < interval; j++) {
					numbers[j*index] = false;
				}
			}
		}
	}
	
	
	public String toString() {
		String temp = "";
		for(int index = 2; index < interval; index++) {
			if(numbers[index]) {
				temp += index + " ";
			}
		}
		return temp;
	}
	
}

