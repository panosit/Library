package com.dit.hua.dao;
import java.util.*;
import com.dit.hua.entity.*;
import org.springframework.stereotype.*;

@Repository
public interface BookDAO{
    List<Book> getBooks(String username);
    List<Book> getBooks(String title,String username);
    void addBook(Book book);
    void deleteBook(String title,String username);
}