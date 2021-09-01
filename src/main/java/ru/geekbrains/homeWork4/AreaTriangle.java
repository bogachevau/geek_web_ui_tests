package ru.geekbrains.homeWork4;

public class AreaTriangle {

    public static double areaTriangle(double a, double b, double c) throws BadTriangleException {
        if (a <= 0 || b <= 0 || c <= 0) throw new BadTriangleException();
        double p = (a + b + c) / 2;
        double square = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        return square;
    }

    public AreaTriangle() {
    }

    public static void main(String[] args) throws BadTriangleException {
        System.out.println(areaTriangle(3, 4, 5));
    }
}
