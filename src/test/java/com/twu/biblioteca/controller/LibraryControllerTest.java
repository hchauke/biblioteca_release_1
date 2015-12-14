package com.twu.biblioteca.controller;

import com.twu.biblioteca.book.Book;
import com.twu.biblioteca.library.BorrowService;
import com.twu.biblioteca.library.LibraryController;
import com.twu.biblioteca.library.ReturnService;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

/**
 * Created by desiree on 10/12/2015.
 */
public class LibraryControllerTest {

    private BorrowService borrowService;
    private ReturnService returnService;
    private LibraryController libraryController;
    private Book book;

    @Before
    public void setUp() {
        borrowService = mock(BorrowService.class);
        returnService = mock(ReturnService.class);
        book = mock(Book.class);
        libraryController = new LibraryController(borrowService, returnService);
    }

    @Test
    public void libraryShouldDelegateToBorrowServiceWhenBookBorrowed() {
        when(borrowService.borrowBook(book)).thenReturn(true);
        assertTrue(libraryController.borrowBook(book));
        verify(borrowService, times(1)).borrowBook(book);
    }

    @Test
    public void libraryShouldDelegateToReturnServiceWhenBookReturned(){
        when(returnService.returnBook(book)).thenReturn(true);
        assertTrue(libraryController.returnBook(book));
        verify(returnService, times(1)).returnBook(book);
    }
}