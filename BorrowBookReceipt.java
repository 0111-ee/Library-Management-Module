package Alpha;

// this use localdate fmt
import java.time.LocalDate;

public class BorrowBookReceipt {
    private Book book;
    private Member member;
    private LocalDate borrowDate;

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    private LocalDate returnDate;

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public BorrowBookReceipt(Book book, Member member, LocalDate borrowDate, LocalDate returnDate) {
        this.book = book;
        this.member = member;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
    }

    // print out receipt
    public void printReceipt() {
        System.out.println("\n╔════════════════════ BOOK BORROW CONFIRMATION ═══════════════════╗");
        System.out.printf("║ %-30s: %-31s ║\n", "Member ID", member.getMemberID());
        System.out.printf("║ %-30s: %-31s ║\n", "Name", member.getMemberName());
        System.out.printf("║ %-30s: %-31d ║\n", "Book ID", book.getBookId());
        System.out.printf("║ %-30s: %-31s ║\n", "Book Title", book.getBookTitle());
        System.out.printf("║ %-30s: %-31s ║\n", "Author", book.getBookAuthor());
        System.out.printf("║ %-30s: %-31s ║\n", "Borrow Date", borrowDate);
        System.out.printf("║ %-30s: %-31s ║\n", "Last Return Date", returnDate);
        System.out.printf("║ %-30s: %-31s ║\n", "Remember to return before", returnDate.plusDays(1));
        System.out.println("╚═════════════════════════════════════════════════════════════════╝");
    }

}