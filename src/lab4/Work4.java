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
        frame.setSize(400, 250);
        frame.setVisible(true);
        frame.setResizable(true);
        frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);

        JPanel panel = new JPanel(null);

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

        DefaultListModel<Dot> listmodel = new DefaultListModel<Dot>();

        JButton addnewpointbutton = new JButton("add dot to the list");
        addnewpointbutton.setSize(new Dimension(120,20));
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

        JList<Dot> list = new JList<Dot>(listmodel);
        list.setVisible(true);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setLocation(new Point(235,25));
        list.setSize(new Dimension(80,25));
        list.add(new Scrollbar(Scrollbar.VERTICAL));

        SpinnerModel spinnermodel = new SpinnerNumberModel(0,0,20,1);
        JSpinner radiusspinner = new JSpinner(spinnermodel);
        radiusspinner.setLocation(new Point(60,65));
        radiusspinner.setVisible(true);
        radiusspinner.setSize(new Dimension(50,25));
        panel.add(radiusspinner);

        JLabel radiuslabel = new JLabel("set radius");
        radiuslabel.setOpaque(false);
        radiuslabel.setSize(80,25);
        radiuslabel.setLocation(new Point(0,65));
        panel.add(radiuslabel);

        JLabel listlabel = new JLabel("dot list");
        listlabel.setOpaque(false);
        listlabel.setLocation(new Point(250,5));
        listlabel.setSize(new Dimension(50,10));
        panel.add(listlabel);

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