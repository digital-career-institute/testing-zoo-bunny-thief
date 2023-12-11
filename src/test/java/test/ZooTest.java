package test;

import main.Animal;
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

    @Test
    void addAnimalTest() {
        boolean expected = true;
        zoo.add(new Animal("Lion"));
        boolean actual = zoo.zooIsEmpty();
        assertNotEquals(expected, actual);
    }

    @Test
    void listAnimalsOneAnimalTest() {
        String expected = "Bear";
        zoo.add(new Animal("Bear"));
        String actual = zoo.listAnimals();
        assertEquals(expected, actual);
    }

    @Test
    void listAnimalsTwoAnimalsTest() {
        String expected = "Bear, Monkey";
        zoo.add(new Animal("Bear"));
        zoo.add(new Animal("Monkey"));
        String actual = zoo.listAnimals();
        assertEquals(expected, actual);
    }

    @Test
    void addThreeAnimalsTest() {
        boolean expected = true;
        Zoo zoo = new Zoo(3);
        zoo.add(new Animal("Bear"));
        zoo.add(new Animal("Monkey"));
        boolean actual = zoo.add(new Animal("Tiger"));
        assertEquals(expected, actual);
    }

    @Test
    void stopAddingAnimalsTest() {
        boolean expected = false;
        Zoo zoo = new Zoo(3);
        zoo.add(new Animal("Bear"));
        zoo.add(new Animal("Monkey"));
        zoo.add(new Animal("Tiger"));
        boolean actual = zoo.add(new Animal("Zebra"));
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({"0, The zoo has 3 free spaces!",
            "1, The zoo has 2 free spaces!",
            "2, The zoo has 1 free spaces!",
            "3, The zoo is full!",
            "4, The zoo is full!"})
    void checkFreeSpaceTest(int numberOfAnimals, String message) {
        zoo = new Zoo(3);
        for (int i = 0; i < numberOfAnimals; i++) {
            zoo.add(new Animal("animal" + i));
        }
        String expected = message;
        String actual = zoo.checkFreeSpace();
        assertEquals(expected, actual);
    }

}
