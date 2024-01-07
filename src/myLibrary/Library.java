package myLibrary;

import java.util.ArrayList;

public class Library {
    ArrayList<Book> Books = new ArrayList<>();
    ArrayList<Member> Members = new ArrayList<>();
    void showAvailableBooks(){
        for(Book book: Books){
            System.out.println(book.bookName + book.bookAuthor);
        }
    }
    void addBook(Book book){
        Books.add(book);
    }
    void removeBook(Book book){
        Books.remove(book);
    }
    void addMember(Member member){
        Members.add(member);
    }
    void removeMember(Member member){
        Members.remove(member);
    }
    void displayAvailableBooks(){
        for(Book book: Books){
            System.out.println(book);
        }
    }
    void displayMembers(){
        for(Member member: Members){
            System.out.println(member);
        }
    }
    public void issueBook(Member member, Book book) {
        if (Books.contains(book) && book.getQuantity() > 0) {
            book.updateQuantity(book.getQuantity() - 1);
            member.issueBook(book);
        } else {
            System.out.println("Sorry, the book is not available for borrowing.");
        }
    }
}
