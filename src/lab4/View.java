package lab4;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;
import java.util.Vector;

class View extends JFrame{
    public ElementsPanel mainwindoww = new ElementsPanel();
    public GraphicPanel graphicpanel = new GraphicPanel();

    public View(String title) {
        super(title);
        setViewComponents();
    }

    private void setViewComponents() {
        this.setSize(new Dimension(950,559));
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null); // ?

        JPanel mainwindow = (JPanel)this.getContentPane();
        mainwindow.setLayout(new GridLayout());
        mainwindow.add(graphicpanel);
        mainwindow.add(mainwindoww);
    }

    class ElementsPanel extends JPanel {
        public JLabel xlabel = new JLabel("insert x coordinate: ");
        public JLabel ylabel = new JLabel("insert y coordinate: ");
        public JLabel radiuslabel = new JLabel("insert radius: ");
        public JButton adddotbutton = new JButton("add new dot to list");
        SpinnerModel spinnermodel = new SpinnerNumberModel(0,0,100,1);
        public JSpinner radiusspinner = new JSpinner(spinnermodel);
        public DefaultListModel<Dot> listmodel = new DefaultListModel<>();
        public JList list = new JList(listmodel);
        public JScrollPane scrollpane = new JScrollPane();
        public JTextField ytextfield = new JTextField("", 5);
        public JTextField xtextfield = new JTextField("", 5);

        public ElementsPanel() {
            this.setBackground(Color.WHITE);
            this.setLayout(new GridBagLayout());

            GridBagConstraints c = new GridBagConstraints();
            c.fill = GridBagConstraints.NONE;

            c.gridwidth = 1;
            c.gridy = 0;
            c.gridx = 0;
            c.insets = new Insets(0, 20, 5, 0);
            this.add(xlabel, c);
            c.gridy = 1;
            this.add(ylabel, c);
            c.gridy = 3;
            this.add(radiuslabel, c);

            c.gridy = 0;
            c.gridx = 1;
            c.insets = new Insets(2, 0, 2, 60);
            this.add(xtextfield, c);
            c.gridy = 1;
            this.add(ytextfield, c);
            c.gridy = 3;
            c.fill = GridBagConstraints.HORIZONTAL;
            this.add(radiusspinner, c);

            c.gridx = 0;
            c.gridwidth = 2;
            c.gridy = 2;
            this.add(adddotbutton, c);

            c.gridy = 0;
            c.gridx = 2;
            c.gridwidth = 1;
            c.gridheight = 3;
            c.weighty = 0;
            list.setVisible(true);
            list.setVisibleRowCount(3);
            list.setLayoutOrientation(JList.VERTICAL);
            list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            scrollpane.setViewportView(list);
            scrollpane.setVisible(true);
            scrollpane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

            this.add(list,c);


        }
    }

    class GraphicPanel extends JPanel {
        private Polygon area = new Polygon();
        private Point2D.Double center = new Point2D.Double(this.getHeight()/2,this.getWidth()/2);
        private Vector<Point2D.Double> areapoints = new Vector<Point2D.Double>();


        public GraphicPanel() {
            this.setBackground(Color.WHITE);
        }

        private void printAxes(Graphics g) {
            int heigth = this.getHeight();
            int width = this.getWidth();

            g.setColor(new Color(50,50,50));
            g.drawLine(0 + 10, heigth / 2, width - 10, heigth / 2);
            g.drawLine(width / 2, 0 + 10, width / 2, heigth - 10);
        }

        private void printArea(Graphics g, int radius) {
            areapoints.add(new Point2D.Double(-radius/2,0));
            areapoints.add(new Point2D.Double(-radius/2, -radius));
            areapoints.add(new Point2D.Double(0, -radius));
            areapoints.add(new Point2D.Double(radius,0));
            areapoints.add(new Point2D.Double(radius/2,0));
            areapoints.add(new Point2D.Double(0,0));
            areapoints.add(new Point2D.Double(0,radius));

            for (int i = -radius; i != radius; i+= 0.1) {
                areapoints.add(new Point2D.Double());
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            printAxes(g);
           // printArea(g);
        }
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
