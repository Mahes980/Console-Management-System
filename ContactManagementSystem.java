import java.util.LinkedHashMap;
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

    @Override
    public String toString() {
        return "Name: " + name +
               ", Phone: " + phone +
               ", Email: " + email;
    }
}

public class ContactManagementSystem {

    static LinkedHashMap<Integer, Contact> contacts =
            new LinkedHashMap<>();

    static Scanner sc = new Scanner(System.in);

    // Insert Contact
    static void insertContact() {
        System.out.print("Enter Contact ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        if (contacts.containsKey(id)) {
            System.out.println("Contact ID already exists!");
            return;
        }

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Phone Number: ");
        String phone = sc.nextLine();

        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        contacts.put(id, new Contact(name, phone, email));

        System.out.println("Contact inserted successfully!");
    }

    // Delete Contact
    static void deleteContact() {
        System.out.print("Enter Contact ID to delete: ");
        int id = sc.nextInt();

        if (contacts.remove(id) != null) {
            System.out.println("Contact deleted successfully!");
        } else {
            System.out.println("Contact not found!");
        }
    }

    // Update Contact
    static void updateContact() {
        System.out.print("Enter Contact ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();

        Contact contact = contacts.get(id);

        if (contact == null) {
            System.out.println("Contact not found!");
            return;
        }

        System.out.print("Enter New Name: ");
        contact.name = sc.nextLine();

        System.out.print("Enter New Phone Number: ");
        contact.phone = sc.nextLine();

        System.out.print("Enter New Email: ");
        contact.email = sc.nextLine();

        System.out.println("Contact updated successfully!");
    }

    // Search Contact
    static void searchContact() {
        System.out.print("Enter Contact ID to search: ");
        int id = sc.nextInt();

        Contact contact = contacts.get(id);

        if (contact != null) {
            System.out.println("\nContact Found:");
            System.out.println(contact);
        } else {
            System.out.println("Contact not found!");
        }
    }

    // Display Contacts
    static void displayContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts available!");
            return;
        }

        System.out.println("\n===== ALL CONTACTS =====");

        for (Map.Entry<Integer, Contact> entry : contacts.entrySet()) {
            System.out.println("ID: " + entry.getKey());
            System.out.println(entry.getValue());
            System.out.println("-------------------------");
        }
    }

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== CONTACT MANAGEMENT SYSTEM =====");
            System.out.println("1. Insert Contact");
            System.out.println("2. Delete Contact");
            System.out.println("3. Update Contact");
            System.out.println("4. Search Contact");
            System.out.println("5. Display All Contacts");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    insertContact();
                    break;

                case 2:
                    deleteContact();
                    break;

                case 3:
                    updateContact();
                    break;

                case 4:
                    searchContact();
                    break;

                case 5:
                    displayContacts();
                    break;

                case 6:
                    System.out.println("Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 6);

        sc.close();
    }
}
