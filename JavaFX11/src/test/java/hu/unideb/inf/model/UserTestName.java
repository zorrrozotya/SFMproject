package hu.unideb.inf.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;

class UserTestName {
    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void checkNameTestIfUsernameIsInvalid() {
    boolean expected =true;
    boolean temp2=User.checkName("Tomaa(sd");
    Assertions.assertEquals(expected,temp2);
    }
    @Test
    void checkNameTestIfUsernameIsValid() {
        boolean expected =false;
        boolean temp2=User.checkName("Tomaasd");
        Assertions.assertEquals(expected,temp2);
    }
    @Test
    void checkPasswordIsValid() {
        boolean expected =false;
        boolean temp2=User.checkPassword("12345678");
        Assertions.assertEquals(expected,temp2);
    }

    @Test
    void checkPasswordIsInvalid() {
        boolean expected =true;
        boolean temp2=User.checkPassword("1234");
        Assertions.assertEquals(expected,temp2);
    }
    @Test
    void CheckScreenTimeHourTest(){
        int expected=5;
        int hour=4;
        int min=60;
        Assertions.assertEquals(expected,Movies.calculateScreenTimeHour(hour,min));
    }
    @Test
    void CheckScreenTimeMinutesTest(){
        int expected=30;
        int hour=0;
        int minutes=90;
        Assertions.assertEquals(expected,Movies.calculateScreenTimeMin(hour,minutes));
    }

    }
