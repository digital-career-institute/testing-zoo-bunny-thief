package test;

import main.Animal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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

}