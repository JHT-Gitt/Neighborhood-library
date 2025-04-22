package org.example;

public class Book {

    int id;
    String isbn, title, checkedOutTo;
    boolean isCheckOut = false;

    public Book(int id, String title, String isbn) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCheckedOutTo(String name) {
        return checkedOutTo;
    }

    public void setCheckedOutTo(String checkedOutTo) {
        this.checkedOutTo = checkedOutTo;
    }

    public boolean isCheckOut() {
        return isCheckOut;
    }

    public void setCheckOut(boolean checkOut) {

        isCheckOut = checkOut;
    }
    public void checkOut(){
        System.out.println("\nBook ID: " + this.id);
        System.out.println("Book Title: " + this.title);
        System.out.println("ISBN: " + this.isbn);
        System.out.println("Checked out to: " + this.checkedOutTo);
        System.out.println("---------------------------------");
    }
    public void checkIn(){

        if(isCheckOut == false) {
            System.out.println("Book ID: " + this.id);
            System.out.println("Book Title: " + this.title);
            System.out.println("ISBN: " + this.isbn);
            System.out.println("---------------------------------");
        }

    }
    public void displayBooks(){

        if(isCheckOut == false) {
            System.out.println("Book ID: " + this.id);
            System.out.println("Book Title: " + this.title);
            System.out.println("ISBN: " + this.isbn);
            System.out.println("---------------------------------");
        }
    }

}
