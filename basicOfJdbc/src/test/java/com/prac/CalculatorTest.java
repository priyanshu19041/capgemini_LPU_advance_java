package com.prac;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

public class CalculatorTest {

//    @Test
//    public void addTest() {
//        int res = Calculator.add(20, 30);
//        assertEquals(50, res);
//    }

//    @Test
    public void reverseTest() {
        String actualres = Calculator.reverseString("data");
        assertEquals("atad", actualres);
    }

//    @Test
    public void palindromeTestTrue() {
        assertTrue(Calculator.palindrome("madam"));
    }

//    @Test
    public void palindromeTestFalse() {
        assertFalse(Calculator.palindrome("hello"));
    }
    
    @Test
    public void testValidAge() {
    	Employee e=new Employee(10,"Allen",10,"CSE");
    	
    	assertTrue(e.isValidAge());
    }
}
