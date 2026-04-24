import java.util.ArrayList;
import java.util.HashMap;

public abstract class Book implements BookInterface {
    // Encapsulation: private fields
    private String title;
    private String author;
    private String genre;
    private double cost;
    private String bookType;

    // Constructor
    public Book(String title, String author, String genre, String bookType) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookType = bookType;
        this.cost = 0.0;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public double getStoredCost() {
        return cost;
    }

    public String getBookType() {
        return bookType;
    }

    // Setter for cost
    public void setStoredCost(double cost) {
        this.cost = cost;
    }

    // Abstraction: subclasses must define how their cost is computed
    public abstract double getCost();

    // Polymorphism support through overriding in subclasses
    @Override
    public double getTotalCost(ArrayList<Book> books) {
        double total = 0.0;
        for (Book book : books) {
            total += book.getCost();
        }
        return total;
    }

    @Override
    public HashMap<String, Integer> numberBooksPerGenre(ArrayList<Book> books) {
        HashMap<String, Integer> genreCount = new HashMap<>();

        for (Book book : books) {
            String genre = book.getGenre();
            genreCount.put(genre, genreCount.getOrDefault(genre, 0) + 1);
        }

        return genreCount;
    }

    @Override
    public String toString() {
        return "Title: " + title +
                ", Author: " + author +
                ", Genre: " + genre +
                ", Type: " + bookType +
                ", Cost: $" + String.format("%.2f", getCost());
    }
}