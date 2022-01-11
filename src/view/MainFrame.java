package view;


import File_IO.FamilyReaderWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;


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
            if (e.getSource().equals(loadButton)) {
                JFileChooser fc = new JFileChooser();
                FamilyReaderWriter frw = new FamilyReaderWriter();
                if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                    try {
                        File file = fc.getSelectedFile();  // select file
                        frw.familyOpen(file);  // set it to my family tree
                        setVisible(true);
                        Container c = MainFrame.this.getContentPane(); // add the info of my file to a container (stacking)
                        c.remove(1); // remove current tree info
                        c.add(new FamilyView(frw.getTree(), frw.getCoordinates())); // and add chosen file info into my container
                         setVisible(true);
                        repaint();

                    } catch (IOException r) {
                        System.out.println("IOError");
                    }
                }

        }
            if (e.getSource().equals(saveButton)) {
                Container c = MainFrame.this.getContentPane();
                JFileChooser fc = new JFileChooser();
                if (fc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                    try {
                        File file = fc.getSelectedFile(); // select file
                        FamilyView fv = (FamilyView) c.getComponent(1); // add recent family to container
                        FamilyReaderWriter frw = new FamilyReaderWriter(fv.getFamilyViewTree(), fv.getFamilyViewCoordinates()); // push that family to reader and writer
                                                                                                                                // class with its info and coordinates
                        frw.familyWriter(file);  // then save that file by using familyWriter function
                    } catch (IOException r) {
                        System.out.println("IO error");
                    }
                }
            }
            if (e.getSource().equals(helpButton)) {
                JOptionPane.showMessageDialog(new JFrame(), "Push the right click button and add your first node.\n" +
                        "You can add child, parent or spouse.\n" +
                        "If you want to save your tree file click the save button.\n"+
                        "Click load button if you load existing tree file on your pc.", "Info", JOptionPane.INFORMATION_MESSAGE);
            }

    }

}
}
