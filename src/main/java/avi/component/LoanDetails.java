package avi.component;

public class LoanDetails {

    private String customerName;
    private double loanAmount;
    private float yearlyInterestRate;
    private int repaymentTenureInYear;

    public LoanDetails(String customerName, double loanAmount, float yearlyInterestRate, int repaymentTenureInYear) {
        this.customerName = customerName;
        this.loanAmount = loanAmount;
        this.yearlyInterestRate = yearlyInterestRate;
        this.repaymentTenureInYear = repaymentTenureInYear;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public float getYearlyInterestRate() {
        return yearlyInterestRate;
    }

    public int getRepaymentTenureInYear() {
        return repaymentTenureInYear;
    }

    public double getMonthlyInterestRate() {
        return (yearlyInterestRate / 12.0) / 100;
    }
    public int getNumberOfPayments() {
        return repaymentTenureInYear * 12;
    }
}
