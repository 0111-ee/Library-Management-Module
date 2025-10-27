package Alpha;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    // Admin Menu


    public static void adminMenu(ArrayList<Book> bookz, ArrayList<Admin> adminz, ArrayList<FacilitiesManagement> facilityz, ArrayList<Member> memberz,

            ArrayList<BookingFacilities> booking, int memberId, Scanner input) {
        int choice;
        do {
            System.out.println("\n╔════════════════════════════════════╗");
            System.out.println("║            ADMIN MENU              ║");
            System.out.println("╠════════════════════════════════════╣");
            System.out.println("║ 1.    Show All Books               ║");
            System.out.println("║ 2.    Manage Books                 ║");
            System.out.println("║ 3.    Manage Facilities            ║");
            System.out.println("║ 4.    Manage Facility Booking      ║");
            System.out.println("║ 5.    Manage Admins                ║");
            System.out.println("║ 6.    Manage Member                ║");
            System.out.println("║ 7.    Logout                       ║");
            System.out.println("╚════════════════════════════════════╝");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    BookManagement.displayAllBooks(bookz);
                    break;
                case 2:
                    int bookChoice;
                    do {
                        System.out.println("\n╔════════════════════════════════════╗");
                        System.out.println("║         BOOK MANAGEMENT            ║");
                        System.out.println("╠════════════════════════════════════╣");
                        System.out.println("║ 1.    Add Book                     ║");
                        System.out.println("║ 2.    Delete Book                  ║");
                        System.out.println("║ 3.    Back to Admin Menu           ║");
                        System.out.println("╚════════════════════════════════════╝");
                        System.out.print("Enter your choice: ");
                        bookChoice = input.nextInt();
                        input.nextLine();

                        switch (bookChoice) {
                            case 1:
                                BookManagement.addBook(bookz, input);
                                break;
                            case 2:
                                BookManagement.deleteBook(bookz, input);
                                break;
                            case 3:
                                System.out.println("Returning to admin menu...");
                                break;
                            default:
                                System.out.println("Invalid option. Try again.");
                                break;
                        }
                    } while (bookChoice != 3);
                    break;

                case 3:
                    int facilityChoice;
                    do {
                        System.out.println("\n╔════════════════════════════════════╗");
                        System.out.println("║      FACILITY MANAGEMENT           ║");
                        System.out.println("╠════════════════════════════════════╣");
                        System.out.println("║ 1.    Add Facility                 ║");
                        System.out.println("║ 2.    Close Facility               ║");
                        System.out.println("║ 3.    Update Facility              ║");
                        System.out.println("║ 4.    Back to Admin Menu           ║");
                        System.out.println("╚════════════════════════════════════╝");
                        System.out.print("Enter your choice: ");
                        facilityChoice = input.nextInt();
                        input.nextLine();

                        switch (facilityChoice) {
                            case 1:
                                FacilitiesManagement.addFacility(facilityz, input);
                                break;
                            case 2:
                                FacilitiesManagement.closeFacility(facilityz, input);
                                break;
                            case 3:
                                FacilitiesManagement.updateFacility(facilityz, input);
                                break;
                            case 4:
                                System.out.println("Returning to admin menu...");
                                break;
                            default:
                                System.out.println("Invalid option. Try again.");
                                break;
                        }
                    } while (facilityChoice != 4);
                    break;

                case 4:
                    int bookingChoice;
                    do {
                        System.out.println("\n╔════════════════════════════════════╗");
                        System.out.println("║   FACILITY BOOKING MANAGEMENT      ║");
                        System.out.println("╠════════════════════════════════════╣");
                        System.out.println("║ 1.   Update Facility Booking       ║");
                        System.out.println("║ 2.   Delete Facility Booking       ║");
                        System.out.println("║ 3.   Back to Admin Menu            ║");
                        System.out.println("╚════════════════════════════════════╝");
                        System.out.print("Enter your choice: ");
                        bookingChoice = input.nextInt();
                        input.nextLine();

                        switch (bookingChoice) {
                            case 1:
                                BookingFacilities adminBooking = new BookingFacilities();
                                adminBooking.updateBooking(booking, facilityz, memberz, input); // Admin Update Booking
                                break;
                            case 2:
                                BookingFacilities adminDelBooking = new BookingFacilities();
                                adminDelBooking.deleteBooking(booking, input); // Admin Delete Booking
                                break;
                            case 3:
                                System.out.println("Returning to Admin Menu...");
                                break;
                            default:
                                System.out.println("Invalid option. Try again.");
                                break;
                        }
                    } while (bookingChoice != 3);
                    break;

                case 5:
                    int adminChoice;
                    do {
                        System.out.println("\n╔════════════════════════════════════╗");
                        System.out.println("║         ADMIN MANAGEMENT           ║");
                        System.out.println("╠════════════════════════════════════╣");
                        System.out.println("║ 1.   View Admin List               ║");
                        System.out.println("║ 2.   Add New Admin                 ║");
                        System.out.println("║ 3.   Update Admin                  ║");
                        System.out.println("║ 4.   Delete Admin                  ║");
                        System.out.println("║ 5.   Back to Admin Menu            ║");
                        System.out.println("╚════════════════════════════════════╝");
                        System.out.print("Enter your choice: ");
                        adminChoice = input.nextInt();
                        input.nextLine();

                        switch (adminChoice) {
                            case 1:
                                Admin.displayAllAdmins(adminz);
                                break;
                            case 2:
                                Admin.addNewAdmin(adminz, input);
                                break;
                            case 3:
                                Admin.updateAdmin(adminz, input);
                                break;
                            case 4:
                                Admin.deleteAdmin(adminz, input);
                                break;
                            case 5:
                                System.out.println("Returning to admin menu...");
                                break;
                            default:
                                System.out.println("Invalid option. Try again.");
                                break;
                        }
                    } while (adminChoice != 5);
                    break;

                case 6:
                    int memberChoice;
                    do {
                        System.out.println("\n╔════════════════════════════════════╗");
                        System.out.println("║         MEMBER MANAGEMENT          ║");
                        System.out.println("╠════════════════════════════════════╣");
                        System.out.println("║ 1.   View Member List              ║");
                        System.out.println("║ 2.   Add New Member                ║");
                        System.out.println("║ 3.   Update Member                 ║");
                        System.out.println("║ 4.   Delete Member                 ║");
                        System.out.println("║ 5.   Back to Admin Menu            ║");
                        System.out.println("╚════════════════════════════════════╝");
                        System.out.print("Enter your choice: ");
                        memberChoice = input.nextInt();
                        input.nextLine();

                        switch (memberChoice) {
                            case 1:
                                Admin.displayAllMembers(memberz);
                                break;
                            case 2:
                                Admin.addNewMember(memberz, input);
                                break;
                            case 3:
                                Admin.updateMember(memberz, input);
                                break;
                            case 4:
                                Admin.deleteMember(memberz, input);
                                break;
                            case 5:
                                System.out.println("Returning to admin menu...");
                                break;
                            default:
                                System.out.println("Invalid option. Try again.");
                                break;
                        }
                    } while (memberChoice != 5);
                    break;

                case 7:
                    System.out.println("Logging out...");
                    break;

                default:
                    System.out.println("Invalid option.");
                    break;
            }

        } while (choice != 7);
    }

    // Member Menu
    public static void memberMenu(ArrayList<Book> bookz, ArrayList<Member> memberz, Scanner input,
            ArrayList<FacilitiesManagement> facilityz, ArrayList<BookingFacilities> bookings, int memberId) {
        int choice;
        do {
            System.out.println("\n╔════════════════════════════════════╗");
            System.out.println("║            MEMBER MENU             ║");
            System.out.println("╠════════════════════════════════════╣");
            System.out.println("║ 1.   View All Books                ║");
            System.out.println("║ 2.   Search Book by ID             ║");
            System.out.println("║ 3.   Borrow/Return Book            ║");
            System.out.println("║ 4.   Facility Booking              ║");
            System.out.println("║ 5.   Logout                        ║");
            System.out.println("╚════════════════════════════════════╝");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    BookManagement.displayAllBooks(bookz);
                    break;
                case 2:
                    BookManagement.searchByBookId(bookz, input);
                    break;
                case 3:
                    int borrowChoice;
                    do {
                        System.out.println("\n╔════════════════════════════════════╗");
                        System.out.println("║      MANAGE BOOK BORROWING         ║");
                        System.out.println("╠════════════════════════════════════╣");
                        System.out.println("║ 1.   Borrow Book                   ║");
                        System.out.println("║ 2.   Return Book                   ║");
                        System.out.println("║ 3.   Back to Member Menu           ║");
                        System.out.println("╚════════════════════════════════════╝");
                        System.out.print("Enter your choice: ");
                        borrowChoice = input.nextInt();
                        input.nextLine();

                        switch (borrowChoice) {
                            case 1:
                                BookManagement.borrowBook(bookz, memberz, input);
                                break;
                            case 2:
                                BookManagement.returnBook(bookz, memberz, input);
                                break;
                            case 3:
                                System.out.println("Returning to Member Menu...");
                                break;
                            default:
                                System.out.println("Invalid option. Please try again.");
                                break;
                        }
                    } while (borrowChoice != 3);
                    break;

                case 4:
                    int bookingChoice;
                    do {
                        System.out.println("\n╔════════════════════════════════════╗");
                        System.out.println("║        FACILITY BOOKING            ║");
                        System.out.println("╠════════════════════════════════════╣");
                        System.out.println("║ 1.   View Facility Status          ║");
                        System.out.println("║ 2.   Book Facility                 ║");
                        System.out.println("║ 3.   Cancel Facility Booking       ║");
                        System.out.println("║ 4.   Back to Member Menu           ║");
                        System.out.println("╚════════════════════════════════════╝");
                        System.out.print("Enter your choice: ");
                        bookingChoice = input.nextInt();
                        input.nextLine();

                        switch (bookingChoice) {
                            case 1:
                                FacilitiesManagement.viewFacilityList(facilityz);
                                break;
                            case 2:
                                BookingFacilities booking = new BookingFacilities(memberId);
                                boolean bookSuscess = booking.bookingRoom(facilityz, memberId, bookings, input);
                                if(bookSuscess){
                                    booking.thanks();
                                }
                                break;
                            case 3:
                                BookingFacilities cancelBooking = new BookingFacilities(memberId);
                                cancelBooking.cancelBooking(facilityz, bookings, memberId, input);
                                break;
                            case 4:
                                System.out.println("Returning to the Member Menu...");
                                break;
                            default:
                                System.out.println("Invalid option. Please try again.");
                                break;
                        }
                    } while (bookingChoice != 4);
                    break;

                case 5:
                    System.out.println("Logging out...");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        } while (choice != 5);
    }
}
