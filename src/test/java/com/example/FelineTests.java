package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class FelineTests {

    @Mock
    private Animal animal;

    @InjectMocks
    private Feline feline;

    @Test
    public void eatMeatShouldReturnPredatorFood() throws Exception {

        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        when(animal.getFood("Хищник")).thenReturn(expectedFood);

        List<String> actualFood = feline.eatMeat();


        assertEquals("Метод должен возвращать пищу для хищников",
                expectedFood, actualFood);
        verify(animal).getFood("Хищник");
    }

    @Test
    public void getFamilyShouldReturnFelidae() {
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void getKittensDefaultShouldReturnOne() {
        assertEquals(1, feline.getKittens());
    }

    @Test
    public void getKittensWithParameterShouldReturnSameValue() {
        int expectedCount = 5;
        assertEquals(expectedCount, feline.getKittens(expectedCount));
    }
}