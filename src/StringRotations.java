import java.util.Arrays;
import java.util.Scanner;

public class StringRotations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		
		String base = in.nextLine();
		if(base.length()!=0) {
			char[] characters = base.toCharArray();
			String[] res = new String[base.length()];
			char temp;
			for(int i = 0; i<base.length(); i++) {
				temp = characters[0];
				res[i]="";
				for(int j=1; j<characters.length; j++) {
					characters[j-1] = characters[j];
					res[i]+=characters[j-1];
				}
				characters[characters.length -1] = temp;
				res[i]+=characters[characters.length-1];
			}
			System.out.println(Arrays.toString(res));;
		}
		else System.out.println("You inputed null-value string!");
		in.close();
	}

}
