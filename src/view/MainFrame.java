package view;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class MainFrame extends JFrame {

    JMenuBar menu;
    JMenuItem saveButton, loadButton, sortButton, helpButton;

    public MainFrame(String title) {
        super(title);
        menu = new JMenuBar();
        saveButton = new JMenuItem("Save", new ImageIcon("icon_save_16x16.gif"));
        loadButton = new JMenuItem("Open", new ImageIcon("icon_OpenFile.png"));
        loadButton.addActionListener(new ButtonActionListener());
        saveButton.addActionListener(new ButtonActionListener());
        sortButton = new JMenuItem("Sort", new ImageIcon("sort-descending-icon.png"));
        helpButton = new JMenuItem("Help", new ImageIcon("Help_Circle_Blue.png"));
        helpButton.addActionListener(new ButtonActionListener());
        saveButton.setSize(18, 18);
        FlowLayout menuLayout = new FlowLayout();
        menuLayout.setAlignment(FlowLayout.LEFT);
        menu.setLayout(menuLayout);
        menu.add(loadButton);
        menu.add(saveButton);
        menu.add(sortButton);
        menu.add(helpButton);
        sortButton.addActionListener(new ButtonActionListener());
        setSize(1000, 1000);
        menu.setSize(130, 50);
        menu.setPreferredSize(new Dimension(130, 34));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container c = getContentPane();
        FamilyView panel1 = new FamilyView();
        this.setLayout(new BorderLayout());
        c.add(menu, BorderLayout.PAGE_START);
        c.add(panel1, BorderLayout.CENTER);
        setVisible(true);
    }

    class ButtonActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {


        }

    }

}
