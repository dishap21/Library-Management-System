package myLibrary;

import java.util.Arrays;
import java.util.List;

public class LibraryManager {
    public static void main(String[] args) {
//        List<Book> fullList = Arrays.asList(
//                new Book(1,"Pride and Prejudice", "Jane Austen", null, null),
//                new Book(2, "To Kill a Mockingbird", "Harper Lee", null, null),
//                new Book(1, "1984", "George Orwell", null, null),
//                new Book(3, "One Hundred Years of Solitude", "Gabriel Garcia Marquez", null, null),
//                new Book(4, "Dune", "Frank Herbert", null, null),
//                new Book(2, "Neuromancer", "William Gibson", null, null),
//                new Book(5, "Harry Potter", "J.K. Rowling", null, null),
//                new Book(1, "The Da Vinci Code", "Dan Brown", null, null),
//                new Book(2, "All the Light We Cannot See", "Anthony Doerr", null, null),
//                new Book(5, "Sapiens: A Brief History of Humankind", "Yuval Noah Harari", null, null),
//                new Book(2, "Where the Crawdads Sing", "Delia Owens", null, null),
//                new Book(2, "The Hound of the Baskervilles", "Arthur Conan Doyle", null, null),
//                new Book(3, "One Hundred Years of Solitude", "Gabriel Garcia Marquez", null, null),
//                new Book(4, "The Book Thief", "Markus Zusak", null, null),
//                new Book(1, "The Pillars of the Earth", "Ken Follett", null, null),
//                new Book(2, "Clean Code: A Handbook of Agile Software Craftsmanship", "Robert C. Martin", null, null),
//                new Book(3, "Code Complete: A Practical Handbook of Software Construction", "Steve McConnell", null, null),
//                new Book(2, "Eloquent JavaScript", "Marijn Haverbeke", null, null)
//        );

        Library library = new Library();
        ConsoleManager consoleManager = new ConsoleManager(library);
        consoleManager.runConsole();

        // GUI interactions
        LibraryGuiManager guiManager = new LibraryGuiManager(library);
        guiManager.runGui();
    }
}
