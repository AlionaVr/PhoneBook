import org.example.PhoneBook;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PhoneBookTest {
    PhoneBook phoneBook;

    @BeforeEach
    void setUp() {
        phoneBook = new PhoneBook();
    }

    @Test
    void whenAddContactReturnCorrectCountOfContacts() {
        //arrange
        int expectedContactCount = 1;
        //act
        int actualContactCount = phoneBook.add("Aliona", "+375(33)862-31-55");
        //assert
        assertEquals(expectedContactCount, actualContactCount);
    }

    @Test
    void whenNameIsMissingRejectContactWithoutReservingNumber() {
        phoneBook.add("Aliona", "123");
        for (String name : Arrays.asList(null, "", " ", "\t", "\n")) {
            assertThrows(IllegalArgumentException.class, () -> phoneBook.add(name, "456"));
            assertNull(phoneBook.findByNumber("456"));
            assertEquals("123", phoneBook.findByName("Aliona"));
        }
        assertEquals(2, phoneBook.add("Boris", "456"));
    }

    @Test
    void whenNumberIsMissingRejectContactWithoutReservingName() {
        phoneBook.add("Aliona", "123");
        for (String number : Arrays.asList(null, "", " ", "\t", "\n")) {
            assertThrows(IllegalArgumentException.class, () -> phoneBook.add("Boris", number));
            assertNull(phoneBook.findByName("Boris"));
            assertEquals("Aliona", phoneBook.findByNumber("123"));
        }
        assertEquals(2, phoneBook.add("Boris", "456"));
    }

    @Test
    void whenAddDuplicatedContactReturnUnchangedCountOfContacts() {
        //arrange
        int expectedContactCount = 1;
        //act
        phoneBook.add("Aliona", "+375(33)862-31-55");
        phoneBook.add("Aliona", "+375(33)862-31-56");
        int actualContactCount = phoneBook.add("Boris", "+375(33)862-31-55");
        //assert
        assertEquals(expectedContactCount, actualContactCount);
    }

    @Test
    void whenFindByNumberReturnCorrectNameOfContact() {
        //arrange
        phoneBook.add("Aliona", "+375(33)862-31-55");
        phoneBook.add("Boris", "+375(33)862-31-56");
        //act
        String actualName = phoneBook.findByNumber("+375(33)862-31-56");
        //assert
        assertEquals("Boris", actualName);
    }

    @Test
    void whenFindByNameReturnCorrectNumber() {
        //arrange
        phoneBook.add("Aliona", "+375(33)862-31-55");
        phoneBook.add("Boris", "+375(33)862-31-56");
        //act
        String actualName = phoneBook.findByName("Boris");
        //assert
        assertEquals("+375(33)862-31-56", actualName);
    }

    @Test
    void whenPrintAllNamesShouldPrintNamesAlphabetically() {
        //arrange
        phoneBook.add("Aliona", "+375(33)862-31-55");
        phoneBook.add("Alice", "+375(33)862-31-56");
        phoneBook.add("Bob", "+375(33)862-31-45");

        List<String> expectedNames = Arrays.asList("Alice", "Aliona", "Bob");
        //act
        List<String> names = phoneBook.printAllNames();
        //assert
        assertEquals(3, names.size());
        assertEquals(expectedNames, names);
    }
}
