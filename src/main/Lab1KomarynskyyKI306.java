package main;
import java.io.*;
import java.util.*;

/**
 * Клас <code>Lab1KomarynskyyKI306</code> виконує програму до завдання лабораторної роботи №1.
 * Програма створює квадратну матрицю із заштрихованими лівим нижнім та правим верхнім квадрантами.
 * @author Yuriy Komarynskyi
 * 
 * @version 2.0
 */
public class Lab1KomarynskyyKI306 {

    /**
     * Точка входу в програму.
     * @param args Аргументи командного рядка (не використовуються).
     * @throws IOException Якщо виникає помилка при роботі з файлом.
     */
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        
        int size = getSize(scanner);
        char filler = getFiller(scanner);
        
        char[][] array = createArray(size, filler);
        
        printArray(array);
        saveArrayToFile(array, "output.txt");
        
        scanner.close();
    }
    
    /**
     * Метод для отримання розміру матриці від користувача.
     * @param scanner Об'єкт Scanner для зчитування введення.
     * @return Розмір матриці.
     */
    private static int getSize(Scanner scanner) {
        int size;
        while (true) {
            System.out.print("Введіть розмір квадратної матриці (парне число): ");
            if (scanner.hasNextInt()) {
                size = scanner.nextInt();
                if (size > 0 && size % 2 == 0) {
                    return size;
                }
            }
            System.out.println("Будь ласка, введіть додатне парне число.");
            scanner.nextLine(); // Очищення буфера
        }
    }
    
    /**
     * Метод для отримання символу-заповнювача від користувача.
     * @param scanner Об'єкт Scanner для зчитування введення.
     * @return Символ-заповнювач.
     */
    private static char getFiller(Scanner scanner) {
        while (true) {
            System.out.print("Введіть символ-заповнювач: ");
            String input = scanner.next();
            if (input.length() == 1) {
                return input.charAt(0);
            }
            System.out.println("Будь ласка, введіть лише один символ.");
        }
    }
    
    /**
     * Метод для створення квадратної матриці із заштрихованими областями.
     * @param size Розмір квадратної матриці.
     * @param filler Символ-заповнювач.
     * @return Двовимірний масив символів.
     */
    private static char[][] createArray(int size, char filler) {
        char[][] array = new char[size][size];
        int half = size / 2;
        
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if ((i >= half && j < half) || (i < half && j >= half)) {
                    array[i][j] = filler;
                } else {
                    array[i][j] = ' ';
                }
            }
        }
        
        return array;
    }
    
    /**
     * Метод для виведення масиву на екран.
     * @param array Двовимірний масив для виведення.
     */
    private static void printArray(char[][] array) {
        for (char[] row : array) {
            System.out.println(new String(row));
        }
    }
    
    /**
     * Метод для збереження масиву у текстовий файл.
     * @param array Двовимірний масив для збереження.
     * @param filename Ім'я файлу для збереження.
     * @throws IOException Якщо виникає помилка при роботі з файлом.
     */
    private static void saveArrayToFile(char[][] array, String filename) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (char[] row : array) {
                writer.println(new String(row));
            }
        }
        System.out.println("Масив збережено у файл: " + filename);
    }
}