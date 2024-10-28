package Lab4KomarynskyyKI306;

import java.io.*;

/**
 * Клас для роботи з файлами результатів обчислень.
 * Підтримує запис та читання у текстовому та бінарному форматах.
 */
public class EquationFileHandler {
    private final String textFilePath;
    private final String binaryFilePath;

    /**
     * Конструктор класу.
     * @param baseFilename базова назва фай	лу (без розширення)
     */
    public EquationFileHandler(String baseFilename) {
        this.textFilePath = baseFilename + ".txt";
        this.binaryFilePath = baseFilename + ".bin";
    }

    /**
     * Записує результат у текстовий файл.
     * @param x вхідне значення
     * @param result результат обчислення
     * @throws IOException якщо виникла помилка при записі
     */
    public void writeTextFile(double x, double result) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(textFilePath))) {
            writer.println("X: " + x);
            writer.println("Результат: " + result);
        }
    }

    /**
     * Читає результат з текстового файлу.
     * @return масив з двох чисел: [x, результат]
     * @throws IOException якщо виникла помилка при читанні
     */
    public double[] readTextFile() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(textFilePath))) {
            String xLine = reader.readLine();
            String resultLine = reader.readLine();
            
            double x = Double.parseDouble(xLine.split(": ")[1]);
            double result = Double.parseDouble(resultLine.split(": ")[1]);
            
            return new double[]{x, result};
        }
    }

    /**
     * Записує результат у бінарний файл.
     * @param x вхідне значення
     * @param result результат обчислення
     * @throws IOException якщо виникла помилка при записі
     */
    public void writeBinaryFile(double x, double result) throws IOException {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(binaryFilePath))) {
            dos.writeDouble(x);
            dos.writeDouble(result);
        }
    }

    /**
     * Читає результат з бінарного файлу.
     * @return масив з двох чисел: [x, результат]
     * @throws IOException якщо виникла помилка при читанні
     */
    public double[] readBinaryFile() throws IOException {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(binaryFilePath))) {
            double x = dis.readDouble();
            double result = dis.readDouble();
            return new double[]{x, result};
        }
    }
}