package States.Islands;

import States.Action;
import States.State;

public class MutineersIsland implements State{

    @Override
    public State transition(Action action) {
        State next = null;
        if(action == Action.A){
            next = new SmugglersCove();
        }
        else if(action == Action.B){
            next = new DeadMansIsland();
        }
        return next;
    }

    @Override
    public String str() {
        return "Mutineers' Island!";
    }

    @Override
    public String info() {
        return this.str() + " Aktion A -> Smugglers' Cove; Aktion B -> Dead Man's Island";
    }
    
}
