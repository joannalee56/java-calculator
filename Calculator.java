import calc.Arithmetic;
import java.util.Scanner;
import java.util.Arrays;
import java.lang.Float;

public class Calculator {
	// Helper method 
	public static String getUserInput(Scanner input){
		System.out.println("Enter your equation > ");
		String userInput = input.nextLine();
		return userInput;
	}

	public static String[] tokenize(String input) {
		return input.split(" ");
	}	

	public static String getOperator(String[] tokens){
		return tokens[0];
	}

	public static String getNum1(String[] tokens){
		// tokens[1] is a string 
		// stringToFloat(tokens[1])
		return tokens[1];
	}

	public static String getNum2(String[] tokens){
		// Exception for second str
		if (tokens.length < 3){
			return "0";
		} else {
			return tokens[2];
		}
	}

	public static boolean validOperator(String operator){
		// System.out.println("I'm in validOperator");
		// System.out.println("op:" + operator);

		if (operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals("/") 
		|| operator.equals("square") || operator.equals("cube") || operator.equals("pow") || operator.equals("mod") ){	
			return true;
		}
		return false;
	}

	public static Float calculate(String operator, Float num1Float, Float num2Float){
		// Conditional for calling Arithmetic class based on operator
		Float result;

		if (operator.equals("+")){
			result = Arithmetic.add(num1Float, num2Float);
		} else if (operator.equals("-")){
			result = Arithmetic.subtract(num1Float, num2Float);
		} else if (operator.equals("*")){
			result = Arithmetic.multiply(num1Float, num2Float);
		} else if (operator.equals("/")){
			result = Arithmetic.divide(num1Float, num2Float);
		} else if (operator.equals("square")){
			result = Arithmetic.square(num1Float);
		} else if (operator.equals("cube")){
			result = Arithmetic.cube(num1Float);
		} else if (operator.equals("pow")){
			result = Arithmetic.power(num1Float, num2Float);
		} else if (operator.equals("mod")){
			result = Arithmetic.mod(num1Float, num2Float);
		} else {
			result = null;
		}
		System.out.println("result:" + result);
		return result;
	}

	// Main method that takes in list of strings as an argument and returns nothing
	public static void main(String[] args) {
		// Create new Scanner object so we can get user input
		Scanner input = new Scanner(System.in);

		while (true){
			// Ask user input
			String userInput = getUserInput(input);

			// Splits string into list of strings
			String[] tokens = tokenize(userInput);
			// System.out.println(Arrays.toString(tokens));

			// Quit program
			if (tokens[0].equals("q")){
				System.out.println("You will exit.");
				break;
			}
			// Exception of not enough input
			else if (tokens.length < 2){
				System.out.println("Not enough inputs.");
				continue;
			}

			// Separating out individual strings
			
			String operator = getOperator(tokens);
			String num1 = getNum1(tokens);  //getNum1
			String num2 = getNum2(tokens); //getNum2
			// System.out.println(operator + num1);

			float result=0;

			float num1Float;
			float num2Float;

			try {
				// Convert string to float
				num1Float = Float.parseFloat(num1);
				num2Float = Float.parseFloat(num2);

			// Exception if str is not num
			} catch (NumberFormatException e){
				System.out.println("Those aren't numbers!");
				continue;
			}

			if (validOperator(operator)){
				System.out.println(calculate(operator, num1Float, num2Float));
			} else {
				System.out.println("Please provide an operator and two numbers.");
				continue;
			}

//			System.out.println(result);
			
		}
	}
}




