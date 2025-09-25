package com.example.library;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library lib = new Library();

        // seed data
        lib.addBook(new Book(1, "1984", "George Orwell"));
        lib.addBook(new Book(2, "To Kill a Mockingbird", "Harper Lee"));
        lib.addUser(new User(1, "Alice"));
        lib.addUser(new User(2, "Bob"));

        while (true) {
            System.out.println("\n1:Add Book  2:Add User  3:Issue  4:Return  5:List Books  6:List Users  7:Exit");
            System.out.print("Choice> ");
            String line = sc.nextLine();
            int ch;
            try { ch = Integer.parseInt(line.trim()); } catch (Exception ex) { System.out.println("Invalid input"); continue; }

            switch (ch) {
                case 1:
                    try {
                        System.out.print("Book id: "); int bid = Integer.parseInt(sc.nextLine());
                        System.out.print("Title: "); String title = sc.nextLine();
                        System.out.print("Author: "); String author = sc.nextLine();
                        lib.addBook(new Book(bid, title, author));
                        System.out.println("Book added.");
                    } catch (Exception e) { System.out.println("Error adding book."); }
                    break;
                case 2:
                    try {
                        System.out.print("User id: "); int uid = Integer.parseInt(sc.nextLine());
                        System.out.print("Name: "); String name = sc.nextLine();
                        lib.addUser(new User(uid, name));
                        System.out.println("User added.");
                    } catch (Exception e) { System.out.println("Error adding user."); }
                    break;
                case 3:
                    System.out.print("User id: "); int uiss = Integer.parseInt(sc.nextLine());
                    System.out.print("Book id: "); int biss = Integer.parseInt(sc.nextLine());
                    System.out.println(lib.issueBook(uiss, biss) ? "Issued." : "Issue failed.");
                    break;
                case 4:
                    System.out.print("User id: "); int uret = Integer.parseInt(sc.nextLine());
                    System.out.print("Book id: "); int bret = Integer.parseInt(sc.nextLine());
                    System.out.println(lib.returnBook(uret, bret) ? "Returned." : "Return failed.");
                    break;
                case 5:
                    System.out.println("Books:");
                    lib.listBooks().forEach(System.out::println);
                    break;
                case 6:
                    System.out.println("Users:");
                    lib.listUsers().forEach(System.out::println);
                    break;
                case 7:
                    System.out.println("Goodbye!");
                    sc.close();
                    return;
                default:
                    System.out.println("Unknown choice.");
            }
        }
    }
}
