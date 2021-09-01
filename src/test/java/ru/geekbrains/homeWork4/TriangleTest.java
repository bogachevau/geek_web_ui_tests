package ru.geekbrains.homeWork4;

import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static ru.geekbrains.homeWork4.AreaTriangle.areaTriangle;

public class TriangleTest {
    AreaTriangle areaTriangle = new AreaTriangle();
    private static Logger logger = LoggerFactory.getLogger(AreaTriangle.class);

    @BeforeAll
    static void beforeAll() {
        logger.info("Тестирование метода нахождения площади треугольника");
        logger.debug("debug level");
        logger.error("error");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("Нахождение площади треугольника по формуле Геррона");
    }

    @Test
    void testGivenEvenFindingAreaTriangle() throws BadTriangleException {
        double result = areaTriangle(3, 4, 5);
        Assertions.assertEquals(6.0, result);
    }

    @Test
    void testGivenEvenBadTriangleNegative() {
        assertThatExceptionOfType(BadTriangleException.class).isThrownBy(
                () -> areaTriangle(1, -1, 2));
    }

    @Test
    void testGivenEvenBadTriangleNull() {
        assertThatExceptionOfType(BadTriangleException.class).isThrownBy(
                () -> areaTriangle(1, 2, 0));
    }

    @AfterEach
    void tearDown() {
        System.out.println("Тест завершился");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Все тесты завершились!");
    }
}
