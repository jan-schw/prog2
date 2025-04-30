package debug.model;

import debug.Animal;

public class Monkey extends Animal {
  public Monkey(String name) {
    super(name);
  }

  //Override von getName gelöscht. Hier kann einfach die Methode der Basisklasse verwendet werden
  //Gilt theoretisch auch für die anderen Overrides. Eigentlich kann der andere Konstruktor von Animal verwendet werden,
  //dann werden alle Overrides überflüssig

  @Override
  public int getArms() {
    return 2;
  }

  @Override
  public int getLegs() {
    return 2;
  }

  @Override
  public String toString() {
    return String.format("%s is a monkey with %d legs and %d arms.", this.getName(), this.getLegs(), this.getArms());
  }
}

/*
 * Zeile 10: Override von getName gelöscht. Hier kann einfach die Methode der Basisklasse verwendet werden
 */