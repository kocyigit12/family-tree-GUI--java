package File_IO;


import java.util.*;
import model.*;
import view.FamilyView.Coordinates;


public class FamilyReaderWriter {

    private FamilyTree tree;
    private HashMap<String, Coordinates> coordinates;

    public FamilyReaderWriter() {
        tree = new FamilyTree();
        coordinates = new HashMap<String, Coordinates>();

    }

    public FamilyReaderWriter(FamilyTree tree, HashMap<String, Coordinates> coordinates) {
        this.tree = tree;
        this.coordinates = coordinates;
    }

    public FamilyTree getTree() {
        return tree;
    }

    public HashMap<String, Coordinates> getCoordinates() {
        return coordinates;
    }




}
