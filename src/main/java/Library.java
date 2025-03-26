import java.util.HashMap;
import java.util.Map;

public class Library {
    private Map<String, Book> books = new HashMap<>();

    // Add a Book
    public void addBook(String bookId, String title, String author, String genre, String availabilityStatus) {
        if (books.containsKey(bookId)) {
            System.out.println("Book ID already exists!");
        } else {
            Book book = new Book(bookId, title, author, genre, availabilityStatus);
            books.put(bookId, book);
            System.out.println("Book added successfully!");
        }
    }

    // View All Books
    public void viewAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available in the catalog.");
        } else {
            for (Book book : books.values()) {
                System.out.println(book);
            }
        }
    }

    // Search Book by ID or Title
    public Book searchBook(String searchTerm) {
        // Search by ID first
        Book bookById = books.get(searchTerm);
        if (bookById != null) {
            return bookById;
        }

        // If not found by ID, search by Title
        for (Book book : books.values()) {
            if (book.getTitle().equalsIgnoreCase(searchTerm)) {
                return book;
            }
        }

        return null; // Book not found
    }

    // Update Book Details
    public void updateBook(String bookId, String newTitle, String newAuthor, String newGenre, String newAvailabilityStatus) {
        Book book = books.get(bookId);
        if (book != null) {
            book.setTitle(newTitle);
            book.setAuthor(newAuthor);
            book.setGenre(newGenre);
            book.setAvailabilityStatus(newAvailabilityStatus);
            System.out.println("Book details updated successfully!");
        } else {
            System.out.println("Book not found.");
        }
    }

    // Delete a Book Record
    public void deleteBook(String bookId) {
        if (books.remove(bookId) != null) {
            System.out.println("Book deleted successfully!");
        } else {
            System.out.println("Book not found.");
        }
    }
}
