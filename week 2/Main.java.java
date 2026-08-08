import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Contact {
    String name;
    String phone;
    String email;

    Contact(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    void display() {
        System.out.println("Name  : " + name);
        System.out.println("Phone : " + phone);
        System.out.println("Email : " + email);
        System.out.println("---------------------------");
    }
}

public class ContactManagementSystem {

    // HashMap: Contact ID -> Contact
    static HashMap<Integer, Contact> contacts = new HashMap<>();
    static Scanner sc = new Scanner(System.in);

    static int contactId = 1;

    // Insert Contact
    static void insertContact() {

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Phone: ");
        String phone = sc.nextLine();

        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        Contact contact = new Contact(name, phone, email);

        contacts.put(contactId, contact);

        System.out.println("Contact inserted successfully!");
        System.out.println("Contact ID: " + contactId);

        contactId++;
    }

    // Display All Contacts
    static void displayContacts() {

        if (contacts.isEmpty()) {
            System.out.println("No contacts available.");
            return;
        }

        System.out.println("\n===== Contact List =====");

        for (Map.Entry<Integer, Contact> entry : contacts.entrySet()) {

            System.out.println("Contact ID: " + entry.getKey());

            Contact contact = entry.getValue();
            contact.display();
        }
    }

    // Search Contact by ID
    static void searchContact() {

        System.out.print("Enter Contact ID to search: ");
        int id = sc.nextInt();
        sc.nextLine();

        if (contacts.containsKey(id)) {

            System.out.println("\nContact Found:");

            Contact contact = contacts.get(id);
            contact.display();

        } else {
            System.out.println("Contact not found.");
        }
    }

    // Search Contact by Name
    static void searchByName() {

        System.out.print("Enter Name to search: ");
        String searchName = sc.nextLine();

        boolean found = false;

        for (Map.Entry<Integer, Contact> entry : contacts.entrySet()) {

            Contact contact = entry.getValue();

            if (contact.name.equalsIgnoreCase(searchName)) {

                System.out.println("\nContact Found:");
                System.out.println("Contact ID: " + entry.getKey());

                contact.display();

                found = true;
            }
        }

        if (!found) {
            System.out.println("Contact not found.");
        }
    }

    // Update Contact
    static void updateContact() {

        System.out.print("Enter Contact ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();

        if (!contacts.containsKey(id)) {
            System.out.println("Invalid Contact ID.");
            return;
        }

        Contact contact = contacts.get(id);

        System.out.print("Enter New Name: ");
        contact.name = sc.nextLine();

        System.out.print("Enter New Phone: ");
        contact.phone = sc.nextLine();

        System.out.print("Enter New Email: ");
        contact.email = sc.nextLine();

        // Update the HashMap
        contacts.put(id, contact);

        System.out.println("Contact updated successfully!");
    }

    // Delete Contact
    static void deleteContact() {

        System.out.print("Enter Contact ID to delete: ");
        int id = sc.nextInt();
        sc.nextLine();

        if (contacts.containsKey(id)) {

            contacts.remove(id);

            System.out.println("Contact deleted successfully!");

        } else {
            System.out.println("Invalid Contact ID.");
        }
    }

    // Main Method
    public static void main(String[] args) {

        int choice;

        do {

            System.out.println("\n==============================");
            System.out.println("   CONTACT MANAGEMENT SYSTEM");
            System.out.println("==============================");

            System.out.println("1. Insert Contact");
            System.out.println("2. Display Contacts");
            System.out.println("3. Search Contact by ID");
            System.out.println("4. Search Contact by Name");
            System.out.println("5. Update Contact");
            System.out.println("6. Delete Contact");
            System.out.println("7. Exit");

            System.out.println("==============================");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    insertContact();
                    break;

                case 2:
                    displayContacts();
                    break;

                case 3:
                    searchContact();
                    break;

                case 4:
                    searchByName();
                    break;

                case 5:
                    updateContact();
                    break;

                case 6:
                    deleteContact();
                    break;

                case 7:
                    System.out.println(
                        "Thank you for using Contact Management System!"
                    );
                    break;

                default:
                    System.out.println(
                        "Invalid choice! Please try again."
                    );
            }

        } while (choice != 7);

        sc.close();
    }
}
