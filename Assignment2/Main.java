import task1.model.*;

public class Main {


    public static void main(String[] args) {
        //Baum aus Figur 1 aufbauen
        Tree five = new Tree(5);
        Tree two = new Tree(2);
        Tree minusfour = new Tree(-4);
        Tree three = new Tree(3);
        Tree eighteen = new Tree(18);

        five.setRight(eighteen);
        five.setLeft(two);
        two.setLeft(minusfour);
        two.setRight(three);

        System.out.println(five.str());

        //Neue Werte hinzufügen
        five.insertValue(29);   //rechts von der 18
        System.out.println("Contains 29? " + five.contains(29));
        five.insertValue(21);   //links von der 18
        System.out.println("Contains 21? " + five.contains(21));
        five.insertValue(1);    //rechts von der -4
        System.out.println("Contains 1? " + five.contains(1));
        System.out.println(five.str());

        //Einige Werte löschen
        five.deleteValue(-4);   //1 soll jetzt links an der 2 hängen
        System.out.println("Contains -4? " + five.contains(-4));
        five.deleteValue(2);   //1 soll jetzt links an der 3 hängen
        System.out.println("Contains 2? " + five.contains(2));
        five.deleteValue(18);   //29 soll jetzt rechts von der 5 hängen, links von der 29 dann die 21
        System.out.println("Contains 18? " + five.contains(18));

        System.out.println(five.str());
    }
}
