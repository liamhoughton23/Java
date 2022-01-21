
//Liam Houghton

public class Zillion 
{
	private int count;
	private int[] element;
	public Zillion(int size) {
		element = new int[size];
		count = size;
		
		
	}
	public void increment() {
		int temp = count - 1;
		int interval = 0;
		while(element[temp] == 9 && temp >= 0) {
			element[temp] = 0;
			if (temp != 0) {
				temp -= 1;
			}
			interval++;
			
		}
		if(temp >= 0 && interval <= count - 1) {
			element[temp] += 1;
		}
	}
	
	public String toString() {
		String temp = "";
		for(int index = 0; index < count; index += 1) {
			temp += element[index] + " ";
		}
		return temp;
	}
	
	public static void main(String[] args) {
		Zillion z = new Zillion(2);
		System.out.println(z);
		
		
		
	}
	
		
	
}


