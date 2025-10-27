package Alpha;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class BookingFacilities extends ManageBooking {
    private Date bookingDate;
    private Date bookingTimeStart;
    private Date bookingTimeEnd;
    private int memberId;
    private int facilityID;
    private static ArrayList<BookingFacilities> bookings = new ArrayList<>();

    public BookingFacilities() {
        this.memberId = 0;
        this.facilityID = 0;
        this.bookingDate = null;
        this.bookingTimeStart = null;
        this.bookingTimeEnd = null;
    }

    public BookingFacilities(int memberId) {
        this.memberId = memberId;
    }

    public static ArrayList<BookingFacilities> getBookings() {
        return bookings;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public boolean setBookingDate(String bookingDate) {
        try {
            SimpleDateFormat calendar = new SimpleDateFormat("dd-MM-yyyy");
            this.bookingDate = calendar.parse(bookingDate);
            return true;
        } catch (Exception e) {
            System.out.println("Please enter the correct date format (dd-MM-yyyy)!");
            return false;
        }
    }

    public Date getBookingTimeStart() {
        return bookingTimeStart;
    }

    public boolean setBookingTimeStart(String bookingTimeStart) {
        try {
            SimpleDateFormat date = new SimpleDateFormat("HH:mm");
            this.bookingTimeStart = date.parse(bookingTimeStart);
            return true;
        } catch (Exception e) {
            System.out.println("Please enter the correct time format (HH:mm)!");
            return false;
        }
    }

    public Date getBookingTimeEnd() {
        return bookingTimeEnd;
    }

    public boolean setBookingTimeEnd(String bookingTimeEnd) {
        try {
            SimpleDateFormat date = new SimpleDateFormat("HH:mm");
            this.bookingTimeEnd = date.parse(bookingTimeEnd);
            return true;
        } catch (Exception e) {
            System.out.println("Please enter the correct time format (HH:mm)!");
            return false;
        }
    }

    public int getMemberID() {
        return memberId;
    }

    public void setMemberID(int memberId) {
        this.memberId = memberId;
    }

    public int getFacilityID() {
        return facilityID;
    }

    public void setFacilityID(int facilityID) {
        this.facilityID = facilityID;
    }

    @Override
    public boolean bookingRoom(ArrayList<FacilitiesManagement> facilityz, int memberId, ArrayList<BookingFacilities> booking, Scanner input) {
        this.memberId = memberId;

        System.out.print("Enter Facility ID to book [Format(5digits)]: ");
        facilityID = input.nextInt();
        input.nextLine();
        setFacilityID(facilityID);

        boolean validDate;
        do {
            System.out.print("Enter the booking date [Format(dd-MM-yyyy)]: ");
            validDate = setBookingDate(input.nextLine());
        } while (!validDate);

        boolean validStart;
        do {
            System.out.print("Enter the booking start time [Format 24(HH:mm)]: ");
            validStart = setBookingTimeStart(input.nextLine());
        } while (!validStart);

        boolean validEnd;
        do {
            System.out.print("Enter the booking end time [Format 24(HH:mm)]: ");
            validEnd = setBookingTimeEnd(input.nextLine());
        } while (!validEnd);

        for (FacilitiesManagement facility : facilityz) {
            if (facility.getFacilityID() == facilityID) {
                if (facility.getFacilityAvailability().equalsIgnoreCase("Available")) {
                    facility.setFacilityAvailability("Booked");

                    BookingRoomReceipt receipt = new BookingRoomReceipt(facility, this);
                    receipt.printBookingReceipt();
                    booking.add(this);
                    return true;
                } else {
                    System.out.println("Sorry, the facility is already booked.");
                    return false;
                }
            }
        }

            System.out.println("Facility not found with the provided ID.");
            return false;
    }

    @Override
    public void cancelBooking(ArrayList<FacilitiesManagement> facilityz, ArrayList<BookingFacilities> booking, int memberId, Scanner input) {
        this.memberId = memberId;

        System.out.print("Enter the Facility ID to cancel: ");
        int facilityID = input.nextInt();
        input.nextLine();

        boolean bookingFound = false;
        for (int i = 0; i < booking.size(); i++) {
            BookingFacilities book = booking.get(i);
            if (book.memberId == this.memberId && book.facilityID == facilityID) {
                booking.remove(i);
                for (FacilitiesManagement facility : facilityz) {
                    if (facility.getFacilityID() == facilityID) {
                        facility.setFacilityAvailability("Available");
                        break;
                    }
                }
                System.out.println("Booking canceled successfully.");
                bookingFound = true;
                break;
            }
        }
        if (!bookingFound) {
            System.out.println("No booking found for this Facility ID under your Member ID.");
        }
    }

    @Override
    public void updateBooking(ArrayList<BookingFacilities> booking, ArrayList<FacilitiesManagement> facilityz, ArrayList<Member> memberz, Scanner input) {
        int memberId = -1;
        try {
            System.out.print("Enter the Member ID to update booking: ");
            memberId = input.nextInt();
            input.nextLine();
        } catch (Exception e) {
            System.out.println("Please enter the valid Member ID [Format(5digit)]");
            input.nextLine();
            return;
        }

        boolean found = false;
        for (BookingFacilities bookings : booking) {
            if (bookings.getMemberID() == memberId) {
                found = true;
                System.out.println("╔════════════════════════════════════════════════════════════╗");
                System.out.printf("║ Current booking details for Member ID: %-19d ║%n", memberId);
                System.out.printf("║ Date       : %-45s ║%n",
                        new SimpleDateFormat("dd-MM-yyyy").format(bookings.getBookingDate()));
                System.out.printf("║ Start Time : %-45s ║%n",
                        new SimpleDateFormat("HH:mm").format(bookings.getBookingTimeStart()));
                System.out.printf("║ End Time   : %-45s ║%n",
                        new SimpleDateFormat("HH:mm").format(bookings.getBookingTimeEnd()));
                System.out.println("╚════════════════════════════════════════════════════════════╝");
                try {
                    boolean validDate;
                    do {
                        System.out.print("Enter the booking date [Format(dd-MM-yyyy)]: ");
                        validDate = bookings.setBookingDate(input.nextLine());
                    } while (!validDate);
                    boolean validStart;
                    do {
                        System.out.print("Enter the booking start time [Format 24(HH:mm)]: ");
                        validStart = bookings.setBookingTimeStart(input.nextLine());
                    } while (!validStart);         
                    boolean validEnd;
                    do {
                        System.out.print("Enter the booking end time [Format 24(HH:mm)]: ");
                        validEnd = bookings.setBookingTimeEnd(input.nextLine());
                    } while (!validEnd);
                    System.out.println("\nBooking updated Successfully!");
                } catch (Exception e) {
                    System.out.println("\nInvalid input. Please try again.");
                }
            }
        }

        if (!found) {
            System.out.println("No booking found for Member ID: " + memberId);
        }
    }

    @Override
    public void deleteBooking(ArrayList<BookingFacilities> booking,Scanner input) {
        System.out.print("Enter the Member ID to delete booking: ");
        int memberId = input.nextInt();
        input.nextLine();
        for (int i = 0; i < booking.size(); i++) {
            if (booking.get(i).getMemberID() == memberId) {
                booking.remove(i);
                System.out.println("Booking deleted successfully for Member ID: " + memberId);
                return;
            }
        }
        System.out.println("No booking found for Member ID: " + memberId);
    }

}



