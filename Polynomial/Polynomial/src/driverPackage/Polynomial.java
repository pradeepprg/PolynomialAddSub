/**
 * 
 */
package driverPackage;

import driverPackage.ArraySortedPolynomial;
//import polynomialPackage.ArrayWithExponentAsIndexPolynomial;

import java.util.Scanner;

import polynomialInterfacePackage.PolynomialInterface;
import driverPackage.LinkedListPolynomial;


public class Polynomial
{
	private static Scanner keyboard = new Scanner(System.in);

	public static void main(String[] args)
	{
		String yesOrNo = "";
		
		do
		{
			System.out.println("Enter the first polynomial");
			String equation1 = inputPolynomial();
			System.out.println("Enter the second polynomial");
			String equation2 = inputPolynomial();
			PolynomialInterface exAsIndex1 = new LinkedListPolynomial(equation1);
			PolynomialInterface exAsIndex2 = new LinkedListPolynomial(equation2);
			PolynomialInterface exAsIndex3;
			exAsIndex3 = exAsIndex1.add(exAsIndex2);

			System.out.println("----Implementation Method 1 Linked List-----");
			System.out.println("First Polynomial Is " + equation1);
			System.out.println("Second Polnomial Is " + equation2);
			System.out.println("First Polynomial + Second Polynomial = " + exAsIndex3);
			
			exAsIndex3 = exAsIndex1.subtract(exAsIndex2);
			System.out.println("First Polynomial - Second Polynomial = " + exAsIndex3.toString());
			System.out.println();
			
			PolynomialInterface sortA1 =  new ArraySortedPolynomial(equation1);
			PolynomialInterface sortA2 = new ArraySortedPolynomial(equation2);
			PolynomialInterface sortA3;
			sortA3 = sortA1.add(sortA2);
			System.out.println("----Implementation Method 2 Sorted Array-----");
			//System.out.println("sortA1 string is " + s1);
			System.out.println("Polynomial 1 after sorting " + sortA1);
			// // System.out.println("sortA2 string is " + s2);
			System.out.println("Polynomial 2 after sorting " + sortA2);
			System.out.println("First Polynomial + Second Polynomial = " + sortA3);
			
			sortA3 = sortA1.subtract(sortA2);
			System.out.println("First Polynomial - Second Polynomial = " + sortA3.toString());
			System.out.println();

			System.out.println("Would you like to repeat this program?");
			do
			{
				System.out.println("Please enter \"yes\" or \"no\".");
				yesOrNo = keyboard.nextLine();
			} while (!yesOrNo.equalsIgnoreCase("yes") && !yesOrNo.equalsIgnoreCase("no"));
			
		} while (yesOrNo.equalsIgnoreCase("yes"));
	}

	private static String inputPolynomial()
	{
		String polynomial = "";
			System.out.println("Do not use spaces between terms in the plynomial.");
			System.out.println("Examples: -3x+45x^3-22, 44x^6-3x^10+4x^4, 44-3x^88, etc.");
			
			polynomial = keyboard.next();
			keyboard.nextLine();
		return polynomial;
	}
}
