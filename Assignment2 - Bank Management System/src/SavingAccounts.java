import java.util.ArrayList;
import java.util.Scanner;

public class SavingAccounts extends Accounts {
    Scanner sc = new Scanner(System.in);
//Data Members
    private double interestRate;
//----------------------------------------------------------------------------------------------------------------------
//Getters and Setters of Data Members
    public void setInterestRate(double interestRate) {this.interestRate = interestRate;}
    public double getInterestRate() {return interestRate;}
//----------------------------------------------------------------------------------------------------------------------
//Ask Users to input necessary details for opening up an Account --- Opening Saving Account
    public void OpenAccount() {
        Accounts[] saveAccount = new Accounts[10];
        String AccountType = "Saving Account";

        for (; i < 10; i++) {
            saveAccount[i] = new Accounts();
            System.out.println("SAVING ACCOUNT DEPARTMENT");

            System.out.println("Account Number: ");
            String acn = sc.next();
            if(CHECK(acn)){break;}
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
//Setting All the inputs to the setters in Array of SavingAccount named as saveAccount.
            saveAccount[i].setAccountNumber(acn);
            saveAccount[i].setName(Name);
            saveAccount[i].setAddress(Address);
            saveAccount[i].setPhoneNumber(PhoneNum);
            saveAccount[i].setBalance(balance);
            saveAccount[i].setOpenDate(date);
            saveAccount[i].setOpenMonth(month);
            saveAccount[i].setOpenYear(year);
            saveAccount[i].setAccountType(AccountType);
//Putting All the details of Saving Account to the ArrayList, named as account declared in Main class
            Main.accounts.add(saveAccount[i]);

            System.out.println("Do you want to Enter another Account(Y/N): ");
            char choice = sc.next().charAt(0);

            if (choice == 'Y' || choice == 'y') {
                continue;
            } else {
                i++;
                break;
            }
        }
    }
//----------------------------------------------------------------------------------------------------------------------
//Calculate Zakat on certain Accounts specified by the user on RunTime
public void calculateZakat() {
    System.out.println("Please Enter Account Number for the account you want to deduct Zakat from it: ");
    String ACN = sc.next();
    for (Accounts i : Main.accounts) {
        if (ACN.equals(i.getAccountNumber()) && i.getAccountType().equals("Saving Account") && i.getBalance() >= 20000) {
            {
                double zakat = (i.getBalance() * 2.5) / 100;
                i.setZakat(zakat);
                break;
            }
        }
    }
}
//----------------------------------------------------------------------------------------------------------------------
//Calculate Interest with help of Simple Interest formula by the rate specified by the user on RunTime
    public void calculateInterest(double interestRate) {

        for (Accounts i : Main.accounts) {
            if (i.getAccountType().equals("Saving Account")) {

                double interest = ((i.getBalance() * interestRate * 1) / 100);
                i.setDeduction(interest);
                i.setBalance(i.getBalance() - interest);
                System.out.println("Interest Rate set for all Saving Accounts");
            }
        }
    }
//----------------------------------------------------------------------------------------------------------------------
}