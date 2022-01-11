package view;

import model.FamilyTree;

import javax.swing.*;

public class AddSpouseWindow extends JDialog {
    private JTextField nField;
    private JTextField aField;
    private JButton next;
    private JButton cancel;
    private boolean result;
    private int level;
    private int numOfError;
    FamilyTree tree;

    public String getName() {
        return nField.getText();
    }

    public int getLevel() {
        return level;
    }

    public int getAge() {
        String str = aField.getText();
        Integer i = Integer.valueOf(str);
        return i;
    }

    public boolean isOk() {
        return result;
    }

    private int checkInput() {
        String str = "";
        if (getName() == null) {
            numOfError = 0;
        }
        for (int i=0; i<tree.getMaximumLevel();i++)
        {
            for (int j=0; j<tree.getLevelSize(i); j++)
            {
                str = tree.getPerson(i, j).getName();
                if (str.equals(getName()))
                    numOfError = 1;
            }
        }
        return numOfError;
    }

}
