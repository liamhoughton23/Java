//Liam Houghton hough084x500
public class PriorityQueue<Base> {
	private class Node{
		private Base object;
		private int rank;
		private Node left;
		private Node right;
		
		private Node(Base object, int rank) {
			this.object = object;
			this.rank = rank;
			left = null;
			right = null;
		}
		
		
		
	}
	
	private Node root;
	
	public PriorityQueue() {
		root = new Node(null, 8);
	}
	
	public void enqueue(Base object, int rank){
		if(rank < 0) {
			throw new IllegalStateException("");
		}
		Node subtree = root;
		while(true) {
			int test = compareTo(subtree.rank, rank);
			if(test < 0) {
				if(subtree.left == null) {
					subtree.left = new Node(object, rank);
					break;
				}
				else {
					subtree = subtree.left;
				}
			}
			else if(test > 0) {
				if(subtree.right == null) {
					subtree.right = new Node(object, rank);
					break;
				}
				else {
					subtree = subtree.right;
				}
			}
			else {
				subtree.right = new Node(object, rank);
				return;
			}
		}
	}
	
	public Base dequeue() {
		if(root.left == null) {
			throw new IllegalStateException("");
		}
		Node above = root;
		Node subtree = root.left;
		while(subtree.left != null) {
			above = subtree;
			subtree = subtree.left;
			
		}
		Base delete = subtree.object;
		above.left = subtree.right;	
		return delete;
		
	}
	
	
	public int compareTo(int subtreeRank, int rank) {
		if(subtreeRank > rank) {
			return -1;
		}
		else if(subtreeRank < rank) {
			return 1;
		}
		else {
			return 0;
		}
	}
	
	public boolean isEmpty() {
		return root.left == null;
	}
}
