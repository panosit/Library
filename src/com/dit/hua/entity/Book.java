package com.dit.hua.entity;
import javax.persistence.*;

@Entity
@Table(name="book")
public class Book{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="username")
    private String username;

    @Column(name="author")
    private String author;

    @Column(name="title")
    private String title;

    @Column(name="genre")
    private String genre;

    @Column(name="price")
    private float price;

    public Book(){}
    public Book(String username,String author,String title,String genre,float price){
        this.username=username;
        this.author=author;
        this.title=title;
        this.genre=genre;
        this.price=price;
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }
    public String getUsername(){
        return username;
    }
    public void setUsername(String username){
        this.username=username;
    }
    public String getAuthor(){
        return author;
    }
    public void setAuthor(String author){
        this.author=author;
    }
    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title=title;
    }
    public String getGenre(){
        return genre;
    }
    public void setGenre(String genre){
        this.genre=genre;
    }
    public float getPrice(){
        return price;
    }
    public void setPrice(float price){
        this.price=price;
    }
    @Override
    public String toString(){
        return "Book{"+"id="+id+
                ", username='"+username+'\''+", author='"+author+'\''+", title='"+
                title+'\''+", genre='"+genre+'\''+", price="+price+'}';
    }
}