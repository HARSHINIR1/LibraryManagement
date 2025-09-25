package com.example.library;

import java.util.HashSet;
import java.util.Set;

public class User {
    private final int id;
    private final String name;
    private final Set<Integer> borrowedBookIds = new HashSet<>();

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public int getId() { return id; }
    public String getName() { return name; }
    public Set<Integer> getBorrowedBookIds() { return borrowedBookIds; }

    public void borrow(int bookId) { borrowedBookIds.add(bookId); }
    public void returned(int bookId) { borrowedBookIds.remove(bookId); }

    @Override
    public String toString() {
        return String.format("User{id=%d, name='%s', borrowed=%s}", id, name, borrowedBookIds);
    }
}
