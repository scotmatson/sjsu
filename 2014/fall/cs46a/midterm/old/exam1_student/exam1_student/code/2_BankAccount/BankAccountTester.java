public class BankAccountTester
{
   public static void main(String[] args)
   {
      //test negative opening balance
      BankAccount account = new BankAccount(-1000);
      System.out.println("Balance after negative opening balance: "
         + account.getBalance());
      System.out.println("Expected: 100.0");

      //test positive opening balance
      account = new BankAccount(100);
      System.out.println("Balance after positive opening balance: "
         + account.getBalance());
      System.out.println("Expected: 200.0");

      //test negative deposit
      account.deposit(-100);
      System.out.println("Balance after negative deposit: "
         + account.getBalance());
      System.out.println("Expected: 200.0");

      //test negative withdraw
      account.withdraw(-50);
      System.out.println("Balance after negative withdraw: "
         + account.getBalance());
      System.out.println("Expected: 200.0");

      //test valid deposit
      account.deposit(200);
      System.out.println("Balance after valid deposit: "
               + account.getBalance());
      System.out.println("Expected: 400.0");

      //test valid withdraw
      account.withdraw(50);
      System.out.println("Balance after valid withdraw: "
         + account.getBalance());
      System.out.println("Expected: 350.0");
   }
}
