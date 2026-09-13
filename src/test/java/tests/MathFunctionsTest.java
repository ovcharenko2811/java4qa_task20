package tests;

import steps.CalculatorSteps;
import io.qameta.allure.*;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Test;

@Epic("Калькулятор")
@Feature("Математические функции")
public class MathFunctionsTest {

    private final CalculatorSteps steps = new CalculatorSteps();

    @Test
    @Story("Возведение в степень")
    @Severity(SeverityLevel.NORMAL)
    @Description("Проверяем возведение в степень: 2^10 = 1024")
    public void testPower() {
        double result = steps.power(2, 10);
        steps.verifyResult(result, 1024);
    }

    @Test
    @Story("Квадратный корень")
    @Severity(SeverityLevel.NORMAL)
    @Description("Проверяем квадратный корень из положительного числа: √16 = 4")
    public void testSqrtPositive() {
        double result = steps.sqrt(16);
        steps.verifyResult(result, 4);
    }

    @Test
    @Story("Корень из отрицательного числа")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверяем, что корень из отрицательного числа выбрасывает ArithmeticException")
    public void testSqrtNegative() {
        try {
            steps.sqrt(-4);
            throw new AssertionError("Ожидалось исключение ArithmeticException");
        } catch (ArithmeticException e) {
            Allure.addAttachment("Сообщение исключения", e.getMessage());
            // Исключение поймано - тест проходит
        }
    }

    @Test
    @Story("Падающий тест")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Специально падающий тест для демонстрации FAIL в отчёте Allure")
    public void testFailingExample() {
        // Этот тест специально падает, чтобы показать, как выглядит FAIL в Allure
        double result = steps.add(2, 3);
        steps.verifyResult(result, 10); // Ожидаем 10, но получим 5 - тест упадёт
    }
}