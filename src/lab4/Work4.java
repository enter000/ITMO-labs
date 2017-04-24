package lab4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Work4 {
    public static void createAndShowGUI() {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

        JFrame frame = new JFrame("work4");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(250, 250);
        frame.setVisible(true);
        frame.setResizable(true);
        frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);

        JPanel panel = new JPanel(null);

        DefaultListModel<Dot> listmodel = new DefaultListModel<Dot>();
        JList<Dot> list = new JList<Dot>(listmodel);
        list.setVisible(true);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setLocation(new Point(0,50));

        JTextField xtextfield = new JTextField("",5);
        xtextfield.setSize(30,25);
        xtextfield.setLocation(new Point(60,0));
        panel.add(xtextfield);

        JLabel xlabel = new JLabel("insert x");
        xlabel.setOpaque(false);
        xlabel.setSize(50,30);
        xlabel.setLocation(new Point(0,0));
        xlabel.setBorder(BorderFactory.createLineBorder(Color.RED,1));
        panel.add(xlabel);

        JTextField ytextfield = new JTextField("",5);
        ytextfield.setLocation(60,30);
        ytextfield.setSize(new Dimension(30,25));
        panel.add(ytextfield);

        JLabel ylabel = new JLabel("insert y");
        ylabel.setOpaque(false);
        ylabel.setSize(new Dimension(50,30));
        ylabel.setLocation(new Point(0,31));
        panel.add(ylabel);

        JButton addnewpointbutton = new JButton("add point");
        addnewpointbutton.setSize(new Dimension(80,20));
        addnewpointbutton.setLocation(new Point(100,20));
        addnewpointbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ((xtextfield.getText().equals("")) || (ytextfield.getText().equals(""))) {
                    JFrame errorframe = new JFrame("Error");
                    errorframe.setVisible(true);
                    errorframe.setSize(300, 90);
                    errorframe.setLocation(dim.width/2-errorframe.getSize().width/2, dim.height/2-errorframe.getSize().height/2);

                    JLabel errorlabel = new JLabel("cannot make a dot from null values");
                    errorlabel.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
                    JPanel errorpanel = new JPanel();

                    errorpanel.add(errorlabel);
                    errorframe.add(errorpanel);
                } else {
                    double coordinateX = Double.valueOf(xtextfield.getText());
                    double coordinateY = Double.valueOf(ytextfield.getText());

                    Dot dot = new Dot(coordinateX, coordinateY);
                    listmodel.addElement(dot);

                    xtextfield.setText("");
                    ytextfield.setText("");
                }
            }
        });
        panel.add(addnewpointbutton);

        panel.add(list);

        frame.add(panel);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }
}

class Dot {
    private double coordinateX;
    private double coordinateY;

    public Dot(double x, double y) {
        this.coordinateX = x;
        this.coordinateY = y;
    }

    @Override
    public  String toString() {
        return coordinateX+";"+coordinateY;
    }
}