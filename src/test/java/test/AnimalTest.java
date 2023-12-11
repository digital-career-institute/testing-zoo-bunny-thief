package test;

import main.Animal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AnimalTest {
    Animal animal;

    @BeforeEach
    void init() {
        animal = new Animal("Lion");
    }

    @Test
    void animalIsNotNullTest() {
        assertNotNull(animal);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Lion", "Elephant", "Zebra"})
    void animalNameTest(String name) {
        String expected = name;
        String actual = new Animal(name).getName();
        assertEquals(expected, actual);
    }

}