package States.Islands;

import States.Action;
import States.State;

public class MutineersIsland implements State{

    @Override
    public State transition(Action action) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'transition'");
    }

    @Override
    public String str() {
        return "Mutineers' Island";
    }

    @Override
    public String info() {
        return "Aktion A -> Smugglers' Cove; Aktion B -> Dead Man's Island";
    }
    
}
