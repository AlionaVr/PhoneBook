import org.example.PhoneBook;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PhoneBookTest {

    @Test
    void whenAddContactReturnCorrectCountOfContacts() {
        //arrange
        PhoneBook phoneBook = new PhoneBook();
        int expectedContactCount = 1;
        //act
        int actualContactCount = phoneBook.add("Aliona", "+375(33)862-31-55");
        //assert
        assertEquals(expectedContactCount, actualContactCount);
    }

    @Test
    void whenAddDuplicatedContactReturnUnchangedCountOfContacts() {
        //arrange
        PhoneBook phoneBook = new PhoneBook();
        int expectedContactCount = 1;
        //act
        phoneBook.add("Aliona", "+375(33)862-31-55");
        int actualContactCount = phoneBook.add("Aliona", "+375(33)862-31-55");
        //assert
        assertEquals(expectedContactCount, actualContactCount);
    }

    @Test
    void whenFindByNumberReturnCorrectNameOfContact() {
        //arrange
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Aliona", "+375(33)862-31-55");
        phoneBook.add("Boris", "+375(33)862-31-56");
        //act
        String actualName = phoneBook.findByNumber("+375(33)862-31-56");
        //assert
        assertEquals("Boris", actualName);
    }
}
