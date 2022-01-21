//Liam Houghton hough084x500
public class Deque<Base> {
	private class Node{
		private Base object;
		private Node left;
		private Node right;
		
		private Node(Base object, Node left, Node right) {
			this.object = object;
			this.left = left;
			this.right = right;
		}
	}
	
	Node head;
	public Deque() {
		head = new Node(null, null, null);
		head.left = head;
		head.right = head;
	}
	
	
	public void enqueueFront(Base object) {
		Node n = new Node(object, head, head.right);
		head.right.left = n;
		head.right = n;
		
	}
	
	public void enqueueRear(Base object) {
		Node n = new Node(object, head.left, head);
		head.left.right = n;
		head.left = n;
		
	}
	
	public Base dequeueFront() {
		if(isEmpty()) {
			throw new IllegalStateException("");
		}
		else {
			Base n = head.right.object;
			head.right = head.right.right;
			head.right.left = head.right;
			return n;

		}
		
	}
	
	public Base dequeueRear() {
		if(isEmpty()) {
			throw new IllegalStateException("");
		}
		else {
			Base n = head.left.object;
			head.left = head.left.left;
			head.left.right = head.left;
			return n;

		}
	}
	
	public boolean isEmpty() {
		return head.left == head && head.right == head;
	}
	
}
