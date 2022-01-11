package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ParentsQuestionWindow extends JDialog {
    private JButton yes;
    private JButton no;
    private String parent;
    private String child;
    private boolean result;

    public ParentsQuestionWindow(String parent, String child)
    {
        super();
        this.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        this.parent=parent;
        this.child=child;
        Box mainBox = Box.createVerticalBox();
        mainBox.setBorder(new EmptyBorder(12, 12, 12, 12));
        Box questionBox = Box.createHorizontalBox();
        Box yesNoBox = Box.createHorizontalBox();
        questionBox.add(Box.createHorizontalGlue());;
        questionBox.add(new JLabel(parent + " is the parent of " + child +"?"));
        questionBox.add(Box.createHorizontalGlue());
        yes = new JButton("Yes");
        no = new JButton("No");
        yes.addActionListener(new ParentsQuestionWindowListener());
        no.addActionListener(new ParentsQuestionWindowListener());
        yesNoBox.add(Box.createHorizontalGlue());
        yesNoBox.add(no);
        yesNoBox.add(Box.createHorizontalStrut(12));
        yesNoBox.add(yes);
        mainBox.add(questionBox);
        mainBox.add(Box.createVerticalStrut(17));
        mainBox.add(yesNoBox);
        setContentPane(mainBox);
        pack();
        setResizable(false);
        setVisible(true);

    }
    public boolean getResult()
    {
        return result;
    }


    class ParentsQuestionWindowListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (e.getSource().equals(yes)) {
                result = true;
                ParentsQuestionWindow.this.setVisible(false);

            }
            if (e.getSource().equals(no)) {
                result = false;
                ParentsQuestionWindow.this.setVisible(false);
            }

        }

    }
}
