/**
 * Пакет лабораторної роботи №2
 */
package Lab2KomarynskyyKI306;

import java.io.*;

/**
 * Клас <code>Reservoir</code> описує водойму з можливістю керування рівнем води,
 * температурою та вмістом риби.
 * @author Komarynskyy Yuriy
 * @version 1.0
 */
public class Reservoir {
    private WaterLevel waterLevel;
    private Temperature temperature;
    private FishPopulation fishPopulation;
    private PrintWriter fout;

    /**
     * Створює водойму з заданими параметрами.
     * @param level рівень води (в метрах)
     * @param temp температура води (в градусах Цельсія)
     * @param fishCount кількість риб
     * @throws FileNotFoundException якщо файл для запису логів не може бути відкрито
     */
    public Reservoir(double level, double temp, int fishCount) throws FileNotFoundException {
        waterLevel = new WaterLevel(level);
        temperature = new Temperature(temp);
        fishPopulation = new FishPopulation(fishCount);
        fout = new PrintWriter(new File("ReservoirLog.txt"));
    }

    /**
     * Створює водойму з налаштуваннями за замовчуванням.
     * @throws FileNotFoundException якщо файл для запису логів не може бути відкрито
     */
    public Reservoir() throws FileNotFoundException {
        this(10.0, 20.0, 1000);
    }

    /**
     * Збільшує рівень води.
     * @param amount кількість води для додавання (в метрах)
     */
    public void addWater(double amount) {
        waterLevel.increase(amount);
        fout.println("Додано " + amount + " метрів води. Новий рівень: " + waterLevel.getLevel());
        fout.flush();
    }

    /**
     * Зменшує рівень води.
     * @param amount кількість води для видалення (в метрах)
     */
    public void removeWater(double amount) {
        waterLevel.decrease(amount);
        fout.println("Видалено " + amount + " метрів води. Новий рівень: " + waterLevel.getLevel());
        fout.flush();
    }

    /**
     * Підвищує температуру води.
     * @param amount величина підвищення температури (в градусах Цельсія)
     */
    public void heatWater(double amount) {
        temperature.increase(amount);
        fout.println("Підвищено температуру на " + amount + " градусів. Нова температура: " + temperature.getTemperature());
        fout.flush();
    }

    /**
     * Знижує температуру води.
     * @param amount величина зниження температури (в градусах Цельсія)
     */
    public void coolWater(double amount) {
        temperature.decrease(amount);
        fout.println("Знижено температуру на " + amount + " градусів. Нова температура: " + temperature.getTemperature());
        fout.flush();
    }

    /**
     * Додає рибу до водойми.
     * @param count кількість риби для додавання
     */
    public void addFish(int count) {
        fishPopulation.increase(count);
        fout.println("Додано " + count + " риб. Нова популяція: " + fishPopulation.getCount());
        fout.flush();
    }

    /**
     * Видаляє рибу з водойми.
     * @param count кількість риби для видалення
     */
    public void removeFish(int count) {
        fishPopulation.decrease(count);
        fout.println("Видалено " + count + " риб. Нова популяція: " + fishPopulation.getCount());
        fout.flush();
    }

    /**
     * Отримує поточний рівень води.
     * @return рівень води в метрах
     */
    public double getWaterLevel() {
        fout.println("Отримано рівень води: " + waterLevel.getLevel());
        fout.flush();
        return waterLevel.getLevel();
    }

    /**
     * Отримує поточну температуру води.
     * @return температура води в градусах Цельсія
     */
    public double getTemperature() {
        fout.println("Отримано температуру води: " + temperature.getTemperature());
        fout.flush();
        return temperature.getTemperature();
    }

    /**
     * Отримує поточну кількість риби.
     * @return кількість риби
     */
    public int getFishCount() {
        fout.println("Отримано кількість риби: " + fishPopulation.getCount());
        fout.flush();
        return fishPopulation.getCount();
    }

    /**
     * Звільнює ресурси, які були використані для роботи з файлом.
     */
    public void dispose() {
        fout.close();
    }

    // Внутрішні класи для представлення складових частин водойми

    private class WaterLevel {
        private double level;

        public WaterLevel(double level) {
            this.level = level;
        }

        public void increase(double amount) {
            level += amount;
        }

        public void decrease(double amount) {
            level = Math.max(0, level - amount);
        }

        public double getLevel() {
            return level;
        }
    }

    private class Temperature {
        private double temperature;

        public Temperature(double temperature) {
            this.temperature = temperature;
        }

        public void increase(double amount) {
            temperature += amount;
        }

        public void decrease(double amount) {
            temperature -= amount;
        }

        public double getTemperature() {
            return temperature;
        }
    }

    private class FishPopulation {
        private int count;

        public FishPopulation(int count) {
            this.count = count;
        }

        public void increase(int amount) {
            count += amount;
        }

        public void decrease(int amount) {
            count = Math.max(0, count - amount);
        }

        public int getCount() {
            return count;
        }
    }
}