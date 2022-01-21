//Liam Houghton hough084x500

import java.util.Random;

public class HBST<Key, Value> {
	private class PairNode{
		private Key key;
		private Value value;
		private PairNode next;
		
		private PairNode(Key key, Value value, PairNode next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}
	}
	
	private class TreeNode{
		private int hash;
		private PairNode pairs; 
		private TreeNode left;
		private TreeNode right;
		
		private TreeNode(int hash, PairNode pairs) {
			this.hash = hash;
			this.pairs = pairs;
			left = null;
			right = null;
		}
	}
	
	private Random generator;
	
	private TreeNode root;
	
	public HBST() {
		generator = new Random();
		root = new TreeNode(0, null);
		
	}
	
	public Value get(Key key) {
		TreeNode temp = root.right;
		int thisHash = hash(key);
		while(temp != null) {
			if(thisHash < temp.hash) {
				temp = temp.left;
			}
			else if(thisHash > temp.hash) {
				temp = temp.right;
			}
			else {
				PairNode node = temp.pairs;
				while(node != null) {
					if(isEqual(node.key, key)) {
						return node.value;				
					}
					else {
						node = node.next;
					}
				}				
			}
		}		
		throw new IllegalArgumentException("");
	}
	
	
	public void put(Key key, Value value) {
		if(root.right == null) {
			root.right = new TreeNode(hash(key), new PairNode(key, value, null));
			
		}
		else {
			TreeNode prev = root;
			TreeNode temp = root.right;
			int thisHash = hash(key);
			while(temp != null) {
				if(thisHash < temp.hash) {
					prev = temp;
					temp = temp.left;
					
				}
				else if(thisHash > temp.hash) {
					prev = temp;
					temp = temp.right;
				}
				else {
					PairNode node = temp.pairs.next;
					PairNode prevPair = temp.pairs;
					while(true) {
						if(isEqual(prevPair.key, key)) {
							prevPair.value = value;
							return;
						}
						else {
							if(node == null) {
								break;
							}
							prevPair = node;
							node = node.next;
							
						}
					}
					prevPair.next = new PairNode(key, value, null);
					return;	
				}		
			}
			
			if(thisHash > prev.hash) {
				prev.right = new TreeNode(thisHash, new PairNode(key, value, null));
			}
			else {
				prev.left = new TreeNode(thisHash, new PairNode(key, value, null));
			}
			
			
		}
	}
	
	
	private boolean isEqual(Key leftKey, Key rightKey) {
		if(leftKey == null || rightKey == null) {
			return leftKey == rightKey;
			
		}
		else {
			return leftKey.equals(rightKey);
		}
	}
	
	public int height() {
		return height(root.right);
	}
	
	private int height(TreeNode subtree) {
		if(subtree == null) {
			return 0;
		}
		else {
			int left = height(subtree.left) + 1;
			int right = height(subtree.right) + 1;
			if(left > right) {
				return left;
			}
			else {
				return right;
			}
		}
	}
	
	private int hash(Key key) {
		if(key == null) {
			return 0;
		}
		else {
			generator.setSeed(key.hashCode());
			return Math.abs(generator.nextInt());
		}
	}
	
	public boolean isEmpty() {
		return root.right == null;
	}
}
