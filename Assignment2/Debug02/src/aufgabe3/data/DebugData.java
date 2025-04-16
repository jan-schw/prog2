package aufgabe3.data;

import java.lang.Math;

// This class is representing a cartesian coordinate in a 2d space with double coordinates.
public class DebugData {    //Klasse Sichtbarkeit public gegeben 
    private double x;
    private double y;
    
    public DebugData(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    public double distance(DebugData other) {
        return Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2));  //pow zu sqrt geändert
    }
    
    public double getX(){
        return this.x;
    }
    
    public double getY(){
        return this.y;  //this.x zu this.y geändert
    }
    
    public void setX(double x){
        this.x = x;
    }
    
    public void setY(double y){
        this.y = y;
    }
    
    public String str() {
        return String.format("(%g, %g)", this.x, this.y);
    }
}

/*
 * Zeile 6: Klasse Sichtbarkeit public gegeben
 * Fehlermeldung: The type DebugData is not visible
 * 
 * Zeile 10: Datentypen in Konstruktor zu double geändert
 * Fehlermeldung: The constructor DebugData(double, double) is undefined
 * 
 * Zeile 16: pow zu sqrt geändert, damit Distanz richtig bestimmt wird
 * Fehlermeldung: The method pow(double, double) in the type Math is not applicable for the arguments (double)
 * 
 * Zeile 24: this.x zu this.y geändert
 * Fehlermeldung: /
 */