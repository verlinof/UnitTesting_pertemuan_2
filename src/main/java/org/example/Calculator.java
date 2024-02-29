package org.example;

public class Calculator {
    public double a;
    public double b;

    public Calculator(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double tambah() {
        return a + b;
    }

    public double kurang() {
        return a - b;
    }

    public double kali() {
        return a * b;
    }

    public double bagi() {
        return a / b;
    }

}