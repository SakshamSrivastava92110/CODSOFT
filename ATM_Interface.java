import java.util.Scanner;
class Bank_Account {
    private double Balance;  
    public Bank_Account(double Initial_Balance){
        this.Balance = Initial_Balance;
    }
    public double getBalance(){
        return Balance;
    }
    public void deposit(double amount) {
        if (amount > 0){
            Balance += amount;
            System.out.println("Deposit successful. New Balance: ₹" + Balance);
        } 
        else{
            System.out.println("Invalid deposit amount.");
        }
    }
    public boolean withdraw(double amount){
        if (amount > 0){
            if (amount <= Balance) {
                Balance -= amount;
                System.out.println("Withdrawal successful. New Balance: ₹" + Balance);
                return true;
            }
            else {
                System.out.println("Insufficient funds for withdrawal. Current Balance: ₹" + Balance);
            }
        }
        else{
            System.out.println("Invalid withdrawal amount. Please enter a positive amount.");
        }
        return false;
    }
}

class ATM_Machine {
    Scanner sc = new Scanner(System.in);
    private Bank_Account Bank_Account;
    public ATM_Machine(Bank_Account Bank_Account) {
        this.Bank_Account = Bank_Account;
    }
    public void displayMenu(){
        System.out.println("ATM Options :");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Exit");
    }
    public void run(){
        while (true){
            displayMenu();
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            switch (choice){
                case 1:
                    System.out.println("Current Balance: ₹" + Bank_Account.getBalance());
                    break;
                case 2:
                    System.out.print("Enter the deposit amount: ₹");
                    double deposit_amount = sc.nextDouble();
                    Bank_Account.deposit(deposit_amount);
                    break;
                case 3:
                    System.out.print("Enter the withdrawal amount: ₹");
                    double withdrawal_amount = sc.nextDouble();
                    boolean withdrawSuccess = Bank_Account.withdraw(withdrawal_amount);
                    if (withdrawSuccess) 
                        System.out.println("Withdrawal successful.");
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. GoodBye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
public class ATM_Interface{
    public static void main(String[] args){
        Bank_Account user_account = new Bank_Account(0.0); // Initial Balance is ₹1000
        ATM_Machine atm = new ATM_Machine(user_account);
        atm.run();
    }
}