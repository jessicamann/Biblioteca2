package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;

public class BibliotecaApp {

    private Biblioteca biblioteca;
    private MainMenu menu;
    private BufferedReader bufferedReader;
    private PrintStream printStream;

    public BibliotecaApp(Biblioteca biblioteca, MainMenu menu) {
        this.biblioteca = biblioteca;
        this.menu = menu;
        this.bufferedReader = bufferedReader;
        this.printStream = printStream;
    }

    public static void main(String[] args) {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Cat in the Hat", "Dr. Seuss", "1957"));
        books.add(new Book("The Green Egg and Ham", "Dr. Seuss", "1960"));
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(in);
        PrintStream printStream = System.out;
        Biblioteca biblioteca = new Biblioteca(printStream, books);
        MainMenu menu = new MainMenu(printStream, bufferedReader, biblioteca);
        BibliotecaApp bibliotecaApp = new BibliotecaApp(biblioteca, menu);
        bibliotecaApp.start();
    }

    public void start() {
        //biblioteca.openTheBiblioteca();
        menu.startMenu();
        menu.printMenuOptions();
        menu.getUserMenuOption();
    }

//    public int getUserMenuOption() {
//        printStream.print("Please enter the number of your menu item: ");
//        int userInput = 0;
//        try {
//            userInput = Integer.parseInt(bufferedReader.readLine());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return userInput;
//    }
}
