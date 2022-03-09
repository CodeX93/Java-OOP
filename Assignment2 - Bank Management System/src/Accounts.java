import java.util.Scanner;

public class Accounts {
    Scanner sc=new Scanner(System.in);
//----------------------------------------------------------------------------------------------------------------------
//All Major Data Members used in the Banking System (Encapsulated)

    static int i=0;
    private String Name;
    private String Address;
    private String PhoneNumber;
    private String AccountNumber;
    private double Balance;
    private int count;

    private int OpenDate;
    private int OpenMonth;
    private int OpenYear;
    private double Deduction;
    private double Zakat;
    private String AccountType;
    private double DepositMoney;
    private double WithdrawMoney;
    private int DepositDate;
    private int WithDrawDate;
    private int DepositMonth;
    private int WithDrawMonth;

//SETTERS OF DATA MEMBERS

    public void setName(String name) {Name = name;}
    public void setAddress(String address) {Address = address;}
    public void setPhoneNumber(String phoneNumber) {PhoneNumber = phoneNumber;}
    public void setAccountNumber(String accountNumber) {AccountNumber = accountNumber;}
    public void setBalance(double balance) {Balance = balance;}
    public void setCount(int count) {this.count = count;}
    public void setZakat(double zakat){this.Zakat=zakat;}

    public void setDepositMoney(double depositMoney){this.DepositMoney=depositMoney;}
    public void setDepositDate(int depositDate) {
        if(depositDate<32 && depositDate>0){
            DepositDate = depositDate;}
        else System.out.println("Invalid Date.");}

    public void setDepositMonth(int depositMonth) {
        if(depositMonth<13 && depositMonth>0){
        DepositMonth = depositMonth;}
        else System.out.println("Invalid Month");}

        public void setWithdrawMonth(int withdrawMonth){
            if(withdrawMonth<13 && withdrawMonth>0){
                WithDrawMonth=withdrawMonth;
            }else System.out.println("Invalid Month");}

    public void setWithDrawDate(int withDrawdate) {
        if(withDrawdate<32 && withDrawdate>0){
        WithDrawDate = withDrawdate;
    }else System.out.println("Invalid Date");}

    public void setOpenDate(int date) {
        if(date<32 && date>0){
        OpenDate = date;}else System.out.println("Invalid Date");}
    public void setOpenMonth(int month) {
        if(month<13 && month>0){
        OpenMonth = month;}else System.out.println("Invalid Month");}
    public void setOpenYear(int year) {OpenYear = year;}
    public void setDeduction(double deduction) {Deduction = deduction;}
    public void setAccountType(String accountType) {AccountType = accountType;}
    public void setWithdrawMoney(double WithDrawMoney){this.WithdrawMoney=WithDrawMoney;}

    //GETTERS OF DATA MEMBERS

    public String getName() {return Name;}
    public String getAddress() {return Address;}
    public String getPhoneNumber() {return PhoneNumber;}
    public String getAccountNumber() {return AccountNumber;}
    public double getBalance() {return Balance;}
    public String getAccountType() {return AccountType;}


    public int getOpenDate() {return OpenDate;}
    public int getOpenMonth() {return OpenMonth;}
    public int getOpenYear() {return OpenYear;}
    public double getDeduction() {return Deduction;}
    public double getZakat() {return Zakat;}
    public int getCount() {return count;}
    public double getDepositMoney(){return DepositMoney;}
    public double getWihdrawMoney(){return WithdrawMoney;}
    public int getDepositDate() {return DepositDate;}

    public int getWithDrawDate() {return WithDrawDate;}

    public int getDepositMonth() {return DepositMonth;}

    public int getWithDrawMonth() {return WithDrawMonth;}

    //Default Constructor
    Accounts(){
        Name="Haider";
        AccountNumber="00100778";
        Address="F-7";
        PhoneNumber="3165000";
        Balance=3400000;
        OpenDate=24;
        OpenMonth=4;
        OpenYear=21;
        Deduction=0;
    }
//----------------------------------------------------------------------------------------------------------------------
//Method used to Delete a function
    public void DeleteAccount() {
        boolean flag=false;
        System.out.print("Please Enter your Account Number: ");
        String accNumber = sc.next();
        for (Accounts i : Main.accounts) {
            if(!Main.accounts.isEmpty()){
                if (accNumber.equals(i.getAccountNumber())) {
                    flag=true;
                    Main.accounts.remove(i);            //Delete All the contents of ArrayList of particular Account No.
                    System.out.println("Account Closed Successfully.");
                    break;
                }
            }
        }
        if(!flag){System.out.println("Account not Found"); }
    }
//----------------------------------------------------------------------------------------------------------------------
//Method Use to login by telling Account Title and its balance by comparing the account Number input from the database
    public void AccountLogin() {
        System.out.print("Enter the account number: ");
        String accNumber = sc.next();
        for (Accounts i : Main.accounts) {
            if (accNumber.equals(i.getAccountNumber())) {
                System.out.println("Welcome "+i.getName()+"!");
                System.out.println("Balance in this account is: " + i.getBalance());
            }
        }
    }
//----------------------------------------------------------------------------------------------------------------------
//Display All Account Details except taxes and Zakat and Interest
    public void Print_Statement(){
        System.out.println("Showing Account Details... ");

        for (Accounts i : Main.accounts) {
            System.out.println("\n\nTitle of Account: " + i.getName());
            System.out.println("Account Number:\t"+i.getAccountNumber());
            System.out.println("Account Type: " + i.getAccountType());
            System.out.println("Account Created - Date/Month/Year:\t"+i.getOpenDate()+"/"+i.getOpenMonth()+"/"+i.getOpenYear());
            System.out.println("Current Balance:\t"+i.getBalance());
            System.out.println("Postal Address:\t"+i.getAddress());
            System.out.println("Contact No:\t"+i.getPhoneNumber());
            System.out.print("\n\n");
        }
    }
//----------------------------------------------------------------------------------------------------------------------
//Transfer of Funds among Accounts, the amount is received by the sender which is done in CheckingAccount class at CheckAccount Method
    public void makeTransfer(double transferFunds) {

        System.out.print("Enter the account number of Recipient: ");
        String accNumber = sc.next();
        for (Accounts i : Main.accounts) {
            if (accNumber.equals(i.getAccountNumber())) {
                i.setBalance(i.getBalance() + transferFunds);

                System.out.println("Funds Transferred Successfully.");
                System.out.println("Yours current Balance is: "+i.getBalance());
            }
        }
    }
//----------------------------------------------------------------------------------------------------------------------
//Display each and every details of Account, including all the taxes, interest and Zakat deducted from the total Balance
public void AllDetails_withDeduction() {

    for (Accounts i : Main.accounts) {

        if (i.getAccountType().equals("Checking Account")) {

            System.out.println("\n\nAccount Title:\t" + i.getName());
            System.out.println("Account Number:\t" + i.getAccountNumber());
            System.out.println("Account Type:\t" + i.getAccountType());
            System.out.println("Tax Deduction:\t" + i.getDeduction());
            setBalance((i.getBalance()-i.getDeduction()));
            System.out.println("Current Balance:\t" + (i.getBalance()));
            System.out.println("Account Created Date/Month/Year\t" + i.getOpenDate() + "/" + i.getOpenMonth() + "/" + i.getOpenYear());
            System.out.println("Deposit Transaction Details:\t"+i.getDepositDate()+"/"+i.getDepositMonth()+"\tAmount: "+i.getDepositMoney());
            System.out.println("Withdrawl Transaction Details:\t"+i.getWithDrawDate()+"/"+i.getWithDrawMonth()+"\tAmount: "+i.getWihdrawMoney());
            System.out.println("Account Holder's Postal Address:\t" + i.getAddress());
            System.out.println("Contact Number:\t" + i.getPhoneNumber());
            }
        if (i.getAccountType().equals("Saving Account")) {
            System.out.println("\n\nAccount Title:\t" + i.getName());
            System.out.println("Account Number:\t" + i.getAccountNumber());
            System.out.println("Account Type:\t" + i.getAccountType());
            System.out.println("Interest and Zakat:\t  " + i.getDeduction() +"  \t"+ i.getZakat());
            setBalance((i.getBalance()-(i.getDeduction()+i.getZakat())));
            System.out.println("Current Balance:\t" + (i.getBalance()));
            System.out.println("Account Created Date/Month/Year\t" + i.getOpenDate() + "/" + i.getOpenMonth() + "/" + i.getOpenYear());
            System.out.println("Account Holder's Postal Address:\t" + i.getAddress());
            System.out.println("Contact Number:\t" + i.getPhoneNumber());
            }
        }
    }
//----------------------------------------------------------------------------------------------------------------------
    //Calculate Taxes for the CheckingAccount if the transaction is more than twice in a month
    public void Deduction(int count,String ACN) {

        for (Accounts i: Main.accounts) {
            if(i.getAccountNumber().equals(ACN)) {
                if (count > 2 ) {
                    double rate = count * 10;
                    i.setDeduction(rate);
                } else i.setBalance(i.getBalance());
            }
        }

    }
//----------------------------------------------------------------------------------------------------------------------
public Boolean CHECK(String acn){
    for (Accounts i: Main.accounts) {
        if(i.getAccountNumber().equals(acn)) {

            System.out.println("Account with this account Number is already there. You Cannot Create another account");
            return true;

        }


    }
return  false;

}


}
