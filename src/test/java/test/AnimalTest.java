package test;

import main.Animal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

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

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"", " ", "\t", "\n", "Tiger", "lion"})
    void animalNameIsValidTest(String argument) {
        String expected = "Lion";
        String actual = new Animal(argument).getName();
        assertNotEquals(expected, actual);
    }

}