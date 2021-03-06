import java.util.Scanner;

/*
 	SoloLearn problem Paranoia
 	
 		This assignment describes a situation in a company.
 			
 			! Names, characters and events are the products of the author's imagination.
 			Any resemblance to actual persons or actual events is purely coincidental. !
 			
 		ByteCorp is a famous technological company in Byteania.
 		The CEO of ByteCorp doesn't trust anyone and and thinks that his accountant
 		managed to move huge amounts of money to a competitor company, MegaCorp.
 		He hires a computer crime investigator and asks him to find inconsistencies
 		in the money transfers.
 		
 		Here is a sample transaction log of the company:
 			Feb SLR 4 M
 			Feb ENT 800 K
 			Mar SLR 4000 K
 			Mar ENT 800 K
 			Apr SLR 4010 K
 			Apr ENT 810 K
 			
 		There are four columns:
 		1. Month of the transaction
 		2. Reason of the expense (SLR for "salary", ENT for "entertainment", OTR for "other")
 		3. Amount
 		4. M, K or B (M for million, K for thousands, B for billion)
 		
 		 In the example above, April expenses show an inconsistency and should be reported.
 		 
 		 Another example:
 		 Jul SLR 4 M
 		 Jul ENR 800 K
 		 Jul OTR 1200 K
 		 Aug SLR 4000 K
 		 Aug ENR 800 K
 		 Aug OTR 1190 K
 		 Sep SLR 4000 K
 		 Sep ENR 800 K
 		 Sep OTR 1190 K
 		 
 		 Here, July expenses show an inconsistency and should be reported.
 		 
 		 As the computer investigator, write a program, which reads the transaction logs,
 		 detects inconsistent expenses and prints the exact month containing the "unusual" activities.
 		 
 		 	! The number of lines in the transaction log, as well as the reasons, are not fixed
 		 	and can contain other values. !
 */

public class Paranoia {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String input = "";
		String temp="";
		while(!temp.equals("stop")) {
			temp = in.next();
			temp+= in.nextLine();
			if(!temp.equals("stop")) input += temp + " ";
		}
		System.out.println(input);
		System.out.println("OK");
	}

}
