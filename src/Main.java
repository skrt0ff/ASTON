import ru.astondevs.l5.TaskArrays;
import ru.astondevs.l5.TaskNumbers;
import ru.astondevs.l5.TaskStrings;

public class Main {
    public static void main(String[] args) {
        int[] replaceArray = new int[] {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        int[] multiplyArray = new int[] {1, 5, 3, 2, 11, 4, 5, 2 ,4, 8, 9, 1};

        System.out.println("TASK 1 ->");
        System.out.println("_____________________________________________________");
        TaskStrings taskStrings = new TaskStrings();
        taskStrings.printThreeWorlds("Orange", "Banana", "Apple");
        System.out.println("_____________________________________________________\n");


        System.out.println("TASK 2 ->");
        System.out.println("_____________________________________________________");
        TaskNumbers taskNumbers = new TaskNumbers();
        taskNumbers.checkSumSign();
        System.out.println("____________________________________________________\n");


        System.out.println("TASK 3 ->");
        System.out.println("_____________________________________________________");
        taskNumbers.printColor();
        System.out.println("____________________________________________________\n");


        System.out.println("TASK 4 ->");
        System.out.println("______________________________________________________");
        taskNumbers.compareNumbers();
        System.out.println("______________________________________________________\n");


        System.out.println("TASK 5 ->");
        System.out.println("______________________________________________________");
        System.out.println(taskNumbers.checkRange(10,10));
        System.out.println("______________________________________________________\n");


        System.out.println("TASK 6 ->");
        System.out.println("______________________________________________________");
        taskNumbers.numberTypeVoid(0);
        System.out.println("______________________________________________________\n");


        System.out.println("TASK 7 ->");
        System.out.println("______________________________________________________");
        System.out.println(taskNumbers.numberTypeBool(0));
        System.out.println("______________________________________________________\n");


        System.out.println("TASK 8 ->");
        System.out.println("______________________________________________________");
        taskStrings.numberOfLines("Привет", 2);
        System.out.println("______________________________________________________\n");


        System.out.println("TASK 9 ->");
        System.out.println("______________________________________________________");
        System.out.println(taskNumbers.checkLeapYear(2022));
        System.out.println("______________________________________________________\n");


        System.out.println("TASK 10 ->");
        System.out.println("______________________________________________________");
        TaskArrays taskArrays = new TaskArrays();
        taskArrays.replaceValueArray(replaceArray);
        System.out.println("\n");
        System.out.println("______________________________________________________\n");


        System.out.println("TASK 11 ->");
        System.out.println("______________________________________________________");
        taskArrays.fillArray(100);
        System.out.println("\n");
        System.out.println("______________________________________________________\n");

        System.out.println("TASK 12 ->");
        System.out.println("______________________________________________________");
        taskArrays.multiplyArray(multiplyArray);
        System.out.println("\n");
        System.out.println("______________________________________________________\n");

        System.out.println("TASK 13 ->");
        System.out.println("______________________________________________________");
        taskArrays.diagonalArray(5,5);
        System.out.println("\n");
        System.out.println("______________________________________________________\n");

        System.out.println("TASK 14 ->");
        System.out.println("______________________________________________________");
        taskArrays.initialArray(5, 10);
        System.out.println("\n");
        System.out.println("______________________________________________________\n");

    }
}