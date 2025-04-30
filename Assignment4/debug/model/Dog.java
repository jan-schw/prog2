package debug.model;

import debug.Animal; //Neuen Import für die Basisklasse Animal

public class Dog extends Animal{
    
  public Dog(String name) {
    super(name);
  }

  //Override von getName gelöscht. Hier kann einfach die Methode der Basisklasse verwendet werden
  //Gilt theoretisch auch für die anderen Overrides. Eigentlich kann der andere Konstruktor von Animal verwendet werden,
  //dann werden alle Overrides überflüssig

  @Override
  public int getArms() {
    return 0;   //Anzahl Arme zu 0 geändert
  }

  @Override
  public int getLegs() {
    return 4;
  }

  @Override
  public String toString() {
    return String.format("%s is a dog with %d legs and %d arms.", this.getName(), this.getLegs(), this.getArms());  //getLegs() und getArms  getauscht, damit die Ausgabe stimmt
  }
}

/*
 * Zeile 3: Neuen Import für die Basisklasse Animal
 * 
 * Zeile 11: Override von getName gelöscht. Hier kann einfach die Methode der Basisklasse verwendet werden
 * 
 * Zeile 17: Anzahl Arme zu 0 geändert
 * 
 * Zeile 25: getLegs() und getArms  getauscht, damit die Ausgabe stimmt
 */