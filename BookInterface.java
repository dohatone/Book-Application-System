import java.util.ArrayList;
import java.util.HashMap;

public interface BookInterface {

    // Default method: displays the details of all books in the application
    default void displayAllBooks(ArrayList<Book> books) {
        if (books.isEmpty()) {
            System.out.println("No books stored in the application.");
            return;
        }

        for (Book book : books) {
            System.out.println(book);
        }
    }

    // Returns the number of books in each genre
    HashMap<String, Integer> numberBooksPerGenre(ArrayList<Book> books);

    // Returns the total computed cost of all stored books
    double getTotalCost(ArrayList<Book> books);
}