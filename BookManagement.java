package Alpha;

import java.time.LocalDate;
import java.util.*;

public class BookManagement {

    // Borrow book - function U
    public static void borrowBook(ArrayList<Book> bookz, ArrayList<Member> memberz, Scanner input) {
        System.out.print("Enter Book ID to borrow: ");
        int id = input.nextInt();
        input.nextLine(); // consume newline

        System.out.print("Enter Member ID: ");
        int memberId = input.nextInt();
        input.nextLine();

        Member member = null;
        for (Member m : memberz) {
            if (m.getMemberID() == memberId) {
                member = m;
                break;
            }
        }

        if (member == null) {
            System.out.println("No member found with the provided ID.");
            return;
        }

        boolean bookFound = false;

        for (Book book : bookz) {
            if (book.getBookId() == id) {
                bookFound = true;
                if (book.getBookAvailability().equalsIgnoreCase("Available")) {
                    book.setBookAvailability("Borrowed");
                    displayBook(book);
                    System.out.println("Book borrowed successfully.");
                    // ask for user to see the receipt
                    LocalDate borrowDate = LocalDate.now();
                    LocalDate returnDate = borrowDate.plusDays(7);

                    BorrowBookReceipt receipt = new BorrowBookReceipt(book, member, borrowDate, returnDate);
                    receipt.printReceipt();
                
            
            } else {
                System.out.println("Sorry, the book is already borrowed.");
            }break;
        }
    }
        if (!bookFound) {
            System.out.println("Book not found with the provided ID.");
        }
    }

    // Return book - function U
    public static void returnBook(ArrayList<Book> bookz, ArrayList<Member> memberz, Scanner input) {
        System.out.print("Enter Book ID to return: ");
        int id = input.nextInt();
        input.nextLine();

        System.out.print("Enter Member ID: ");
        int memberId = input.nextInt();
        input.nextLine();

        Member member = null;
        for (Member m : memberz) {
            if (m.getMemberID() == memberId) {
                member = m;
                break;
            }
        }

        if (member == null) {
            System.out.println("No member found with the provided ID.");
            return;
        }

        boolean bookFound = false;

        for (Book book : bookz) {
            if (book.getBookId() == id) {
                bookFound = true;
                if (book.getBookAvailability().equalsIgnoreCase("Borrowed")) {
                    book.setBookAvailability("Available");
                    displayBook(book);
                    System.out.println("Book returned successfully.");

                    break;
                } else {
                    System.out.println("This book was not marked as borrowed.");
                }
            }
        }

        if (!bookFound) {
            System.out.println("Book not found with the provided ID.");
        }
    }

    // Display book - function
    public static void displayBook(Book book) {
        System.out.println(
                "+---------+--------------------------------------+-------------------------+------------+--------------+--------------+");
        System.out.printf("| %-7d | %-36s | %-23s | %-10s | %-12s | %-12s |%n",
                book.getBookId(), book.getBookTitle(), book.getBookAuthor(),
                book.getBookAvailability(), book.getBookCategory(), book.getImportDate());
        System.out.println(
                "+---------+--------------------------------------+-------------------------+------------+--------------+--------------+");
    }

    // Display all books - function
    public static void displayAllBooks(ArrayList<Book> bookz) {
        System.out.println(
                "+---------+--------------------------------------+-------------------------+------------+--------------+--------------+");
        System.out.println(
                "| Book ID | Title                                | Author                  | Status     | Category     | Import Date  |");
        System.out.println(
                "+---------+--------------------------------------+-------------------------+------------+--------------+--------------+");

        for (Book book : bookz) {
            System.out.printf("| %-7d | %-36s | %-23s | %-10s | %-12s | %-12s |%n",
                    book.getBookId(), book.getBookTitle(), book.getBookAuthor(),
                    book.getBookAvailability(), book.getBookCategory(), book.getImportDate());
            System.out.println(
                    "+---------+--------------------------------------+-------------------------+------------+--------------+--------------+");
        }
    }

    // Search book by ID - function
    public static void searchByBookId(ArrayList<Book> bookz, Scanner input) {
        int bookId;
        boolean bookFound;

        do {
            System.out.print("Please enter book ID: ");
            bookId = input.nextInt();
            input.nextLine();

            System.out.println(
                    "+---------+--------------------------------------+-------------------------+------------+--------------+--------------+");
            System.out.println(
                    "| Book ID | Title                                | Author                  | Status     | Category     | Import Date  |");
            System.out.println(
                    "+---------+--------------------------------------+-------------------------+------------+--------------+--------------+");

            bookFound = false;
            for (Book book : bookz) {
                if (book.getBookId() == bookId) {
                    displayBook(book);
                    bookFound = true;
                    break;
                }
            }

            if (!bookFound) {
                System.out.println("No book found with ID: " + bookId);
                System.out.println("Please enter again: ");
            }
        } while (!bookFound);
    }

    // Add book - function
    public static void addBook(ArrayList<Book> bookz, Scanner input) {
        System.out.print("Enter Book ID: ");
        int id = input.nextInt();
        input.nextLine();

        // Check for duplicate ID
        for (Book book : bookz) {
            if (book.getBookId() == id) {
                System.out.println("A book with this ID already exists. Please use a different ID.");
                return;
            }
        }

        System.out.print("Enter Book Title: ");
        String title = input.nextLine();
        System.out.print("Enter Author: ");
        String author = input.nextLine();
        System.out.print("Enter Import Date (e.g., 01-01-2025): ");
        String importDate = input.nextLine();
        System.out.print("Enter Status : ");
        String status = input.nextLine();

        System.out.println("Choose a category for the book:");
        System.out.println("1. Fiction");
        System.out.println("2. EBook");
        System.out.println("3. Reference Book");
        System.out.println("4. Magazine");
        System.out.print("Enter your choice: ");
        int categoryChoice = input.nextInt();
        input.nextLine();

        Book newBook = null;

        switch (categoryChoice) {
            case 1:
                newBook = new Fiction(id, title, author, importDate, status);
                break;
            case 2:
                newBook = new Ebook(id, title, author, importDate, status);
                break;
            case 3:
                newBook = new ReferenceBook(id, title, author, importDate, status);
                break;
            case 4:
                newBook = new Magazine(id, title, author, importDate, status);
                break;
            default:
                System.out.println("Invalid category choice. Book will not be added.");
                return;
        }

        bookz.add(newBook);
        System.out.println("Book added successfully.");

        System.out.print("\nDo you want to see the updated book list? (Y/N): ");
        String choice = input.nextLine().toUpperCase();

        if (choice.equals("Y")) {
            System.out.println("\nUpdated Book List:");
            displayAllBooks(bookz);
            System.out.println("\nTotal number of books: " + bookz.size());
        } else {
            System.out.println("Returning to the main menu...");
        }
    }

    // Delete book - function
    public static void deleteBook(ArrayList<Book> bookz, Scanner input) {
        try {
            System.out.print("Enter the Book ID to delete: ");

            // Check if input is a valid integer
            if (!input.hasNextInt()) {
                System.out.println("Invalid input. Please enter a numeric Book ID.");
                input.nextLine(); // clear invalid input
                return;
            }

            int bookId = input.nextInt();
            input.nextLine(); // consume newline

            Book bookToDelete = null;

            for (Book book : bookz) {
                if (book.getBookId() == bookId) {
                    bookToDelete = book;
                    break;
                }
            }

            if (bookToDelete == null) {
                throw new NoSuchElementException("Book not found!");
            }

            // Ask for confirmation
            System.out.print("Are you sure you want to delete this book? (Y/N): ");
            String confirm = input.nextLine();

            if (confirm.equalsIgnoreCase("Y")) {
                bookz.remove(bookToDelete);
                System.out.println("Book successfully deleted.");
            } else {
                System.out.println("Deletion cancelled.");
            }

        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
    }
}