
// Liam Houghton x500

class Reserved { 
	private static final String [] reserved = 
       { "and", 
         "begin", 
         "define", 
         "do", 
         "else", 
         "end", 
         "if", 
         "not", 
         "or", 
         "return", 
         "then", 
         "while" }; 
     
	private static int hash(String name) 
	{ 
		int p = (2 * name.charAt(0)) + (6 * name.charAt(1)) - name.length();
		return p;
      
	} 
    
	public static void main(String [] args) 
	{ 
		for (int index = 0; index < reserved.length ; index += 1) 
		{ 
			System.out.print("h(\"" + reserved[index] + "\") = "); 
			System.out.print(hash(reserved[index])); 
			System.out.println(); 
        } 
    } 
 }


/* OUTPUT
h("and") = 851
h("begin") = 797
h("define") = 800
h("do") = 864
h("else") = 846
h("end") = 859
h("if") = 820
h("not") = 883
h("or") = 904
h("return") = 828
h("then") = 852
h("while") = 857
 */

