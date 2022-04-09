package Loaner;

public abstract class Loan implements LoanConstants {
	protected int loanNumber;
	protected String lastName;
	protected double loanAmount;
	protected double interestRate;
	protected int term;
	
	Loan(int number, String name, double amount, int termIn)
	{
		loanNumber = number;
		lastName = name;
		if(amount > maxLoan)
		{
			loanAmount = maxLoan;
		}
		else
		{
			loanAmount = amount;
		}
		if(termIn == shortTerm| termIn == mediumTerm| termIn == longTerm)
		{
			term = termIn;
		}
		else
		{
			term = shortTerm;
		}
	}
	
	public abstract String toString();
}
