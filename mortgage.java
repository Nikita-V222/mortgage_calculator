//MortgageCalculator.java
import java.util.Scanner;

class MortgageCalculator {
//Instance variables
private double principal; //Loan amount
private double annualRate; //Annual interest rate (in %)
private int years; //Loan term (in years)

//Constructor
public MortgageCalculator(double principal, double annualRate, int years) {
    this.principal=principal;
    this.annualRate=annualRate;
    this.years=years;
}

//Method to calculate monthly payement
public double calculateMonthlyPayement() {
    double monthlyRate=(annualRate/100)/12; //Monthly interest rate
    int totalPayments=years*12; //Total number of payements

    // Formula: M = P * (r(1+r)^n) / ((1+r)^n - 1)
    return (principal*monthlyRate*Math.pow(1+monthlyRate,totalPayments))/(Math.pow(1+monthlyRate,totalPayments)-1);
}
}

public class Main {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        //Input values
        System.out.println("Welcome to the Mortgage Calculator!");
        System.out.println("Enter the loan amount(principal):");
        double principal=sc.nextDouble();

        System.out.println("Enter the annual interest rate (in %):");
        double annualRate=sc.nextDouble();

        System.out.println("Enter the loan term (in years):");
        int years=sc.nextInt();

        //Create an object of MortgageCalculator
        MortgageCalculator calculator=new MortgageCalculator(principal, annualRate, years);

        //Calculate monthly payement
        double monthlyPayment=calculator.calculateMonthlyPayement();

        //Output result
        System.out.println("Your monthly payement is:%.2f\n",monthlyPayment);

        sc.close();
    }
}

