package com.klm.cases.df.fares;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class DefaultFaresFacadeTest {

    @Mock
    FaresService faresService;

    @InjectMocks
    private DefaultFaresFacade underTest;

    @Test
    public void testCalculateFareShouldCallFaresService() {
        // GIVEN
        String origin = "BUD";
        String destination = "SZG";
        String currency = "USD";

        // WHEN
        underTest.calculateFare(origin, destination, currency);

        // THEN
        verify(faresService).calculateFare(origin, destination, currency);
    }
}