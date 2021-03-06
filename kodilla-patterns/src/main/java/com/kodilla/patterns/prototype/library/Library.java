package com.kodilla.patterns.prototype.library;

import java.util.HashSet;
import java.util.Set;

public final class Library extends Prototype<Library> {

    private String name;
    private Set<Book> books = new HashSet<>();

    public Library(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public Library shallowCopy() throws CloneNotSupportedException {
        return super.clone();
    }

    public Library deepCopy() throws CloneNotSupportedException {
        Library clonedLibrary = shallowCopy();
        clonedLibrary.books = new HashSet<>();
        for (Book b : books) {
            clonedLibrary.getBooks().add(new Book(b.getTitle(), b.getAuthor(), b.getPublicationDate()));
        }
        return clonedLibrary;
    }
}