package Lab4KomarynskyyKI306;

/**
 * Клас {@code Equations} реалізує метод для обчислення
 * математичного виразу y = sin(x) / tg(4x).
 * <p>
 * Цей клас містить метод для обчислення значення виразу
 * та обробляє можливі математичні помилки.
 * </p>
 *
 * @author Комаринський Юрій
 * @version 1.1
 */
public class Equations {
    /**
     * Обчислює значення виразу y = sin(x) / tg(4x).
     * <p>
     * Метод перетворює вхідне значення з градусів у радіани,
     * обчислює вираз та перевіряє результат на коректність.
     * </p>
     *
     * @param x кут у градусах
     * @return результат обчислення виразу
     * @throws CalcException якщо виникла помилка під час обчислень
     */
    public double calculate(double x) throws CalcException {
        // Перетворення градусів у радіани
        double rad = Math.toRadians(x);
        double rad4 = Math.toRadians(4 * x);
        
        try {
            double sinX = Math.sin(rad);
            double tan4X = Math.tan(rad4);
            
            // Перевірка на ділення на нуль
            if (tan4X == 0) {
                throw new ArithmeticException("Тангенс 4x дорівнює нулю");
            }
            
            double result = sinX / tan4X;
            
            // Перевірка результату на коректність
            if (Double.isNaN(result)) {
                throw new ArithmeticException("Результат не є числом");
            }
            
            return result;
        } catch (ArithmeticException ex) {
            // Перехоплення арифметичних помилок і створення спеціалізованого виключення
            throw new CalcException("Помилка обчислення: " + ex.getMessage());
        }
    }
}