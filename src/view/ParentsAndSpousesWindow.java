package view;

import model.Person;

import javax.swing.*;

public class ParentsAndSpousesWindow extends JDialog {
    private JButton ok;
    private JButton cancel;
    private Person p = null;
    private String name;
    private int age;
    private int level;
    boolean result;
    private String firstParent;
    private String secondParent;
    private String spouse;

    public String getSpouse() {
        return spouse;
    }

    public boolean isOk() {
        return result;
    }

    public Person getPerson() {
        return p;
    }
}
