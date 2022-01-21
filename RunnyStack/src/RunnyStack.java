// Liam Houghton houghx500
public class RunnyStack<Base> {
	private class Run{
		private Base base;
		private int length;
		private Run next;
		
		private Run(Base base, int length, Run next) {
			this.base = base;
			this.length = length;
			this.next = next;
		}
	}
	
	private Run top;
	private int runs;
	private int depth;
	
	public RunnyStack() {
		top = null;
		runs = 0;
		depth = 0;
	}
	
	private boolean isEqual(Base one, Base two) {
		if(one == null && two == null) {
			return true;
		}
		else if(one != null && two != null && one.equals(two)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean isEmpty() {
		return top == null;
	}
	
	public void push(Base base) {
		int number = 1;
		if(isEmpty()) {
			top = new Run(base, number, top);
			runs += 1;
			depth += 1;
		}
		else if(isEqual(base, top.base)) {
			top.length += 1;
			depth += 1;
		}
		else {
			top = new Run(base, number, top);
			runs += 1;
			depth += 1;
		}
	}
	
	public Base peek() {
		if(isEmpty()) {
			throw new IllegalStateException("");
		}
		else {
			return top.base;
		}
	}
	
	public void pop(){
		if(isEmpty()) {
			throw new IllegalStateException("");
			
		}
		else if(top.length - 1 == 0) {
			depth -= top.length;
			runs -= 1;
			top = top.next;
			
		}
		else {
			top.length -= 1;
			depth -= 1;
		}
	}
	
	public int runs() {
		return runs;
	}
	
	public int depth() {
		return depth;
	}
	/*
	
	public static void main(String [] args) {
		RunnyStack<String> s = new RunnyStack<String>();
		 System.out.println(s.isEmpty());
		 System.out.println(s.depth());
		 System.out.println(s.runs());
		 try {
			 s.pop();
		 }
		 catch(IllegalStateException ignore){
			 System.out.println("No pop");
		 }
		 try {
			 s.peek();
		 }
		 catch(IllegalStateException ignore){
			 System.out.println("No peek");
		 }		 
		 s.push("A");
		 System.out.println(s.peek());
		 System.out.println(s.depth());
		 System.out.println(s.runs());
		 System.out.println(s.isEmpty());
		 
		 s.push("B");
		 System.out.println(s.peek());
		 System.out.println(s.depth());
		 System.out.println(s.runs());
		 
		 s.push("B");
		 System.out.println(s.peek());
		 System.out.println(s.depth());
		 System.out.println(s.runs());
		 
		 s.push("B");
		 System.out.println(s.peek());
		 System.out.println(s.depth());
		 System.out.println(s.runs());
		 
		 s.push("C");
		 System.out.println(s.peek());
		 System.out.println(s.depth());
		 System.out.println(s.runs());
		 
		 s.push("C");
		 System.out.println(s.peek());
		 System.out.println(s.depth());
		 System.out.println(s.runs());		 
		 
		 s.pop();
		 System.out.println(s.peek());
		 System.out.println(s.depth());
		 System.out.println(s.runs());
		 
		 s.pop();
		 System.out.println(s.peek());
		 System.out.println(s.depth());
		 System.out.println(s.runs());
		 
		 s.pop();
		 System.out.println(s.peek());
		 System.out.println(s.depth());
		 System.out.println(s.runs());
		 
		 s.pop();
		 s.pop();
		 System.out.println(s.peek());
		 System.out.println(s.depth());
		 System.out.println(s.runs());
		 
		 s.pop();
		 System.out.println(s.isEmpty());
		 System.out.println(s.depth());
		 System.out.println(s.runs());
		 
		 try {
			 System.out.println(s.peek());
		 }
		 catch(IllegalStateException ignore) {
			 System.out.println("No peek");
		 }
		 
	}
	*/
	
	
	
	

}
