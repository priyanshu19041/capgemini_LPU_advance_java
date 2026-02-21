package com.assignment;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

public class PriceServiceTest {

    @Test
    void testMobileDiscount() {
        DiscountRepository mockRepo = mock(DiscountRepository.class);
        when(mockRepo.getDiscountPercentage("MOB")).thenReturn(10.0);

        PriceService service = new PriceService(mockRepo);

        double finalPrice = service.calculateFinalPrice(1000, "MOB");

        assertEquals(900.0, finalPrice);
        verify(mockRepo).getDiscountPercentage("MOB");
    }

    @Test
    void testLaptopDiscount() {
        DiscountRepository mockRepo = mock(DiscountRepository.class);
        when(mockRepo.getDiscountPercentage("LAP")).thenReturn(20.0);

        PriceService service = new PriceService(mockRepo);

        double finalPrice = service.calculateFinalPrice(2000, "LAP");

        assertEquals(1600.0, finalPrice);
        verify(mockRepo).getDiscountPercentage("LAP");
    }

    @Test
    void testExceptionFromRepository() {
        DiscountRepository mockRepo = mock(DiscountRepository.class);
        when(mockRepo.getDiscountPercentage("ERR"))
                .thenThrow(new RuntimeException("Discount service failed"));

        PriceService service = new PriceService(mockRepo);

        assertThrows(RuntimeException.class, () -> {
            service.calculateFinalPrice(1000, "ERR");
        });
    }
}