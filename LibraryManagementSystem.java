package Alpha;

import java.util.*;

public class LibraryManagementSystem {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Book> bookz = new ArrayList<>();
        ArrayList<Admin> adminz = new ArrayList<>();
        ArrayList<Member> memberz = new ArrayList<>();
        ArrayList<FacilitiesManagement> facilityz = new ArrayList<>();
        ArrayList<BookingFacilities> booking = new ArrayList<>();

        // Adding members
        memberz.add(new Member(11223, "Jackie Chan", 'M', "012-4455-3344"));
        memberz.add(new Member(11224, "Derrick Yap", 'M', "018-7689-030"));
        memberz.add(new Member(11225, "David Teoh", 'M', "015-7899-223"));
        memberz.add(new Member(11226, "Ashley Cheah", 'F', "017-2992-8974"));
        memberz.add(new Member(11227, "Alex Lee", 'M', "012-4323-6744"));
        memberz.add(new Member(11228, "Gobigal A/L Sulahim", 'M', "019-7678-933"));

        // Adding facility list
        facilityz.add(new FacilitiesManagement(11111, "Room G1-01", "Discussion Room", "Library Ground 1", "Available"));
        facilityz.add(new FacilitiesManagement(11112, "Room G1-02", "Discussion Room", "Library Ground 1", "Available"));
        facilityz.add(new FacilitiesManagement(12221, "Room G2-01", "Presentation Room", "Library Ground 2", "Available"));
        facilityz.add(new FacilitiesManagement(13331, "Room G3-01", "Individual Study Room", "Library Ground 3", "Available"));
        facilityz.add(new FacilitiesManagement(13332, "Room G3-02", "Individual Study Room", "Library Ground 3", "Available"));
        facilityz.add(new FacilitiesManagement(14441, "Room G4-01", "Public Study Room", "Library Ground 4", "Available"));

        // Adding books
        bookz.add(new Fiction(12345, "Harry Potter", "J.K Rowling", "10-11-2024", "Available"));
        bookz.add(new Magazine(54321, "How To Earn Money In One Week", "Leo Tolstoy", "12-11-2024", "Available"));
        bookz.add(new Fiction(10384, "The Little Prince", "Antoine Saint-Exupéry", "19-11-2024", "Available"));
        bookz.add(new Ebook(13049, "Confident!!", "J.K Rowling", "29-11-2024", "Available"));
        bookz.add(new ReferenceBook(75240, "Java in A Book", "Stephen King", "10-01-2025", "Available"));
        bookz.add(new ReferenceBook(72634, "A Brief History of Time", "Stephen Hawking", "10-01-2025", "Available"));
        bookz.add(new Magazine(78963, "TIME Magazine", "James J", "18-02-2025", "Available"));
        bookz.add(new Ebook(12563, "Introduction to the Computation", "Michael Sipser", "27-02-2025", "Available"));
        bookz.add(new ReferenceBook(32597, "Princeton Companion to Mathematics", "Timothy Gowers", "10-03-2025",
                "Available"));
        bookz.add(new Fiction(11339, "The Night Circus", "Erin Morgenstern", "23-03-2025", "Available"));

        // Adding admins
        adminz.add(new Admin(12345, "Chong Jia Wei", 'M', "012-336-4597"));
        adminz.add(new Admin(54321, "Ea Jia Pei", 'F', "017-443-3567"));
        adminz.add(new Admin(24680, "Ee Wan Yin", 'F', "014-556-7889"));
        adminz.add(new Admin(12332, "Cha Li Zhe", 'M', "019-674-0933"));

        // Adding booking
        booking.add(new BookingFacilities());

        System.out.println("╔════════════════════════════════════════════════════╗");
        System.out.println("║                                                    ║");
        System.out.println("║              __   __  __   __  __   __             ║");
        System.out.println("║             |  | |  ||  |_|  ||  | |  |            ║");
        System.out.println("║             |  | |  ||       ||  | |  |            ║");
        System.out.println("║             |  |_|  ||       ||  |_|  |            ║");
        System.out.println("║             |       ||       ||       |            ║");
        System.out.println("║             |       || ||_|| ||       |            ║");
        System.out.println("║             |_______||_|   |_||_______|            ║");
        System.out.println("║                                                    ║");
        System.out.println("╠════════════════════════════════════════════════════╣");
        System.out.println("║     Welcome to the UMU Online Library System!      ║");
        System.out.println("╚════════════════════════════════════════════════════╝\n");

        boolean exit = false;

        while (!exit) {
            System.out.println("\n╔════════════════════════════════════╗");
            System.out.println("║             MAIN MENU              ║");
            System.out.println("╠════════════════════════════════════╣");
            System.out.println("║ 1.    Login                        ║");
            System.out.println("║ 2.    Registration                 ║");
            System.out.println("║ 3.    Exit                         ║");
            System.out.println("╚════════════════════════════════════╝");
            System.out.print("Enter your choice: ");
            int enter = input.nextInt();
            input.nextLine(); 

            switch (enter) {
                case 1:
                    boolean logout = false;
                    while (!logout) {
                        System.out.println("\n╔════════════════════════════════════╗");
                        System.out.println("║            LOGIN PAGE              ║");
                        System.out.println("╠════════════════════════════════════╣");
                        System.out.println("║ 1.    Admin Login                  ║");
                        System.out.println("║ 2.    Member Login                 ║");
                        System.out.println("║ 3.    Back to Main Menu            ║");
                        System.out.println("╚════════════════════════════════════╝");
                        System.out.print("\nChoose an option: ");
                        int option = input.nextInt();
                        input.nextLine();

                        switch (option) {
                            case 1:
                            System.out.println("+---------------------------------------------------------+");
                            System.out.print("Enter Admin ID: ");
                                int adminId = input.nextInt();
                                input.nextLine();

                                Admin foundAdmin = null;
                                for (Admin admin : adminz) {
                                    if (admin.getadminID() == adminId) {
                                        foundAdmin = admin;
                                        break;
                                    }
                                }

                                if (foundAdmin != null) {
                                    System.out.println("Welcome " + foundAdmin.getadminName() + " to UMU Online Library System!");
                                    System.out.println("+---------------------------------------------------------+");
                                    Menu.adminMenu(bookz, adminz, facilityz, memberz, booking, adminId, input);
                                } else {
                                    System.out.println("Invalid Admin ID.");
                                }

                                System.out.println("+---------------------------------------------------------+");

                                break;

                            case 2:
                            System.out.println("+---------------------------------------------------------+");
                            System.out.print("Enter Member ID: ");
                                int memberId = input.nextInt();
                                input.nextLine();

                                Member foundMember = null;
                                for (Member member : memberz) {
                                    if (member.getMemberID() == memberId) {
                                        foundMember = member;
                                        break;
                                    }
                                }

                                if (foundMember != null) {
                                    System.out.println("Welcome " + foundMember.getMemberName() + " to UMU Online Library System!");
                                    System.out.println("+---------------------------------------------------------+");
                                    Menu.memberMenu(bookz, memberz, input, facilityz, booking, memberId);
                                } else {
                                    System.out.println("\n!---------------------------------!");
                                    System.out.println("Invalid Member ID.");
                                    System.out.println("!---------------------------------!");
                                }

                                System.out.println("+---------------------------------------------------------+");

                                break;

                            case 3:
                                logout = true;
                                break;

                            default:
                                System.out.println("\n!---------------------------------!");
                                System.out.println("    Invalid option. Try again.");
                                System.out.println("!---------------------------------!\n");

                                break;
                        }
                    }
                    break;

                case 2:
                    System.out.println("\n╔════════════════════════════════════════╗");
                    System.out.println("║          REGISTRATION MENU             ║");
                    System.out.println("╠════════════════════════════════════════╣");
                    System.out.println("║ 1.    Register as Member               ║");
                    System.out.println("║ 2.    Register as Admin                ║");
                    System.out.println("╚════════════════════════════════════════╝");
                    System.out.print("\nEnter your choice: ");
                    int pick = input.nextInt();
                    input.nextLine(); // Consume newline

                    switch (pick) {
                        case 1:
                            System.out.println("+---------------------------------+");
                            Admin.addNewMember(memberz, input);
                            System.out.println("+---------------------------------+");
                            break;
                        case 2:
                            System.out.println("+---------------------------------+");
                            Admin.addNewAdmin(adminz, input);
                            System.out.println("+---------------------------------+\n");
                            break;
                        default:
                            System.out.println("\n!---------------------------------!");
                            System.out.println("    Invalid option. Try again.");
                            System.out.println("!---------------------------------!\n");
                            break;
                    }
                    break;

                case 3:
                    System.out.println("\n+--------------------------------------------+");
                    System.out.println("Thank you for using UMU Online Library System!");
                    System.out.println("+--------------------------------------------+");
                    exit = true;
                    break;

                default:
                    System.out.println("\n!---------------------------------!");
                    System.out.println("    Invalid option. Try again.");
                    System.out.println("!---------------------------------!\n");
                    break;
            }
        }

        input.close();
    }
}