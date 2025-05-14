package States.Islands;

import States.Action;
import States.State;

public class PiratesIsland implements State {

    @Override
    public State transition(Action action) {
        State next = null;
        if(action == Action.A){
            next = new ShipwreckBay();
        }
        else if(action == Action.B){
            next = new MusketHill();
        }
        return next;
    }

    @Override
    public String str() {
        return "Pirates' Island";
    }

    @Override
    public String info() {
        return "Aktion A -> Shipwreck Bay; Aktion B -> Musket Hill";
    }
    
}
