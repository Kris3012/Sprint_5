package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
    public class LionTest {
        @Mock
        Feline feline;

        @Test
        public void ifLionBoyReturnTrue() throws Exception {
            Lion lion = new Lion("Самец", feline);
            assertTrue(lion.doesHaveMane());
        }

        @Test
        public void ifLionGirlReturnFalse() throws Exception {
            Lion lion = new Lion("Самка", feline);
            assertFalse(lion.doesHaveMane());
        }

        @Test
        public void ifLionUnknownSexReturnException(){
            Exception exception = assertThrows(Exception.class, () -> new Lion ("Неизвестно", feline));
            assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
        }

        @Test
        public void getKittensExpectReturnSomeValue() throws Exception {
            Mockito.when(feline.getKittens()).thenReturn(3);
            Lion lion = new Lion("Самец", feline);
            int expected = 3;
            int actual = lion.getKittens();
            assertEquals(expected, actual);
        }

        @Test
        public void getFoodReturnsExpectedFoodList() throws Exception{
            List<String> expected = List.of("Мясо", "Курица");
            Mockito.when(feline.getFood("Хищник")).thenReturn(expected);
            Lion lion = new Lion("Самец", feline);
            List<String> actual = lion.getFood();
            assertEquals(expected, actual);
            }

        }