package ru.astondevs.l8.figures;

public class Circle implements Perimeter, Square {
    private double radius;
    private String fillingColor;
    private String borderColor;

    public Circle(double radius) {
        this.radius = radius;
    }

    public void setBorderColor(String borderColor) {
        this.borderColor = borderColor;
    }

    public void setFillingColor(String fillingColor) {
        this.fillingColor = fillingColor;
    }

    public String getBorderColor() {
        return "Цвет границ: " + borderColor;
    }

    public String getFillingColor() {
        return "Цвет заливки: " + fillingColor;
    }

    public void perimeter() {
        if (radius <= 0) {
            System.out.println("Пожалуйста, введите корректные данные! ");
        } else {
            System.out.println("Длина окружности: " + 2.0 * Math.PI * radius);
        }
    }

    public void square() {
        if (radius <= 0) {
            System.out.println("Пожалуйста, введите корректные данные! ");
        } else {
            System.out.println("Площадь: " + Math.PI * radius * radius);
        }
    }
}
