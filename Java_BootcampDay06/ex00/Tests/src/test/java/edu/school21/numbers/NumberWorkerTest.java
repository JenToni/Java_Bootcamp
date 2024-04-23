package edu.school21.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberWorkerTest {
    private  NumberWorker numberWorker;

    @BeforeEach
    void setUp(){
         numberWorker = new NumberWorker();
    }
    @ParameterizedTest
    @ValueSource(ints = {3,5,7,29,13,31,1223})
    void isPrimeForPrimes(int input) {
         numberWorker = new NumberWorker();
        Assertions.assertTrue(numberWorker.isPrime(input));
    }
    @ParameterizedTest
    @ValueSource(ints = {10, 6, 8, 102, 14, 200})
    void isPrimeForNotPrimes(int input) {
         numberWorker = new NumberWorker();
        Assertions.assertFalse(numberWorker.isPrime(input));
    }
    @ParameterizedTest
    @ValueSource(ints = {0, 1, -1, -1000})
    void isPrimeForIncorrectNumbers(int input) {
         numberWorker = new NumberWorker();
        Assertions.assertThrows(IllegalArgumentException.class, () -> numberWorker.isPrime(input));
    }
    @ParameterizedTest
    @CsvFileSource(resources = "/data.csv")
    void digitSum(int input, int expected) {
        numberWorker = new NumberWorker();
        assertEquals(expected, numberWorker.digitsSum(input));
    }
}
