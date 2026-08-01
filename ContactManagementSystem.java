import java.util.ArrayList;
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

    static ArrayList<Contact> contacts = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    // Insert Contact
    static void insertContact() {
        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Phone: ");
        String phone = sc.nextLine();

        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        Contact contact = new Contact(name, phone, email);
        contacts.add(contact);

        System.out.println("Contact inserted successfully!");
    }

    // Display All Contacts
    static void displayContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts available.");
            return;
        }

        System.out.println("\n===== Contact List =====");

        for (int i = 0; i < contacts.size(); i++) {
            System.out.println("Contact ID: " + (i + 1));
            contacts.get(i).display();
        }
    }

    // Search Contact
    static void searchContact() {
        System.out.print("Enter name to search: ");
        String searchName = sc.nextLine();

        boolean found = false;

        for (Contact contact : contacts) {
            if (contact.name.equalsIgnoreCase(searchName)) {
                System.out.println("\nContact Found:");
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

        if (id < 1 || id > contacts.size()) {
            System.out.println("Invalid Contact ID.");
            return;
        }

        Contact contact = contacts.get(id - 1);

        System.out.print("Enter New Name: ");
        contact.name = sc.nextLine();

        System.out.print("Enter New Phone: ");
        contact.phone = sc.nextLine();

        System.out.print("Enter New Email: ");
        contact.email = sc.nextLine();

        System.out.println("Contact updated successfully!");
    }

    // Delete Contact
    static void deleteContact() {
        System.out.print("Enter Contact ID to delete: ");
        int id = sc.nextInt();
        sc.nextLine();

        if (id < 1 || id > contacts.size()) {
            System.out.println("Invalid Contact ID.");
            return;
        }

        contacts.remove(id - 1);

        System.out.println("Contact deleted successfully!");
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
            System.out.println("3. Search Contact");
            System.out.println("4. Update Contact");
            System.out.println("5. Delete Contact");
            System.out.println("6. Exit");
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
                    updateContact();
                    break;

                case 5:
                    deleteContact();
                    break;

                case 6:
                    System.out.println("Thank you for using Contact Management System!");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }

        } while (choice != 6);

        sc.close();
    }
}