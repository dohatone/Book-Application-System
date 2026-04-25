# 📚 Book Application System

## 👋 Hi, this is Doha Bousmah

---

## 1. Project Description

This project is a Java-based Book Application System that allows users to store and manage books they have read. The system supports two types of books: **Printed Books** and **AudioBooks**.

Each book stores:
- Title  
- Author  
- Genre  
- Cost  

Printed books store the **number of pages**, while audiobooks store the **duration in minutes**.

The application provides functionalities to:
- Add books  
- Search books  
- Sort books  
- Display statistics  
- Save and load book data from a file  

The system is implemented using object-oriented programming principles.

---

## 2. How to Run the Program

1. Open the project in a Java IDE (e.g., IntelliJ IDEA, Eclipse).
2. Ensure all source files are in the project:
   - `BookInterface.java`  
   - `Book.java`  
   - `PrintedBook.java`  
   - `AudioBook.java`  
   - `BookApp.java`  
   - `Main.java`  

3. Run the `Main.java` file.
4. Use the command-line menu to:
   - Add books  
   - Search books  
   - Sort books  
   - Display statistics  
   - Save and load data  

---

## 3. Design Explanation

The system is designed using object-oriented programming concepts:

### 🔹 Interface (`BookInterface`)
Defines common operations such as:
- Displaying books  
- Counting books per genre  
- Calculating total cost  

---

### 🔹 Abstract Class (`Book`)
Implements the interface and contains shared attributes:
- Title  
- Author  
- Genre  
- Type  

It also defines an abstract method:
- `getCost()` → implemented differently by each subclass  

---

### 🔹 Subclass (`PrintedBook`)
- Extends `Book`  
- Stores number of pages  
- Cost is calculated based on pages  

---

### 🔹 Subclass (`AudioBook`)
- Extends `Book`  
- Stores duration in minutes  
- Cost is calculated based on duration  

---

### 🔹 Application Class (`BookApp`)
Manages the system using:
- `ArrayList<Book>`  

Handles:
- Adding books  
- Searching  
- Sorting  
- Statistics  
- File handling  

---

### 🔹 Main Class (`Main`)
Provides a command-line interface (CLI) that allows user interaction through a menu system.

---

## 🧠 OOP Concepts Demonstrated

- **Encapsulation** → Private fields with getters/setters  
- **Inheritance** → Subclasses extend the `Book` class  
- **Polymorphism** → Using `ArrayList<Book>` to store multiple types  
- **Abstraction** → Abstract class and abstract method implementation  

---

## 🎥 Video Demonstration

👉 https://www.loom.com/share/21873945d1964fc08bba43ea0459b72c

---

## 👤 Author

**Doha Bousmah**

