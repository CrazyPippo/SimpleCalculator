import java.util.*;
public class Brain {
	/*			variables		*/
	private static Scanner scan = new Scanner(System.in);
	private static boolean  mainLoop = true;
	private static int operation = 0;
	private static int answer = 0;
	private static boolean validInteger = false;
	private static boolean validCommand = false;
	private static int operand1 = 0;
	private static int operand2 = 0;
	
	/* start program
	 * 
	 */
	public static void main(String[] args) {
		
		while (mainLoop) {
			mainMenu();
			// verify whether the input is integer
			operation = checkInteger();
			if (validInteger) {
				// check whether the input is from 1 to 4
				validCommand = testCommand(operation);
				if (validCommand) {
					// compute according to the input
					computation(operation);
					// ask user whether want to do the computation again
					mainLoop = continueProgram();
				}
			}
		}
		
	}
	/* display main menu
	 * 
	 */
	private static void mainMenu(){
		System.out.println("Select operations\n" +
				"1. Addition\n" +
				"2. Subtraction\n" +
				"3. Multiplication\n" +
				"4. Division (Integer)");
	}
	
	/* make sure input is an integer
	 * 
	 */
	private static int checkInteger(){
		int integer = 0;
		try {
			integer = scan.nextInt();
			validInteger = true;
			return integer;
		}
		catch(InputMismatchException ex){
			System.out.println("Only integers allowed");
			// clear input buffer
			scan.nextLine();
			validInteger = false;
		}
		return 0;
	}
	
	/*
	 *  calculate according to different integers
	 */
	private static void computation (int operation){
			// get operands
			do{
				System.out.println("Enter the first number");
				operand1 = checkInteger();
			}while(validInteger == false);
			do{
				System.out.println("Enter the second number");
				operand2 = checkInteger();
			}while(validInteger == false);
			switch (operation) {
			case 1: {
				answer = operand1 + operand2;
				break;
			}
			case 2: {
				answer = operand1 - operand2;
				break;
			}
			case 3: {
				answer = operand1 * operand2;
				break;
			}
			case 4: {
				answer = operand1 / operand2;
				break;
			}
			}
			System.out.println("The answer is " + answer  );
	}
	
	/*ask user whether want to continue the program
	 * 
	 */
	private static boolean continueProgram(){
		boolean getUserOption = true;
		String preceed = "";
		while (getUserOption) {
			System.out.println("Do you want to preceed ?\t" + "y/n");
			// get the user's answer
			try {
				preceed = scan.next();
				getUserOption = false;
			}
			catch (InputMismatchException ex){
				 getUserOption = true;
				 scan.nextLine();
				 System.out.println("Must be a letter");
			}
			if (preceed.equals("y")) {	
				mainLoop = true;
				validInteger = false;
				validCommand = false;
				return true;
			}
			
			else if (preceed.equals("n")) 	System.exit(0);
			// re ask if user's answer is neither "Y" nor "N"
			else {
				System.out.println("Unknow command");
				getUserOption = true;
			}
		}
		return false;
	}
	/* check whether the command is from 1 to 4
	 * 
	 */
	private static boolean testCommand(int input){
		if(input >= 1 && input <= 4)	return true;
		else{
			System.out.println("Unknow command");
			return false;
		}
	}
}
