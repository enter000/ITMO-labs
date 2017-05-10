package lab4;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Implementation {
    private View view;
    final Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

    public Implementation() {
        view = new View("work 4");

        view.mainwindoww.adddotbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ((view.mainwindoww.xtextfield.getText().equals("")) || (view.mainwindoww.ytextfield.getText().equals(""))
                        || (view.mainwindoww.xtextfield.getText().matches("[a-z\\-_]+"))
                        || (view.mainwindoww.ytextfield.getText().matches("[a-z\\-_]+"))) {
                    view.mainwindoww.xtextfield.setText("");
                    view.mainwindoww.ytextfield.setText("");

                    JFrame errorframe = new JFrame("Error");
                    errorframe.setVisible(true);
                    errorframe.setSize(300, 90);
                    errorframe.setLocation(dim.width/2-errorframe.getSize().width/2, dim.height/2-errorframe.getSize().height/2);

                    JLabel errorlabel = new JLabel("cannot make a dot from null or string values");
                    errorlabel.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
                    JPanel errorpanel = new JPanel();

                    errorpanel.add(errorlabel);
                    errorframe.add(errorpanel);
                } else {
                    double coordinateX = Double.valueOf(view.mainwindoww.xtextfield.getText());
                    double coordinateY = Double.valueOf(view.mainwindoww.ytextfield.getText());

                    Dot dot = new Dot(coordinateX, coordinateY);
                    view.mainwindoww.listmodel.addElement(dot);

                    view.mainwindoww.xtextfield.setText("");
                    view.mainwindoww.ytextfield.setText("");
                }
            }
        });
    }

    public void startApplication() {
        view.setVisible(true);
    }
}
