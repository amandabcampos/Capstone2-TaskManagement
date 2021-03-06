
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Validator {

	/**
	 * Get any valid integer.
	 */
	public static int getInt(Scanner scnr, String prompt) {
		// This approach use "hasNext" look ahead.
		System.out.print(prompt);
		while (!scnr.hasNextInt()) {
			scnr.nextLine(); // clear bad line.
			System.out.println("Sorry, I can't read that. Enter a whole number, using digits.");
			System.out.println(prompt);
		}
		int result = scnr.nextInt();
		scnr.nextLine(); // clear for next line of input.
		return result;
	}

	/**
	 * Get any valid double.
	 */
	public static double getDouble(Scanner scnr, String prompt) {
		// This approach use "hasNext" look ahead.
		boolean isValid = false;
		do {
			System.out.print(prompt);
			isValid = scnr.hasNextDouble();
			if (!isValid) {
				scnr.nextLine(); // clear bad line.
				System.out.println("Sorry, I can't read that. Enter a number, using digits.");
			}
		} while (!isValid);

		double number = scnr.nextDouble();
		scnr.nextLine(); // clear for next line of input.
		return number;
	}

	/**
	 * Get any string.
	 */
	public static String getString(Scanner scnr, String prompt) {
		// This approach uses exception handling.
		System.out.print(prompt);
		return scnr.nextLine();
	}

	/**
	 * Get any valid integer between min and max.
	 */
	public static int getInt(Scanner scnr, String prompt, int min, int max) {
		boolean isValid = false; // redundant
		int number;
		do {
			number = getInt(scnr, prompt);

			if (number < min) {
				isValid = false;
				System.out.println("The number must be at least " + min);
			} else if (number > max) {
				isValid = false;
				System.out.println("The number must not be larger than " + max);
			} else {
				isValid = true;
			}

		} while (!isValid);
		return number;
	}

	/**
	 * Get any valid double between min and max.
	 */
	public static double getDouble(Scanner scnr, String prompt, double min, double max) {
		boolean isValid = false;
		double number;
		do {
			number = getDouble(scnr, prompt);

			if (number < min) {
				isValid = false;
				System.out.println("The number must be at least " + min);
			} else if (number > max) {
				isValid = false;
				System.out.println("The number must not be larger than " + max);
			} else {
				isValid = true;
			}

		} while (!isValid);
		return number;
	}

	/**
	 * Get a string of input from the user that must match the given regex.
	 */
	public static String getStringMatchingRegex(Scanner scnr, String prompt, String regex) {
		boolean isValid = false;
		String input;
		do {
			input = getString(scnr, prompt);

			if (input.matches(regex)) {
				isValid = true;
			} else {
				System.out.println("Input must match the appropriate format.");
				isValid = false;
			}

		} while (!isValid);
		return input;
	}

	public static int getNaturalWithoutZero(Scanner scnr, String prompt) {
		// This approach use "hasNext" look ahead.
		System.out.print(prompt);
		int result = 0;
		boolean looping = true;
		while (looping) {
			while (!scnr.hasNextInt()) {
				scnr.nextLine(); // clear bad line.
				System.out.println("Sorry, I can't read that. Enter a natural number, using digits.");
				System.out.println(prompt);
			}
			result = scnr.nextInt();
			if (result > 0) {
				looping = false;
			} else {
				scnr.nextLine();
				System.out.println("Sorry, enter a positive number higher that zero.");
			}
		}

		scnr.nextLine(); // clear for next line of input.
		return result;
	}
	
	public static Date getDate(Scanner scnr, String prompt) {
		boolean isValid = false;
		String input;
		do {
			input = getString(scnr, prompt);

			if (input.matches("[0-3][0-9]/[0-1][0-9]/[0-9]{4}")) {
				isValid = true;
			} else {
				System.out.println("Input must match the appropriate format.");
				isValid = false;
			}

		} while (!isValid);
		String[] elements = input.split("/");
		int day = Integer.parseInt(elements[0]);
		int month = Integer.parseInt(elements[1]);
		int year = Integer.parseInt(elements[2]);
		
		Date date = new GregorianCalendar(year, month-1, day).getTime();
		return date;
		
		
	}
	

	

//	public static boolean yesOrNo(Scanner scnr, String prompt) {
//		
//		System.out.println(prompt);
//		String input = scnr.nextLine();
//		
//		boolean isValid = false; // must initialize, why? (cause default)
//		
//		do {
//			
//			input = getString(scnr, prompt);
//			if( input.toLowerCase().startsWith("y")) {
//				return true;
//
//			} else {
//				System.out.println("Are you sure?");
//			}
//			
//			
//		} while(!isValid);
//		
//	}

}