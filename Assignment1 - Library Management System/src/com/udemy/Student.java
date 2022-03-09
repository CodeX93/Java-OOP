package com.udemy;

import java.util.Scanner;

public class Student {

    Scanner sc = new Scanner(System.in);            
    static Admin admin = new Admin();           //STATIC OBJECT OF ADMIN TAKEN TO USED THE AVAILABLEBOOKS Arrray and other functions implemented in Admin class                  
    int choice;

    public void Display_Student() {

        do {
                        //STUDENT Menu

            System.out.println("-------(Student)-Library Management System--------\n");

            System.out.println("Press 1\t to search a book available in the library stock.\n" +
                    "Press 2\t to borrow a particular book from library.\n" +
                    "Press 3\t to read a particular book\n" +
                    "Press 4\t Return the Book.\n" +
                    "Press 5\t Go back to Main Menue\n\n");
            System.out.print("Choose from Above: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1: {
                    Search_book();
                    break;
                }
                case 2: {
                    Borrow_Book();
                    break;
                }
                case 3: {
                    Read_Book();
                    break;
                }
                case 4: {
                    Return_Book();
                    break;
                }
            }
        } while (choice >= 1 && choice <= 3);

    }


    public void Search_book() {
        System.out.println("In Search Book");               //display all the available books stored by Admin
        admin.Available_Book();

    }

    public void Borrow_Book() {                         //Store the details while borrowing books and storing in AvailableBook of Admin Class.
        System.out.println("In Borrow Book");           
        admin.Available_Book();

        System.out.println("To borrow a Book\n\n ");
        System.out.println("You have to Return with 3 days, otherwise you will be fined for Rs 500");
        sc.nextLine();
        System.out.println("Enter Book Name: \t");
        String name = sc.nextLine();

        for (int i = 0; i < Admin.AvailableBooks.length; i++) {

            if (name.equals(Admin.AvailableBooks[i].getBookName())) //Check Bookname for Specific pointing/access required by the user 
            {         
                System.out.print("What is the date today: ");
                int date = sc.nextInt();
                System.out.println("What is the month today: ");
                int month = sc.nextInt();
                System.out.println("What is the year today: ");
                int year = sc.nextInt();

                Admin.AvailableBooks[i].setIssueDate(date);
                Admin.AvailableBooks[i].setIssueMonth(month);
                Admin.AvailableBooks[i].setIssueYear(year);
            } else System.out.println("There is No Book with this name.\nSelect from the books in Available Section\n");
            break;
        }
    }


    public void Read_Book() {                               //Read Specific Book demanded by the user(Student)
        System.out.println("In Read Book");

        System.out.print("Which Book you like to read:\t");
        sc.nextLine();
        String ReadBook=sc.nextLine();

        for (int i=0; i<Admin.AvailableBooks.length;i++)            
        {
            if(ReadBook.equals(Admin.AvailableBooks[i].getBookName())) {        //Check if Book is Available
                System.out.println("Book Name: " + Admin.AvailableBooks[i].getBookName());
                System.out.println("Reading Mode here");
                break;
            }
else  System.out.println("No Book Available with such Name, Books Are only Available which is shown in Search Tab\tAsk Admin to add this book\n");
        }





    }


    public void Return_Book() {             //Get Details from User(Student) while the student returns the book in AvailableBooks Array of Admin Class
        System.out.println("In Return Book");
int dateDiff=0;
int monthDiff=0;
        System.out.print("Enter the Book Name which you want to return:\t");
        sc.nextLine();
        String ReturnBookName = sc.nextLine();
        for (int i = 0; i < Admin.AvailableBooks.length; i++) {

            if (ReturnBookName.equals(Admin.AvailableBooks[i].getBookName())) {
                System.out.print("What is the date today: ");
                int date = sc.nextInt();
                System.out.println("What is the month today: ");
                int month = sc.nextInt();

                Admin.AvailableBooks[i].setReturnDate(date);                //Setting Date of Returning
                Admin.AvailableBooks[i].setReturnmonth(month);              //Setting Month of Returning

                 dateDiff = Admin.AvailableBooks[i].getReturnDate() - Admin.AvailableBooks[i].getIssueDate();       //Find the days exceed after issuing by counting date
                 monthDiff = Admin.AvailableBooks[i].getReturnmonth() - Admin.AvailableBooks[i].getIssueMonth();    //Find the month exceed after issuing by counting months
                    break;
                }
            else System.out.println("Book Not found.\tTry Again...\n");

            }
        if (dateDiff > 3 || monthDiff >= 1)
        {
            System.out.println("You returned the book late, you have been charged Rs 500.\n");
        }
            else System.out.println("Book Returned Successfully\nNo Fine..");


        }


    }

