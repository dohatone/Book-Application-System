import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class BookApp {
    private ArrayList<Book> books;

    public BookApp() {
        books = new ArrayList<>();
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    // Add a book
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully.");
    }

    // Display all books
    public void displayAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the application.");
            return;
        }

        for (Book book : books) {
            System.out.println(book);
        }
    }

    // Search by title (partial match)
    public void searchByTitle(String titleKeyword) {
        boolean found = false;

        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(titleKeyword.toLowerCase())) {
                System.out.println(book);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No books found with that title.");
        }
    }

    // Search by author
    public void searchByAuthor(String authorName) {
        boolean found = false;

        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(authorName)) {
                System.out.println(book);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No books found by that author.");
        }
    }

    // Search by genre
    public void searchByGenre(String genre) {
        boolean found = false;

        for (Book book : books) {
            if (book.getGenre().equalsIgnoreCase(genre)) {
                System.out.println(book);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No books found in that genre.");
        }
    }

    // Search by type
    public void searchByType(String type) {
        boolean found = false;

        for (Book book : books) {
            if (book.getBookType().equalsIgnoreCase(type)) {
                System.out.println(book);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No books found of that type.");
        }
    }

    // Sort by title
    public void sortByTitle() {
        Collections.sort(books, Comparator.comparing(Book::getTitle, String.CASE_INSENSITIVE_ORDER));
        System.out.println("Books sorted by title.");
    }

    // Sort by author
    public void sortByAuthor() {
        Collections.sort(books, Comparator.comparing(Book::getAuthor, String.CASE_INSENSITIVE_ORDER));
        System.out.println("Books sorted by author.");
    }

    // Sort by genre
    public void sortByGenre() {
        Collections.sort(books, Comparator.comparing(Book::getGenre, String.CASE_INSENSITIVE_ORDER));
        System.out.println("Books sorted by genre.");
    }

    // Sort by cost
    public void sortByCost() {
        Collections.sort(books, Comparator.comparingDouble(Book::getCost));
        System.out.println("Books sorted by cost.");
    }

    // Display statistics
    public void displayStatistics() {
        if (books.isEmpty()) {
            System.out.println("No books available for statistics.");
            return;
        }

        double totalCost = books.get(0).getTotalCost(books);
        HashMap<String, Integer> genreCounts = books.get(0).numberBooksPerGenre(books);

        System.out.println("----- Statistics -----");
        System.out.println("Total books: " + books.size());
        System.out.println("Total cost of all books: $" + String.format("%.2f", totalCost));
        System.out.println("Average pages of printed books: " + String.format("%.2f", PrintedBook.getAveragePages(books)));
        System.out.println("Average duration of audiobooks: " + String.format("%.2f", AudioBook.getAverageDuration(books)) + " minutes");
        System.out.println("Books per genre: " + genreCounts);
    }

    // Display last 6 overall books
    public void displayLast6Books() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }

        System.out.println("----- Last 6 Overall Books -----");
        int start = Math.max(0, books.size() - 6);

        for (int i = start; i < books.size(); i++) {
            System.out.println(books.get(i));
        }
    }

    // Display last 3 printed books
    public void displayLast3PrintedBooks() {
        System.out.println("----- Last 3 Printed Books -----");
        int count = 0;

        for (int i = books.size() - 1; i >= 0 && count < 3; i--) {
            if (books.get(i) instanceof PrintedBook) {
                System.out.println(books.get(i));
                count++;
            }
        }

        if (count == 0) {
            System.out.println("No printed books found.");
        }
    }

    // Display last 3 audiobooks
    public void displayLast3AudioBooks() {
        System.out.println("----- Last 3 Audio Books -----");
        int count = 0;

        for (int i = books.size() - 1; i >= 0 && count < 3; i--) {
            if (books.get(i) instanceof AudioBook) {
                System.out.println(books.get(i));
                count++;
            }
        }

        if (count == 0) {
            System.out.println("No audiobooks found.");
        }
    }
    // Save books to file
    public void saveToFile(String fileName) {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(fileName));

            for (Book book : books) {
                if (book instanceof PrintedBook) {
                    PrintedBook printedBook = (PrintedBook) book;
                    writer.println("PrintedBook," +
                            printedBook.getTitle() + "," +
                            printedBook.getAuthor() + "," +
                            printedBook.getGenre() + "," +
                            printedBook.getPages());
                } else if (book instanceof AudioBook) {
                    AudioBook audioBook = (AudioBook) book;
                    writer.println("AudioBook," +
                            audioBook.getTitle() + "," +
                            audioBook.getAuthor() + "," +
                            audioBook.getGenre() + "," +
                            audioBook.getDurationMinutes());
                }
            }

            writer.close();
            System.out.println("Books saved successfully to " + fileName);

        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }

    // Load books from file
    public void loadFromFile(String fileName) {
        try {
            File file = new File(fileName);

            if (!file.exists()) {
                System.out.println("File does not exist.");
                return;
            }

            Scanner fileScanner = new Scanner(file);
            books.clear(); // clear current list before loading

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split(",");

                if (parts.length == 5) {
                    String type = parts[0];
                    String title = parts[1];
                    String author = parts[2];
                    String genre = parts[3];
                    int value = Integer.parseInt(parts[4]);

                    if (type.equalsIgnoreCase("PrintedBook")) {
                        books.add(new PrintedBook(title, author, genre, value));
                    } else if (type.equalsIgnoreCase("AudioBook")) {
                        books.add(new AudioBook(title, author, genre, value));
                    }
                }
            }

            fileScanner.close();
            System.out.println("Books loaded successfully from " + fileName);

        } catch (IOException e) {
            System.out.println("Error loading file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format in file.");
        }
    }
}