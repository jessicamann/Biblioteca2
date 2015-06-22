package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.List;

/**
 * Created by jmann on 6/16/15.
 */
public class Biblioteca {
    private PrintStream printStream;
    private List<Book> books;

    public Biblioteca(PrintStream printStream, List<Book> books){
        this.printStream = printStream;
        this.books = books;
    }

    public void listBooks() {
        for(Book book : books){
            if(!book.isCheckedOut) {
                printStream.println(book.getFormattedBookDetails());
            }
        }
    }


    public void printColumnHeaders() {
        printStream.println(String.format("%-35s %-35s %-35s %n", "Title", "Author", "Year"));
    }


    public void checkoutBook(String title) {
        boolean isAvailable = false;
        for (Book book : books) {
            if(book.title.equals(title)){
                book.isCheckedOut = true;
                printStream.println("Thank you! Enjoy the book!");
                isAvailable = true;
                break;
            }
        }
        if(isAvailable == false) {
            printStream.println("That book is not available.");
        }
    }

    public void returnBook(String title) {
        boolean canReturn = false;
        for (Book book : books) {
            if(book.title.equals(title) && book.isCheckedOut){
                book.isCheckedOut = false;
                printStream.println("Thank you for returning the book");
                canReturn = true;
                break;
            }
        }
        if(canReturn == false) {
            printStream.println("That is not a valid book to return");
        }
    }

}
