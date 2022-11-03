import java.util.Random;
public class BankAccount {
    // private String accountNumber;
    private double checkingBalance;
    private double savingsBalance;
    private static int accountCount = 0;
    private static double totalCash = 0;

    public BankAccount(){
        this(0,0);
    }

    public BankAccount(double checking, double savings) {
        this.checkingBalance = checking;
        this.savingsBalance = savings;
        // this.accountNumber = accountGenerator();
        // System.out.println(accountNumber);
        accountCount++;
        totalCash += checking + savings;
    }

    // private int accountGenerator() {
    //     Random rnd = new Random();
    //     int number = rnd.nextInt(9000000000);
    //     return number;
    // }

    // getters
    public double getCheckingBalance() {
        return checkingBalance;
    }

    public double getSavingsBalance() {
        return savingsBalance;
    }

    public double getTotalBalance() {
        return savingsBalance + checkingBalance;
    }

    // deposits
    public void depositInChecking(double amount) {
        this.checkingBalance += amount;
        totalCash += amount;
    }

    public void depositInSavings(double amount) {
        this.savingsBalance += amount;
        totalCash += amount;
    }

    // withdraws
    public String withdrawFromChecking(double amount) {
        if (amount > this.checkingBalance) {
            return "Insufficient funds.";
        } else {
            this.checkingBalance -= amount;
            totalCash -= amount;
            return String.format("%f withdrawn from your checking account", amount);
        }
    }

    public String withdrawFromSavings(double amount) {
        if (amount > this.savingsBalance) {
            return "Insufficient funds.";
        } else {
            this.savingsBalance -= amount;
            totalCash -= amount;
            return String.format("%f withdrawn from your savings account", amount);
        }
    }

    public static int getAccountCount() {
        return accountCount;
    }

    public static double getTotalCash() {
        return totalCash;
    }
}