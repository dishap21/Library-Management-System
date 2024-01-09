package myLibrary;

import java.time.LocalDate;

public class Book {
    int bookId=0, quantity;
    String bookName, bookAuthor, issuedTo;
    LocalDate issueOn;

    public Book(int quantity, String bookName, String bookAuthor, String issuedTo, LocalDate issueOn) {
        this.bookId += bookId;
        this.quantity = quantity;
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.issuedTo = issuedTo;
        this.issueOn = issueOn;
    }

    public String getBookName() {
        return bookName;
    }
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
    public String getBookAuthor() {
        return bookAuthor;
    }
    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }
    public String getIssuedTo() {
        return issuedTo;
    }
    public void setIssuedTo(String issuedTo) {
        this.issuedTo = issuedTo;
    }
    public LocalDate getIssueOn() {
        return issueOn;
    }
    public void setIssueOn(LocalDate issueOn) {
        this.issueOn = issueOn;
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
    public void getBookDetails(int Id) {
        if (this.bookId == Id) {
            System.out.println("Book ID: " + bookId);
            System.out.println("Title: " + bookName);
            System.out.println("Author: " + bookAuthor);
            System.out.println("Quantity: " + quantity);
        } else {
            System.out.println("Book with ID " + bookId + " not found.");
        }
    }
    void updateQuantity(int newQuantity){
        quantity = newQuantity;
    }
}
