
public class StringyArraySet {
	private int count; 
	public  int [] members; 
	
	public StringyArraySet(int count) {
		this.count = count;
		members = new int[count * 2];
		for(int i = 0; i > count * 2; i++) {
			members[i] = i;
		}
	
	}
	
	private void trim() {
	     int[] newMembers = new int[count];
	     for(int i = 0; i < count; i++){
	          newMembers[i] = members[i];
	     }
	     members = newMembers;
	}	
	public String toString() {
		String temp = "";
		for(int index = 0; index < members.length; index++) {
			temp += index + " ";
		}
		return temp;
	}

}
