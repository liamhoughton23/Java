//Liam Houghton 500xhough084
public class BinaryVsLinear {
	  private static int linearSearch(int key, int [] array) 
	  { 
		 int count = 0;
	     for(int i = 0; i < array.length; i += 1) {
	    	 if(key == array[i]) {
	    		 count++;
	    		 return i;
	    	 }
	     }
	     return count;
	  } 
	 
	  private static int binarySearch(int key, int [] array) 
	  { 
	    int left = 0;
	    int mid;
	    int right = array.length - 1;
	    int count = 0;
	    while(true) {
	    	if(left > right) {
	    		mid = -1;
	    		break;
	    	}
	    	else {
	    		mid = (left + right) / 2;
	    		if(key < array[mid]) {
	    			count++;
	    			right = mid - 1;
	    		}
	    		else if(key > array[mid]) {
	    			count++;
	    			left = mid + 1;
	    		}
	    		else {
	    			break;
	    		}
	    		
	    	}
	    }
	    return count;
	  } 
	 
	  public static void main(String [] args) 
	  { 
	    for (int length = 1; length <= 30; length += 1) 
	    { 
	      int[] array = new int[length]; 
	      for (int index = 0; index < length; index += 1) 
	      { 
	        array[index] = index; 
	      } 
	 
	      double linearTotal = 0.0; 
	      double binaryTotal = 0.0; 
	      for (int element = 0; element < length; element += 1) 
	      { 
	        linearTotal += linearSearch(element, array); 
	        binaryTotal += binarySearch(element, array); 
	      } 
	 
	      double linearAverage = linearTotal / length; 
	      double binaryAverage = binaryTotal / length; 
	      System.out.println(length + " " + linearAverage + " " + binaryAverage); 
	    } 
	  }	

}
