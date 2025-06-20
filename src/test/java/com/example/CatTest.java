package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class CatTest {

    @Mock
    Feline feline;

    @Test
    public void getSound_shouldReturnMeow() {
        Cat cat = new Cat(null);
        String result = cat.getSound();
        assertEquals("Мяу", result);
    }

    @Test
    public void getFood_shouldReturnCorrectFoodList() throws Exception {
        Mockito.when(feline.eatMeat()).thenReturn(List.of("Мясо", "Рыба"));
        Cat cat = new Cat(feline);
        List<String> actual = cat.getFood();
        List<String> expected = List.of("Мясо", "Рыба");
        assertEquals(expected, actual);
    }
}