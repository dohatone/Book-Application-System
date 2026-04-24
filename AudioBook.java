import java.util.ArrayList;

public class AudioBook extends Book {
    private int durationMinutes;

    public AudioBook(String title, String author, String genre, int durationMinutes) {
        super(title, author, genre, "AudioBook");
        this.durationMinutes = durationMinutes;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    @Override
    public double getCost() {
        double cost = durationMinutes * 0.25;
        setStoredCost(cost);
        return cost;
    }

    public static double getAverageDuration(ArrayList<Book> books) {
        int totalMinutes = 0;
        int count = 0;

        for (Book book : books) {
            if (book instanceof AudioBook) {
                AudioBook audioBook = (AudioBook) book;
                totalMinutes += audioBook.getDurationMinutes();
                count++;
            }
        }

        if (count == 0) {
            return 0.0;
        }

        return (double) totalMinutes / count;
    }

    @Override
    public String toString() {
        return super.toString() + ", Duration: " + durationMinutes + " minutes";
    }
}