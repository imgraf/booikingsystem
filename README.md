# Book Management System
The Book Management System is a Java application designed to allow users to manage their book collection. With this program, users can add, delete, view, and search for books. It is based on a MongoDB database used as the backend for storing and querying book data.

## Functionality
1. Add Book: Users can enter the information about a book, including title, author, publisher, publication year, and ISBN. The program captures this data and creates a new book object, which is then stored in the MongoDB database.
2. Delete Book: If a user wants to remove a book from their collection, they can specify the title of the book. The program searches for the book in the database and permanently deletes it.
3. View All Books: By selecting this option, all stored books are listed, and detailed information about each book is displayed, including title, author, publisher, publication year, and ISBN.
4. Search for Book: Users can search for books based on a search term in the title. The program searches the database for matches and displays the corresponding books.

## Requirements
To run the program properly, some prerequisites must be met:

1. MongoDB: Make sure MongoDB is installed and running on your system. You can visit the official MongoDB website and follow the instructions to download and install MongoDB.
2. Java Development Kit (JDK): You need to have a JDK version installed to run the program. Check if Java is installed on your system by running the `java -version` command in the terminal. If Java is not installed, download the latest JDK version from the official Oracle website and install it.
3. Integrated Development Environment (optional): You can use a Java Integrated Development Environment like Eclipse, IntelliJ IDEA, or NetBeans to edit the source code and run the program. If you're not using an IDE, you can edit the source code with a text editor and compile and run it using the command line.

## Program Execution
Follow these steps to run the program:

1. Start MongoDB: Open a terminal window and start the MongoDB service using the `mongod` command. Make sure MongoDB is running on the default port (27017).
2. Open a terminal window or command prompt and navigate to the directory where the program source code is located.
3. Compile the source code using the `javac *.java` command.
4. Execute the program using the `java UserInterface` command.

Once the program is launched, you can utilize the available functionalities by following the instructions on the user interface.

## Author
Graf, Raul