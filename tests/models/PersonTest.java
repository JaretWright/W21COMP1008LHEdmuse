package models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    private Person person;

    @BeforeEach
    void setUp() {
        person = new Person("Fred","Flintstone","1 Bedrock Lane, Bedrock", LocalDate.of(1974,3,24));
    }

    @Test
    void setFirstname() {
        person.setFirstName("Alfred");
        assertEquals("Alfred",person.getFirstName());
    }

    @Test
    void setFirstNameInvalid(){
        assertThrows(IllegalArgumentException.class, () ->
                person.setFirstName(""));
    }

    @Test
    void setLastName() {
    }

    @Test
    void setAddress() {
    }

    @Test
    void setBirthday() {
    }

    @Test
    void getAge() {
        assertEquals(47, person.getAge());
    }
}