package myLibrary;

import java.util.ArrayList;

public class Library {
    ArrayList<Book> Books = new ArrayList<>();
    ArrayList<Book> issuedBooks = new ArrayList<>();
    void showAvailableBooks(){
        for(Book book: Books){
            System.out.println(book.bookName + book.bookAuthor);
        }
    }
    void addBook(Book book){
        Books.add(book);
    }
    void issueBook(Book book, String name){
        if(Books.contains(book)){
            issuedBooks.add(book);
            book.setIssueOn(java.time.LocalDate.now());
            book.setIssuedTo(name);
            Books.remove(book);
            System.out.println("Issued book. -->"+ book.getBookName());
        }
        else{
            if(issuedBooks.contains(book)){
                System.out.println("Sorry the book is not available right now. Try to come on: "+ book.getIssueOn());
            }
            else{
                System.out.println("The book you are searching for is not available is this library");
            }
        }
    }
    void returnBook(Book book){
        Books.add(book);
        book.setIssueOn(null);
        book.setIssuedTo(null);
    }
}
