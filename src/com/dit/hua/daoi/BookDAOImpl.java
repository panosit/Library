package com.dit.hua.daoi;
import java.util.*;
import javax.transaction.*;
import com.dit.hua.entity.*;
import com.dit.hua.dao.*;
import org.hibernate.*;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

@Repository
public class BookDAOImpl implements BookDAO{
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    @Transactional
    public List<Book> getBooks(String username){
        Session currentSession=sessionFactory.getCurrentSession();
        Query<Book> query=currentSession.createQuery("from Book where username='"+username+"'",Book.class);
        return query.getResultList();
    }
    @Override
    @Transactional
    public List<Book> getBooks(String title,String username){
        Session currentSession=sessionFactory.getCurrentSession();
        Query<Book> query=currentSession.createQuery("from Book WHERE title='"+title+"'"
                +"and username='"+username+"'",Book.class);
        return query.getResultList();
    }
    @Override
    @Transactional
    public void addBook(Book book){
        Session session=sessionFactory.getCurrentSession();
        session.persist(book);
    }
    @Override
    @Transactional
    public void deleteBook(String title,String username){
        Session currentSession=sessionFactory.getCurrentSession();
        List<Book> books=this.getBooks(title,username);
        try{
            for(Book book:books)
                currentSession.delete(book);
        }catch(Exception ignored){}
    }
}