import java.util.Objects;
import ru.astondevs.classes.Employee;
import ru.astondevs.classes.Park;

public class Main {
    public static void main(String[] args) {
       /* 1. Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст.
        Конструктор класса должен заполнять эти поля при создании объекта.
        Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль.*/
        System.out.println("TASK №1");
        Employee employee = new Employee("Благинин Александр Артемович", "Менеджер", "Blaginin03@gmail.com", 89237892003L, 50000L, 20);
        employee.displayInfo();
        System.out.println("\n");

         /*   2. Создать массив из 5 сотрудников.
                Пример:
        // вначале объявляем массив объектов
        Person[] persArray = new Person[5];
        // потом для каждой ячейки массива задаем объект
        persArray[0] = new Person("Ivanov Ivan", "Engineer",
                "ivivan@mailbox.com", "892312312", 30000, 30);
        persArray[1] = new Person(...);
        ...persArray[4] = new Person(...);*/

        System.out.println("TASK №2");
        Employee[] emplArray = new Employee[5];
        emplArray[0] = new Employee("Иванов Иван Иванович", "Инженер", "Ivanov@mail.ru", 89237892456L, 100000L, 35);
        emplArray[1] = new Employee("Кириллов Кирилл Кириллович ", "Врач", "Kir@mail.ru", 89233452456L, 40000L, 26);
        emplArray[2] = new Employee("Сергеев Сергей Сергеевич", "Повар", "serg@mail.ru", 89231852400L, 60000L, 25);
        emplArray[3] = new Employee("Матвеев Матвей Матвеевич", "Разработчик", "matv@mail.ru", 89277462456L, 250000L, 40);
        emplArray[4] = new Employee("Алексеев Алексей Алексеевич", "QA", "Ivanov@mail.ru", 89237892456L, 25000L, 18);
        emplArray[0].displayInfo();
        System.out.println("\n");

        /*3. Создать класс Park с внутренним классом,
        с помощью объектов которого можно хранить информацию об аттракционах, времени их работы и стоимости.*/

        System.out.println("TASK №3");
        Park dreamIsland = new Park("Остров мечты", "12:00-22:00");
        Park.Attraction mill = dreamIsland.new Attraction("Мельница", "12:00-22:00", 3300);
        dreamIsland.displayPark();
        mill.displayAttraction();
        System.out.println("\n");
    }
}