package Alpha;

import java.util.ArrayList;

public class Book {

    private int bookId;
    private String bookTitle;
    private String bookAuthor;
    private String importDate;
    private String bookAvailability;
    private String bookCategory;

    public Book(int bookId, String bookTitle, String bookAuthor, String importDate,
            String bookAvailability, String bookCategory) {
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.importDate = importDate;
        this.bookAvailability = bookAvailability;
        this.bookCategory = bookCategory;

    }

    public int getBookId() {
        return bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public String getImportDate() {
        return importDate;
    }

    public String getBookAvailability() {
        return bookAvailability;
    }

    public String getBookCategory() {
        return bookCategory;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public void setImportDate(String importDate) {
        this.importDate = importDate;
    }

    public void setBookAvailability(String bookAvailability) {
        this.bookAvailability = bookAvailability;
    }

    public void setBookCategory(String bookCategory) {
        this.bookCategory = bookCategory;
    }

    // display booklist
    public static void displayAllBooks(ArrayList<Book> bookz) {
        System.out.println(
                "+---------+--------------------------------------+-------------------------+------------+----------------+--------------+");
        System.out.println(
                "| Book ID | Title                                | Author                  | Status     | Category     | Import Date    |");
        System.out.println(
                "+---------+--------------------------------------+-------------------------+------------+----------------+--------------+");

        for (Book book : bookz) {
            System.out.printf("| %-7d | %-36s | %-23s | %-10s | %-12s | %-12s |%n",
                    book.getBookId(), book.getBookTitle(), book.getBookAuthor(),
                    book.getBookAvailability(), book.getBookCategory(), book.getImportDate());

            System.out.println(
                    "+---------+--------------------------------------+-------------------------+------------+----------------+--------------+");
        }
    }

    // display
    public void displayBook(Book book) {
        System.out.printf("| %-7d | %-36s | %-23s | %-10s | %-12s | %-12s |%n",
                book.getBookId(), book.getBookTitle(), book.getBookAuthor(),
                book.getBookAvailability(), book.getBookCategory(), book.getImportDate());
        System.out.println(
                "+---------+--------------------------------------+-------------------------+------------+----------------+--------------+");
    }
}
