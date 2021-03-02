package com.dit.hua.controller;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import com.dit.hua.dao.*;
import org.springframework.security.access.annotation.*;
import org.springframework.ui.*;
import com.dit.hua.entity.*;
import java.security.*;
import java.util.*;
import javax.servlet.http.*;

@Controller
@RequestMapping("/")
public class UserController{
    @Autowired
    BookDAO bookDAO;
    @Autowired
    UserDAO userDAO;
    @Autowired
    AuthoritiesDAO authoritiesDAO;
    @Secured("ROLE_USER")
    @GetMapping("/show")
    public String showBook(Model model, Principal principal){
        List<Book> books=bookDAO.getBooks(principal.getName());
        model.addAttribute("books",books);
        model.addAttribute("username",principal.getName());
        return "results";
    }
    @Secured("ROLE_USER")
    @GetMapping("/search")
    public String searchBook(HttpServletRequest request,Model model,Principal principal){
        String title=request.getParameter("searchtitle");
        List<Book> books=bookDAO.getBooks(title,principal.getName());
        model.addAttribute("books",books);
        model.addAttribute("username",principal.getName());
        return "results";
    }
    @Secured("ROLE_USER")
    @PostMapping("/add")
    public String addBook(HttpServletRequest request,Principal principal,Model model){
        String author=request.getParameter("author");
        String title=request.getParameter("title");
        String genre=request.getParameter("genre");
        float price=0;
        try{
            price=Float.parseFloat(request.getParameter("price"));
        }catch(Exception ignored){}
        Book a=new Book(principal.getName(),author,title,genre,price);
        bookDAO.addBook(a);
        model.addAttribute("username",principal.getName());
        return "index";
    }
    @Secured("ROLE_USER")
    @GetMapping("/return")
    public String returnPage(Principal principal,Model model){
        model.addAttribute("username",principal.getName());
        return "index";
    }
    @PostMapping("/delete")
    public String delete(HttpServletRequest request,Principal principal,Model model){
        String title=request.getParameter("titled");
        bookDAO.deleteBook(title,principal.getName());
        model.addAttribute("username",principal.getName());
        return "index";
    }
}