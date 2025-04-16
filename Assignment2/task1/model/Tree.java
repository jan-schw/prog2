package task1.model;


public class Tree {

    private int value;
    private Tree left;
    private Tree right;

    public Tree(int input){
        this.value = input;
    }

    public String str(){
        String inOrder = "";

        if(left != null){
            inOrder += left.str() + " ";
        }

        inOrder += value;

        if(right != null){
            inOrder += " " + right.str();
        }

        return inOrder;
    }

    public boolean contains(int value){

        boolean result = this.value == value;
        boolean inLeftSide = left != null ? left.contains(value) : false;
        boolean inRightSide = right != null ? right.contains(value) : false;
        return result || inLeftSide || inRightSide;
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
