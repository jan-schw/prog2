package task1.model;

import java.util.ArrayList;

public class Tree {

    private int value;
    private Tree left;
    private Tree right;

    public Tree(int input) {
        this.value = input;
    }

    public String str() {
        String inOrder = "";

        if (hasLeft()) {
            inOrder += left.str() + " ";
        }

        inOrder += value;

        if (hasRight()) {
            inOrder += " " + right.str();
        }

        return inOrder;
    }

    public boolean contains(int value) {

        boolean result = this.value == value;
        boolean inLeftSide = hasLeft() ? left.contains(value) : false;
        boolean inRightSide = hasRight() ? right.contains(value) : false;
        return result || inLeftSide || inRightSide;
    }

    public void insertValue(int value) {
        if (!this.contains(value)) {
            if (this.value < value) {
                if (hasRight()) {
                    this.right.insertValue(value);
                } else {
                    this.setRight(new Tree(value));
                }
            } else {
                if (hasLeft()) {
                    this.left.insertValue(value);
                } else {
                    this.setLeft(new Tree(value));
                }
            }
        }
    }

    public void deleteValue(int value) {
        // Value ist rechts vom aktuellen Knoten
        if (this.value < value && hasRight()) {

            // Knoten direkt rechts soll gelöscht werden
            if (this.right.getValue() == value) {
                this.right = deleteNode(this.right);
            }
            // weitergeben
            else {
                this.right.deleteValue(value);
            }
        }
        // Value ist links vom aktuellen Knoten
        else if (this.value > value && hasLeft()) {

            // Knoten direkt rechts soll gelöscht werden
            if (this.left.getValue() == value) {
                this.left = deleteNode(this.left);
            }
            // weitergeben
            else {
                this.left.deleteValue(value);
            }
        }
        // Value ist der aktuelle Knoten
        else if (this.value == value) {
            Tree newTree = deleteNode(this);

            this.value = newTree.getValue();
            this.left = newTree.getLeft();
            this.right = newTree.getRight();
        }
    }

    private Tree deleteNode(Tree toBeDeleted){
        Tree newNode = null;
    
        //Knoten hat zwei Unterknoten
        if(toBeDeleted.hasLeft() && toBeDeleted.hasRight()){
            ArrayList<Integer> valuesLeftSide = toBeDeleted.getLeft().getValues();
            newNode = toBeDeleted.getRight();
            
            for(int current : valuesLeftSide){
                newNode.insertValue(current);
            }
        }
        //Nur einen Knoten links
        else if(toBeDeleted.hasLeft()){
            newNode = toBeDeleted.getLeft();
        }
        //Nur einen Knoten rechts
        else if(toBeDeleted.hasRight()){
            newNode = toBeDeleted.getRight();
        }

        return newNode;
    }

    public int getValue() {
        return value;
    }

    public Tree getLeft() {
        return left;
    }

    public void setLeft(Tree left) {
        this.left = left;
    }

    public Tree getRight() {
        return right;
    }

    public void setRight(Tree right) {
        this.right = right;
    }

    private boolean hasLeft() {
        return this.left != null;
    }

    private boolean hasRight() {
        return this.right != null;
    }

    private ArrayList<Integer> getValues() {
        ArrayList<Integer> list = new ArrayList<Integer>();

        if (hasLeft()) {
            list.addAll(this.left.getValues());
        }

        list.add(this.value);

        if (hasRight()) {
            list.addAll(this.right.getValues());
        }

        return list;
    }
}
