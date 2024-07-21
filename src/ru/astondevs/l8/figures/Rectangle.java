package ru.astondevs.l8.figures;

public class Rectangle implements Perimeter, Square {
    private double a;
    private double b;
    private String fillingColor;
    private String borderColor;

    public Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public void setBorderColor(String borderColor) {
        this.borderColor = borderColor;
    }

    public String getBorderColor() {
        return "Цвет границ: " + borderColor;
    }

    public void setFillingColor(String fillingColor) {
        this.fillingColor = fillingColor;
    }

    public String getFillingColor() {
        return "Цвет заливки: " + fillingColor;
    }

    public void perimeter() {
        if (a <= 0 || b <= 0) {
            System.out.println("Пожалуйста, введите корректные значения сторон! ");
        } else {
            System.out.println("Периметр: " + 2.0 * (a + b));
        }
    }

    public void square() {
        if (a <= 0 || b <= 0) {
            System.out.println("Пожалуйста, введите корректные значения сторон! ");
        } else {
            System.out.println("Площадь: " + a * b);
        }

    }
}
