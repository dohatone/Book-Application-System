import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        BookApp app = new BookApp();

        int choice = -1;

        do {
            System.out.println("\n===== Shelfy: Book Tracker Menu =====");
            System.out.println("1. Add Printed Book");
            System.out.println("2. Add AudioBook");
            System.out.println("3. Display All Books");
            System.out.println("4. Search by Title");
            System.out.println("5. Search by Author");
            System.out.println("6. Search by Genre");
            System.out.println("7. Search by Type");
            System.out.println("8. Sort by Title");
            System.out.println("9. Sort by Author");
            System.out.println("10. Sort by Genre");
            System.out.println("11. Sort by Cost");
            System.out.println("12. Display Statistics");
            System.out.println("13. Display Last 6 Overall Books");
            System.out.println("14. Display Last 3 Printed Books");
            System.out.println("15. Display Last 3 Audio Books");
            System.out.println("16. Save Books to File");
            System.out.println("17. Load Books from File");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            if (!input.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                input.nextLine(); // clear the wrong input
                continue; // go back to menu
            }

            choice = input.nextInt();
            input.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter title: ");
                    String pTitle = input.nextLine();

                    System.out.print("Enter author: ");
                    String pAuthor = input.nextLine();

                    System.out.print("Enter genre: ");
                    String pGenre = input.nextLine();

                    System.out.print("Enter number of pages: ");
                    int pages = input.nextInt();
                    input.nextLine();

                    app.addBook(new PrintedBook(pTitle, pAuthor, pGenre, pages));
                    break;

                case 2:
                    System.out.print("Enter title: ");
                    String aTitle = input.nextLine();

                    System.out.print("Enter author: ");
                    String aAuthor = input.nextLine();

                    System.out.print("Enter genre: ");
                    String aGenre = input.nextLine();

                    System.out.print("Enter duration in minutes: ");
                    int minutes = input.nextInt();
                    input.nextLine();

                    app.addBook(new AudioBook(aTitle, aAuthor, aGenre, minutes));
                    break;

                case 3:
                    app.displayAllBooks();
                    break;

                case 4:
                    System.out.print("Enter title keyword: ");
                    String titleKeyword = input.nextLine();
                    app.searchByTitle(titleKeyword);
                    break;

                case 5:
                    System.out.print("Enter author name: ");
                    String authorName = input.nextLine();
                    app.searchByAuthor(authorName);
                    break;

                case 6:
                    System.out.print("Enter genre: ");
                    String genre = input.nextLine();
                    app.searchByGenre(genre);
                    break;

                case 7:
                    System.out.print("Enter type (PrintedBook or AudioBook): ");
                    String type = input.nextLine();
                    app.searchByType(type);
                    break;

                case 8:
                    app.sortByTitle();
                    break;

                case 9:
                    app.sortByAuthor();
                    break;

                case 10:
                    app.sortByGenre();
                    break;

                case 11:
                    app.sortByCost();
                    break;

                case 12:
                    app.displayStatistics();
                    break;

                case 13:
                    app.displayLast6Books();
                    break;

                case 14:
                    app.displayLast3PrintedBooks();
                    break;

                case 15:
                    app.displayLast3AudioBooks();
                    break;

                case 16:
                    System.out.print("Enter file name to save to: ");
                    String saveFile = input.nextLine();
                    app.saveToFile(saveFile);
                    break;

                case 17:
                    System.out.print("Enter file name to load from: ");
                    String loadFile = input.nextLine();
                    app.loadFromFile(loadFile);
                    break;

                case 0:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 0);

        input.close();
    }
}