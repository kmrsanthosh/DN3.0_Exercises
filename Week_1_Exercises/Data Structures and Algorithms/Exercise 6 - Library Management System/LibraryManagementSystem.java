import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LibraryManagementSystem {
    private List<Book> books;

    public LibraryManagementSystem() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public Book linearSearchByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public Book binarySearchByTitle(String title) {
        Collections.sort(books); // Ensure the list is sorted
        int left = 0;
        int right = books.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = books.get(mid).getTitle().compareToIgnoreCase(title);

            if (comparison == 0) {
                return books.get(mid);
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        LibraryManagementSystem lms = new LibraryManagementSystem();

        lms.addBook(new Book(1, "To Kill a Mockingbird", "Harper Lee"));
        lms.addBook(new Book(2, "1984", "George Orwell"));
        lms.addBook(new Book(3, "Pride and Prejudice", "Jane Austen"));
        lms.addBook(new Book(4, "The Great Gatsby", "F. Scott Fitzgerald"));

        long startTime = System.nanoTime();
        Book foundLinear = lms.linearSearchByTitle("1984");
        long endTime = System.nanoTime();
        System.out.println("Linear Search Result: " + foundLinear);
        System.out.println("\nLinear Search Time: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        Book foundBinary = lms.binarySearchByTitle("1984");
        endTime = System.nanoTime();
        System.out.println("\n\nBinary Search Result: " + foundBinary);
        System.out.println("\nBinary Search Time: " + (endTime - startTime) + " ns");
    }
}