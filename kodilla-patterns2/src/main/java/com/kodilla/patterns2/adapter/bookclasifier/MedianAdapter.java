package com.kodilla.patterns2.adapter.bookclasifier;

import com.kodilla.patterns2.adapter.bookclasifier.libraryb.Book;
import com.kodilla.patterns2.adapter.bookclasifier.librarya.Classifier;
import com.kodilla.patterns2.adapter.bookclasifier.libraryb.BookSignature;
import com.kodilla.patterns2.adapter.bookclasifier.libraryb.BookStatistics;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MedianAdapter extends MedianAdaptee implements Classifier {

    @Override
    public int publicationYearMediana(Set<com.kodilla.patterns2.adapter.bookclasifier.librarya.Book> bookSet) {
        Map<BookSignature, Book> bookMap = new HashMap<>();
        for (com.kodilla.patterns2.adapter.bookclasifier.librarya.Book bookA : bookSet) {
            BookSignature signature = new BookSignature(bookA.getSignature());
            Book bookB = new Book(
                    bookA.getAuthor(),
                    bookA.getTitle(),
                    bookA.getPublicationYear());
            bookMap.put(signature, bookB);
        }
        return medianPublicationYear(bookMap);
    }
}
