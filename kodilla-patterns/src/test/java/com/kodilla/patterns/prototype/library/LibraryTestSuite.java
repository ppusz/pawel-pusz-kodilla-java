package com.kodilla.patterns.prototype.library;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Random;
import java.util.stream.IntStream;

public class LibraryTestSuite {

    @Test
    public void testGetBooks() {
        //Given
        Library library = new Library("Original library");
        Random random = new Random();
        IntStream.rangeClosed(1,20)
                .forEach(n -> library.getBooks().add(new Book("Title " + n, "Author " + n,
                        LocalDate.of(1990 + random.nextInt(28),
                                random.nextInt(12) + 1, random.nextInt(30) + 1))));

        Library shallowClonedLibrary = null;
        try {
            shallowClonedLibrary = library.shallowCopy();
            shallowClonedLibrary.setName("New library");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        Library deepClonedLibrary = null;
        try {
            deepClonedLibrary = library.deepCopy();
            deepClonedLibrary.setName("Another new library");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        //When
        //czemu poniższe nie działa?
        //shallowClonedLibrary.getBooks().stream().limit(1).forEach(library.getBooks()::remove);
        for (Book b : library.getBooks()) {
            library.getBooks().remove(b);
            break;
        }

        //Then
        int libraryBooksCount = library.getBooks().size();
        int shallowClonedLibraryBooksCount = shallowClonedLibrary.getBooks().size();
        int deepClonedLibraryBooksCount = deepClonedLibrary.getBooks().size();
        Assert.assertEquals(19, libraryBooksCount);
        Assert.assertEquals(19, shallowClonedLibraryBooksCount);
        Assert.assertEquals(20, deepClonedLibraryBooksCount);
    }
}
