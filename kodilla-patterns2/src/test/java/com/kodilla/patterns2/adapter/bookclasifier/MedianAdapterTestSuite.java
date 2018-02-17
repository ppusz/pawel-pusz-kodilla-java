package com.kodilla.patterns2.adapter.bookclasifier;

import com.kodilla.patterns2.adapter.bookclasifier.librarya.Book;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class MedianAdapterTestSuite {

    @Test
    public void testPublicationYearMediana() {
        // Given
        int booksCount = 10;
        Book[] books = new Book[booksCount];
        for (int i = 0, j = 1; i < booksCount; i++, j++) {
            books[i] = new Book(
                    "Author " + j,
                    "Title " + j,
                    2010 + i,
                    "Signature " + j);
        }
        Set<Book> bookSet = new HashSet<>(Arrays.asList(books));
        MedianAdapter adapter = new MedianAdapter();
        // When
        int medianOfYears = adapter.publicationYearMediana(bookSet);
        //Then
        System.out.println(medianOfYears);
        assertEquals(2015, medianOfYears);
    }
}
