package Lab3KomarynskyyKI306;

import java.io.*;

/**
 * Абстрактний клас Reservoir представляє загальну структуру водойми.
 * Містить базові характеристики та методи для управління водоймою.
 */
public abstract class Reservoir {
    protected WaterLevel waterLevel;
    protected Temperature temperature;
    protected FishPopulation fishPopulation;
    protected PrintWriter fout;

    /**
     * Конструктор для створення нової водойми.
     * @param level початковий рівень води
     * @param temp початкова температура води
     * @param fishCount початкова кількість риби
     * @throws FileNotFoundException якщо не вдалося створити файл для логування
     */
    public Reservoir(double level, double temp, int fishCount) throws FileNotFoundException {
        waterLevel = new WaterLevel(level);
        temperature = new Temperature(temp);
        fishPopulation = new FishPopulation(fishCount);
        fout = new PrintWriter(new File("ReservoirLog.txt"));
    }

    // Абстрактні методи для управління водоймою
    public abstract void addWater(double amount);
    public abstract void removeWater(double amount);
    public abstract void heatWater(double amount);
    public abstract void coolWater(double amount);
    public abstract void addFish(int count);
    public abstract void removeFish(int count);

    /**
     * @return поточний рівень води
     */
    public double getWaterLevel() {
        return waterLevel.getLevel();
    }

    /**
     * @return поточна температура води
     */
    public double getTemperature() {
        return temperature.getTemperature();
    }

    /**
     * @return поточна кількість риби
     */
    public int getFishCount() {
        return fishPopulation.getCount();
    }

    /**
     * Закриває файл логування при завершенні роботи з водоймою.
     */
    public void dispose() {
        fout.close();
    }

    /**
     * Внутрішній клас для управління рівнем води.
     */
    protected class WaterLevel {
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

    /**
     * Внутрішній клас для управління температурою води.
     */
    protected class Temperature {
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

    /**
     * Внутрішній клас для управління популяцією риби.
     */
    protected class FishPopulation {
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