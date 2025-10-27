package Alpha;

import java.util.ArrayList;
import java.util.Scanner;

public class Registration {

    public static void registerUser(ArrayList<Admin> adminz, ArrayList<Member> memberz, Scanner input) {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║          REGISTRATION MENU             ║");
        System.out.println("╠════════════════════════════════════════╣");
        System.out.println("║ 1.  Register as Admin                  ║");
        System.out.println("║ 2.  Register as Member                 ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.print("Enter your choice: ");
        int choice = input.nextInt();
        input.nextLine();

        switch (choice) {
            case 1:
                Admin.addNewAdmin(adminz, input);
                break;
            case 2:
                Admin.addNewMember(memberz, input);
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    public static void viewUsers(ArrayList<Admin> adminz, ArrayList<Member> memberz) {
        System.out.println("\n╔════════════════════════════════════╗");
        System.out.println("║         REGISTERED ADMINS          ║");
        System.out.println("╚════════════════════════════════════╝");
        Admin.displayAllAdmins(adminz);

        System.out.println("\n╔════════════════════════════════════╗");
        System.out.println("║        REGISTERED MEMBERS          ║");
        System.out.println("╚════════════════════════════════════╝");
        Admin.displayAllMembers(memberz);
    }
}
