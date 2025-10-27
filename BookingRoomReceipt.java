package Alpha;

//this use simple dateformt
import java.text.SimpleDateFormat;

public class BookingRoomReceipt {
    private BookingFacilities booking;
    private FacilitiesManagement facility;

    public BookingRoomReceipt(FacilitiesManagement facility, BookingFacilities booking) {
        this.facility = facility;
        this.booking = booking;
    }

    public void printBookingReceipt() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");

        System.out.println("\n╔════════════════════ FACILITY BOOKING DETAILS ═══════════════════╗");
        System.out.printf("║ %-20s: %-41d ║\n", "Member ID", booking.getMemberID());
        System.out.printf("║ %-20s: %-41d ║\n", "Facility ID", facility.getFacilityID());
        System.out.printf("║ %-20s: %-41s ║\n", "Facility Name", facility.getFacilityName());
        System.out.printf("║ %-20s: %-41s ║\n", "Booking Date", dateFormat.format(booking.getBookingDate()));
        System.out.printf("║ %-20s: %-41s ║\n", "Start Time", timeFormat.format(booking.getBookingTimeStart()));
        System.out.printf("║ %-20s: %-41s ║\n", "End Time", timeFormat.format(booking.getBookingTimeEnd()));
        System.out.println("╚═════════════════════════════════════════════════════════════════╝");
    }
}
