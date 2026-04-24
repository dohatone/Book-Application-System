import java.util.ArrayList;

public class PrintedBook extends Book {
    private int pages;

    public PrintedBook(String title, String author, String genre, int pages) {
        super(title, author, genre, "PrintedBook");
        this.pages = pages;
    }

    public int getPages() {
        return pages;
    }

    @Override
    public double getCost() {
        double cost = pages * 0.50;
        setStoredCost(cost);
        return cost;
    }

    public static double getAveragePages(ArrayList<Book> books) {
        int totalPages = 0;
        int count = 0;

        for (Book book : books) {
            if (book instanceof PrintedBook) {
                PrintedBook printedBook = (PrintedBook) book;
                totalPages += printedBook.getPages();
                count++;
            }
        }

        if (count == 0) {
            return 0.0;
        }

        return (double) totalPages / count;
    }

    @Override
    public String toString() {
        return super.toString() + ", Pages: " + pages;
    }
}