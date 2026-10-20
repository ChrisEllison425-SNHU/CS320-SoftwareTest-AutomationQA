/*
 * Program: CS320 Project1
 * Author: Christopher Ellison
 * Date: Oct 7, 2026
 *
 * Description:
 * This class stores contact details
 */


package Main;

public class Contact {

    // Creating limits as static variables making it easier to edit if ever needed
    private static final int MAX_ID_LENGTH = 10;
    private static final int MAX_NAME_LENGTH = 10;
    private static final int MAX_ADDRESS_LENGTH = 30;

    private final String contactId;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    // Validate everything at start of Contact
    public Contact(String contactId, String firstName, String lastName,
                   String phone, String address) {

        checkLength(contactId, MAX_ID_LENGTH, "Contact ID");
        checkLength(firstName, MAX_NAME_LENGTH, "First name");
        checkLength(lastName, MAX_NAME_LENGTH, "Last name");
        checkPhone(phone);
        checkLength(address, MAX_ADDRESS_LENGTH, "Address");

        this.contactId = contactId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }

    public String getContactId() {
        return contactId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    // Validate before changing the first name
    public void setFirstName(String firstName) {

        checkLength(firstName, MAX_NAME_LENGTH, "First name");
        this.firstName = firstName;
    }

    // Validate before changing the last name
    public void setLastName(String lastName) {

        checkLength(lastName, MAX_NAME_LENGTH, "Last name");
        this.lastName = lastName;
    }

    // Validate before changing the phone number
    public void setPhone(String phone) {

        checkPhone(phone);
        this.phone = phone;
    }

    // Validate before changing the address
    public void setAddress(String address) {

        checkLength(address, MAX_ADDRESS_LENGTH, "Address");
        this.address = address;
    }

    // Keep length validation in one place
    private static void checkLength(String value, int maxLength, String fieldName) {

        if (value == null || value.length() > maxLength) {
            throw new IllegalArgumentException(
                    fieldName + " cannot be null or exceed "
                            + maxLength + " characters"
            );
        }
    }

    // Keep phone validation in one place
    private static void checkPhone(String phone) {

        if (phone == null || !phone.matches("\\d{10}")) {
            throw new IllegalArgumentException(
                    "Phone must be exactly 10 digits"
            );
        }
    }
}