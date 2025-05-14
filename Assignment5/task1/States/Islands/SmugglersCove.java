package States.Islands;

import States.Action;
import States.State;

public class SmugglersCove implements State{

    @Override
    public State transition(Action action) {
        State next = null;
        if(action == Action.A){
            next = new PiratesIsland();
        }
        else if(action == Action.B){
            next = new TreasureIsland();
        }
        return next;
    }

    @Override
    public String str() {
        return "Smugglers' Cove";
    }

    @Override
    public String info() {
        return "Aktion A -> Pirates' Island; Aktion B -> Treasure Island";
    }
    
}
