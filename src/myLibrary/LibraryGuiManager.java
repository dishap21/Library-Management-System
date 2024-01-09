package myLibrary;

public class LibraryGuiManager {
    private Library library;

    public LibraryGuiManager(Library library) {
        this.library = library;
        initializeGui();
    }

    private void initializeGui() {
        // Implement GUI initialization
    }

    public void runGui() {
        // Implement GUI-based interactions
    }

    public void issueBook(Member member, Book book) {
        library.issueBook(member, book);
    }
}
