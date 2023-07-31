package com.klm.cases.df.fares;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FaresControllerTest {
    @Mock
    private FaresFacade facade;

    private final Fare mockFare = new Fare(2.2, "EUR", "BUD", "SZG");
    
    @InjectMocks
    private FaresController underTest;
    

    @BeforeEach
    void setUp() {
        when(facade.calculateFare(anyString(), anyString(), anyString())).thenReturn(mockFare);
    }

    @Test
    void testCalculateFareCallsFacadeMethod() {
        // GIVEN
        // WHEN
        underTest.calculateFare("BUD", "SZG", "EUR");

        // THEN
        verify(facade).calculateFare(anyString(), anyString(), anyString());
    }
}