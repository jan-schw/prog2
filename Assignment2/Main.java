import task1.model.*;

public class Main {


    public static void main(String[] args) {
        Tree five = new Tree(5);
        Tree two = new Tree(2);
        Tree minusfour = new Tree(-4);
        Tree three = new Tree(3);
        Tree eighteen = new Tree(18);

        five.setRight(eighteen);
        five.setLeft(two);

        two.setLeft(minusfour);
        two.setRight(three);

        String order = five.str();
        System.out.println(order);
    }
}
