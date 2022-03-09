package com.udemy;


import java.util.Scanner;


public class Admin {

    Scanner sc=new Scanner(System.in);
    //static Books []AvailableBooks=new Books[120];
    //Student student=new Student();
    //Books bb=new Books();
    static int i=0;         
    String NewPassword;

    static int counter=0;
    int choice;
    char ask;


//Display Function for Admin Menue
public void Display_Admin(){                    //Menue Mode for Admin

    do{

        System.out.println("-------(Admin)-Library Management System--------\n");

        System.out.println(
            "Press 1\t to add a new book.\n" +
            "Press 2\t to modify a book record.\n" +
            "Press 3\t to delete a book detail.\n" +
            "Press 4\t Show All Issue books\n" +
            "Press 6\t to view all available books.\n" +
            "Press 7\t to view the records of all books issued in a particular month\n" +
            "Press 8\t to change the password.\n" +
            "Press 9\t to go back to general menu.\n\n");
    System.out.print("Choose from Above: ");
    choice=sc.nextInt();

    switch (choice) {

        case 1: {

            Add_book();            // Function to add a book
            break; }
        case 2: {
            Modify_Book_Record();   // Function to modify's book name,author name, published year, no of pages
            break; }
        case 3: {
            System.out.println("Delete Book");      

            Delete_Book();          //Function to Delete the entire books detail
            break; }
        case 4:{Issue_Books();
                break;}              //Function to view the all the issue date, issue month of book issued by the student
        case 6: {Available_Book();
                break;}
        case 7:{View_Recordsof_Month_IssuedBook();      //View the specific book for specific month
                break;}
        case 8: {ChangePassword();                  //Function to change the password of Admin by entering his previous password only
                break;} 
        }
    }while (choice>=1 && choice <=8 && choice!=5);
}


public void Add_book(){
Books []  books=new Books[10];          //Object of array of Book named as books

do {

    books[i]=new Books();              //Linking/Associating array of Books with its object to store all the details of process in array of size 120
            sc.nextLine();
    
    
            System.out.print("Please Enter the BookName: ");
    String NewBookName = sc.nextLine();

    System.out.print("Please Enter the Author Name for Book " + NewBookName + ": ");
    String NewAuthorName = sc.nextLine();

    System.out.print("Please Enter the Publisher Year of " + NewBookName + ": ");
    int NewPublishYear = sc.nextInt();
    System.out.print("Please Enter the Number of pages of " + NewBookName + ": ");
    int NewBookPages = sc.nextInt();
    
    //initializing inputs to the setter  functions in array  declared in Student Class.
    books[i].setBookName(NewBookName);
    books[i].setPublisherName(NewAuthorName);
    books[i].setPublishedYear(NewPublishYear);
    books[i].setPages(NewBookPages);

    AvailableBooks[i] = books[i];           //Static Array in order to make the changes save to store entire info of books

    counter++;
    i++;
    System.out.println("Book Added Successfully...!");
    System.out.print("Do you want to add more? (Y/N) :\t");
    ask = sc.next().charAt(0);

}while(ask=='Y'|| ask=='y') ;

}



public void Modify_Book_Record()
{

    int getter=0;
    System.out.println("Please Enter the Name of Book:\t ");
    sc.nextLine();
    String checkName=sc.nextLine();
    for (int i=0; i<counter; i++)
    {
        if (checkName.equals(AvailableBooks[i].getBookName()))          //Check booksName individually for specific access to the book required by the user.
        {

            System.out.print("Please Enter the New BookName: ");
            String NewBookName = sc.nextLine();
            System.out.print("Please Enter the New Author Name for Book " + NewBookName + ": ");
            String NewAuthorName = sc.nextLine();
            System.out.print("Please Enter the  New Publisher Year of " + NewBookName + ": ");
            int NewPublishYear = sc.nextInt();
            System.out.print("Please Enter the New Number of pages of " + NewBookName + ": ");
            int NewBookPages = sc.nextInt();

             //initializing inputs to the setter  functions in array  declared in Student Class.
            AvailableBooks[i].setBookName(NewBookName);
            AvailableBooks[i].setPublisherName(NewAuthorName);
            AvailableBooks[i].setPublishedYear(NewPublishYear);
            AvailableBooks[i].setPages(NewBookPages);

        }
        else System.out.println("No Book Found.\nSORRY.");
        break;
    }



}


public void Delete_Book()
{
    boolean b=false;
    System.out.print("Please Enter the name of book you like to Delete:\t");
    sc.nextLine();
    String DelBook=sc.nextLine();
        for (int i=0; i<counter;i++)
        {
            if(DelBook.equals(AvailableBooks[i].getBookName()))
            {
                    AvailableBooks[i]=null;
                    b=true;
                    break;
            }
        }
        if(!b){
            System.out.println("No book found.");
        }
}

public void Issue_Books()
    {
        for (int i=0; i< AvailableBooks.length; i++)
        {
            if(AvailableBooks[i]!=null) {
                System.out.println("All Issued Books");
                System.out.println("Book Name:\t" + AvailableBooks[i].getBookName());
                System.out.println("Issue Date-Issue Month-Issue-Year:\t" + AvailableBooks[i].getIssueDate() + " - " + AvailableBooks[i].getIssueMonth() + " - " + AvailableBooks[i].getIssueYear());
            }
            if(AvailableBooks[i]==null) {
                    break;
            }
        }
    }

public void Available_Book()
{
    System.out.println("Available Books\n");

    for( int i=0; i<counter; i++)
    {
            if(AvailableBooks[i]!=null)
            {
                System.out.println("Book Name:\t "+AvailableBooks[i].getBookName());
                System.out.println("Author Name:\t "+AvailableBooks[i].getPublisherName());
                System.out.println("Published Year:\t "+AvailableBooks[i].getPublishedYear());
                System.out.println("");
            }
            else System.out.println("No Book found in RECORDS");
    }
        System.out.println("That's All. \n\n");
}


public void View_Recordsof_Month_IssuedBook()
{
    System.out.println("Records of Issue Book Book");
    System.out.println("Issue Book");

int month;
    System.out.println("Enter Month:\t ");
    month=sc.nextInt();

    while(month<1 || month >12) {
        System.out.println("Enter Month:\t ");
        month=sc.nextInt();


    }

        for (int i = 0; i < AvailableBooks.length; i++) {


            if(Admin.AvailableBooks[i] != null)            //If Available Book array is not empty, proceed for further instructions
             {
                if (month == (AvailableBooks[i].getIssueMonth()))       //Individually compare the array month stored with the month of books issued to be specific
                {

                    System.out.println("Book Name:\t" + AvailableBooks[i].getBookName());
                    System.out.println("Date:\t" + AvailableBooks[i].getIssueDate());
                    System.out.println("Month:\t" + AvailableBooks[i].getIssueMonth());
                    System.out.println("Year:\t" + AvailableBooks[i].getIssueYear());


                }
            }
        }

    }


public void ChangePassword()
    {
        System.out.println("Change Password");
        System.out.print("Please Enter your Current password: ");
        sc.nextLine();
        String pass=sc.nextLine();
        if(pass.equals("123"))
        {
            System.out.print("Enter your New Password: ");
            NewPassword=sc.nextLine();
        }
        else System.out.println("Incorrect Password.");

    }

public void password(String Password)
{

        if(Password.equals("123"))
        {
                Display_Admin();
        }
        else
                System.out.println("Invalid Password.");
}




}
