package org.example;
import javax.xml.transform.Source;
import java.sql.SQLOutput;
import java.util.*;

public class Main {
    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {


        Book[] books = new Book[30];
        books[0] = new Book(15, " Echoes of the Forgotten Sky", "978-1-78612-845-0");
        books[1] = new Book(61, "The Orchard Beneath the Ashes", "978-0-59318-429-2");
        books[2] = new Book(45, "Midnight Algorithms", "978-1-52478-003-6");
        books[3] = new Book(25, "Salt & Spirit: Tales from the Northern Shore", "978-0-43955-722-1");
        books[4] = new Book(11, "Blueprint for a Broken City", "978-1-67031-118-4");
        books[5] = new Book(50, "Letters to the Moonflower Café", "978-0-31647-911-7");

        menu(books);


    }
    public static void menu(Book[] books) {
        int input;
        do {
            System.out.println("\n--Neighborhood Library--");
            System.out.println(" 1 - Show Available Books");
            System.out.println(" 2 - Show Checked Out Books");
            System.out.println(" 3 - Exit");
            System.out.print("Enter your choice: ");
            input = scan.nextInt();
            switch (input) {
                case 1:
                    showBooks(books);
                    checkExit(books);
                    break;
                case 2:
                    showCheckOut(books);
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("Invalid Input");
            }
        } while (input > 3);
    }
    public static void checkIn(Book[] books){
        boolean isCheck = false;
        int idIn, i;

        do {
            System.out.println("\nEnter Book ID or 0 to Home Screen");
            System.out.print("Book ID: ");
            idIn = scan.nextInt();

            if(idIn == 0){
                menu(books);
                break;
            }
            try {
                for (i = 0; i < books.length; i++) {
                    if (idIn == books[i].id && books[i].isCheckOut == true) {
                        books[i].setCheckOut(false);
                        books[i].setCheckedOutTo("");
                        isCheck = true;
                        System.out.println("\n-------------------------");
                        System.out.println("Successfully Check In!!");
                        System.out.println("⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️");
                        books[i].checkIn();
                        showCheckOut(books);
                    }
                }
            }catch(NullPointerException e){
            }
        }while(!isCheck);
    }
    public static void showCheckIn(Book[] books){
                 String input;
                 do {
                            System.out.println("\n C - Book Check in");
                            System.out.println(" X - Home Screen");
                            System.out.print("\nEnter your Choice: ");
                            input = scan.next().toLowerCase();
                            if (input.equals("c")) {
                                checkIn(books);
                            } else if (input.equals("x")) {
                                menu(books);
                            }else{
                                System.out.println("\nInvalid input");
                            }
                        } while (input != "c");
    }
    public static void showCheckOut(Book[] books) {
        boolean isEmpty = false;
        System.out.println("\n---Checked out Books---");
       // System.out.println("\n⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️");
        try {
            for (Book book : books) {
                if (book.isCheckOut == true) {
                    isEmpty = true;
                    book.checkOut();
                    }
            }
        } catch (NullPointerException e) {

        }
        if(!isEmpty){
            System.out.println("\n⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️");
            System.out.println("No Books are check out yet");
            System.out.println("⬆️⬆️⬆️⬆️⬆️⬆️⬆️⬆️⬆️⬆️⬆️⬆️");
        }else {
            showCheckIn(books);
        }
        menu(books);
    }
    public static void showBooks(Book[] books) {

        System.out.println("\n----Available Books----");
        try {
            for (Book book : books) {
                book.displayBooks();
            }
        } catch (NullPointerException e) {

        }
    }
    public static void checkExit(Book[] books) {
        int input;
        do {
            System.out.println(" 1 - Check out a book");
            System.out.println(" 2 - Home Screen");
            System.out.print("Enter your choice: ");
            input = scan.nextInt();
            switch (input) {
                case 1:
                    nameCheckout(books);
                    break;
                case 2:
                    menu(books);
                    break;
                default:
                    System.out.println("Invalid Input");
            }
        } while (input != 2);
    }
    public static void nameCheckout(Book[] books) {
        String name;
        int bookID;
        boolean check = false;
        scan.nextLine();
        System.out.println("\n--Book Checkout--");
        System.out.print("Enter your name: ");
        name = scan.nextLine();
        System.out.print("Enter the Book ID: ");
        bookID = scan.nextInt();
        try {
            for (int i = 0; i < books.length; i++) {
                if (books[i].getId() == bookID && books[i].isCheckOut == false) {
                    books[i].setCheckOut(true);
                    books[i].setCheckedOutTo(name);
                    books[i].getCheckedOutTo(name);
                    System.out.println("\n----------------------------------");
                    System.out.println("Successfully Check Out !!! ");
                    books[i].checkOut();
                    check = true;
                   // menu(books);
                    checkExit(books);
                }
            }
        } catch (NullPointerException e) {
        }
        if(!check){
            System.out.println("\nBook ID is not found/Book ID is checked out\n");
        }
    }

}