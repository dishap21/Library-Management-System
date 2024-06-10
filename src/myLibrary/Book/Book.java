package myLibrary.Book;

import java.time.LocalDate;

public class Book {
    int bookId, quantity;
    String title, author, genre;

    public Book(int bookId, int quantity, String title, String author, String genre) {
        this.bookId = bookId;
        this.quantity = quantity;
        this.title = title;
        this.author = author;
        this.genre = genre;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void getBookDetails(int Id) {
        if (this.bookId == Id) {
            System.out.println("Book ID: " + bookId);
            System.out.println("Title: " + title);
            System.out.println("Author: " + author);
            System.out.println("Quantity: " + quantity);
        } else {
            System.out.println("Book with ID " + bookId + " not found.");
        }
    }
    public void updateQuantity(int newQuantity){
        quantity = newQuantity;
    }
}
