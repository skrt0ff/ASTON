package ru.astondevs.l8.figures;

public class Main {
    public static void main(String[] args) {
        /*Применяя интерфейсы написать программу расчета периметра и площади геометрических фигур:
         круг, прямоугольник, треугольник.
               Задать для каждой фигуры цвет заливки и цвет границы.
        Результат полученных характеристик
        [ Периметр, площадь, цвет фона, цвет границ ] по каждой фигуре вывести в консоль.
        Попробуйте реализовать базовые методы, такие как расчет периметра фигур,
        в качестве дефолтных методов в интерфейсе.*/
        System.out.println();
        System.out.println("_____Треугольник_____ ");
        Triangle triangle = new Triangle(3.0, 4.0, 5.0);
        triangle.setBorderColor("Черный");
        triangle.setFillingColor("Красный");
        triangle.perimeter();
        triangle.square();
        System.out.println(triangle.getFillingColor());
        System.out.println(triangle.getBorderColor());
        System.out.println();
        System.out.println("_____Прямоугольник_____ ");
        Rectangle rectangle = new Rectangle(2.0, 2.0);
        rectangle.setBorderColor("Черный");
        rectangle.setFillingColor("Фиолетовый");
        rectangle.perimeter();
        rectangle.square();
        System.out.println(rectangle.getFillingColor());
        System.out.println(rectangle.getBorderColor());
        System.out.println();
        System.out.println("_____Круг_____ ");
        Circle circle = new Circle(10);
        circle.setBorderColor("Черный");
        circle.setFillingColor("Синий");
        circle.perimeter();
        circle.square();
        System.out.println(circle.getFillingColor());
        System.out.println(circle.getBorderColor());
        System.out.println();
    }
}
