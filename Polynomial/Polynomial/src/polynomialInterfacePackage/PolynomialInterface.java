/**
 * 
 */
package polynomialInterfacePackage;


public interface PolynomialInterface{
	PolynomialInterface add(PolynomialInterface other);
	// Effect:        Adds value to owner of addPolynomial method.
	// Postcondition: Return value =  this + value.
	PolynomialInterface subtract(PolynomialInterface other);
	// Effect:        Subtracts value from owner of addPolynomial method.
	// Postcondition: Return value = this - value.
	String toString();
	// Postcondition: polynomial converted to string.
} 

