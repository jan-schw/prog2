package task1.model;


public class Tree {

    private int value;
    private Tree left;
    private Tree right;

    public Tree(int input){
        this.value = input;
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
}
