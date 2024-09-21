package main;
import java.io.*;
import java.util.*;

/**
 * Клас <code>Lab1KomarynskyyKI306</code> виконує програму до завдання лабораторної роботи №1.
 * Програма створює квадратну матрицю із заштрихованими лівим нижнім та правим верхнім квадрантами.
 * @author Komarynskyi Yuriy
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
        char[][] array = new char[size][];
        int half = size / 2;

        for (int i = 0; i < size; i++) {            
                array[i] = new char[half];
                
                for (int j = half; j < size; j++) {
                    array[i][j - half] = filler;
                } 
                
           
                
                
            }
        return array;
    }
    
    /**
     * Метод для виведення масиву на екран.
     * @param array Двовимірний масив для виведення.
     */
    private static void printArray(char[][] array) {
        int size = array.length;
        int half = size / 2;
        for (int i = 0; i < size; i++) {
            if (i < half) {
                System.out.print(new String(array[i]));
                for (int j = half; j < size; j++) {
                    System.out.print(' ');
                }
                System.out.println();
            } else {
                for (int j = 0; j < half; j++) {
                    System.out.print(' ');
                }
                System.out.println(new String(array[i]));
            }
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
            int size = array.length;
            int half = size / 2;
            
            for (int i = 0; i < size; i++) {
                if (i < half) {
                    writer.print(new String(array[i]));
                    for (int j = half; j < size; j++) {
                        writer.print(' ');
                    }
                } else {
                    for (int j = 0; j < half; j++) {
                        writer.print(' ');
                    }
                    writer.print(new String(array[i]));
                }
                writer.println(); // Перехід на новий рядок
            }
        }
        System.out.println("Масив збережено у файл: " + filename);
    }
}