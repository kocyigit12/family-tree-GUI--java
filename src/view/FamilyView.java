package view;

import javax.swing.*;
import java.awt.*;


import java.awt.event.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;
import java.util.*;
import java.util.Map.Entry;
import model.*;



public class FamilyView extends JPanel {

    private JPopupMenu menuPopUp1 = new JPopupMenu();
    private JPopupMenu menuPopUp2 = new JPopupMenu();
    private JMenuItem remove;
    private JMenuItem properties;
    private JMenuItem add;
    private JMenuItem addChild;
    private JMenuItem addSpouse;

    private FamilyTree tree;
    private HashMap<String, Coordinates> coord;
    static boolean needSort;
    private String currentPers;
    private int mouseX;
    private int mouseY;
    private boolean leftMousePressed;


    public FamilyView() {
        tree = new FamilyTree();
        coord = new HashMap();
        needSort = false;
        addMouseListener(new MyMouseListener());
        menuPopUp1 = new JPopupMenu();
        menuPopUp2 = new JPopupMenu();
        remove = new JMenuItem("Remove", new ImageIcon("delete.png"));
        properties = new JMenuItem("Info", new ImageIcon("Studio2-icon-Properties.png"));
        add = new JMenuItem("Add first person", new ImageIcon("add-icon.png"));
        addChild = new JMenuItem("Add child", new ImageIcon("Add child icon.png"));
        addSpouse = new JMenuItem("Add spouse", new ImageIcon("add-icon.png"));
        addChild.addActionListener(new PopButtonActionListener());
        remove.addActionListener(new PopButtonActionListener());
        properties.addActionListener(new PopButtonActionListener());
        add.addActionListener(new PopButtonActionListener());
        addSpouse.addActionListener(new PopButtonActionListener());
        addMouseMotionListener(new MyMouseMotionListener());
        menuPopUp1.add(remove);
        menuPopUp1.add(addChild);
        menuPopUp1.add(addSpouse);
        menuPopUp1.add(properties);
        menuPopUp2.add(add);
    }

    public FamilyView(FamilyTree tree, HashMap coord) {
        this();
        this.tree = tree;
        this.coord = coord;

    }

    public FamilyTree getFamilyViewTree() {
        return tree;
    }

    public HashMap<String, Coordinates> getFamilyViewCoordinates() {
        return coord;
    }

    public void changePersonCoords(String name, int x, int y, int width, int heigth) {
        coord.put(name, new Coordinates(x, y, width, heigth));
    }




    public class MyMouseListener implements MouseListener {

        public void mouseClicked(MouseEvent e) {

        }

        public void mouseEntered(MouseEvent e) {

        }

        public void mouseExited(MouseEvent e) {
        }

        public void mousePressed(MouseEvent e) {



        }

        public void mouseReleased(MouseEvent e) {
            leftMousePressed = false;
        }
    }

    public class MyMouseMotionListener implements MouseMotionListener {

        @Override
        public void mouseDragged(MouseEvent e) {

        }

        @Override
        public void mouseMoved(MouseEvent e) {
        }

    }

    class PopButtonActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {


        }

    }
    public class Coordinates {

        private int x;
        private int y;
        private int width;
        private int height;

        public Coordinates(int x, int y, int width, int height) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
        }

        private Coordinates(int level, int num, Dimension dim) {
            calcCoordinates(level, num, dim);
        }

        public void setCoordinates(int x, int y, int width, int height) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
        }

        public void calcCoordinates(int level, int num, Dimension dim) {
            AffineTransform affinetransform = new AffineTransform();
            FontRenderContext frc = new FontRenderContext(affinetransform, false, false);
            Font f = new Font("SERIF", 1, 12);
            this.width = (int) (f.getStringBounds(tree.getPerson(level, num).getName(), frc).getWidth()) + 10;
            this.height = 20;
            this.x = dim.width / (tree.getLevelSize(level) + 1) * (num + 1) - this.width / 2;
            this.y = 20 + level * 50 + 34;
        }

        private boolean isIn(int x, int y) {
            if (x >= this.x && x <= this.x + this.width && y >= this.y && y <= this.y + this.height) {
                return true;
            } else {
                return false;
            }
        }

        private void setX(int x) {
            this.x = x;
        }

        private void setY(int y) {
            this.y = y;
        }

        public String toString() {
            String str = x + "." + y + "." + width + "." + height + ".";
            return str;
        }

    }
}
