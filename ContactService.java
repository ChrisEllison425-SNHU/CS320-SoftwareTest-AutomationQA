/*
 * Program: CS320 Project1
 * Author: Christopher Ellison
 * Date: Oct 7, 2026
 *
 * Description:
 * This class manages contacts
 */


package Main;

import java.util.HashMap;
import java.util.Map;

public class ContactService {

    // Keep track of contacts using their unique ID
    private final Map<String, Contact> contacts = new HashMap<>();

    // Check that the contact is valid before adding it
    public void addContact(Contact contact) {

        if (contact == null) {
            throw new IllegalArgumentException(
                    "No NULL Contacts"
            );
        }

        // Make sure the contact ID is not already being used
        if (contacts.containsKey(contact.getContactId())) {
            throw new IllegalArgumentException(
                    "This contact ID already exists"
            );
        }

        contacts.put(contact.getContactId(), contact);
    }

    // Make sure the contact exists before deleting it
    public void deleteContact(String contactId) {

        if (contactId == null || !contacts.containsKey(contactId)) {
            throw new IllegalArgumentException(
                    "The specified contact ID is invalid"
            );
        }

        contacts.remove(contactId);
    }

    // Find the contact before changing its first name
    public void updateFirstName(String contactId, String firstName) {

        Contact contact = getContact(contactId);
        contact.setFirstName(firstName);
    }

    // Find the contact before changing its last name
    public void updateLastName(String contactId, String lastName) {

        Contact contact = getContact(contactId);
        contact.setLastName(lastName);
    }

    // Find the contact before changing its phone number
    public void updatePhone(String contactId, String phone) {

        Contact contact = getContact(contactId);
        contact.setPhone(phone);
    }

    // Find the contact before changing its address
    public void updateAddress(String contactId, String address) {

        Contact contact = getContact(contactId);
        contact.setAddress(address);
    }

    // Make sure the contact exists before returning it
    public Contact getContact(String contactId) {

        if (contactId == null || !contacts.containsKey(contactId)) {
            throw new IllegalArgumentException(
                    "This contact ID is not valid"
            );
        }

        return contacts.get(contactId);
    }
}