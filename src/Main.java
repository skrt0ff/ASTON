import ru.astondevs.exeptions.Converter;

public class Main {
    public static void main(String[] args) {
        /*1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4.
        При подаче массива другого размера необходимо бросить исключение MyArraySizeException.
        2. Далее метод должен пройтись по всем элементам массива, преобразовать в int и просуммировать.
        Если в каком-то элементе массива преобразование не удалось
        (например, в ячейке лежит символ или текст вместо числа),
        должно быть брошено исключение MyArrayDataException с детализацией,
         в какой именно ячейке лежат неверные данные.
        3. В методе main() вызвать полученный метод, обработать возможные
         исключения MyArraySizeException и MyArrayDataException и вывести результат расчета.*/
        String[][] correctArray = new String[][] {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"},
        };

        String[][] wrongArraySize = new String[][] {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14"},
        };

        String[][] charArray = new String[][] {
                {"1", "2", "f", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"},
        };

        try {
            System.out.println("_____Correct Array_____");
            System.out.println("Сумма всех элементов в массиве: " + Converter.strConverter(correctArray));
        } catch (Exception e) {
            e.getMessage();
        }

        try {
            System.out.println("_____Wrong Array_____");
            System.out.println("Сумма всех элементов в массиве: " + Converter.strConverter(wrongArraySize));
        } catch (Exception e) {
            e.getMessage();
        }

        try {
            System.out.println("_____Char Array_____");
            System.out.println("Сумма всех элементов в массиве: " + Converter.strConverter(charArray));
        } catch (Exception e) {
            e.getMessage();
        }
    }
}