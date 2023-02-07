import java.util.Scanner;

public class Encapsulation {
    public static void main(String[] args) {
        BankAccount savings = new BankAccount();
        Scanner action = new Scanner(System.in);


        do {
            System.out.println("Account balance: " + savings.getBalance());
            System.out.println("What do you want to do?");
            System.out.println("1) Withdraw money");
            System.out.println("2) Deposit money");
            System.out.println("3) Exit");
            int decision = action.nextInt();
            switch (decision){
                case 1 -> BankAccount.withdraw();
                case 2 -> BankAccount.deposit();
                case 3 -> {return;}
            }
//            if (decision == 1) {
//                BankAccount.withdraw();
//            } else if (decision == 2) {
//                BankAccount.deposit();
//            } else if (decision == 3){
//                System.exit(0);
//            } else {
//                System.out.println("Wrong action. Try one more time");
//                return;
//            }
        } while (action.nextDouble() != 3);
    }
}
class BankAccount {
    private double balance;
    public BankAccount() {
        balance = 10000;
    }
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

    // TODO: 07.02.2023 fix 'no continue' problem & saving amount to memory
    public static void deposit() {
        BankAccount savings = new BankAccount();
        Scanner amount = new Scanner(System.in);
        System.out.print("How much you want to deposit?: ");
        double deposit = amount.nextDouble();
        savings.deposit(deposit);
        System.out.println("Deposit: " + deposit);
        savings.setBalance(savings.getBalance());
        System.out.println("Account balance: ");
        System.out.println(savings.getBalance());
    }
    public static void withdraw(){
        BankAccount savings = new BankAccount();
        Scanner amount = new Scanner(System.in);
        System.out.print("How much you want to withdraw?: ");
        double withdraw = amount.nextDouble();

        if (savings.withdraw(withdraw)) {
            System.out.println("Paid: " + withdraw);
        }
        else System.out.println("Not enough money");
        System.out.print("Account balance: ");
        System.out.println(savings.getBalance());
    }
}