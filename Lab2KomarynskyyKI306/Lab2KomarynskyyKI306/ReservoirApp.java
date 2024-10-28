package Lab2KomarynskyyKI306;

import java.io.*;

/**
 * Клас <code>ReservoirApp</code> виконує тестування та демонстрацію роботи класу Reservoir.
 * @author Komarynskyy Yuriy
 * @version 1.0
 */
public class ReservoirApp {
    /**
     * Є вхідною точкою програми
     * @param args аргументи командного рядка
     * @throws FileNotFoundException якщо виникла помилка при роботі з файлом
     */
    public static void main(String[] args) throws FileNotFoundException {
        // Створення водойми за замовчуванням
        Reservoir reservoir1 = new Reservoir();
        System.out.println("Водойму 1 створено за замовчуванням.");
        logReservoirState(reservoir1);

        // Модифікація параметрів водойми
        reservoir1.addWater(5.0);
        reservoir1.heatWater(2.0);
        reservoir1.addFish(500);
        logReservoirState(reservoir1);

        // Створення другої водойми з заданими параметрами
        Reservoir reservoir2 = new Reservoir(15.0, 25.0, 2000);
        System.out.println("Водойму 2 створено з заданими параметрами.");
        logReservoirState(reservoir2);

        // Модифікація параметрів другої водойми
        reservoir2.removeWater(3.0);
        reservoir2.coolWater(1.5);
        reservoir2.removeFish(300);
        logReservoirState(reservoir2);

        // Закриття ресурсів для логування
        reservoir1.dispose();
        reservoir2.dispose();
        System.out.println("Логування закінчено, ресурси звільнено.");
    }

    /**
     * Допоміжний метод для виведення стану водойми на консоль.
     * @param reservoir водойма, стан якої необхідно вивести
     */
    private static void logReservoirState(Reservoir reservoir) {
        System.out.println("Стан водойми:");
        System.out.println("Рівень води: " + reservoir.getWaterLevel() + " метрів");
        System.out.println("Температура води: " + reservoir.getTemperature() + " градусів Цельсія");
        System.out.println("Кількість риби: " + reservoir.getFishCount());
        System.out.println();
    }
}
