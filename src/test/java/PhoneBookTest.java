import org.example.PhoneBook;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
