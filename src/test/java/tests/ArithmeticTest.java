package tests;

import steps.CalculatorSteps;
import io.qameta.allure.*;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Test;

@Epic("Калькулятор")
@Feature("Арифметические операции")
public class ArithmeticTest {

    private final CalculatorSteps steps = new CalculatorSteps();

    @Test
    @Story("Сложение")
    @Severity(SeverityLevel.NORMAL)
    @Owner("ВашеИмя")
    @Description("Проверяем базовое сложение двух положительных чисел: 2 + 3 = 5")
    @Link(name = "Требование CAL-001", url = "https://jira.example.com/CAL-001")
    public void testAddPositiveNumbers() {
        Allure.parameter("Операнд A", "2");
        Allure.parameter("Операнд B", "3");

        double result = steps.add(2, 3);
        steps.verifyResult(result, 5);
    }

    @Test
    @Story("Сложение")
    @Severity(SeverityLevel.NORMAL)
    @Description("Проверяем сложение с отрицательным числом: -5 + 3 = -2")
    public void testAddWithNegativeNumber() {
        double result = steps.add(-5, 3);
        steps.verifyResult(result, -2);
    }

    @Test
    @Story("Вычитание")
    @Severity(SeverityLevel.NORMAL)
    @Owner("ВашеИмя")
    @Description("Проверяем вычитание: 10 - 4 = 6")
    public void testSubtract() {
        double result = steps.subtract(10, 4);
        steps.verifyResult(result, 6);
    }

    @Test
    @Story("Умножение")
    @Severity(SeverityLevel.NORMAL)
    @Description("Проверяем умножение: 7 × 8 = 56")
    public void testMultiply() {
        double result = steps.multiply(7, 8);
        steps.verifyResult(result, 56);
    }

    @Test
    @Story("Деление")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверяем деление: 15 / 3 = 5")
    public void testDivide() {
        double result = steps.divide(15, 3);
        steps.verifyResult(result, 5);
    }

    @Test
    @Story("Деление на ноль")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверяем, что деление на ноль выбрасывает ArithmeticException")
    public void testDivideByZero() {
        try {
            steps.divide(10, 0);
            throw new AssertionError("Ожидалось исключение ArithmeticException");
        } catch (ArithmeticException e) {
            Allure.addAttachment("Сообщение исключения", e.getMessage());
            // Исключение поймано - тест проходит
        }
    }
}