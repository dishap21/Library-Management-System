package myLibrary;

import java.util.ArrayList;

public class Member {
    int id, contactNumber;
    String name, stream;
    ArrayList<Book> issuedBooks = new ArrayList<>();
    public Member(int id, int contactNumber, String name, String stream) {
        this.id = id;
        this.contactNumber = contactNumber;
        this.name = name;
        this.stream = stream;
    }
    void getMemberDetails(){
        System.out.println("Name: "+this.name+
                "Contact Number: "+this.contactNumber+
                "Stream: "+this.stream);
    }
    void borrowBook(Book book){
//        if(Books.contains(book)){
//            issuedBooks.add(book);
//            book.setIssueOn(java.time.LocalDate.now());
//            book.setIssuedTo(name);
//            Books.remove(book);
//            System.out.println("Issued book. -->"+ book.getBookName());
//        }
//        else{
//            if(issuedBooks.contains(book)){
//                System.out.println("Sorry the book is not available right now. Try to come on: "+ book.getIssueOn());
//            }
//            else{
//                System.out.println("The book you are searching for is not available is this library");
//            }
//        }
    }
    void returnBook(Book book){

    }
}
