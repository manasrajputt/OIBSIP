import java.util.Scanner;
class UserAccount
{
    int username=1234;
    int password=0001;
    int total_withdraw=0;
    int total_deposit=0;
    int total_transfer=0;
    int current_balance=0;
    public boolean login(int user,int password)
    {
        return user==username && password == password;
    }
    public void view_transaction()
    {
        System.out.println("Total Money Withdraw: "+total_withdraw);
        System.out.println("Total Money Deposited: "+total_deposit);
        System.out.println("Total Money Transferred: "+total_transfer);
    }
    public void withdraw(int with_amount)
    {
        if(current_balance-with_amount>1000)
        {
            current_balance-=with_amount;
            total_withdraw+=with_amount;
        }
        else
        {
            System.out.println("Isufficient Balance");
        }
    }
    public void deposit(int depo_amount)
    {
        current_balance+=depo_amount;
        total_deposit+=depo_amount;
    }
    public void transfer(int ben_account,int trans_amount)
    {
        if(current_balance-trans_amount>1000)
        {
            current_balance-=trans_amount;
            total_transfer+=trans_amount;
            System.out.println("Rs. "+trans_amount+" is transferred in Account: "+ben_account);
        }
    }
}
public class ATMapp {
    public static void main(String args[])
    {
        int user, password;
        Scanner sc = new Scanner(System.in);
        UserAccount account = new UserAccount();
        int choice = -1;
        while (choice != 6) {
            System.out.println("Enter user_name: ");
            user = sc.nextInt();
            System.out.println("Enter Password: ");
            password = sc.nextInt();
            boolean login_status = account.login(user, password);
            if (login_status) {
                System.out.println("\t\t\t\tWelcome to the ATM System");
                System.out.println("1. View Transctions");
                System.out.println("2. Withdraw");
                System.out.println("3. Deposit");
                System.out.println("4. Transfer");
                System.out.println("5. Check Balance");
                System.out.println("6. Exit");
                System.out.println();
                System.out.println("Enter your choice(1-6): ");
                choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        account.view_transaction();
                        break;

                    case 2:
                        System.out.println("Enter the amount: ");
                        int with_amount = sc.nextInt();
                        System.out.println("Are you sure(Y/N):");
                        char yes_no = sc.next().charAt(0);
                        if ('y' == yes_no || yes_no == 'Y') {
                            account.withdraw(with_amount);
                            System.out.println("Thank you");
                        }
                        break;

                    case 3:
                        System.out.println("Enter the amount to be deposited: ");
                        int depo_amount = sc.nextInt();
                        account.deposit(depo_amount);
                        break;

                    case 4:
                        System.out.println("Enter the Beneficiary account number: ");
                        int ben_account = sc.nextInt();
                        System.out.println("Enter the amount to be transfer: ");
                        int trans_amount = sc.nextInt();
                        System.out.println("Are you sure want to transfer " + trans_amount + " in Account NO:" + ben_account);
                        char transfer_choice = sc.next().charAt(0);
                        if ('y' == transfer_choice || transfer_choice == 'y') {
                            account.transfer(ben_account, trans_amount);
                            System.out.println(" Thank you ");
                        }
                        break;
                    case 5:
                        System.out.println("Your current balance is: " + account.current_balance);
                        break;
                }
            } else {
                System.out.println("Invalid User name or password:");
                System.out.println("1. Retry");
                System.out.println("2. Exit");
                byte ans = sc.nextByte();
                if (ans == 2)
                    choice = 6;
            }
            System.out.println("\n\n\n\n");
        }
    }
}
