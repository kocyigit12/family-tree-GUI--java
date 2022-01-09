package model;

import java.util.*;


public class FamilyTree {

    private LinkedList<Person>[] tree;
    int maximumLevel;

    public FamilyTree() {
        tree = new LinkedList[20];
        for (int i = 0; i < 20; i++) {
            tree[i] = new LinkedList<Person>();
            maximumLevel=0;
        }
    }

    public void add(Person person) {
        int i = 0;
        i = person.getLevel();
        if(i>maximumLevel)
            maximumLevel=i;
        tree[i].add(person);
    }

    public void remove(Person person) {
        int i = 0;
        i = person.getLevel();
        tree[i].remove(person); }

    public Person getPerson(int level, int num) {
        return tree[level].get(num);
    }
    public int getMaximumLevel ()
    {
        return maximumLevel;
    }
    public int getLevelSize(int level) {
        return tree[level].size();
    }

    public Person getPerson(String name) {
        for (int i = 0; i < 20; i++) {
            ListIterator iter = tree[i].listIterator();
            while (iter.hasNext()) {
                Person p = (Person) iter.next();
                if (p.getName().equals(name)) {
                    return p;
                }
            }
        }
        return null;
    }







}
