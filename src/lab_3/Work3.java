package lab_3; /**
 * Created by Fima on 03.04.2017.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Work3 {

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("enter parameter R ");
        double R = 0;

        try {
            while (true) {
                R = Double.valueOf(reader.readLine());
            }
        } catch (NumberFormatException e) {
            System.out.println("mfmf");
        }

        Forma forma = new Forma(R);

        ArrayList<Dot> DoNotHit = new ArrayList<Dot>();

        ArrayList<Dot> dots = new ArrayList<Dot>(9);

        dots.add(new Dot(-4f,-5f));
        dots.add(new Dot(1f,-3f));
        dots.add(new Dot(0f,0.f));
        dots.add(new Dot(4f,-5f));
        dots.add(new Dot(-3f,3f));
        dots.add(new Dot(1f,-2f));
        dots.add(new Dot(5f,4f));
        dots.add(new Dot(-3f,4f));
        dots.add(new Dot(-3f,3));

        for (Dot dot : dots) {
            if (forma.hitting(dot))
                System.out.println("dot "+dot.toString()+" hit the form");
            else
                DoNotHit.add(dot);
        }

        System.out.println("dots, that did not hit the form: ");
        for (Dot dot : DoNotHit)
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

class Forma {
    private double R;

    public Forma(double R) {
        this.R = Math.abs(R);
    }

    public boolean hitting(Dot dot) {
        if (dot.coordinateX < 0 & dot.coordinateY > 0) //2st quarter
            return false;

        if (dot.coordinateX <= 0 & dot.coordinateY <= 0) { //3nd quarter
            return (((dot.coordinateX >= (-R / 2)) & (dot.coordinateX <= 0))) & ((dot.coordinateY <= 0) & (dot.coordinateY >= -R));
        }

        if (dot.coordinateX >= 0 & dot.coordinateY <= 0) { //4rd quarter
            return (dot.coordinateX * dot.coordinateX) + (dot.coordinateY * dot.coordinateY) < R * R;
        }

        if (dot.coordinateX >= 0 & dot.coordinateY >= 0)  //1th quarter
            return ((dot.coordinateY <= -2*dot.coordinateX + R) & (dot.coordinateX <= (R - dot.coordinateY)/2));

        return dot.coordinateX == 0 & dot.coordinateY == 0;

    }
}