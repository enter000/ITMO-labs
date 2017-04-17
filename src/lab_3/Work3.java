package lab_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Work3 {
    public static void main(String[] args) throws IOException {
        ArrayList<Dot> dots = generateTestList();
        Form form = createForm();
        checkDotsOnForm(dots, form);
    }

    public static void checkDotsOnForm(ArrayList<Dot> dots, Form form) {
        ArrayList<Dot> doNotHit = new ArrayList<Dot>();

        for (Dot dot : dots) {
            if (form.isInForm(dot)) {
                System.out.println("dot " + dot.toString() + " hit the form");
            } else {
                doNotHit.add(dot);
            }
        }

        System.out.println("dots, that did not hit the form: ");
        for (Dot dot : doNotHit) {
            System.out.println(dot);
        }
    }

    public static ArrayList<Dot> generateTestList() {
        ArrayList<Dot> dots = new ArrayList<Dot>(9);

        dots.add(new Dot(-4f, -5f));
        dots.add(new Dot(1f, -3f));
        dots.add(new Dot(0f, 0.f));
        dots.add(new Dot(4f, -5f));
        dots.add(new Dot(-3f, 3f));
        dots.add(new Dot(1f, -2f));
        dots.add(new Dot(5f, 4f));
        dots.add(new Dot(-3f, 4f));
        dots.add(new Dot(-3f, 3f));

        return dots;
    }

    public static Form createForm() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("insert parameter");
        double radius = 0;

        while (radius == 0) {
            try {
                radius = Double.valueOf(reader.readLine());
            } catch (NumberFormatException e) {
                System.out.println("parameter must be double valued");
            }
        }
        Form form = new Form(radius);

        return form;
    }
}

class Dot {
    public float coordinateX;
    public float coordinateY;

    public Dot(float coordinateX, float coordinateY) {
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
    }

    @Override
    public String toString() {
       return "("+coordinateX+","+coordinateY+")";
    }
}

class Form {
    private double radius;

    public Form(double radius) {
        this.radius = Math.abs(radius);
    }

    public boolean isInForm(Dot dot) {
        if (dot.coordinateX >= 0 & dot.coordinateY >= 0) { // 1st quarter
            return ((dot.coordinateY <= -2 * dot.coordinateX + radius) & (dot.coordinateX <= (radius - dot.coordinateY) / 2));
        }
        if (dot.coordinateX < 0 & dot.coordinateY > 0) { // 2nd quarter
            return false;
        }
        if (dot.coordinateX <= 0 & dot.coordinateY <= 0) { // 3rd quarter
            return (((dot.coordinateX >= (-radius / 2)) & (dot.coordinateX <= 0))) & ((dot.coordinateY <= 0) & (dot.coordinateY >= -radius));
        }
        if (dot.coordinateX >= 0 & dot.coordinateY <= 0) { // 4th quarter
            return (Math.pow(dot.coordinateX, 2)) + (Math.pow(dot.coordinateY, 2)) < Math.pow(radius, 2 );
        }
        return (dot.coordinateX == 0 & dot.coordinateY == 0);
    }
}