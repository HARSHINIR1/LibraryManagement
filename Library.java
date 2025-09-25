package com.example.library;

import java.util.*;

public class Library {
    private final Map<Integer, Book> books = new HashMap<>();
    private final Map<Integer, User> users = new HashMap<>();

    public void addBook(Book b) { books.put(b.getId(), b); }
    public void addUser(User u) { users.put(u.getId(), u); }

    public boolean issueBook(int userId, int bookId) {
        Book b = books.get(bookId);
        User u = users.get(userId);
        if (b == null || u == null) return false;
        if (b.isIssued()) return false;
        b.setIssued(true);
        u.borrow(bookId);
        return true;
    }

    public boolean returnBook(int userId, int bookId) {
        Book b = books.get(bookId);
        User u = users.get(userId);
        if (b == null || u == null) return false;
        if (!b.isIssued()) return false;
        if (!u.getBorrowedBookIds().contains(bookId)) return false;
        b.setIssued(false);
        u.returned(bookId);
        return true;
    }

    public List<Book> listBooks() { return new ArrayList<>(books.values()); }
    public List<User> listUsers() { return new ArrayList<>(users.values()); }
}
