import java.util.Arrays;
import java.lang.Math;

public class Main {
    /**
     * Задание 1. (А) Реализовать процедуру, генерирующую массив вещественных чисел
     */
    static void genArr(double[] a, int n) {
        for (int i = 0; i < n; i++)
            a[i] = (double)Math.random() * (100 - 0) + 0; /** Числа в диапазоне от 0 до 100 */
    }
    static void printArr(double[] a, int n) {
        for (int i = 0; i < n; i++)
            System.out.println(a[i]);
        System.out.println("");
    }

    /**
     * Задание 2. (А) Реализовать процедуру вычисления суммы всех чисел, взятых в порядке возрастания
     */
    static double sum1(double[] a, int n) {
        double result = 0;
        Arrays.sort(a);
        for (int i=0; i<n; i++) {
            result += a[i];
            if (i != n-1) System.out.print(a[i] + " + ");
            else System.out.print(a[i] + " = ");
        }
        return result;
    }
    /**
     * Задание 2. (А) Реализовать процедуру вычисления суммы всех чисел, взятых в порядке убывания
     */
    static double sum2(double[] a, int n) {
        double result = 0;
        Arrays.sort(a);
        for (int i=n-1; i>=0; i--){
            result += a[i];
            if (i != 0) System.out.print(a[i] + " + ");
            else System.out.print(a[i] + " = ");
        }
        return result;
    }
    /**
     * Задание 2. (B) Реализовать процедуру вычисления суммы всех чисел, взятых в случайном порядке
     */
    static double sum3(double[] a, int n) {
        double result = 0;
        Arrays.sort(a);
        int[] flags = new int[n];
        for (int i=0; i<n; i++)
            flags[i] = 0;

        for (int i=0; i<n; i++) {
            int num = (int)(Math.random() * (n));
            if (flags[num] == 1)
                i--;
            else {
                result += a[num];
                if (i != n-1) System.out.print(a[num] + " + ");
                else System.out.print(a[num] + " = ");
                flags[num] = 1;
            }
        }
        return result;
    }

    /**
     * Задание 3. Предусмотреть возможность вычисления точного значения суммы следующим образом:
     * (В) значение, вычисленное на двойной точности (double), считается точнымж
     *     значение, вычисленное на одинарной точности (float), считается приближённым
     */
    static double sumD1(double[] a, int n) {
        double result = 0;
        for (int i=0; i<n; i++)
            result += a[i];
        return result;
    }
    static float sumF1(double[] a, int n) {
        float result = 0;
        for (int i=0; i<n; i++)
            result += (float)a[i];
        return result;
    }
    /***/
    static double sumD2(double[] a, int n) {
        double result = 0;
        for (int i=n-1; i>=0; i--)
            result += a[i];
        return result;
    }
    static float sumF2(double[] a, int n) {
        float result = 0;
        for (int i=n-1; i>=0; i--)
            result += (float)a[i];
        return result;
    }
    /***/
    static double sumD3(double[] a, int n) {
        double result = 0;
        int[] flags = new int[n];
        for (int i=0; i<n; i++)
            flags[i] = 0;

        for (int i=0; i<n; i++) {
            int num = (int)(Math.random() * (n));
            if (flags[num] == 1)
                i--;
            else {
                result += a[num];
                flags[num] = 1;
            }
        }
        return result;
    }
    static float sumF3(double[] a, int n) {
        float result = 0;
        int[] flags = new int[n];
        for (int i=0; i<n; i++)
            flags[i] = 0;

        for (int i=0; i<n; i++) {
            int num = (int)(Math.random() * (n));
            if (flags[num] == 1)
                i--;
            else {
                result += (float)a[num];
                flags[num] = 1;
            }
        }
        return result;
    }
    /**
     * Задание 4. (А) Реализовать процедуру определения абсолютной погрешности каждой из вычисленных сумм
     */
    static double absoluteError(float approximate_value, double exact_value) {
        return Math.abs(approximate_value - exact_value);
    }

    /**
     * Задание 5. (А) Таблица
     */
    static void table() {
        System.out.println("Вычислительный эксперимент:");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("Size    |       Error 1         |       Error 2         |       Error 3");
        System.out.println("--------------------------------------------------------------------------------");
        int[] n = {10, 20, 50, 100, 200, 500, 1000, 2000, 5000};
        for (int i=0; i<9; i++) {
            System.out.print(n[i] + "   \t" + "|");
            double[] arr = new double[n[i]];
            genArr(arr, n[i]);
            System.out.print(" " + absoluteError(sumF1(arr, n[i]), sumD1(arr, n[i])) + "\t" + "|");
            System.out.print(" " + absoluteError(sumF2(arr, n[i]), sumD2(arr, n[i])) + "\t" + "|");
            System.out.println(" " + absoluteError(sumF3(arr, n[i]), sumD3(arr, n[i])));
        }
    }


    public static void main(String[] Args) {

        int n = 10;
        double[] arr = new double[n];
        genArr(arr, n);
        printArr(arr, n);

        System.out.println("В порядке возрастания:");
        System.out.println(sum1(arr, n));
        System.out.print("Точное значение: ");
        System.out.println(sumD1(arr, n));
        System.out.print("Приближённое значение: ");
        System.out.println(sumF1(arr, n));
        System.out.print("Абсолютная погрешность: ");
        System.out.println(absoluteError(sumF1(arr, n), sumD1(arr, n)));
        System.out.println("");

        System.out.println("В порядке убывания:");
        System.out.println(sum2(arr, n));
        System.out.print("Точное значение: ");
        System.out.println(sumD2(arr, n));
        System.out.print("Приближённое значение: ");
        System.out.println(sumF2(arr, n));
        System.out.print("Абсолютная погрешность: ");
        System.out.println(absoluteError(sumF2(arr, n), sumD2(arr, n)));
        System.out.println("");

        System.out.println("В случайном порядке:");
        System.out.println(sum3(arr, n));
        System.out.print("Точное значение: ");
        System.out.println(sumD3(arr, n));
        System.out.print("Приближённое значение: ");
        System.out.println(sumF3(arr, n));
        System.out.print("Абсолютная погрешность: ");
        System.out.println(absoluteError(sumF3(arr, n), sumD3(arr, n)));
        System.out.println("");
        
        table();

    }
}
