package Alpha;

import java.util.ArrayList;
import java.util.Scanner;

public class Admin {

    private int adminID;
    private String adminName;
    private char gender;
    private String contactNumber;

    public Admin(int adminID, String adminName, char gender, String contactNumber) {
        this.adminID = adminID;
        this.adminName = adminName;
        this.gender = gender;
        this.contactNumber = contactNumber;
    }

    public int getadminID() {
        return adminID;
    }

    public String getadminName() {
        return adminName;
    }

    public char getGender() {
        return gender;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setadminName(String adminName) {
        this.adminName = adminName;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    // Contact number validation
    private static boolean isValidContact(String contact) {
        return contact.matches("\\d{3}-\\d{4}-\\d{4}");
    }

    // ADMIN ROLE

    public static void addNewAdmin(ArrayList<Admin> adminz, Scanner input) {
        int adminID;
        boolean valid = false;

        do {
            System.out.print("Create a unique Admin ID[5digit]: ");
            try {
                adminID = input.nextInt();
                input.nextLine();

                valid = true;
                for (Admin admin : adminz) {
                    if (admin.getadminID() == adminID) {
                        System.out.println("This Admin ID already exists. Please try again.");
                        valid = false;
                        break;
                    }
                }

                if (!valid) {
                    adminID = -1;
                }

            } catch (Exception e) {
                System.out.println("Invalid input. Please enter numbers only.");
                input.nextLine();
                adminID = -1;
            }
        } while (adminID <= 0);

        System.out.print("Enter name: ");
        String name = input.nextLine();

        char gender;
        do {
            System.out.print("Enter gender (M/F): ");
            gender = input.next().toUpperCase().charAt(0);
            input.nextLine();
            if (gender != 'M' && gender != 'F') {
                System.out.println("Please enter the correct gender! [Male(M)/Female(F)]");
            }
        } while (gender != 'M' && gender != 'F');
        

        String contact;
        do {
            System.out.print("Enter contact number [Format(123-4567-8899)]: ");
            contact = input.nextLine();
            if (!isValidContact(contact)) {
                System.out.println("Invalid contact number format. Please try again.");
            }
        } while (!isValidContact(contact));

        adminz.add(new Admin(adminID, name, gender, contact));
        System.out.println("Admin registered successfully.");
    }

    public static void updateAdmin(ArrayList<Admin> adminz, Scanner input) {
        boolean found = false;

        do {
            System.out.print("Enter Admin ID to update [Format(NNNNN)]: ");
            int adminID = input.nextInt();
            input.nextLine();

            for (Admin admin : adminz) {
                if (admin.getadminID() == adminID) {
                    found = true;

                    System.out.print("Set your new name: ");
                    String adminName = input.nextLine();

                    char gender;
                    do {
                        System.out.print("Set your new gender [Male(M)/Female(F)]: ");
                        gender = input.next().toUpperCase().charAt(0);
                        input.nextLine();
                        if (gender != 'M' && gender != 'F') {
                            System.out.println("Please enter the correct gender!");
                        }
                    } while (gender != 'M' && gender != 'F');

                    String contactNumber;
                    do {
                        System.out.print("Set your new contact number [Format(123-4567-8899)]: ");
                        contactNumber = input.nextLine();
                        if (!isValidContact(contactNumber)) {
                            System.out.println("Invalid contact number format. Please enter again.");
                        }
                    } while (!isValidContact(contactNumber));

                    admin.setadminName(adminName);
                    admin.setGender(gender);
                    admin.setContactNumber(contactNumber);

                    System.out.println("Admin information updated successfully!");
                    break;
                }
            }

            if (!found) {
                System.out.println("Admin ID was not found. Please enter again.\n");
            }

        } while (!found);
    }

    public static void deleteAdmin(ArrayList<Admin> adminz, Scanner input) {
        boolean found;

        do {
            System.out.print("\nEnter the Admin ID to delete: ");
            int adminID = input.nextInt();
            input.nextLine();

            found = false;
            for (Admin admin : adminz) {
                if (admin.getadminID() == adminID) {
                    adminz.remove(admin);
                    found = true;
                    System.out.println("Admin deleted successfully.");
                    break;
                }
            }

            if (!found) {
                System.out.println("No admin found with ID: " + adminID);
                System.out.println("Please enter again!");
            }

        } while (!found);
    }

    public static void displayAllAdmins(ArrayList<Admin> adminz) {
        System.out.println("╔════════════╦═════════════════════╦════════════╦══════════════════╗");
        System.out.printf("║ %-10s ║ %-19s ║ %-10s ║ %-16s ║%n", "ID", "Name", "Gender", "Contact");
        System.out.println("╠════════════╬═════════════════════╬════════════╬══════════════════╣");

        for (Admin a : adminz) {
            System.out.printf("║ %-10d ║ %-19s ║ %-10c ║ %-16s ║%n",
                    a.getadminID(), a.getadminName(), a.getGender(), a.getContactNumber());
        }

        System.out.println("╚════════════╩═════════════════════╩════════════╩══════════════════╝");
    }

    // MEMBER ROLE

    public static void addNewMember(ArrayList<Member> memberz, Scanner input) {
        int memberID;
        boolean valid=false;
  

        do {
            System.out.print("Create a unique Member ID[5 digit only]: ");
            try {
                memberID = input.nextInt();
                input.nextLine();

                valid = true;
                
                for (Member member : memberz) {
                    if (member.getMemberID() == memberID) {
                        System.out.println("This Member ID already exists. Please try again.");
                        valid = false;
                        break;
                    }
                }

                if (!valid) {
                    memberID = -1;
                }

            } catch (Exception e) {
                System.out.println("Invalid input. Please enter numbers only.");
                input.nextLine();
                memberID = -1;
            }
        } while (memberID <= 0);
    
        System.out.print("Enter name: ");
        String name = input.nextLine();

        char gender;
        do {
            System.out.print("Enter gender (M/F): ");
            gender = input.next().toUpperCase().charAt(0);
            input.nextLine();
            if (gender != 'M' && gender != 'F') {
                System.out.println("Please enter the correct gender! [Male(M)/Female(F)]");
            }
        } while (gender != 'M' && gender != 'F');

        String contact;
        do {
            System.out.print("Enter contact number [Format(123-4567-8899)]: ");
            contact = input.nextLine();
            if (!isValidContact(contact)) {
                System.out.println("Invalid contact number format. Please try again.");
            }
        } while (!isValidContact(contact));

        memberz.add(new Member(memberID, name, gender, contact));
        System.out.println("Member registered successfully.");
    }

    public static void updateMember(ArrayList<Member> memberz, Scanner input) {
        boolean found = false;

        do {
            System.out.print("Enter Member ID to update [Format(XXXXX)]: ");
            int memberID = input.nextInt();
            input.nextLine();

            for (Member member : memberz) {
                if (member.getMemberID() == memberID) {
                    found = true;

                    System.out.print("Set your new name: ");
                    String name = input.nextLine();

                    char gender;
                    do {
                        System.out.print("Set your new gender [Male(M)/Female(F)]: ");
                        gender = input.next().toUpperCase().charAt(0);
                        input.nextLine();
                        if (gender != 'M' && gender != 'F') {
                            System.out.println("Please enter the correct gender!");
                        }
                    } while (gender != 'M' && gender != 'F');

                    String contact;
                    do {
                        System.out.print("Set your new contact number [Format(123-4567-8899)]: ");
                        contact = input.nextLine();
                        if (!isValidContact(contact)) {
                            System.out.println("Invalid contact number format. Please enter again.");
                        }
                    } while (!isValidContact(contact));

                    member.setMemberName(name);
                    member.setGender(gender);
                    member.setContactNumber(contact);

                    System.out.println("Member information updated successfully!");
                    break;
                }
            }

            if (!found) {
                System.out.println("Member ID was not found. Please enter again.\n");
            }

        } while (!found);
    }

    public static void deleteMember(ArrayList<Member> memberz, Scanner input) {
        boolean found;

        do {
            System.out.print("Enter the Member ID to delete: ");
            int memberID = input.nextInt();
            input.nextLine();

            found = false;
            for (int i = 0; i < memberz.size(); i++) {
                if (memberz.get(i).getMemberID() == memberID) {
                    memberz.remove(i);
                    found = true;
                    System.out.println("Member deleted successfully.");
                    break;
                }
            }

            if (!found) {
                System.out.println("No member found with ID: " + memberID);
                System.out.println("Please enter again!");
            }

        } while (!found);
    }

    public static void displayAllMembers(ArrayList<Member> memberz) {
        System.out.println("╔════════════╦══════════════════════╦════════════╦══════════════════╗");
        System.out.printf("║ %-10s ║ %-20s ║ %-10s ║ %-16s ║%n", "ID", "Name", "Gender", "Contact");
        System.out.println("╠════════════╬══════════════════════╬════════════╬══════════════════╣");

        for (Member m : memberz) {
            System.out.printf("║ %-10d ║ %-20s ║ %-10c ║ %-16s ║%n",
                    m.getMemberID(), m.getMemberName(), m.getGender(), m.getContactNumber());
        }

        System.out.println("╚════════════╩══════════════════════╩════════════╩══════════════════╝");
 }
}