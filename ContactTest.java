/*
 * Program: CS320 Project1
 * Author: Christopher Ellison
 * Date: Oct 7, 2026
 *
 * Description:
 * This class test Contact class
 */


package baseTest;

import Main.Contact;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactTest {

    @Test
    void testValidContactCreation() {
        // Create a contact using valid values
        Contact contact = new Contact(
                "92745",
                "Lulu",
                "Fields",
                "4255635122",
                "1548 103rd pl sw"
        );

        // Check that all the values were stored correctly
        assertEquals("92745", contact.getContactId());
        assertEquals("Lulu", contact.getFirstName());
        assertEquals("Fields", contact.getLastName());
        assertEquals("4255635122", contact.getPhone());
        assertEquals("1548 103rd pl sw", contact.getAddress());
    }

    @Test
    void testContactIdCannotBeNull() {
        // Check that a null ID is not allowed
        assertThrows(
                IllegalArgumentException.class,
                () -> new Contact(
                        null,
                        "Lulu",
                        "Fields",
                        "4255635122",
                        "1548 103rd pl sw"
                )
        );
    }

    @Test
    void testContactIdCannotBeLongerThan10Characters() {
        // Check that the ID cannot be too long
        assertThrows(
                IllegalArgumentException.class,
                () -> new Contact(
                        "92745678901",
                        "Lulu",
                        "Fields",
                        "4255635122",
                        "1548 103rd pl sw"
                )
        );
    }

    @Test
    void testFirstNameCannotBeNull() {
        // Check that a null first name is not allowed
        assertThrows(
                IllegalArgumentException.class,
                () -> new Contact(
                        "92745",
                        null,
                        "Fields",
                        "4255635122",
                        "1548 103rd pl sw"
                )
        );
    }

    @Test
    void testFirstNameCannotBeLongerThan10Characters() {
        // Check that the first name cannot be too long
        assertThrows(
                IllegalArgumentException.class,
                () -> new Contact(
                        "92745",
                        "LuluBooBooo",
                        "Fields",
                        "4255635122",
                        "1548 103rd pl sw"
                )
        );
    }

    @Test
    void testLastNameCannotBeNull() {
        // Check that a null last name is not allowed
        assertThrows(
                IllegalArgumentException.class,
                () -> new Contact(
                        "92745",
                        "Lulu",
                        null,
                        "4255635122",
                        "1548 103rd pl sw"
                )
        );
    }

    @Test
    void testLastNameCannotBeLongerThan10Characters() {
        // Check that the last name cannot be too long
        assertThrows(
                IllegalArgumentException.class,
                () -> new Contact(
                        "92745",
                        "Lulu",
                        "Foreverbaby",
                        "4255635122",
                        "1548 103rd pl sw"
                )
        );
    }

    @Test
    void testPhoneCannotBeNull() {
        // Check that a null phone number is not allowed
        assertThrows(
                IllegalArgumentException.class,
                () -> new Contact(
                        "92745",
                        "Lulu",
                        "Fields",
                        null,
                        "1548 103rd pl sw"
                )
        );
    }

    @Test
    void testPhoneMustBeExactly10Digits() {
        // Check that the phone number must contain exactly 10 digits
        assertThrows(
                IllegalArgumentException.class,
                () -> new Contact(
                        "92745",
                        "Lulu",
                        "Fields",
                        "5635122",
                        "1548 103rd pl sw"
                )
        );
    }

    @Test
    void testPhoneCannotContainLetters() {
        // Check that the phone number cannot contain letters
        assertThrows(
                IllegalArgumentException.class,
                () -> new Contact(
                        "92745",
                        "Lulu",
                        "Fields",
                        "4255635ABC",
                        "1548 103rd pl sw"
                )
        );
    }

    @Test
    void testAddressCannotBeNull() {
        // Check that a null address is not allowed
        assertThrows(
                IllegalArgumentException.class,
                () -> new Contact(
                        "92745",
                        "Lulu",
                        "Fields",
                        "4255635122",
                        null
                )
        );
    }

    @Test
    void testAddressCannotBeLongerThan30Characters() {
        // Check that the address cannot be too long
        assertThrows(
                IllegalArgumentException.class,
                () -> new Contact(
                        "92745",
                        "Lulu",
                        "Fields",
                        "4255635122",
                        "This is the address that never ends going on and on"
                )
        );
    }

    @Test
    void testContactIdCannotBeUpdated() {
        // Create a contact with an ID that should remain unchanged
        Contact contact = new Contact(
                "92745",
                "Lulu",
                "Fields",
                "4255635122",
                "1548 103rd pl sw"
        );

        // There is no way to change the ID after the contact is created
        assertEquals("92745", contact.getContactId());
    }

    @Test
    void testFirstNameCanBeUpdated() {
        // Create a contact with a first name
        Contact contact = new Contact(
                "92745",
                "Lulu",
                "Fields",
                "4255635122",
                "1548 103rd pl sw"
        );

        // Update the first name
        contact.setFirstName("Kathy");

        // Check that the first name was updated correctly
        assertEquals("Kathy", contact.getFirstName());
    }

    @Test
    void testLastNameCanBeUpdated() {
        // Create a contact with a last name
        Contact contact = new Contact(
                "92745",
                "Lulu",
                "Fields",
                "4255635122",
                "1548 103rd pl sw"
        );

        // Update the last name
        contact.setLastName("Flashy");

        // Check that the last name was updated correctly
        assertEquals("Flashy", contact.getLastName());
    }

    @Test
    void testPhoneCanBeUpdated() {
        // Create a contact with a phone number
        Contact contact = new Contact(
                "92745",
                "Lulu",
                "Fields",
                "4255635122",
                "1548 103rd pl sw"
        );

        // Update the phone number
        contact.setPhone("7075579920");

        // Check that the phone number was updated correctly
        assertEquals("7075579920", contact.getPhone());
    }

    @Test
    void testAddressCanBeUpdated() {
        // Create a contact with an address
        Contact contact = new Contact(
                "92745",
                "Lulu",
                "Fields",
                "4255635122",
                "1548 103rd pl sw"
        );

        // Update the address
        contact.setAddress("1522 Canyon Park Rd");

        // Check that the address was updated correctly
        assertEquals("1522 Canyon Park Rd", contact.getAddress());
    }
}
