Hi, this is Doha Bousmah 👋
Book Application System
1. Project Description
This project is a Java-based Book Application System that allows users to store and manage books they have read. The system supports two types of books: Printed Books and AudioBooks. Each book stores information such as title, author, genre, and cost. Printed books store the number of pages, while audiobooks store the duration in minutes.
The application provides features to add books, search books, sort books, display statistics, and save/load book data from a file. The system is implemented using object-oriented programming principles.

2. How to Run the Program
1.	Open the project in a Java IDE (such as IntelliJ IDEA or Eclipse). 
2.	Ensure all source files are in the src folder: 
o	BookInterface.java 
o	Book.java 
o	PrintedBook.java 
o	AudioBook.java 
o	BookApp.java 
o	Main.java 
3.	Run the Main.java file. 
4.	Use the menu displayed in the console to: 
o	Add books 
o	Search books 
o	Sort books 
o	Display statistics 
o	Save and load data from a file 

3. Design Explanation
The system is designed using object-oriented programming concepts:
•	Interface (BookInterface)
Defines common operations such as displaying books, counting books per genre, and calculating total cost. 
•	Abstract Class (Book)
Implements the interface and contains shared attributes for all books, including title, author, genre, and type. It also defines an abstract method getCost() that is implemented differently in each subclass. 
•	Subclass (PrintedBook)
Extends the Book class and adds a field for the number of pages. The cost is calculated based on the number of pages. 
•	Subclass (AudioBook)
Extends the Book class and adds a field for duration in minutes. The cost is calculated based on the duration. 
•	Application Class (BookApp)
Manages the collection of books using an ArrayList<Book>. It handles operations such as adding books, searching, sorting, displaying statistics, and file handling. 
•	Main Class (Main)
Provides a command-line interface (CLI) that allows the user to interact with the system through a menu. 
This design demonstrates encapsulation, inheritance, polymorphism, and abstraction

Demonstration video 
https://www.loom.com/share/21873945d1964fc08bba43ea0459b72c
