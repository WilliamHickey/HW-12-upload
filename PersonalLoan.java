/* This is a program to Create the Personal Loan class
 * Assignment: 10
 * Name: Will Hickey
 * 
 */
package Loaner;

public class PersonalLoan extends Loan {

	public PersonalLoan(int number, String name, double amount, int termIn) {
		super(number, name, amount, termIn);
		interestRate = .02;
	}

	@Override
	public String toString() {
		return companyName +  " has approved loan number " + loanNumber + " a loan of " + loanAmount + " to a Mr/Ms "+ lastName + " for a term of " + term + " years at an interest rate of " + interestRate + ", which leads to a loan fee of " + (interestRate*loanAmount*term) + " leading to a total amount owed of " + (loanAmount + (interestRate*loanAmount*term));
	}

}
