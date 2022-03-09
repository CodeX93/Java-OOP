import java.util.Scanner;

public class CheckingAccounts extends Accounts {

    int count = 0;
    Scanner sc = new Scanner(System.in);

    CheckingAccounts() {
        super();}
//----------------------------------------------------------------------------------------------------------------------
//Ask Users to input necessary details for opening up an Account --- Opening Checking Account
    public void OpenAccount() {
        Accounts[] acc = new Accounts[10];
        String AccountType = "Checking Account";

        for (; i < 10; i++) {
            acc[i] = new Accounts();
            System.out.println("CHECKING ACCOUNT DEPARTMENT");

            System.out.println("Account Number: ");
            String acn = sc.next();


            System.out.println("Title of Account: ");
            String Name = sc.next();

            System.out.println("Address: ");
            String Address = sc.next();

            System.out.println("Phone Number: ");
            String PhoneNum = sc.next();

            System.out.println("Please Make a Deposit: ");
            double balance = sc.nextDouble();

            System.out.println("Today's Date: ");
            int date = sc.nextInt();
            System.out.println("Today's Month: ");
            int month = sc.nextInt();
            System.out.println("Today's Year: ");
            int year = sc.nextInt();
//Setting All the inputs to the setters in Array of CheckingList named as acc.
            acc[i].setAccountNumber(acn);
            if(CHECK(acn)){break;}
            acc[i].setName(Name);
            acc[i].setAddress(Address);
            acc[i].setPhoneNumber(PhoneNum);
            acc[i].setBalance(balance);
            acc[i].setOpenDate(date);
            acc[i].setOpenMonth(month);
            acc[i].setOpenYear(year);
            acc[i].setAccountType(AccountType);
//Putting an entire Array of CheckingAccount to ArrayList declared in Main class named as accounts.
            Main.accounts.add(acc[i]);

            System.out.println("Do you want to Enter another Account(Y/N): ");
            char choice = sc.next().charAt(0);

            if (choice == 'Y' || choice == 'y') {
                continue;
            } else {i++;}
            break;
        }
    }
//----------------------------------------------------------------------------------------------------------------------
//Deposit Money from Checking Account

    public void makeDeposit() {
        System.out.print("Enter your account number: ");
        String accNumber = sc.next();
        for (Accounts i : Main.accounts) {
            if (accNumber.equals(i.getAccountNumber())) {
                System.out.print("Please Enter the Amount you like to Deposit: ");
                double DepositMoney = sc.nextDouble();
                System.out.print("Please Enter Deposit Date:\t");
                int date=sc.nextInt();
                System.out.print("Please Enter Deposit Month:\t");
                int month=sc.nextInt();
            //Setting Deposit Date and Month to Date-Month Setters declared in Account Class
                i.setDepositMoney(DepositMoney);
                i.setDepositDate(date);
                i.setDepositMonth(month);
                i.setBalance((i.getBalance() + DepositMoney));
                count++;                                            //Counter to count the transactions numbers made
                i.setCount(count);

                if(i.getAccountType().equals("Checking Account")){Deduction(i.getCount(),i.getAccountNumber());}

                System.out.println("Money Deposit Successfully.");
            }
        }
    }
//----------------------------------------------------------------------------------------------------------------------
//WithDraw Money from Checking Account
    public void makeWithdrawl() {
        System.out.print("Enter your account number: ");
        String accNumber = sc.next();
        for (Accounts i : Main.accounts) {
            if (accNumber.equals(i.getAccountNumber())) {
                System.out.println("Yours current Balance is: "+i.getBalance());
                System.out.print("Please Enter the Amount you like to Withdraw: ");
                double WithdrawMoney = sc.nextDouble();

                System.out.print("Please Enter WithDrawl Date:\t");
                int date=sc.nextInt();
                System.out.print("Please Enter WithDrawl Month:\t");
                int month=sc.nextInt();

               i.setWithDrawDate(date);
               i.setWithdrawMonth(month);

                double max=i.getBalance()+5000;

                if (WithdrawMoney > i.getBalance() && i.getAccountType().equals("Checking Account") && WithdrawMoney <=max) {
                    i.setWithdrawMoney(WithdrawMoney);
                    i.setBalance((i.getBalance() - WithdrawMoney));
                    count++;                                             //Counter to count the transactions numbers made
                    i.setCount(count);
                    Deduction(i.getCount(),i.getAccountNumber());

                    System.out.println("Money Withdrawn Successfully.");
                    System.out.println("Yours current Balance is: "+i.getBalance());
                } else if (i.getAccountType().equals("Checking Account") && WithdrawMoney > max) {
                    System.out.println("Insufficient Funds.\nTransaction Cancelled");
                    break;
                }
                if(WithdrawMoney<=i.getBalance() && i.getAccountType().equals("Saving Account")) {
                    i.setBalance(i.getBalance() - WithdrawMoney);
                    i.setWithdrawMoney(WithdrawMoney);
                    System.out.println("LoL");
                    System.out.println("Money WithDrawn Successfully.");
                    System.out.println("Yours current Balance is: " + i.getBalance());
                    break;
                }else if (WithdrawMoney>i.getBalance() && i.getAccountType().equals("Saving Account"))
                {i.setBalance(i.getBalance());
                i.setWithdrawMoney(0);
                    System.out.println("Insufficient Funds\nTransaction Cancelled");break;}
            }
        }
    }
//----------------------------------------------------------------------------------------------------------------------
//To Verify if the Account Exist and proceed for the transfer of Funds to the other Account
    public void checkAccount() {
        System.out.print("Enter Your account number: ");
        String accNumber = sc.next();
        for (Accounts i : Main.accounts) {
            if (accNumber.equals(i.getAccountNumber())) {
                System.out.print("Enter the amount you want to transfer: ");
                double transferFund = sc.nextDouble();

                double max=i.getBalance()+5000;
                if (transferFund < i.getBalance() && i.getAccountType().equals("Saving Account") ) {
                    i.setBalance(i.getBalance()-transferFund);
                    makeTransfer(transferFund);             //Call the Recipient Account for the Transfer Verification and Proceedings
                }
                if (transferFund < i.getBalance() && i.getAccountType().equals("Checking Account")&& transferFund<=max) {
                    i.setBalance(i.getBalance()-transferFund);
                    makeTransfer(transferFund);
                    count++;
                    i.setCount(count);
                    Deduction(i.getCount(),i.getAccountNumber());

                } else System.out.println("WithDrawl Limit Exceed");
            }
        }
    }

}//---------------------------------------------------------------------------------------------------------------------



