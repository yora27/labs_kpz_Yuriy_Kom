package Lab3KomarynskyyKI306;

import java.io.*;

/**
 * Клас <code>ReservoirApp</code> виконує тестування та демонстрацію роботи класу Lake.
 * @author Komarynskyy Yuriy
 * @version 1.1
 */
public class ReservoirApp {
    /**
     * Є вхідною точкою програми
     * @param args аргументи командного рядка
    * @throws FileNotFoundException якщо виникла помилка при роботі з файлом
    */
    public static void main(String[] args) throws FileNotFoundException {
        Sea sea = new Sea("Чорне море", 2000.0, 18.0, 50000, true);
        System.out.println("Створено море " + sea.getName());
        logSeaState(sea);

        sea.addWater(5.0);
        sea.heatWater(2.0);
        sea.addFish(10000);
        logSeaState(sea);

        sea.addMarineLifeType("Дельфін");
        sea.addMarineLifeType("Скумбрія");
        sea.addMarineLifeType("Медуза");

        sea.addSeagulls(50);
        sea.setBeach(true);

        sea.changeWaterColor("темно-синій");

        sea.simulateStorm(4.5);

        sea.controlWaterQuality();
        sea.manageVegetation();
        sea.monitorEcosystem();

        logSeaState(sea);

        sea.dispose();
        System.out.println("Логування закінчено, ресурси звільнено.");
    }

    /**
    * Допоміжний метод для виведення стану моря на консоль.
    * @param sea море, стан якого необхідно вивести
    */
    private static void logSeaState(Sea sea) {
        System.out.println("Стан моря " + sea.getName() + ":");
        System.out.println("Рівень води: " + sea.getWaterLevel() + " метрів");
        System.out.println("Максимальна глибина: " + sea.getMaxDepth() + " метрів");
        System.out.println("Температура води: " + sea.getTemperature() + " градусів Цельсія");
        System.out.println("Кількість морських організмів: " + sea.getFishCount());
        System.out.println("Види морського життя: " + sea.getMarineLifeTypes());
        System.out.println("Кількість чайок: " + sea.getSeagullCount());
        System.out.println("Колір води: " + sea.getWaterColor());
        System.out.println("Наявність пляжу: " + (sea.hasBeach() ? "Так" : "Ні"));
        System.out.println("Відкрите море: " + (sea.isOpenSea() ? "Так" : "Ні"));
        System.out.println();
    }
}