package model;

import java.util.*;


public class FamilyTree {

    private LinkedList<Person>[] tree;
    int maximumLevel;  //

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
        tree[i].remove(person);
      }

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
    public void setChildToParents(Person child) {
        if (child.getLevel() > 0) {
            for (int i = 0; i < child.getParents().size(); i++) {
                ListIterator iter = tree[child.getLevel() - 1].listIterator();
                while (iter.hasNext()) {
                    Person p = (Person) iter.next();
                    if (p.getName().equals(child.getParents().get(i))) {
                        p.addChild(child.getName());
                        iter.set(p);
                        break;
                    }
                }
            }
        }
    }
    public void setSpouse(Person spouse) {
        ListIterator iter = tree[spouse.getLevel()].listIterator();
        while (iter.hasNext()) {
            Person p = (Person) iter.next();
            if (p.getName().equals(spouse.getSpouse())) {
                removeSpouse(p);
                p.setSpouse(spouse.getName());
                iter.set(p);
            }
        }

    }
    public void removeSpouse(Person spouse) {
        ListIterator iter = tree[spouse.getLevel()].listIterator();
        while (iter.hasNext()) {
            Person p = (Person) iter.next();
            if (p.getName().equals(spouse.getSpouse())) {
                p.setSpouse("");
                iter.set(p);
            }
        }

    }

    public void removeChildFromParents(Person child) {
        if (child.getLevel() > 0) {
            for (int i = 0; i < child.getParents().size(); i++) {
                ListIterator iter = tree[child.getLevel() - 1].listIterator();
                while (iter.hasNext()) {
                    Person p = (Person) iter.next();
                    if (p.getName().equals(child.getParents().get(i))) {
                        p.removeChild(child.getName());
                        iter.set(p);
                        break;
                    }
                }
            }
        }
    }

    public void removeParentFromChild(Person parent) {
        if (parent.getLevel() < 19) {
            for (int i = 0; i < parent.getChildren().size(); i++) {
                ListIterator iter = tree[parent.getLevel() + 1].listIterator();
                while (iter.hasNext()) {

                    Person p = (Person) iter.next();
                    if (p.getName().equals(parent.getChildren().get(i))) {
                        p.removeParent(parent.getName());
                        iter.set(p);
                        break;
                    }
                }
            }
        }
    }






}
