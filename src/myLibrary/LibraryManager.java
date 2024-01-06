package myLibrary;

import java.util.Arrays;
import java.util.List;

public class LibraryManager {
    public static void main(String[] args) {
        List<Book> fullList = Arrays.asList(
                new Book("Pride and Prejudice", "Jane Austen", null, null),
                new Book("To Kill a Mockingbird", "Harper Lee", null, null),
                new Book("1984", "George Orwell", null, null),
                new Book("One Hundred Years of Solitude", "Gabriel Garcia Marquez", null, null),
                new Book("Dune", "Frank Herbert", null, null),
                new Book("Neuromancer", "William Gibson", null, null),
                new Book("Harry Potter", "J.K. Rowling", null, null),
                new Book("The Da Vinci Code", "Dan Brown", null, null),
                new Book("All the Light We Cannot See", "Anthony Doerr", null, null),
                new Book("Sapiens: A Brief History of Humankind", "Yuval Noah Harari", null, null),
                new Book("Where the Crawdads Sing", "Delia Owens", null, null),
                new Book("The Hound of the Baskervilles", "Arthur Conan Doyle", null, null),
                new Book("One Hundred Years of Solitude", "Gabriel Garcia Marquez", null, null),
                new Book("The Book Thief", "Markus Zusak", null, null),
                new Book("The Pillars of the Earth", "Ken Follett", null, null),
                new Book("Clean Code: A Handbook of Agile Software Craftsmanship", "Robert C. Martin", null, null),
                new Book("Code Complete: A Practical Handbook of Software Construction", "Steve McConnell", null, null),
                new Book("Eloquent JavaScript", "Marijn Haverbeke", null, null)
        );
    }
}
