/*
 * Program: CS320 Project1
 * Author: Christopher Ellison
 * Date: Oct 7, 2026
 *
 * Description:
 * This class test ContactService class
 */


package baseTest;

import Main.Contact;
import Main.ContactService;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactServiceTest {

    @Test
    void testValidContactCanBeAdded() {
        // Create a contact using valid values
        Contact contact = new Contact(
                "56479",
                "Zeus",
                "Fieldson",
                "4253613084",
                "113 Brigantine Rd"
        );

        ContactService service = new ContactService();
        service.addContact(contact);

        // Check that the contact can be retrieved
        assertEquals(contact, service.getContact("56479"));
    }

    @Test
    void testDuplicateContactIdCannotBeAdded() {
        // Create two contacts using the same ID
        Contact contact1 = new Contact(
                "56479",
                "Zeus",
                "Fieldson",
                "4253613084",
                "113 Brigantine Rd"
        );

        Contact contact2 = new Contact(
                "56479",
                "Michael",
                "Ellison",
                "7079800713",
                "816 This Place"
        );

        ContactService service = new ContactService();
        service.addContact(contact1);

        // Check that a duplicate ID is not allowed
        assertThrows(
                IllegalArgumentException.class,
                () -> service.addContact(contact2)
        );
    }

    @Test
    void testContactCanBeDeleted() {
        // Create and add a contact
        Contact contact = new Contact(
                "56479",
                "Zeus",
                "Fieldson",
                "4253613084",
                "113 Brigantine Rd"
        );

        ContactService service = new ContactService();
        service.addContact(contact);

        // Delete the contact
        service.deleteContact("56479");

        // Check that the deleted contact cannot be found
        assertThrows(
                IllegalArgumentException.class,
                () -> service.getContact("56479")
        );
    }

    @Test
    void testFirstNameCanBeUpdated() {
        // Create and add a contact
        Contact contact = new Contact(
                "56479",
                "Zeus",
                "Fieldson",
                "4253613084",
                "113 Brigantine Rd"
        );

        ContactService service = new ContactService();
        service.addContact(contact);

        // Update the first name
        service.updateFirstName("56479", "Michael");

        // Check that the first name was updated
        assertEquals("Michael", contact.getFirstName());
    }

    @Test
    void testLastNameCanBeUpdated() {
        // Create and add a contact
        Contact contact = new Contact(
                "56479",
                "Zeus",
                "Fieldson",
                "4253613084",
                "113 Brigantine Rd"
        );

        ContactService service = new ContactService();
        service.addContact(contact);

        // Update the last name
        service.updateLastName("56479", "Ellison");

        // Check that the last name was updated
        assertEquals("Ellison", contact.getLastName());
    }

    @Test
    void testPhoneCanBeUpdated() {
        // Create and add a contact
        Contact contact = new Contact(
                "56479",
                "Zeus",
                "Fieldson",
                "4253613084",
                "113 Brigantine Rd"
        );

        ContactService service = new ContactService();
        service.addContact(contact);

        // Update the phone number
        service.updatePhone("56479", "7079800713");

        // Check that the phone number was updated
        assertEquals("7079800713", contact.getPhone());
    }

    @Test
    void testAddressCanBeUpdated() {
        // Create and add a contact
        Contact contact = new Contact(
                "56479",
                "Zeus",
                "Fieldson",
                "4253613084",
                "113 Brigantine Rd"
        );

        ContactService service = new ContactService();
        service.addContact(contact);

        // Update the address
        service.updateAddress("56479", "816 This Place");

        // Check that the address was updated
        assertEquals("816 This Place", contact.getAddress());
    }

    @Test
    void testCannotUpdateNonexistentContact() {
        // Create a service without adding a contact
        ContactService service = new ContactService();

        // Check that updating a missing contact is not allowed
        assertThrows(
                IllegalArgumentException.class,
                () -> service.updateFirstName("99999", "Michael")
        );
    }

    @Test
    void testCannotDeleteNonexistentContact() {
        // Create a service without adding a contact
        ContactService service = new ContactService();

        // Check that deleting a missing contact is not allowed
        assertThrows(
                IllegalArgumentException.class,
                () -> service.deleteContact("99999")
        );
    }

    @Test
    void testCannotGetNonexistentContact() {
        // Create a service without adding a contact
        ContactService service = new ContactService();

        // Check that retrieving a missing contact is not allowed
        assertThrows(
                IllegalArgumentException.class,
                () -> service.getContact("99999")
        );
    }
}
