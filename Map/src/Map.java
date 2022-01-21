//Liam Houghton hough084_x500
public class Map<Key, Value> {
	private Key[] keys;
	private Value[] values;
	private int count;
	private int length;
	
	public Map(int length) {
		if(length < 0) {
			throw new IllegalArgumentException("No negatives");
		}
		keys = (Key[])new Object[length];
		values = (Value[])new Object[length];
		count = 0;
		this.length = length;
		
	}
	
	
	public Value get(Key key) {
		Value v = null; 
		boolean success = false;
		for(int i = 0; i < count; i++) {
			if(isEqual(keys[i], key)) {
				v = values[i];
				success = true;
				break;
			}	
		}
		if(!success) {
			throw new IllegalArgumentException("");
		}
		
		return v;
		
	}
	
	private boolean isEqual(Key leftKey, Key rightKey) {
		if(leftKey == null && rightKey == null) {
			return true;
		}
		if(leftKey != null && rightKey!= null && leftKey.equals(rightKey)) {
			return true;
		}
		else {
			return false;
	
		}
	}
		
		
		
	
	public void put(Key key, Value value) {
		int where = where(key);
	    if(count >= length && where < 0) {
	    	throw new IllegalStateException("yarn");
	    }
		
		if(where > 0) {
			values[where] = value;
			
		}
		else {
			keys[count] = key;
			values[count] = value;
			count++;
		}
		
		
		
	}
	
	public boolean isIn(Key key) {
		for(int i = 0; i < keys.length; i++) {
			if(isEqual(keys[i], key)) {
				return true;
			}
		}
		return false;
	}
	
	private int where(Key key) {
		for(int i = 0; i < count; i++) {
			if(isEqual(keys[i], key)) {
				return i;
			}
		}
		return -1;
	}
	/*
	
	public static void main(String[] args) {
		
		Map<String, String> map;
		try {
			map = new Map<String, String>(-5);
		}
		catch(IllegalArgumentException ignore) {
			System.out.println("No negatives");
		}
		map = new Map<String, String>(5);
		map.put("Harry", "Ginny");
		map.put("Ron", "Lavender");
		map.put("Voldemort", null);
		map.put(null, "Wormtail");
		System.out.println(map.isIn("Harry"));
		System.out.println(map.isIn("Ginny"));
		System.out.println(map.isIn("Ron"));
		System.out.println(map.isIn("Voldemort"));
		System.out.println(map.isIn(null));
		System.out.println(map.isIn("Joanne"));
		System.out.println(map.get("Harry"));
		System.out.println(map.get("Ron"));
		System.out.println(map.get("Voldemort"));
		System.out.println(map.get(null));
	    try {
	    	System.out.println(map.get("Joanne"));
	    	
	    }
	    catch(IllegalArgumentException ignore){
	    	System.out.println("No Joanne");
	    	
	    }
	    
	    map.put("Ron",   "Hermione");   
	    map.put("Albus", "Gellert");
	    map.put(null,    null);
	    
	    System.out.println(map.isIn(null));
	    System.out.println(map.isIn("Albus"));
	    System.out.println(map.get("Albus"));
	    System.out.println(map.get("Harry"));
	    System.out.println(map.get("Ron"));
	    System.out.println(map.get("Voldemort"));
	    System.out.println(map.get(null));
	    try {
	    	map.put("Draco", "Pansy");
	    	
	    }
	    catch(IllegalStateException ignore){
	    	System.out.println("No draco");
	    	
	    }
	    
		
		
	}
	*/
	
	
	
	
	

}
