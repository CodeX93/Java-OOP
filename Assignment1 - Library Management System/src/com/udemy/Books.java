package com.udemy;

public class Books {
    
  //data members

    private  String BookName;
    private String PublisherName;
    private int PublishedYear;
    private int Pages;
    private int IssueDate;
    private int ReturnDate;
    private int Issuemonth;
    private int Returnmonth;
    private int IssueYear;

    Books()
    {
        this.BookName="bookName";
        this.PublisherName="authorName";                //default Constructor to initialized the data members
        this.PublishedYear=3021;
        this.Pages=0;
        this.ReturnDate=0;
        this.Issuemonth=0;
        this.Returnmonth=0;
        this.IssueDate=0;
        this.IssueYear=0;

    }

    
    Books(int Year,int month,int date)
    {
        this.BookName=BookName;
        this.IssueYear=Year;
        this.PublisherName=PublisherName;      //Parameterize Constructor
         this.IssueDate= date;
        this.Issuemonth=month;


    }

//GETTER AND SETTERS FOR THE DATA MEMBERS

    public void setReturnmonth(int returnmonth) {
        Returnmonth = returnmonth;
    }

    public int getReturnmonth() {
        return Returnmonth;
    }

        public void setIssueMonth(int month) {
        this.Issuemonth = month;
    }

    public int getIssueMonth() {
        return Issuemonth;
    }

    public void setPages(int pages) {
        Pages = pages;
    }

    public int getPages() {
        return Pages;
    }

    public void setIssueDate(int issueDate) {
        IssueDate = issueDate;
    }

    public int getIssueDate() {
        return IssueDate;
    }

    public void setReturnDate(int returnDate) {
        ReturnDate = returnDate;
    }

    public int getReturnDate() {
        return ReturnDate;
    }

    public void setBookName(String bookName) {
        BookName = bookName;
    }

    public String getBookName() {
        return BookName;
    }

    public void setPublisherName(String publisherName) {
        PublisherName = publisherName;
    }

    public String getPublisherName() {
        return PublisherName;
    }

    public void setPublishedYear(int publishedYear) {
        PublishedYear = publishedYear;
    }

    public int getPublishedYear() {
        return PublishedYear;
    }



    public void setIssueYear(int issueYear) {
        IssueYear = issueYear;
    }

    public int getIssueYear() {
        return IssueYear;
    }


//GETTER SETTER FOR DATA MEMBERS END HERE.

}
