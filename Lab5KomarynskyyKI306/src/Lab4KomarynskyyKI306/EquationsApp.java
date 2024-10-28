package Lab4KomarynskyyKI306;

import java.util.Scanner;
import java.io.*;
import static java.lang.System.out;

/**
 * Клас {@code EquationsApp} реалізує головну програму для обчислення
 * математичного виразу та запису результату у файл.
 * <p>
 * Цей клас демонструє використання класу {@link Equations} для обчислень
 * та обробку можливих винятків.
 * </p>
 *
 * @author Комаринський
 * @version 1.0
 */
public class EquationsApp {
    /**
     * Головний метод програми.
     * <p>
     * Метод запитує у користувача ім'я файлу для запису результату та значення X,
     * потім обчислює результат за допомогою {@link Equations#calculate(double)}
     * і записує його у вказаний файл.
     * </p>
     *
     * @param args аргументи командного рядка (не використовуються)
     */
    public static void main(String[] args) {
        try {
            out.print("Введіть ім'я файлу: ");
            Scanner in = new Scanner(System.in);
            String fName = in.nextLine();
            PrintWriter fout = new PrintWriter(new File(fName));
            try {
                try {
                    Equations eq = new Equations();
                    out.print("Введіть X (в градусах): ");
                    double result = eq.calculate(in.nextDouble());
                    out.println("Результат: " + result);
                    fout.println("Результат: " + result);
                } finally {
                    fout.flush();
                    fout.close();
                }
            } catch (CalcException ex) {
                out.println(ex.getMessage());
            }
        } catch (FileNotFoundException ex) {
            out.println("Помилка: Можливо, невірний шлях до файлу");
        }
    }
}