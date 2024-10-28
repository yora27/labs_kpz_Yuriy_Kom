package Lab3KomarynskyyKI306;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Клас Sea представляє морську водойму.
 * Розширює клас Reservoir та реалізує інтерфейс WaterManagement.
 */
public class Sea extends Reservoir implements WaterManagement {
    private String name;
    private boolean isOpenSea;
    private ArrayList<String> marineLifeTypes;
    private int seagullCount;
    private boolean hasBeach;
    private double maxDepth;
    private String waterColor;
    private Random random;

    /**
     * Конструктор для створення нового об'єкта Sea.
     * @param name назва моря
     * @param level початковий рівень води
     * @param temp початкова температура води
     * @param marineLifeCount початкова кількість морських організмів
     * @param isOpenSea чи є море відкритим
     * @throws FileNotFoundException якщо не вдалося створити файл для логування
     */
    public Sea(String name, double level, double temp, int marineLifeCount, boolean isOpenSea) throws FileNotFoundException {
        super(level, temp, marineLifeCount);
        this.name = name;
        this.isOpenSea = isOpenSea;
        this.marineLifeTypes = new ArrayList<>();
        this.seagullCount = 0;
        this.hasBeach = false;
        this.maxDepth = level * 10; 
        this.waterColor = "синій";
        this.random = new Random();
    }

    /**
     * Додає воду до моря.
     * @param amount кількість води для додавання
     */
    @Override
    public void addWater(double amount) {
        waterLevel.increase(amount);
        fout.println("Додано " + amount + " метрів води до моря " + name + ". Новий рівень: " + waterLevel.getLevel());
        fout.flush();
    }

    /**
     * Видаляє воду з моря.
     * @param amount кількість води для видалення
     */
    @Override
    public void removeWater(double amount) {
        waterLevel.decrease(amount);
        fout.println("Знижено рівень на " + amount + " метрів у морі " + name + ". Новий рівень: " + waterLevel.getLevel());
        fout.flush();
    }

    /**
     * Підвищує температуру води в морі.
     * @param amount величина підвищення температури
     */
    @Override
    public void heatWater(double amount) {
        temperature.increase(amount);
        fout.println("Підвищено температуру на " + amount + " градусів у морі " + name + ". Нова температура: " + temperature.getTemperature());
        if (temperature.getTemperature() > 30) {
            fout.println("Увага! Температура води стає критичною для деяких морських організмів!");
        }
        fout.flush();
    }

    /**
     * Знижує температуру води в морі.
     * @param amount величина зниження температури
     */
    @Override
    public void coolWater(double amount) {
        temperature.decrease(amount);
        fout.println("Знижено температуру на " + amount + " градусів у морі " + name + ". Нова температура: " + temperature.getTemperature());
        if (temperature.getTemperature() < 5) {
            fout.println("Увага! Вода стає занадто холодною для деяких морських видів!");
        }
        fout.flush();
    }

    /**
     * Додає морські організми до моря.
     * @param count кількість організмів для додавання
     */
    @Override
    public void addFish(int count) {
        fishPopulation.increase(count);
        fout.println("Додано " + count + " морських організмів до моря " + name + ". Нова популяція: " + fishPopulation.getCount());
        fout.flush();
    }

    /**
     * Видаляє морські організми з моря.
     * @param count кількість організмів для видалення
     */
    @Override
    public void removeFish(int count) {
        fishPopulation.decrease(count);
        fout.println("Зменшено популяцію на " + count + " організмів у морі " + name + ". Нова популяція: " + fishPopulation.getCount());
        fout.flush();
    }

    /**
     * Контролює якість води в морі.
     */
    @Override
    public void controlWaterQuality() {
        fout.println("Проведено контроль якості води в морі " + name);
        if (random.nextBoolean()) {
            fout.println("Якість води відповідає нормам.");
        } else {
            fout.println("Виявлено забруднення, потрібні заходи очищення.");
        }
        fout.flush();
    }

    /**
     * Керує рослинністю в морі.
     */
    @Override
    public void manageVegetation() {
        fout.println("Проведено моніторинг морської рослинності в " + name);
        if (random.nextBoolean()) {
            fout.println("Стан водоростей та планктону в нормі.");
        } else {
            fout.println("Виявлено надмірне розростання водоростей, потрібні заходи контролю.");
        }
        fout.flush();
    }

    /**
     * Моніторить екосистему моря.
     */
    @Override
    public void monitorEcosystem() {
        fout.println("Проведено моніторинг екосистеми моря " + name);
        fout.println("Кількість морських організмів: " + fishPopulation.getCount());
        fout.println("Кількість чайок: " + seagullCount);
        fout.flush();
    }

    /**
     * Додає новий вид морського життя до моря.
     * @param marineLifeType вид морського життя для додавання
     */
    public void addMarineLifeType(String marineLifeType) {
        marineLifeTypes.add(marineLifeType);
        fout.println("Додано новий вид морського життя до моря " + name + ": " + marineLifeType);
        fout.flush();
    }

    /**
     * Додає чайок до узбережжя моря.
     * @param count кількість чайок для додавання
     */
    public void addSeagulls(int count) {
        seagullCount += count;
        fout.println("Додано " + count + " чайок до узбережжя моря " + name + ". Нова кількість чайок: " + seagullCount);
        fout.flush();
    }

    /**
     * Встановлює наявність пляжу на узбережжі моря.
     * @param hasBeach true, якщо пляж є; false - якщо немає
     */
    public void setBeach(boolean hasBeach) {
        this.hasBeach = hasBeach;
        fout.println("Пляж " + (hasBeach ? "додано до" : "видалено з") + " узбережжя моря " + name);
        fout.flush();
    }

    /**
     * Змінює колір води в морі.
     * @param newColor новий колір води
     */
    public void changeWaterColor(String newColor) {
        this.waterColor = newColor;
        fout.println("Колір води в морі " + name + " змінився на " + newColor);
        fout.flush();
    }

    /**
     * Симулює шторм у морі.
     * @param waveHeight висота хвиль під час шторму
     */
    public void simulateStorm(double waveHeight) {
        fout.println("Симуляція шторму в морі " + name + ". Висота хвиль: " + waveHeight + " метрів");
        removeWater(waveHeight * 0.1); // Припустимо, що шторм трохи знижує рівень моря
        fout.flush();
    }

    // Гетери
    public String getName() { return name; }
    public boolean isOpenSea() { return isOpenSea; }
    public double getMaxDepth() { return maxDepth; }
    public String getWaterColor() { return waterColor; }
    public boolean hasBeach() { return hasBeach; }
    public int getSeagullCount() { return seagullCount; }
    public ArrayList<String> getMarineLifeTypes() { return new ArrayList<>(marineLifeTypes); }
}