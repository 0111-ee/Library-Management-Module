package Alpha;

import java.util.ArrayList;
import java.util.Scanner;

public class FacilitiesManagement {

    private int facilityID;
    private String facilityName;
    private String facilityType;
    private String facilityAvailability;
    private String facilityPlaces;

    // Constructor
    public FacilitiesManagement(int facilityID, String facilityName, String facilityType, String facilityPlaces, String facilityAvailability) {
        this.facilityID = facilityID;
        this.facilityName = facilityName;
        this.facilityType = facilityType;
        this.facilityAvailability = facilityAvailability;
        this.facilityPlaces = facilityPlaces;
    }

    // Getters and Setters
    public int getFacilityID() {
        return facilityID;
    }

    public void setFacilityID(int facilityID) {
        this.facilityID = facilityID;
    }

    public String getFacilityName() {
        return facilityName;
    }

    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
    }

    public String getFacilityType() {
        return facilityType;
    }

    public void setFacilityType(String facilityType) {
        this.facilityType = facilityType;
    }

    public String getFacilityAvailability() {
        return facilityAvailability;
    }

    public void setFacilityAvailability(String facilityAvailability) {
        this.facilityAvailability = facilityAvailability;
    }

    public String getFacilityPlaces() {
        return facilityPlaces;
    }

    public void setFacilityPlaces(String facilityPlaces) {
        this.facilityPlaces = facilityPlaces;
    }

    // Static method to view facility list
    public static void viewFacilityList(ArrayList<FacilitiesManagement> facilityz) {
        System.out.println("+-------------+----------------------------+--------------------------+--------------------------+---------------+");
        System.out.println("| Facility ID | Facility Name              | Facility Type            | Places                   | Status        |");
        System.out.println("+-------------+----------------------------+--------------------------+--------------------------+---------------+");
        for (FacilitiesManagement facilities : facilityz) {
            System.out.printf("| %-11d | %-26s | %-24s | %-24s | %-13s |%n",
                    facilities.getFacilityID(), facilities.getFacilityName(), facilities.getFacilityType(),
                    facilities.getFacilityPlaces(), facilities.getFacilityAvailability());
        }

        System.out.println("+-------------+----------------------------+--------------------------+--------------------------+---------------+");
    }

    public void displayFacility() {
        System.out.println(
                "+-------------+----------------------------+--------------------------+--------------------------+---------------+");
        System.out.println(
                "| Facility ID | Facility Name              | Facility Type            | Places                   | Status        |");
        System.out.println(
                "+-------------+----------------------------+--------------------------+--------------------------+---------------+");
        System.out.printf("| %-11d | %-26s | %-24s | %-24s | %-13s |%n",
                facilityID, facilityName, facilityType, facilityPlaces, facilityAvailability);
        System.out.println(
                "+-------------+----------------------------+--------------------------+--------------------------+---------------+");
    }

    // addnew facility room
    public static void addFacility(ArrayList<FacilitiesManagement> facilityz, Scanner input) {
        int facilityID;

        do {
            viewFacilityList(facilityz);
            System.out.print("Create a unique ID [Format(5digits)]: ");
            try {
                facilityID = input.nextInt();
                input.nextLine();
                if (facilityID <= 0) {
                    System.out.println("Facility ID must be a positive integer. Please try again.");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Error input. Please enter a valid ID.");
                input.nextLine();
                facilityID = -1; // Force the loop to repeat
            }
        } while (facilityID <= 0); // Keep asking until a valid ID is entered

        System.out.print("Enter the facility name: ");
        String facilityName = input.nextLine();

        // Select facility type
        System.out.println("Select the type of facility:");
        System.out.println("1. Discussion Room");
        System.out.println("2. Presentation Room");
        System.out.println("3. Individual Study Room");
        System.out.println("4. Public Study Room");
        System.out.print("Enter your choice: ");
        int typeChoice = input.nextInt();
        input.nextLine();

        String facilityType = "";
        switch (typeChoice) {
            case 1:
                facilityType = "Discussion Room";
                break;
            case 2:
                facilityType = "Presentation Room";
                break;
            case 3:
                facilityType = "Individual Study Room";
                break;
            case 4:
                facilityType = "Public Study Room";
                break;
            default:
                System.out.println("Invalid choice, defaulting to 'Discussion Room'.");
                facilityType = "Discussion Room";
                break;
        }

        System.out.print("Enter the location of facility: ");
        String facilityPlaces = input.nextLine();

        System.out.print("Enter the facility status (Available/Booked): ");
        String facilityAvailability = input.nextLine();

        FacilitiesManagement newFacility;
        // Create the correct subclass of facility based on the user's selection
        switch (typeChoice) {
            case 1:
                newFacility = new DiscussionRoom(facilityID, facilityName, facilityPlaces, facilityAvailability);
                break;
            case 2:
                newFacility = new PresentationRoom(facilityID, facilityName, facilityPlaces, facilityAvailability);
                break;
            case 3:
                newFacility = new IndividualStudyRoom(facilityID, facilityName, facilityPlaces, facilityAvailability);
                break;
            case 4:
                newFacility = new PublicStudyRoom(facilityID, facilityName, facilityPlaces, facilityAvailability);
                break;
            default:
                newFacility = new DiscussionRoom(facilityID, facilityName, facilityPlaces, facilityAvailability);
        }

        newFacility.setFacilityType(facilityType);
        facilityz.add(newFacility);

        newFacility.displayFacility();
        System.out.println("Facility added successfully!");

    }

    // Method to update facility details
    public static void updateFacility(ArrayList<FacilitiesManagement> facilityz, Scanner input) {
        boolean found = false;
    
        do {
            System.out.print("Enter Facility ID to update [Format(5 digits)]: ");
            int facilityID = input.nextInt();
            input.nextLine();
    
            for (FacilitiesManagement facility : facilityz) {
                if (facility.getFacilityID() == facilityID) {
                    found = true;
    
                    System.out.print("Set the new facility name: ");
                    String facilityName = input.nextLine();
    
                    System.out.println("Select the type of facility:");
                    System.out.println("1. Discussion Room");
                    System.out.println("2. Presentation Room");
                    System.out.println("3. Individual Study Room");
                    System.out.println("4. Public Study Room");
                    System.out.print("Enter your choice: ");
                    int typeChoice = input.nextInt();
                    input.nextLine();
    
                    String facilityType;
                    switch (typeChoice) {
                        case 1:
                            facilityType = "Discussion Room";
                            break;
                        case 2:
                            facilityType = "Presentation Room";
                            break;
                        case 3:
                            facilityType = "Individual Study Room";
                            break;
                        case 4:
                            facilityType = "Public Study Room";
                            break;
                        default:
                            System.out.println("Invalid choice, defaulting to 'Discussion Room'.");
                            facilityType = "Discussion Room";
                    }
    
                    System.out.print("Change facility location to: ");
                    String facilityPlaces = input.nextLine();
    
                    System.out.print("Change facility status to (Available/Booked): ");
                    String facilityAvailability = input.nextLine();
    
                    facility.setFacilityName(facilityName);
                    facility.setFacilityType(facilityType);
                    facility.setFacilityPlaces(facilityPlaces);
                    facility.setFacilityAvailability(facilityAvailability);
    
                    System.out.println("Facility information updated successfully!");
                    return;
                }
            }
    
            if (!found) {
                System.out.println("Facility ID was not found. Please enter again.\n");
            }
    
        } while (!found);
    }
    
    public static void closeFacility(ArrayList<FacilitiesManagement> facilityz, Scanner input) {
        boolean found = false;
    
        do {
            int facilityID = -1;
    
            try {
                System.out.print("\nEnter the Facility ID to close [Format(5digits)]: ");
                facilityID = Integer.parseInt(input.nextLine()); 
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid numeric Facility ID [Format(5digits)].");
                continue; 
            }
                for (FacilitiesManagement facility : facilityz) {
                if (facility.getFacilityID() == facilityID) {
                    System.out.print("Are you sure to close this facility? (Y/N): ");
                    String confirm = input.nextLine();
    
                    if (confirm.equalsIgnoreCase("Y")) {
                        facilityz.remove(facility);
                        System.out.println("Facility closed Successfully.");
                    } else {
                        System.out.println("Closure cancelled.");
                    }
    
                    found = true;
                    break;
                }
            }
    
            if (!found) {
                System.out.println("No facility found with ID: " + facilityID);
                System.out.println("Please enter again!");
            }
    
        } while (!found);
    }
    
    }