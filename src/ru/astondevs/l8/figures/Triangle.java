package ru.astondevs.l8.figures;

public class Triangle implements Perimeter, Square {
    private String fillingColor;
    private String borderColor;
    private double a, b, c;
    private double p;
    public Triangle(double a, double b, double c) {
        this.a = a;
        this.c = c;
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
        if (a <= 0 || b <= 0 || c <= 0) {
            System.out.println("Пожалуйста, введите корректные значения сторон");
        } else {
            System.out.println("Периметр: " + (a + b + c));
        }
    }

    public void square() {
        if (a <= 0 && b <= 0 && c <= 0) {
            System.out.println("Пожалуйста, введите корректные значения");
        } else {
            p = (a + b + c) / 2;
            System.out.println("Площадь: " + Math.sqrt(p*(p-a)*(p-b)*(p-c)));
        }
    }
}
