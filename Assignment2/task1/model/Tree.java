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

        if(hasLeft()){
            inOrder += left.str() + " ";
        }

        inOrder += value;

        if(hasRight()){
            inOrder += " " + right.str();
        }

        return inOrder;
    }

    public boolean contains(int value){

        boolean result = this.value == value;
        boolean inLeftSide = hasLeft() ? left.contains(value) : false;
        boolean inRightSide = hasRight() ? right.contains(value) : false;
        return result || inLeftSide || inRightSide;
    }

    public void insertValue(int value){
        if(!this.contains(value)){
            if(this.value < value){
                if(hasRight()){
                    this.right.insertValue(value);
                }
                else{
                    this.setRight(new Tree(value));
                }
            }
            else{
                if(hasLeft()){
                    this.left.insertValue(value);
                }
                else{
                    this.setLeft(new Tree(value));
                }
            }
        }
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

    private boolean hasLeft(){
        return this.left != null;
    }

    private boolean hasRight(){
        return this.right != null;
    }
}
