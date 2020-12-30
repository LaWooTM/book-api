package com.tmobile.bookapi;


import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.*;

public class BookServiceControllerTest extends AbstractTest {

    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    @Test
    public void getBookList() throws Exception {
        String uri = "/api/books";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Book[] booklist = super.mapFromJson(content, Book[].class);
        assertTrue(booklist.length >= 0);
    }

    @Test
    public void createProduct() throws Exception {
        String uri = "/api/books";
        Book book = new Book();
        book.setTitle("One Flew Over the Cuckoo's Nest");
        book.setAuthor("Ken Kesey");
        String inputJson = super.mapToJson(book);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Book responseBook = super.mapFromJson(content, Book.class);
        assertEquals(responseBook.getAuthor(), book.getAuthor());
        assertEquals(responseBook.getTitle(), book.getTitle());
        assertNotNull(responseBook.getId());
    }
}
