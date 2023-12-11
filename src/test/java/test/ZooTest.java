package test;

import main.Zoo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class ZooTest {
    Zoo zoo;

    @BeforeEach
    void init() {
        zoo = new Zoo(5);
    }

    @Test
    void zooIsNotNullTest() {
        assertNotNull(zoo);
    }

    @Test
    void animalListIsInitiallyEmptyTest() {
        assertTrue(zoo.zooIsEmpty());
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 5, 10})
    void zooSizeTest(int arguments) {
        int expected = arguments;
        int actual = new Zoo(arguments).getZooSize();
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 1, 4, 6, 10})
    void zooIsCorrectSizeTest(int arguments) {
        int expected = arguments;
        int actual = new Zoo(5).getZooSize();
        assertNotEquals(expected, actual);
    }

}
