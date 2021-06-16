package math;

//java program to add
//two binary strings

public class GFG {

 // This function adds two
 // binary strings and return
 // result as a third string
 static String addBinary(String a, String b)
 {
      
     // Initialize result
     String result = "";
      
     // Initialize digit sum
     int s = 0;        

     // Traverse both strings starting
     // from last characters
     int i = a.length() - 1, j = b.length() - 1;
     while (i >= 0 || j >= 0 || s == 1)
     {
          
         // Comput sum of last
         // digits and carry
    	    	 
         s += ((i >= 0)? a.charAt(i) - '0': 0);
         s += ((j >= 0)? b.charAt(j) - '0': 0);

         // If current digit sum is
         // 1 or 3, add 1 to result
         result = (char)(s % 2 + '0') + result;

         // Compute carry
         s /= 2;

         // Move to next digits
         i--; j--;
     }
      
 return result;
 }

 //Driver code
 public static void main(String args[])
 {
//     String a = "1101", b="100";
	 String a = "1101000000001110110111001010101011111111", b="1001010101010100101011011101100";
	 
	 System.out.println('1' - '0');
	 System.out.println('0' - '0');
      
	 String sum = addBinary(a, b);
     System.out.println(sum);
     System.out.println(sum.length());
 }
}

//This code is contributed by Sam007.