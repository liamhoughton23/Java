//Liam Houghton hough084_x500
public class AssociationList<Key,Value> {
	private class Node {
		private Key key;
		private Value value;
		private Node next;
		
		private Node(Key key, Value value, Node next){
			this.key = key;
			this.value = value;
			this.next = next;
			
		}
	}
	
	Node head;
	
	public AssociationList() {
		head = new Node(null, null, null);
	}
	
	public void put(Key key, Value value) {
		Node temp = head.next;
		boolean notThere = true;
		while(temp != null) {
			if(isEqual(temp.key, key)) {
				temp.value = value;
				notThere = false;
				break;
			}
			else {
				temp = temp.next;
			}
		}
		if(notThere){
			head.next = new Node(key, value, head.next);
		}
	}
	
	public void delete(Key key) {
		Node left = head;
		Node right = head.next;
		while(right != null) {
			if(isEqual(right.key, key)) {
				left.next = right.next;
				break;
			}
			else {
				left = right;
				right = right.next;
			}
		}
	}
	
	public Value get(Key key) {
		Node temp = head.next;
		Value value = null;
		boolean isThere = false;
		while(temp != null) {
			if(isEqual(temp.key, key)) {
				isThere = true;
				value = temp.value;
				break;
			}
			else {
				temp = temp.next;
			}
		}		
		if(value == null && !isThere) {
			throw new IllegalArgumentException("");
		}
		
		return value;
	}
	
	public boolean isIn(Key key) {
		Node temp = head.next;
		while(temp != null) {
			if(isEqual(temp.key, key)) {
				return true;
			}
			else {
				temp = temp.next;
			}
		}
		return false;
	}
	
	private boolean isEqual(Key leftKey, Key rightKey) {
		if(leftKey == null && rightKey == null) {
			return true;
			
		}
		else if(leftKey != null && rightKey != null && leftKey.equals(rightKey)) {
			return true;
		}
		else {
			return false;
		}
	}
	
}

