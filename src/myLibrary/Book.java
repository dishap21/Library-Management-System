package myLibrary;

import java.time.LocalDate;

public class Book {
    String bookName, bookAuthor, issuedTo;
    LocalDate issueOn;

    public Book(String bookName, String bookAuthor, String issuedTo, LocalDate issueOn) {
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
}