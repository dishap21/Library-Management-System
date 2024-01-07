package myLibrary;

import java.util.ArrayList;

public class Member {
    int MemberId, contactNumber;
    String name, stream;
    ArrayList<Book> issuedBooks = new ArrayList<>();
    public Member(int MemberId, int contactNumber, String name, String stream) {
        this.MemberId = MemberId;
        this.contactNumber = contactNumber;
        this.name = name;
        this.stream = stream;
    }
    void getMemberDetails(){
        System.out.println("Name: "+this.name+
                "Contact Number: "+this.contactNumber+
                "Stream: "+this.stream);
    }
    void displayIssuedBooks(){
        for(Book book: issuedBooks){
            System.out.println(book);
        }
    }
    void issueBook(Book book){
        issuedBooks.add(book);
        System.out.println("Book issued successfully.");
    }
    void returnBook(Book book){
        issuedBooks.remove(book);
        System.out.println("Book returned successfully.");
    }
}
