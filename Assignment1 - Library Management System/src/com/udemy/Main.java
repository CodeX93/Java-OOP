package com.udemy;

import java.awt.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

     
        Scanner sc = new Scanner(System.in);
        char choice;
        int check = 0;

            do {
                //MAIN MENUE
                System.out.print("Press '#'\tAdmin Mode. \nPress '$'\tStudent Mode. \nPress '<'\tExit. \n\nChoose from Above: ");

                choice = sc.next().charAt(0);

                if (choice == '#') {

                    //ADMIN MODE

                    Admin adm = new Admin();
                    System.out.println("Enter your Password: ");
                    String Password = sc.next();
                    adm.password(Password);

                    check = 1;

                }

                if (choice == '$') {

                    //STUDENT MODE
                Student std=new Student();
                std.Display_Student();
                check=1;

                }

                if (choice == '<') {

                    //EXITING MODE WHEN ASKED BY THE USER
                    System.out.println("\n\nTHANK YOU FOR USING\n\nProgram Ended.");
                    System.exit(0);
                } else if (choice != '#' && choice != '$' && choice != '<') {
                    System.out.println("Invalid Input.\nTry Again. \n");
                }

            } while (check == 1);

            System.out.println("Invalid Input\n");
        }


    }
