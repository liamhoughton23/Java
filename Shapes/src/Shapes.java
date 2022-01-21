//hough084x500 Liam Houghton

class Polygon 
{ 
	private int[] sideLengths; 
     
      public Polygon(int sides, int ... lengths) 
      { 
        int index = 0; 
        sideLengths = new int[sides]; 
        for (int length: lengths) 
        { 
          sideLengths[index] = length; 
          index += 1; 
        } 
      } 
     
      public int side(int number) 
      { 
        return sideLengths[number]; 
      } 
     
      public int perimeter() 
      { 
        int total = 0; 
        for (int index = 0; index < sideLengths.length; index += 1) 
        { 
          total += side(index); 
        } 
        return total; 
      }
     
}

class Rectangle extends Polygon{
	int sideOne;
	int sideTwo;
	public Rectangle(int sideOne, int sideTwo) {
		super(4, sideOne, sideTwo, sideOne, sideTwo);
		this.sideOne = sideOne;
		this.sideTwo = sideTwo;
		
	}
	
	public int area() {
		return sideOne * sideTwo;
	}

	
}

class Square extends Polygon {
	int sideOne;
	public Square(int sideOne) {
		super(4, sideOne, sideOne, sideOne, sideOne);
		this.sideOne = sideOne;
	}
	
	public int area() {
		return sideOne * sideOne;
	}
}


