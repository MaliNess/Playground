
/*
 	SoloLearn problem String Rotations
 	
 	Create a function that accepts a string argument and returns
 	an array of strings, which are shifted versions of the
 	argument string.
 	
 	Sample input
 	"Hello"
 	
 	Sample Output
 	["elloH", "lloHe", "loHel", "oHell", "Hello"]
 	
 	As you can see from the example above, each element shifts 
 	the first character of the previous version to the end.
 	The original string should be included in the output array.
 	The order matters; each element of the output array should
 	be the shifted version of the previous element.
 	The output array should have the same length as the input string.
 	The function should return an empty array when a zero-length
 	String is provided as the argument.
 */

import java.util.Arrays;
import java.util.Scanner;

public class StringRotations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);

		System.out.print("Enter string: ");
		String base = in.nextLine();
		if (base.length() != 0) {
			char[] characters = base.toCharArray();
			String[] res = new String[base.length()];
			char temp;
			for (int i = 0; i < base.length(); i++) {
				temp = characters[0];
				res[i] = "";
				for (int j = 1; j < characters.length; j++) {
					characters[j - 1] = characters[j];
					res[i] += characters[j - 1];
				}
				characters[characters.length - 1] = temp;
				res[i] += characters[characters.length - 1];
			}
			System.out.println(Arrays.toString(res));
			;
		} else
			System.out.println("You inputed null-value string!");
		in.close();
	}

}
