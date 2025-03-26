import java.util.Scanner;

public class DigitalLibrary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        while (true) {
            System.out.println("\nWelcome to the Digital Library Management System");
            System.out.println("1. Add a Book");
            System.out.println("2. View All Books");
            System.out.println("3. Search Book by ID or Title");
            System.out.println("4. Update Book Details");
            System.out.println("5. Delete a Book");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    String bookId = scanner.nextLine();
                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter Genre: ");
                    String genre = scanner.nextLine();
                    System.out.print("Enter Availability Status (Available/Checked Out): ");
                    String availabilityStatus = scanner.nextLine();
                    library.addBook(bookId, title, author, genre, availabilityStatus);
                    break;
                case 2:
                    library.viewAllBooks();
                    break;
                case 3:
                    System.out.print("Enter Book ID or Title to Search: ");
                    String searchTerm = scanner.nextLine();
                    Book searchedBook = library.searchBook(searchTerm);
                    if (searchedBook != null) {
                        System.out.println(searchedBook);
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter Book ID to Update: ");
                    String bookIdToUpdate = scanner.nextLine();
                    System.out.print("Enter new Title: ");
                    String newTitle = scanner.nextLine();
                    System.out.print("Enter new Author: ");
                    String newAuthor = scanner.nextLine();
                    System.out.print("Enter new Genre: ");
                    String newGenre = scanner.nextLine();
                    System.out.print("Enter new Availability Status: ");
                    String newAvailabilityStatus = scanner.nextLine();
                    library.updateBook(bookIdToUpdate, newTitle, newAuthor, newGenre, newAvailabilityStatus);
                    break;
                case 5:
                    System.out.print("Enter Book ID to Delete: ");
                    String bookIdToDelete = scanner.nextLine();
                    library.deleteBook(bookIdToDelete);
                    break;
                case 6:
                    System.out.println("Exiting system. Goodbye!");
                    scanner.close();
                    return;  // Exit the program
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
