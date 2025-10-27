package Alpha;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class ManageBooking {

    public abstract boolean bookingRoom(ArrayList<FacilitiesManagement> facilityz, int memberId,
            ArrayList<BookingFacilities> booking, Scanner input);

    public abstract void cancelBooking(ArrayList<FacilitiesManagement> facilityz, ArrayList<BookingFacilities> booking,
            int memberId, Scanner input);

    public abstract void updateBooking(ArrayList<BookingFacilities> booking, ArrayList<FacilitiesManagement> facilityz, ArrayList<Member> memberz, Scanner input);


    public abstract void deleteBooking(ArrayList<BookingFacilities> booking, Scanner input);

    public void thanks() {
        System.out.println("╔═════════════════════════════════════════════════════════════════╗");
        System.out.println("║                    Thanks for your booking!                     ║");
        System.out.println("╚═════════════════════════════════════════════════════════════════╝");
    }
}
