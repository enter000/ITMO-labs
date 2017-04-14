package lab_3;
/**
 * Created by Fima on 03.04.2017.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Work3 {
    public static void main(String[] args) throws IOException {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("insert parameter");
            double R = 0;

            while (R == 0) {
                try {
                    R = Double.valueOf(reader.readLine());
                } catch (NumberFormatException e) {
                    System.out.println("parameter must be double valued");
                }
            }
            Form forma = new Form(R);

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

            ArrayList<Dot> doNotHit = new ArrayList<Dot>();

            for (Dot dot : dots) {
                if (forma.hittingTheForm(dot))
                    System.out.println("dot " + dot.toString() + " hit the form");
                else
                    doNotHit.add(dot);
            }

            System.out.println("dots, that did not hit the form: ");
            for (Dot dot : doNotHit)
                System.out.println(dot);
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
    private double R;

    public Form(double R) {
        this.R = Math.abs(R);
    }

    public boolean hittingTheForm(Dot dot) {
        if (dot.coordinateX < 0 & dot.coordinateY > 0) //2st quarter
            return false;
        if (dot.coordinateX <= 0 & dot.coordinateY <= 0) { //3nd quarter
            return (((dot.coordinateX >= (-R / 2)) & (dot.coordinateX <= 0))) & ((dot.coordinateY <= 0) & (dot.coordinateY >= -R));
        }
        if (dot.coordinateX >= 0 & dot.coordinateY <= 0) { //4rd quarter
            return (Math.pow(dot.coordinateX, 2)) + (Math.pow(dot.coordinateY, 2)) < Math.pow(R, 2 );
        }
        if (dot.coordinateX >= 0 & dot.coordinateY >= 0)  //1th quarter
            return ((dot.coordinateY <= -2*dot.coordinateX + R) & (dot.coordinateX <= (R - dot.coordinateY)/2));

        return dot.coordinateX == 0 & dot.coordinateY == 0;
    }
}