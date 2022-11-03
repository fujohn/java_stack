public class BankAccountTest {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        BankAccount accountTwo = new BankAccount(449.91, 540.09);

        account.depositInChecking(123.4);
        System.out.println(account.getCheckingBalance());
        account.depositInSavings(886.60);
        System.out.println(account.getSavingsBalance());
        System.out.println(account.getTotalBalance()); // should be 1010
        System.out.println(BankAccount.getTotalCash()); // Should be 2000
        System.out.println(BankAccount.getAccountCount()); // Should be 2
        System.out.println(accountTwo.withdrawFromChecking(450)); //insufficient funds
        System.out.println(account.withdrawFromChecking(5));
        System.out.println(account.withdrawFromSavings(5));
        System.out.println(account.getTotalBalance()); // should be 1000
        
    }
}