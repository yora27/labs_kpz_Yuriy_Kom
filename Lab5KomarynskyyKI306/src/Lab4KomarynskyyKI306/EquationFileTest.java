package Lab4KomarynskyyKI306;

/**
 * Тестова програма для перевірки класу EquationFileHandler
 */
public class EquationFileTest {
    public static void main(String[] args) {
        try {
            // Створюємо екземпляри класів
            Equations equation = new Equations();
            EquationFileHandler fileHandler = new EquationFileHandler("equation_result");

            // Тестові дані
            double x = 45.0; // 45 градусів
            
            // Обчислюємо результат
            double result = equation.calculate(x);
            
            System.out.println("Тестування запису/читання у текстовому форматі:");
            // Записуємо у текстовий файл
            fileHandler.writeTextFile(x, result);
            
            // Читаємо з текстового файлу
            double[] textData = fileHandler.readTextFile();
            System.out.println("Прочитано з текстового файлу:");
            System.out.println("X = " + textData[0] + ", Результат = " + textData[1]);
            
            System.out.println("\nТестування запису/читання у бінарному форматі:");
            // Записуємо у бінарний файл
            fileHandler.writeBinaryFile(x, result);
            
            // Читаємо з бінарного файлу
            double[] binaryData = fileHandler.readBinaryFile();
            System.out.println("Прочитано з бінарного файлу:");
            System.out.println("X = " + binaryData[0] + ", Результат = " + binaryData[1]);
            
        } catch (Exception e) {
            System.out.println("Помилка: " + e.getMessage());
            e.printStackTrace();
        }
    }
}