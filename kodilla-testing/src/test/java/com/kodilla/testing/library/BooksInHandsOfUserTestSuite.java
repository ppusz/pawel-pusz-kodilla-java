package com.kodilla.testing.library;

import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BooksInHandsOfUserTestSuite {

    private LibraryUser dummyLibraryUser;
    private LibraryDatabase mockLibraryDatabase;
    private BookLibrary library;

    private List<Book> generateListOfNBooks(int booksCount) {
        List<Book> resultListOfBooks = new ArrayList<>();
        for (int i = 0; i < booksCount; i++) {
            resultListOfBooks.add(new Book("Title " + i,"Author " + i, 1900 + (i % 118 )));
        }
        return resultListOfBooks;
    }

    @Before
    public void setUp() throws Exception {
        dummyLibraryUser = new LibraryUser("first name", "last name", "pesel");
        mockLibraryDatabase = mock(LibraryDatabase.class);
        when(mockLibraryDatabase.listBooksInHandsOf(dummyLibraryUser)).thenReturn(new ArrayList<Book>());
        library = new BookLibrary(mockLibraryDatabase);
    }

    @Test
    public void testListBooksInHandsOfNoBooksLent() {
        //When
        List<Book> listOf0Books = library.listBooksInHandsOf(dummyLibraryUser);

        //Then
        assertEquals(0, listOf0Books.size());
    }

    @Test
    public void testListBooksInHandsOf1Book() {
        //Given
        List<Book> resultListOfBooks = generateListOfNBooks(1);
        when(mockLibraryDatabase.listBooksInHandsOf(dummyLibraryUser)).thenReturn(resultListOfBooks);

        //When
        List<Book> listOf1Book = library.listBooksInHandsOf(dummyLibraryUser);

        //Then
        assertEquals(1, listOf1Book.size());
    }

    @Test
    public void testListBooksInHandsOf5Books() {
        //Given
        List<Book> resultListOfBooks = generateListOfNBooks(5);
        when(mockLibraryDatabase.listBooksInHandsOf(dummyLibraryUser)).thenReturn(resultListOfBooks);

        //When
        List<Book> listOf5Books = library.listBooksInHandsOf(dummyLibraryUser);

        //Then
        assertEquals(5, listOf5Books.size());
    }
}