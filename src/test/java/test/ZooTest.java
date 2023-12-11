package test;

import main.Zoo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

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

}