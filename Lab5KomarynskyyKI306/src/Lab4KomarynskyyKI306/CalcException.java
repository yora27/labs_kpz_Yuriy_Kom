package Lab4KomarynskyyKI306;

/**
 * Клас {@code CalcException} представляє спеціалізоване виключення
 * для обробки помилок обчислень.
 * <p>
 * Цей клас розширює {@link ArithmeticException} для більш точного
 * опису помилок, що виникають під час математичних обчислень.
 * </p>
 *
 * @author Komarynskyy Yuriy
 * @version 1.0
 */
public class CalcException extends ArithmeticException {
    /**
     * Конструктор за замовчуванням.
     */
    public CalcException() {
        super();
    }

    /**
     * Конструктор з повідомленням про причину виключення.
     *
     * @param cause рядок, що описує причину виникнення виключення
     */
    public CalcException(String cause) {
        super(cause);
    }
}