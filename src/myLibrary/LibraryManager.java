package myLibrary;

import myLibrary.GUI.LibraryGuiManager;

public class LibraryManager {
    public static void main(String[] args) {

        Library library = new Library();
        ConsoleManager consoleManager = new ConsoleManager(library);
        consoleManager.runConsole();

        // GUI interactions
        LibraryGuiManager guiManager = new LibraryGuiManager(library);
        guiManager.runGui();

    }
}
