package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FelineGetKittensParameterizedTest {

    private final int input;
    private final int expected;

    public FelineGetKittensParameterizedTest(int input, int expected) {
        this.input = input;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getKittensData() {
        return new Object[][] {
                {1, 1},
                {3, 3},
                {0, 0},
                {-5, -5}
        };
    }

    @Test
    public void testGetKittensWithParameter() {
        Feline feline = new Feline();
        assertEquals(expected, feline.getKittens(input));
    }
}
