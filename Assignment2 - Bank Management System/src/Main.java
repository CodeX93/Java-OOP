import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Accounts>accounts=new ArrayList<>();

    public static void main(String[] args) {

        Accounts dbs=new Accounts();
        CheckingAccounts current=new CheckingAccounts();
        SavingAccounts saving=new SavingAccounts();

        int choice;
        Scanner sc=new Scanner(System.in);
do{
    System.out.println("\n**********WELCOME TO STANDARD CHARTERED BANK**********\n\n\n\t\t\t-----Main Menu-----\n");
    System.out.println("1.\tOpen or Close Account:\n" +
                "2.\tLogin to Account\n" +
                "3.\tPerform Account Operations\n" +
                "4.\tDisplay All Account Details\n" +
                "5.\tDisplay All Account Deductions include Account Details\n" +
                "6.\tSpecify the Interest Rate for all Saving Accounts only.\n" +
                "0.\tTo Exit the Program\n\n" +
                "Chose from the above: ");
         choice=sc.nextInt();

        switch (choice) {

            case 1: {
                System.out.println("1.\tOpen a Account.\n" +
                        "2.\tClose a Account.");
                int choice2=sc.nextInt();
                if(choice2==1) {
                    System.out.println("Account Types: \n" +
                            "1.\tChecking Account\n" +
                            "2.\tSaving Account\n\n" +
                            "Choose From above: ");
                    int choice3 = sc.nextInt();
                    if (choice3 == 1) {
                        current.OpenAccount();
                    } else if (choice3 == 2) {
                        saving.OpenAccount();
                    } else System.out.println("Invalid Input.");
                }
                if(choice2==2){dbs.DeleteAccount();}
                break;
            }

            case 2: {
                    dbs.AccountLogin();
            break;
            }

            case 3: {

                System.out.println
                        ("1.\tDeposit Funds\n" +
                        "2.\tWithdraw Funds\n" +
                        "3.\tTransfer to Account\n" +
                                "4.\tApply Zakkat To Saving Account\n" +
                        "Please choose from the above:\t");
                int choice2=sc.nextInt();
                    if (choice2==1) {current.makeDeposit();}
                    else if (choice2==2) {current.makeWithdrawl();}
                    else if(choice2==3){current.checkAccount();}
                    else if (choice2==4){saving.calculateZakat();}
                    else if(choice2!=1 && choice2!=2 && choice2!=3){System.out.println("Invalid Input.");}
                break;
            }

            case 4: {

                dbs.Print_Statement();
                break;
            }

            case 5: {
                System.out.print("Display All Account Deductions including Details ");
                    dbs.AllDetails_withDeduction();
                    break;
            }

            case 6: {
                System.out.print("Please Enter the interest Rate applicable to Saving Accounts only: ");
                double interest = sc.nextDouble();
                saving.calculateInterest(interest);

                break;
            }

            case 0: {
                System.out.println("Thanks for Using,\nProgram Ended.");
                System.exit(0);
            }

            default:
                System.out.println("Invalid Input.\nTry Again");
          }

    }while(choice>0 );

  }

}

