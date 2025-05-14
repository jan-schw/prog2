package States.Islands;

import States.Action;
import States.State;

public class DeadMansIsland implements State{

    @Override
    public State transition(Action action) {
        State next = null;
        if(action == Action.A){
            next = new MusketHill();
        }
        else if(action == Action.B){
            next = new ShipwreckBay();
        }
        return next;
    }

    @Override
    public String str() {
        return "Dead Man's Island!";
    }

    @Override
    public String info() {
        return this.str() + " Aktion A -> Musket Hill; Aktion B -> Shipwreck Bay";
    }
    
}
