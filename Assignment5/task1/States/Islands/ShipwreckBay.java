package States.Islands;

import States.Action;
import States.State;

public class ShipwreckBay implements State{

    @Override
    public State transition(Action action) {
        State next = null;
        if(action == Action.A){
            next = new MusketHill();
        }
        else if(action == Action.B){
            next = new DeadMansIsland();
        }
        return next;
    }

    @Override
    public String str() {
        return "Shipwreck Bay!";
    }

    @Override
    public String info() {
        return this.str() + " Aktion A -> Musket Hill; Aktion B -> Dead Man's Island";
    }
    
}
