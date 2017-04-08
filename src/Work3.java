package labs.lab3;

/**
 * Created by Fima on 03.04.2017.
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.PriorityQueue;

public class Work3 {

    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("enter parameter R ");

        Double R = Double.valueOf(reader.readLine());

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
            if (forma.Hitting(R,dot))
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
       return "("+coordinateX+";"+coordinateY+")";
    }


}

class Forma {
    private double R;
    //private Dot dot;

    public Forma(double R) {
        this.R = R;
    }

    public boolean Hitting(double R, Dot dot) {
        if (dot.coordinateX < 0 & dot.coordinateY > 0) //1st quarter
            return false;

        if (dot.coordinateX <= 0 & dot.coordinateY <= 0) { //2nd quarter
            return (((dot.coordinateX >= (-R / 2)) & (dot.coordinateX <= 0))) & ((dot.coordinateY <= 0) & (dot.coordinateY >= -R));
        }

        if (dot.coordinateX >= 0 & dot.coordinateY <= 0) { //3rd quarter
            return (dot.coordinateX * dot.coordinateX) + (dot.coordinateY * dot.coordinateY) < R * R;

        }

        if (dot.coordinateX >= 0 & dot.coordinateY >= 0)  //4th quarter
            return ((dot.coordinateY <= -2 * R * dot.coordinateX + R)) & (dot.coordinateX >= 0) & (dot.coordinateX <= R / 2);
        else
        return false;
    }



}
