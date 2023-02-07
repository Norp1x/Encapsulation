import java.util.Scanner;

public class Encapsulation {
    public static void main(String[] args) {
        BankAccount savings = new BankAccount();
        Scanner amount = new Scanner(System.in);
        savings.setBalance(10000);
        System.out.println("Account balance: " + savings.getBalance());
        System.out.print("How much you want to withdraw?: ");
        double withdraw = amount.nextDouble();

        if (savings.withdraw(withdraw)) {
            System.out.println("Paid: " + withdraw);
        }
        else System.out.println("Not enough money");
        System.out.print("Account balance: ");
        System.out.println(savings.getBalance());

        System.out.print("How much you want to deposit?: ");
        double deposit = amount.nextDouble();
        savings.deposit(deposit);
        System.out.println("Deposit: ");
        System.out.println(savings.getBalance());
    }
}
class BankAccount {
    public BankAccount() {
        balance = 1000;
    }
    private double balance;
    double getBalance() {
        return balance;
    }
    void setBalance(double balance) {
        /*
         WARUNKI DOSTĘPU DO KONTA
         */
        this.balance = balance;
    }
    boolean withdraw(double amount) {
        if (balance < amount)
            return false;
        else balance -= amount;
        return true;
    }
    void deposit(double amount) {
        setBalance(balance + amount);
    }
}